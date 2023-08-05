package com.virtual.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.virtual.store.form.CartRequestForm;
import com.virtual.store.form.CartUpdateForm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "cart")
public class Cart {

	@Id
	private String id;
	private String userId;
	private String productId;
	private String name;
	private Long quantity;
	private Double oneProductPrice;
	private Double price;
	private String desc;
	private Double totoal;
	
	public static Cart convertToCart(CartRequestForm cartRequestForm)
	{
		var cart = new Cart();
		cart.setProductId(cartRequestForm.getProductId());
		cart.setQuantity(cartRequestForm.getQuantity());
		cart.setOneProductPrice(cartRequestForm.getOneProductPrice());
		cart.setPrice(cartRequestForm.getOneProductPrice());
		cart.setDesc(cartRequestForm.getDesc());
		cart.setTotoal(cartRequestForm.getTotoal());
		cart.setName(cartRequestForm.getProductName());

		return cart;
	}

	public static Cart convertCartUpdateFormToCart(CartUpdateForm cartUpdateForm,Cart cart) {
	
		cart.setProductId(cartUpdateForm.getProductId());
		cart.setQuantity(cartUpdateForm.getQuantity());
		cart.setPrice(cartUpdateForm.getQuantity()*cart.getOneProductPrice());
		cart.setDesc(cartUpdateForm.getDesc());
        cart.setTotoal(cartUpdateForm.getTotoal());
		return cart;
	}
}
