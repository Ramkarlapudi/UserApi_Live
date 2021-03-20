package com.ramkarlapudi.userapilive.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramkarlapudi.userapilive.entity.UserProfileEntity;
import com.ramkarlapudi.userapilive.exception.UserExceptions;
import com.ramkarlapudi.userapilive.service.UserServiceImpl;

@RestController
@RequestMapping("/user-service")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ProController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/getDefaultUser")
	public String getUserData() {
		return "Ram Karlapudi";
	}

	@GetMapping("/getusers")
	public ArrayList<UserProfileEntity> getusers() {

		return userServiceImpl.getAllUsers();

	}

	@GetMapping("/getusersbyname/{name}")
	public UserProfileEntity getUserbyName(@PathVariable("name") String name) {
		System.out.println("calling getUserbyName " + name);
		UserProfileEntity userList = userServiceImpl.getUserBYname(name);
		if (userList == null) {
			throw new com.ramkarlapudi.userapilive.exception.UserExceptions("User Not found");
		}
		return userList;

	}

	@PostMapping("/uploadProfile")
	public UserProfileEntity uploadEntity(@RequestBody UserProfileEntity userProfileEntity) {
		System.out.println("calling uploadProfile " + userProfileEntity.toString());
		UserProfileEntity user = userServiceImpl.uploadUser(userProfileEntity);
		if (user == null) {
			throw new UserExceptions("User Not Found for the UserID: " + userProfileEntity.getUserid());
		}
		return user;
	}

	@PostMapping("/Rigester")
	public UserProfileEntity userRegistration(@RequestBody UserProfileEntity userProfileEntity) {
		if (userProfileEntity != null) {
			userProfileEntity.setVerified("NO");
		  return	userServiceImpl.registerUser(userProfileEntity);
		} else {
			throw new UserExceptions("User Data is Empty to Register ");
		}

	}
}
