package com.ramkarlapudi.userapilive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.ramkarlapudi.userapilive.entity.UserProfileEntity;
import com.ramkarlapudi.userapilive.repository.UserProfileSortandPagingRepo;

@Component
public class UserServicePagination {

	private Pageable pageinput;

	@Autowired
	private UserProfileSortandPagingRepo userProfileSortandPagingRepo;

	public List<UserProfileEntity> getallUsersbySort() {
		Sort sort = Sort.by("username");
		Iterable<UserProfileEntity> u = userProfileSortandPagingRepo.findAll(sort);
		return (List<UserProfileEntity>) u;
	}

	public List<UserProfileEntity> getallUsersbySortDesc() {
		Sort sort = Sort.by(Direction.DESC, "username");
		Iterable<UserProfileEntity> u = userProfileSortandPagingRepo.findAll(sort);
		return (List<UserProfileEntity>) u;
	}

	public List<UserProfileEntity> getUsersbyPage(int pageno  ) {
		pageinput = PageRequest.of(pageno, 4);
		Page<UserProfileEntity> pageData = userProfileSortandPagingRepo.findAll(pageinput);
		System.out.println(pageData.getTotalPages());
		return pageData.getContent();

	}
	public List<UserProfileEntity> getUsersbyPageDesc(int pageno  ) {
		Sort sort = Sort.by(Direction.DESC, "username");
		pageinput = PageRequest.of(pageno, 4,sort);
		Page<UserProfileEntity> pageData = userProfileSortandPagingRepo.findAll(pageinput);
		System.out.println(pageData.getTotalPages());
		return pageData.getContent();

	}

}
