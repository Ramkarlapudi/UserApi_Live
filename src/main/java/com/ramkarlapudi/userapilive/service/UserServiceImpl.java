package com.ramkarlapudi.userapilive.service;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ramkarlapudi.userapilive.entity.UserProfileEntity;
import com.ramkarlapudi.userapilive.exception.UserExceptions;
import com.ramkarlapudi.userapilive.repository.UserProfileRepo;

@Component
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
	@Autowired
	private UserProfileRepo userProfileRepo;

	@Override
	public ArrayList<UserProfileEntity> getAllUsers() {
		LOGGER.info("--------------> Entering  getAllUsers");
		ArrayList<UserProfileEntity> usersList = (ArrayList<UserProfileEntity>) userProfileRepo.findAll();
		LOGGER.info("--------------> Exiting  getAllUsers "+ usersList.size() );
		return usersList;
	}

	@Override
	public Optional<UserProfileEntity> getUserById(int id) {
		Optional<UserProfileEntity> user = userProfileRepo.findById(id);
		try {
			if (!user.isPresent())
				throw new UserExceptions("User id" + id);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;

	}

	public UserProfileEntity getUserBYname(String userName) {
		System.out.println("calling getUserbyName from service "+ userName);
		UserProfileEntity username = userProfileRepo.findByUserName(userName);
		//System.out.println("calling getUserbyName from service "+ username.toString());
		return username;

	}

	public UserProfileEntity uploadUser(UserProfileEntity userProfileEntity) {

		try {
			System.out.println("calling uploadUser from service ");
			Optional<UserProfileEntity> byuser = userProfileRepo.findById(userProfileEntity.getUserid());
			if (byuser.isPresent()) {
				
				UserProfileEntity userEntity = byuser.get();
				userEntity.setFirstname(userProfileEntity.getFirstname());
				userEntity.setLastname(userProfileEntity.getLastname());
				//userEntity.setPasscode(userProfileEntity.getPasscode());
				userEntity.setPhone(userProfileEntity.getPhone());
				userEntity.setEmail(userProfileEntity.getEmail());
				userEntity.setUsername(userProfileEntity.getUsername());
				userEntity.setCountry(userProfileEntity.getCountry());
				userEntity.setState(userProfileEntity.getState());
				userEntity.setAddress(userProfileEntity.getAddress());
				//userEntity.setPasscode(userProfileEntity.getPasscode());
				userEntity.setPincode(userProfileEntity.getPincode());
				userProfileRepo.save(userEntity);
				return userEntity;
			} else {
				return null;
			   
			}
			// UserProfileEntity entity = userProfileRepo.save(userProfileEntity);
			// return entity;
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		System.out.println("Exiting uploadUser from service");
		return null;

	}

}
