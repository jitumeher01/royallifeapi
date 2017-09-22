package com.spring.royallife.converter;

import com.spring.royallife.dto.UserData;
import com.spring.royallife.entity.UserEntity;

public interface UserConverter {
	
	public void convert(UserEntity source, UserData target);

}
