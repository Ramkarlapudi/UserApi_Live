package com.ramkarlapudi.userapilive.service;

import java.util.ArrayList;
import java.util.Optional;

import com.ramkarlapudi.userapilive.entity.UserProfileEntity;

public interface UserService {
	
	public  ArrayList<UserProfileEntity> getAllUsers();
	
    public Optional<UserProfileEntity>  getUserById(int id );	

}
