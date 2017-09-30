package com.spring.royallife.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.royallife.converter.UserConverter;
import com.spring.royallife.dto.UserData;
import com.spring.royallife.entity.UserEntity;
import com.spring.royallife.facade.AdminFacade;
import com.spring.royallife.facade.UserFacade;
import com.spring.royallife.form.UserForm;
import com.spring.royallife.repository.UserRepository;
import com.spring.royallife.service.AdminService;
import com.spring.royallife.service.UserService;

@Service
public class AdminFacadeImpl implements AdminFacade {

	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userservice;
	@Autowired
	private UserFacade userFacade;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private UserRepository userRepository;


	@Override
	public List<UserData> findAllUser() {
		List<UserEntity> allUserEntity=adminService.findAllUser();
		List<UserData> allUserData=new ArrayList<UserData>();
		for (UserEntity userEntity : allUserEntity) {
			UserData userData=new UserData();
			userConverter.convert(userEntity, userData);
			allUserData.add(userData);
		}
		return allUserData;
	}

	@Override
	public UserData findUserById(String userId) {
		return userFacade.getUserById(userId);
	}

	@Override
	public void updateUser(UserForm userForm) {
		UserEntity userEntity=userservice.findByUserId(userForm.getUserId());
		userEntity.setName(userForm.getName());
		userEntity.setEmail(userForm.getEmail());
		userEntity.setPassword(userForm.getPassword());
		userEntity.setMobile(userForm.getMobile());
		userEntity.setAddress(userForm.getAddress());
		userEntity.setGender(userForm.getGender());
		userEntity.setState(userForm.getState());
		userRepository.save(userEntity);
	}

}
