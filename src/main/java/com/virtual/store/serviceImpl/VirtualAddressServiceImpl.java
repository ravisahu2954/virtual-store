package com.virtual.store.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.virtual.store.controller.service.VirtualAddressService;
import com.virtual.store.dto.AddressDto;
import com.virtual.store.entity.Address;
import com.virtual.store.entity.User;
import com.virtual.store.exceptions.AddressIsNotFoundException;
import com.virtual.store.form.AddressRequestForm;
import com.virtual.store.form.AddressUpdateForm;
import com.virtual.store.repository.VirtualAddressRepository;
import com.virtual.store.repository.VirtualUserRepository;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VirtualAddressServiceImpl implements VirtualAddressService {

	private final VirtualAddressRepository virtualAddressRepository;

	private final VirtualUserRepository virtualUserRepository;

	private final ModelMapper modelMapper;

	@Override
	public APIResponseDTO getAddresss() {
		List<Address> findAllAddressItem = virtualAddressRepository.findAll();
		List<AddressDto> collect = findAllAddressItem.stream()
				.map(address -> modelMapper.map(address, AddressDto.class)).collect(Collectors.toList());
		return APIResponseDTO.builder().data(collect).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched all orders").timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO getAddress(String productId) {
		Optional<Address> order = virtualAddressRepository.findById(productId);
		if (order.isEmpty())
			throw new AddressIsNotFoundException("there is no order with this id: " + productId);
		return APIResponseDTO.builder().data(order.get()).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched order").timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO addAddress(AddressRequestForm addressRequestForm) {

		Address address = modelMapper.map(addressRequestForm, Address.class);
		Optional<User> findById = virtualUserRepository.findById(addressRequestForm.getUserId());
		List<String> list = findById.get().getAddressId();
		if (list == null) {
			List<String> listAdd = new ArrayList<>();
			listAdd.add(address.getId());
			findById.get().setAddressId(listAdd);

		} else
			list.add(address.getId());

		virtualUserRepository.save(findById.get());
		virtualAddressRepository.save(address);
		return APIResponseDTO.builder().statusCode(HttpStatus.CREATED.value()).success(true).message("order is placed")
				.timeStamp(new Date(System.currentTimeMillis())).build();

	}

	@Override
	public APIResponseDTO deleteAddress(List<String> addresId) {
		addresId.forEach(ids -> {
			if (!virtualAddressRepository.findById(ids).isPresent())
				throw new AddressIsNotFoundException("there is no order with this productId : " + ids);

		});
		virtualAddressRepository.deleteAllByUserIdIn(addresId);

		return APIResponseDTO.builder().statusCode(HttpStatus.OK.value()).success(true).message("orders deleted")
				.timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO updateAddress(AddressUpdateForm cartUpdateForm) {

		Optional<Address> findAddress = virtualAddressRepository.findById(cartUpdateForm.getId());
		if (findAddress.isEmpty())
			throw new AddressIsNotFoundException(
					"there is no order with this productId : " + cartUpdateForm.getId());
		Address address = Address.convertAddressUpdateFormToAddress(cartUpdateForm, findAddress.get());
		virtualAddressRepository.save(address);
		return APIResponseDTO.builder().statusCode(HttpStatus.OK.value()).success(true).message("order updated")
				.timeStamp(new Date(System.currentTimeMillis())).build();
	}

}