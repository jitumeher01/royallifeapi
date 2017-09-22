package com.spring.royallife.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.royallife.entity.AdminEntity;
import com.spring.royallife.entity.AdminRepository;
import com.spring.royallife.entity.UserEntity;
import com.spring.royallife.entity.UserRepository;
import com.spring.royallife.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public AdminEntity findAdminByIdAndPassword(String adminId, String password) {
		return adminRepository.findByAdminIdAndPassword(adminId, password);
	}

	@Override
	public List<UserEntity> findAllUser() {
		return (List<UserEntity>) userRepository.findAll();
	}

	@Override
	public AdminEntity verifyToken(String token) {
		return adminRepository.findByToken(token);
	}

}
