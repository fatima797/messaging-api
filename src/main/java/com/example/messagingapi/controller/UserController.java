package com.example.messagingapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.messagingapi.dto.CreateUserDTO;
import com.example.messagingapi.dto.UserResponseDTO;
import com.example.messagingapi.model.User;
import com.example.messagingapi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody CreateUserDTO dto){
		User savedUser = userService.createUser(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponseDTO(savedUser));
	}

}
