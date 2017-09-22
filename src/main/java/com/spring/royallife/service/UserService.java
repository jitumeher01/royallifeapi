package com.spring.royallife.service;

import java.util.List;
import java.util.Set;

import com.spring.royallife.entity.BankEntity;
import com.spring.royallife.entity.MessageEntity;
import com.spring.royallife.entity.UserEntity;
import com.spring.royallife.form.BankForm;
import com.spring.royallife.form.MessageForm;
import com.spring.royallife.form.UserForm;

public interface UserService {
	void register(UserForm userForm);

	UserEntity verifyToken(String token);

	UserEntity findByUserId(String userId);

	UserEntity findByUserIdAndPassword(String userId, String password);

	void updateProfile(UserForm userForm);

	void updatePassword(UserForm userForm);

	Set<BankEntity> getAllBank(String userId);

	void addBank(BankForm bankForm);

	void updateBank(BankForm bankForm);

	void defaultBank(BankForm bankForm);

	void deleteBank(Integer id);

	List<UserEntity> getFriend(String userId);

	List<MessageEntity> getAllMessage(String userId);

	void addMessage(MessageForm messageForm);

	List<UserEntity> searchListUSer(String userId);

	List<UserEntity> getAllUser();

}
