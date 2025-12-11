package com.example.messagingapi.dto;

import java.util.Set;
import java.util.UUID;

import com.example.messagingapi.model.User;
import com.example.messagingapi.role.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private Set<Role> roles;
	
	public UserResponseDTO(User savedUser) {
		this.id = savedUser.getId();
		this.firstName = savedUser.getFirstName();
		this.lastName = savedUser.getLastName();
		this.email = savedUser.getEmail();
		this.username = savedUser.getUsername();
		this.roles = savedUser.getRoles();
	}

}
