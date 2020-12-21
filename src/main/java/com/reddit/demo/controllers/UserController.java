package com.reddit.demo.controllers;

import com.reddit.demo.entities.*;
import com.reddit.demo.repos.UserRepo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class UserController {
  @Autowired
  private UserRepo userRepository;

  @PostMapping(path="/add")
  public @ResponseBody String addNewUser (@RequestParam String userName, @RequestParam String password) {
    User n = new User(userName, password);
    userRepository.save(n);
    return "Saved";
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
  
  @PutMapping(path="/update")
  public @ResponseBody Optional<User> updateUser(@RequestParam int id, @RequestParam String userName, @RequestParam String password) {
		  Optional<User> user = userRepository.findById(id);
		  User editUser = user.get();
		  editUser.setUserName(userName);
		  editUser.setPassword(password);
		  userRepository.save(editUser);
		  return userRepository.findById(editUser.getId());
  }
  
  @GetMapping(path="/select")
  public @ResponseBody Optional<User> findUser(@RequestParam int id) {
	  return userRepository.findById(id);
  }
}
