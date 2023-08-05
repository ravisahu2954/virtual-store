package com.virtual.store.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private List<String> addressId;
	@CreatedDate
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime updatedDate;
	private Boolean isDeleted;

}
