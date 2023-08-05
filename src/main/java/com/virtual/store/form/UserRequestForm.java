package com.virtual.store.form;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestForm {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private List<String> addressId;
	private Boolean isDeleted;

}
