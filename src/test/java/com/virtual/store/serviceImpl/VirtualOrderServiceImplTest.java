package com.virtual.store.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.virtual.store.entity.Address;
import com.virtual.store.entity.Order;
import com.virtual.store.form.OrderRequestForm;
import com.virtual.store.repository.VirtualOrderRepository;
import com.virtual.store.util.APIResponseDTO;

@SpringBootTest
class VirtualOrderServiceImplTest {

	@InjectMocks
	private VirtualOrderServiceImpl virtualOrderService;

	@Mock
	private VirtualOrderRepository virtualOrderRepository;

	@Test
	void testPlaceOrder() {
		OrderRequestForm cartRequestForm = new OrderRequestForm();
		cartRequestForm.setShipTo(new Address());

		when(virtualOrderRepository.save(any(Order.class))).thenReturn(new Order());

		APIResponseDTO responseDTO = virtualOrderService.placeOrder(cartRequestForm);

		assertEquals(HttpStatus.CREATED.value(), responseDTO.getStatusCode());
	}

}
