package com.ramkarlapudi.userapilive.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ramkarlapudi.userapilive.entity.UserProfileEntity;

@Repository
public interface UserProfileCrudRepo extends CrudRepository<UserProfileEntity, Integer> {

}
