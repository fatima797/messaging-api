package com.example.messagingapi;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.messagingapi.role.Role;
import com.example.messagingapi.user.User;
import com.example.messagingapi.user.UserRepository;

// Assume User, Role, RoleName, UserRepository, RoleRepository exist in your project

@SpringBootApplication
public class MessagingApiApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(MessagingApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MessagingApiApplication.class, args);
	}
	
	/**
	 * Single CommandLineRunner to ensure Roles are created before Users are created.
	 */
	@Bean
	public CommandLineRunner initDatabase(UserRepository userRepository) {
		return (args -> {
            
            // Save user only if the user table is empty.
            if (userRepository.count() == 0) {
                
                Set<Role> sarahRoles = Set.of(Role.ROLE_ADMIN, Role.ROLE_PRODUCER);
         
                User saraUser = new User(
                		null,
                		"Sarah", "Smith", 
                		"sarah@gmail.com", 
                		"sarah123", 
                		"pass123",
                		LocalDateTime.now(), 
                		sarahRoles);
                
                userRepository.save(saraUser);
                
                LOG.info("User 'Sarah' saved with multiple roles.");
            }
            
            LOG.info("Users found with findAll():");
            LOG.info("-----------------------------");
            userRepository.findAll().forEach(user -> 
            	LOG.info("User: {}", user.toString()));
		});
	}
}