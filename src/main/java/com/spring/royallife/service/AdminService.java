package com.spring.royallife.service;

import java.util.List;

import com.spring.royallife.entity.UserEntity;

public interface AdminService {
	
	List<UserEntity> findAllUser();
	
}
