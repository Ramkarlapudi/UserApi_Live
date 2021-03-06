package com.ramkarlapudi.userapilive.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ramkarlapudi.userapilive.entity.UserProfileEntity;

@Repository
public interface UserProfileSortandPagingRepo extends PagingAndSortingRepository<UserProfileEntity, Integer> {

	
}
