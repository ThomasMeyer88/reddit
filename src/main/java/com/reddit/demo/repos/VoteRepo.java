package com.reddit.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.reddit.demo.entities.Vote;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface VoteRepo extends CrudRepository<Vote, Integer> {

}