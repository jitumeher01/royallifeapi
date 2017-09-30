package com.spring.royallife.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.royallife.entity.UserEntity;
import com.spring.royallife.repository.UserRepository;
import com.spring.royallife.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntity> findAllUser() {
		return (List<UserEntity>) userRepository.findAll();
	}

}
