package com.spring.royallife.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.royallife.entity.BankEntity;
import com.spring.royallife.entity.BankRepository;
import com.spring.royallife.entity.MessageEntity;
import com.spring.royallife.entity.MessageRepository;
import com.spring.royallife.entity.UserEntity;
import com.spring.royallife.entity.UserRepository;
import com.spring.royallife.form.BankForm;
import com.spring.royallife.form.MessageForm;
import com.spring.royallife.form.UserForm;
import com.spring.royallife.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public void register(UserForm userForm) {
		UserEntity userEntity = new UserEntity();
		
		getSponser(userForm);
		if (userForm != null) {
			userEntity.setUserId(userForm.getUserId());
			userEntity.setName(userForm.getName());
			userEntity.setEmail(userForm.getEmail());
			userEntity.setPassword(userForm.getPassword());
			userEntity.setMobile(userForm.getMobile());
			userEntity.setAddress(userForm.getAddress());
			userEntity.setGender(userForm.getGender());
			userEntity.setState(userForm.getState());
			userEntity.setSponsorId(userForm.getSponsorId());
			userEntity.setSponsorName(userForm.getSponsorName());
			userEntity.setSponsorMobile(userForm.getSponsorMobile());

			String token = UUID.randomUUID().toString();
			Date newDate = DateUtils.addHours(new Date(), 24);
			userEntity.setToken(token);
			userEntity.setExpiryDate(newDate);
			userRepository.save(userEntity);
		}
		
	}

	@Override
	public UserEntity verifyToken(String token) {
		return userRepository.findByToken(token);
	}

	@Override
	public UserEntity findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public UserEntity findByUserIdAndPassword(String userId, String password) {
		UserEntity userEntity=userRepository.findByUserIdAndPassword(userId, password);
		if(userEntity!=null){
			String token = UUID.randomUUID().toString();
			Date newDate = DateUtils.addHours(new Date(), 24);
			userEntity.setToken(token);
			userEntity.setExpiryDate(newDate);
			userRepository.save(userEntity);
			return userEntity;
		}	
		return null;
	}
	
	
	private void getSponser(UserForm userForm) {
		if (userRepository.findByUserId(userForm.getSponsorId()) == null) {
			userForm.setSponsorId("royallife");
			userForm.setSponsorName("Royal Life");
			userForm.setSponsorMobile("1234567890");
		} else {
			UserEntity sponser = userRepository.findByUserId(userForm.getSponsorId());
			userForm.setSponsorName(sponser.getName());
			userForm.setSponsorMobile(sponser.getMobile());
		}
	}

	@Override
	public void updateProfile(UserForm userForm) {
		UserEntity userEntity=userRepository.findByUserId(userForm.getUserId());
		userEntity.setAddress(userForm.getAddress());
		userEntity.setGender(userForm.getGender());
		userEntity.setMobile(userForm.getMobile());
		userEntity.setName(userForm.getName());
		userRepository.save(userEntity);
	}

	@Override
	public void updatePassword(UserForm userForm) {
		UserEntity userEntity=userRepository.findByUserId(userForm.getUserId());
		userEntity.setPassword(userForm.getPassword());
	}

	@Override
	public Set<BankEntity> getAllBank(String userId) {
		return bankRepository.findByUserUserId(userId);
	}

	@Override
	public void addBank(BankForm bankForm) {
		UserEntity userEntity = userRepository.findByUserId(bankForm.getUserId());
		BankEntity bankEntity = new BankEntity();
		bankEntity.setBankAccNo(bankForm.getBankAccNo());
		bankEntity.setBankAccName(bankForm.getBankAccName());
		bankEntity.setBankName(bankForm.getBankName());
		bankEntity.setBranchName(bankForm.getBranchName());
		bankEntity.setIfscCode(bankForm.getIfsc());
		bankEntity.setIsDefault(true);
		bankEntity.setUserEntity(userEntity);

		Hibernate.initialize(userEntity.getBankEntity());

		for (BankEntity be : userEntity.getBankEntity()) {
			be.setIsDefault(false);
			bankRepository.save(be);
		}
		bankRepository.save(bankEntity);
		
	}

	@Override
	public void updateBank(BankForm bankForm) {
		BankEntity bankEntity = bankRepository.findById(bankForm.getId());
		bankEntity.setBankAccNo(bankForm.getBankAccNo());
		bankEntity.setBankAccName(bankForm.getBankAccName());
		bankEntity.setBankName(bankForm.getBankName());
		bankEntity.setBranchName(bankForm.getBranchName());
		bankEntity.setIfscCode(bankForm.getIfsc());
		
		UserEntity ue = userRepository.findByUserId(bankEntity.getUserEntity().getUserId());
		Hibernate.initialize(ue.getBankEntity());

		for (BankEntity be : ue.getBankEntity()) {
			be.setIsDefault(false);
			bankRepository.save(be);
		}
		bankEntity.setIsDefault(true);
		bankRepository.save(bankEntity);
	}

	@Override
	public void defaultBank(BankForm bankForm) {
		UserEntity ue = userRepository.findByUserId(bankForm.getUserId());
		Hibernate.initialize(ue.getBankEntity());
		for (BankEntity be : ue.getBankEntity()) {
			if (be.getId().equals(bankForm.getId())) {
				be.setIsDefault(true);
			} else {
				be.setIsDefault(false);
			}
			bankRepository.save(be);
		}
	}

	@Override
	public void deleteBank(Integer id) {
		BankEntity bankEntity = bankRepository.findById(id);
		bankRepository.delete(bankEntity);
	}

	@Override
	public List<UserEntity> getFriend(String userId) {
		return userRepository.findFriendsBySponsorId(userId);
	}

	@Override
	public List<MessageEntity> getAllMessage(String userId) {
		return messageRepository.findByUserUserId(userId);
	}

	@Override
	public void addMessage(MessageForm messageForm) {
		UserEntity userEntity = userRepository.findByUserId(messageForm.getSenderId());
		MessageEntity messageEntity = new MessageEntity();
		messageEntity.setSenderId(messageForm.getSenderId());
		messageEntity.setReceiverId(messageForm.getReceiverId());
		messageEntity.setSubject(messageForm.getSubject());
		messageEntity.setMessage(messageForm.getMessage());
		messageEntity.setDate(new Date().toString());
		messageEntity.setUser(userEntity);
		messageRepository.save(messageEntity);
	}

	@Override
	public List<UserEntity> searchListUSer(String userId) {
		return userRepository.searchUserList(userId);
	}

	@Override
	public List<UserEntity> getAllUser() {
		return (List<UserEntity>) userRepository.findAll();
	}
}
