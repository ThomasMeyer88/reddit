package com.reddit.demo.controllers;

import com.reddit.demo.entities.*;
import com.reddit.demo.repos.UserRepo;

import java.net.http.HttpResponse;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(path="/user")
public class UserController {
  @Autowired
  private UserRepo userRepository;

  @PostMapping(path="/create")
  public @ResponseBody ResponseEntity<CustomResponse> createUser (@RequestBody User user) {
	  
	  if (userRepository.findUserByUserName(user.getUserName()).isPresent()) {
		return new ResponseEntity<>(new CustomResponse("Username is already in use.", true), HttpStatus.OK);
	  } else if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
		return new ResponseEntity<>(new CustomResponse("Email is already in use.", true), HttpStatus.OK);
	  } else {
	   userRepository.save(user);
	   return new ResponseEntity<>(new CustomResponse("User successfully created.", false), HttpStatus.OK);
	  }
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
  
  @DeleteMapping(path="/delete")
  public @ResponseBody String deleteUser(@RequestParam int id) {
	  try {
		  userRepository.deleteById(id);
		  return "Deleted";
	  } catch (Exception e) {
		  return e.toString();
	  }
  }
  
  @PutMapping(path="/update", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<String> updateUser(@RequestBody User user) {
	  Optional<User> oldUser = userRepository.findById(user.getId());
	  if (oldUser.isPresent()) {
		  User editUser = oldUser.get();
		  editUser.setUserName(user.getUserName());
		  editUser.setPassword(user.getPassword());
		  userRepository.save(editUser);
		  return new ResponseEntity<>("User Updated", HttpStatus.OK);
	  }
	  return new ResponseEntity<>("Update Failed", HttpStatus.OK);
  }
  
  @GetMapping(path="/select")
  public @ResponseBody Optional<User> findUser(@RequestParam int id) {
	  return userRepository.findById(id);
  }
}
