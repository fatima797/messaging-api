package com.example.messagingapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.messagingapi.dto.CreateUserDTO;
import com.example.messagingapi.model.User;

public interface UserService {
	User createUser(CreateUserDTO dto);
	Optional<User> getUserById(UUID id);
	Optional<User> getUserByUsername(String username);
	List<User> getAllUsers();

}
