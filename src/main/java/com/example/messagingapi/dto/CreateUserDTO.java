package com.example.messagingapi.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.example.messagingapi.role.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private Set<Role> roles;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}
