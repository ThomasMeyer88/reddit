package com.reddit.demo.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.reddit.demo.entities.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepo extends CrudRepository<User, Integer> {
	Optional<User> findUserByUserName(String username);
	
	Optional<User> findUserByEmail(String email);
}