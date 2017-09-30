package com.spring.royallife.facade;

import java.util.List;

import com.spring.royallife.dto.UserData;
import com.spring.royallife.form.UserForm;

public interface AdminFacade {
	List<UserData> findAllUser();

	UserData findUserById(String userId);

	void updateUser(UserForm userForm);

}
