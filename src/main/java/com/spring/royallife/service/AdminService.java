package com.spring.royallife.service;

import java.util.List;

import com.spring.royallife.entity.AdminEntity;
import com.spring.royallife.entity.UserEntity;

public interface AdminService {
	AdminEntity findAdminByIdAndPassword(String userId, String password);
	
	List<UserEntity> findAllUser();
	
	AdminEntity verifyToken(String token);
}
