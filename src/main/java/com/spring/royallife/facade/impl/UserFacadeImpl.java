package com.spring.royallife.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.royallife.converter.BankDetailsConverter;
import com.spring.royallife.converter.CommitConverter;
import com.spring.royallife.converter.MessageConverter;
import com.spring.royallife.converter.UserConverter;
import com.spring.royallife.dto.BankDetailData;
import com.spring.royallife.dto.CommitData;
import com.spring.royallife.dto.MessageData;
import com.spring.royallife.dto.UserData;
import com.spring.royallife.entity.BankEntity;
import com.spring.royallife.entity.MessageEntity;
import com.spring.royallife.entity.UserEntity;
import com.spring.royallife.facade.UserFacade;
import com.spring.royallife.form.BankForm;
import com.spring.royallife.form.MessageForm;
import com.spring.royallife.form.UserForm;
import com.spring.royallife.service.UserService;

@Service
public class UserFacadeImpl implements UserFacade {
	@Autowired
    private UserService userService;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private BankDetailsConverter bankDetailsConverter;
	
	@Autowired
	private MessageConverter messageConverter;
	@Autowired
	private CommitConverter commitConverter;
    
	@Override
	public UserData findByUserIdAndPassword(String userId, String password) {
		UserEntity userEntity=userService.findByUserIdAndPassword(userId, password);
		if(userEntity!=null){
			UserData userData=new UserData();
			userConverter.convert(userEntity, userData);
			if(userEntity.getCommit()!=null){
				CommitData commitData=new CommitData();
				commitConverter.convert(userEntity.getCommit(), commitData);
				userData.setCommitData(commitData);
			}
			return userData;
		}
		return null;
	}


	@Override
	public void updateProfile(UserForm userForm) {
		userService.updateProfile(userForm);
	}

	@Override
	public UserData getUserById(String userId) {
		UserEntity userEntity=userService.findByUserId(userId);
		if(userEntity!=null){
			UserData userData=new UserData();
			userConverter.convert(userEntity, userData);
			return userData;
		}
		return null;
	}

	@Override
	public void updatePassword(UserForm userForm) throws Exception {
		userService.updatePassword(userForm);
	}

	@Override
	public List<BankDetailData> getAllBank(String userId) {
		Set<BankEntity> allBankEntity=userService.getAllBank(userId);
		List<BankDetailData> allBanakData= new ArrayList<BankDetailData>();
		for (BankEntity bankEntity : allBankEntity) {
			BankDetailData bankData=new BankDetailData();
			bankDetailsConverter.convert(bankEntity, bankData);
			allBanakData.add(bankData);
		}
		return allBanakData;
	}

	@Override
	public void addBank(BankForm bankForm) {
		userService.addBank(bankForm);
	}

	@Override
	public void updateBank(BankForm bankForm) {
		userService.updateBank(bankForm);
		
	}

	@Override
	public void defaultBank(BankForm bankForm) {
		userService.defaultBank(bankForm);
		
	}

	@Override
	public void deleteBank(Integer id) {
		userService.deleteBank(id);
	}

	@Override
	public List<UserData> getFriend(String userId) {
		
		List<UserEntity> allFriendsEntity=userService.getFriend(userId);
		List<UserData> allFriendsData=new ArrayList<UserData>();
		for (UserEntity userEntity : allFriendsEntity) {
			UserData userData=new UserData();
			userConverter.convert(userEntity, userData);
			allFriendsData.add(userData);
		}
		return allFriendsData;
	}

	@Override
	public List<MessageData> getAllMessage(String userId) {
		List<MessageEntity> allMessageEntity=userService.getAllMessage(userId);
		List<MessageData> allMessageData=new ArrayList<MessageData>();
		for (MessageEntity messageEntity : allMessageEntity) {
			MessageData messageData=new MessageData();
			messageConverter.convert(messageEntity, messageData);
			allMessageData.add(messageData);
		}
		return allMessageData;
	}

	@Override
	public void addMessage(MessageForm messageForm) {
		userService.addMessage(messageForm);
	}

	@Override
	public List<UserData> searchListUSer(String userId) {
		List<UserEntity> allUserEntity=userService.searchListUSer(userId);
		List<UserData> allUserData=new ArrayList<UserData>();
		for (UserEntity userEntity : allUserEntity) {
			UserData userData=new UserData();
			userConverter.convert(userEntity, userData);
			allUserData.add(userData);
		}
		return allUserData;
	}

	@Override
	public List<UserData> getAllUser() {
		List<UserEntity> allUserEntity=userService.getAllUser();
		List<UserData> allUserData=new ArrayList<UserData>();
		for (UserEntity userEntity : allUserEntity) {
			UserData userData=new UserData();
			userConverter.convert(userEntity, userData);
			allUserData.add(userData);
		}
		return allUserData;
	}

	@Override
	public UserData getProfile(String userId) {
		UserEntity userEntity=userService.findByUserId(userId);
		UserData userData=new UserData();
		if(userEntity!=null){
			userConverter.convert(userEntity, userData);
		}else {
			throw new UsernameNotFoundException("User Id Not found !");
		}		
		return userData;
	}

}
