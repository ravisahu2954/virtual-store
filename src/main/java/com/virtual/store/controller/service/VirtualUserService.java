package com.virtual.store.controller.service;

import java.util.List;

import com.virtual.store.form.UserRequestForm;
import com.virtual.store.form.UserUpdateForm;
import com.virtual.store.util.APIResponseDTO;

public interface VirtualUserService {

	APIResponseDTO getUsers();

	APIResponseDTO getUser(String productId);

	APIResponseDTO addUser(UserRequestForm cartRequestForm);

	APIResponseDTO deleteUser(List<String> userId);

	APIResponseDTO updateUser(UserUpdateForm cartUpdateForm);

}