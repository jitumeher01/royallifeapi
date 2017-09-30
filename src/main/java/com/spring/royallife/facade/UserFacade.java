package com.spring.royallife.facade;

import java.util.List;

import com.spring.royallife.dto.BankDetailData;
import com.spring.royallife.dto.MessageData;
import com.spring.royallife.dto.UserData;
import com.spring.royallife.form.BankForm;
import com.spring.royallife.form.MessageForm;
import com.spring.royallife.form.UserForm;

public interface UserFacade {
	UserData findByUserIdAndPassword(String userId, String password);

	void updateProfile(UserForm userForm);

	UserData getUserById(String userId);

	void updatePassword(UserForm userForm) throws Exception;

	List<BankDetailData> getAllBank(String userId);

	void addBank(BankForm bankForm);

	void updateBank(BankForm bankForm);

	void defaultBank(BankForm bankForm);

	void deleteBank(Integer id);

	Object getFriend(String userId);

	List<MessageData> getAllMessage(String userId);

	void addMessage(MessageForm messageForm);
	
	List<UserData> searchListUSer(String userId);

	List<UserData> getAllUser();
	
	
	UserData getProfile(String userId);
}
