package com.virtual.store.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.virtual.store.controller.service.VirtualCartService;
import com.virtual.store.dto.CartDto;
import com.virtual.store.entity.Cart;
import com.virtual.store.exceptions.AddressIsNotFoundException;
import com.virtual.store.form.CartRequestForm;
import com.virtual.store.form.CartUpdateForm;
import com.virtual.store.repository.VirtualCartRepository;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VirtualCartServiceImpl implements VirtualCartService {

	private final VirtualCartRepository virtualCartRepository;

	private final ModelMapper modelMapper;

	@Override
	public APIResponseDTO getCarts() {

		List<Cart> findAllCartItem = virtualCartRepository.findAll();
		Double total = findAllCartItem.stream().mapToDouble(cart -> cart.getPrice()) // Assuming there is a getPrice()
																						// method in Cart class
				.sum();
		List<CartDto> collect = findAllCartItem.stream().map(cart -> modelMapper.map(cart, CartDto.class))
				.collect(Collectors.toList());
		return APIResponseDTO.builder().data(collect).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched all carts").timeStamp(new Date(System.currentTimeMillis())).total(total).build();
	}

	@Override
	public APIResponseDTO addCart(CartRequestForm cartRequestForm) {

		Cart cart = Cart.convertToCart(cartRequestForm);
		virtualCartRepository.save(cart);
		return APIResponseDTO.builder().statusCode(HttpStatus.OK.value()).success(true).message("added in cart")
				.timeStamp(new Date(System.currentTimeMillis())).build();

	}

	@Override
	public APIResponseDTO deleteCart(Long productId) {
		virtualCartRepository.deleteByProductId(productId);
		return APIResponseDTO.builder().statusCode(HttpStatus.OK.value()).success(true).message("item delete from cart")
				.timeStamp(new Date(System.currentTimeMillis())).build();

	}

	@Override
	public APIResponseDTO updateCart(CartUpdateForm cartUpdateForm) {
		Optional<Cart> findCart = virtualCartRepository.findByProductId(cartUpdateForm.getProductId());
		if (findCart.isEmpty())
			throw new AddressIsNotFoundException(
					"there is no order with this productId : " + cartUpdateForm.getProductId());

		Cart cart = Cart.convertCartUpdateFormToCart(cartUpdateForm, findCart.get());
		virtualCartRepository.save(cart);
		return APIResponseDTO.builder().statusCode(HttpStatus.OK.value()).success(true).message("item updated in cart")
				.timeStamp(new Date(System.currentTimeMillis())).build();

	}

}
