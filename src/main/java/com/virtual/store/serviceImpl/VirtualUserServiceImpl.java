
package com.virtual.store.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.virtual.store.controller.service.VirtualUserService;
import com.virtual.store.dto.UserDto;
import com.virtual.store.entity.User;
import com.virtual.store.exceptions.UserIsNotFoundException;
import com.virtual.store.form.UserRequestForm;
import com.virtual.store.form.UserUpdateForm;
import com.virtual.store.repository.VirtualUserRepository;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VirtualUserServiceImpl implements VirtualUserService {

	private final VirtualUserRepository virtualUserRepository;
	
	private final ModelMapper modelMapper;

	@Override
	public APIResponseDTO getUsers() {
		List<User> findAllUserItem = virtualUserRepository.findAll();
		//List<UserDto> collect = findAllUserItem.stream().modelMapper.map(user,UserDto.class).collect(Collectors.toList());
		return APIResponseDTO.builder().data(findAllUserItem).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched all users").timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO getUser(String productId) {
		Optional<User> user = virtualUserRepository.findById(productId);
		UserDto map = modelMapper.map(user.get(), UserDto.class);
		if (user.isEmpty())
			throw new UserIsNotFoundException("there is no user with this id: " + productId);
		return APIResponseDTO.builder().data(map).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched user").timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO addUser(UserRequestForm cartRequestForm) {
		User user = modelMapper.map(cartRequestForm, User.class);
		virtualUserRepository.save(user);
		return APIResponseDTO.builder().statusCode(HttpStatus.CREATED.value()).success(true).message("user is placed")
				.timeStamp(new Date(System.currentTimeMillis())).build();

	}

	@Override
	public APIResponseDTO deleteUser(List<String> userId) {
		userId.forEach(ids -> {
			if (!virtualUserRepository.findById(ids).isPresent())
				throw new UserIsNotFoundException("");

		});
		virtualUserRepository.deleteAllByIdIn(userId);

		return APIResponseDTO.builder().statusCode(HttpStatus.OK.value()).success(true).message("users deleted")
				.timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO updateUser(UserUpdateForm cartUpdateForm) {

		Optional<User> user = virtualUserRepository.findById(cartUpdateForm.getId());
		if (user.isEmpty())
			throw new UserIsNotFoundException("");
		User cart = modelMapper.map(cartUpdateForm, User.class);
		virtualUserRepository.save(cart);
		return APIResponseDTO.builder().statusCode(HttpStatus.OK.value()).success(true).message("user updated")
				.timeStamp(new Date(System.currentTimeMillis())).build();
	}

}
