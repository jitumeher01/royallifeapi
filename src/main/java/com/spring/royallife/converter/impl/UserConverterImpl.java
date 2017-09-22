package com.spring.royallife.converter.impl;
import org.springframework.stereotype.Service;
import com.spring.royallife.converter.UserConverter;
import com.spring.royallife.dto.UserData;
import com.spring.royallife.entity.UserEntity;


@Service
public class UserConverterImpl implements UserConverter {
	
	public void convert(UserEntity source, UserData target) {
		
		if(source!=null){
			target.setUserId(source.getUserId());
			target.setName(source.getName());
			target.setEmail(source.getEmail());
			target.setMobile(source.getMobile());
			target.setAddress(source.getAddress());
			target.setPassword(source.getPassword());
			target.setGender(source.getGender());
			target.setSponsorId(source.getSponsorId());
			target.setSponsorName(source.getSponsorName());
			target.setSponsorMobile(source.getSponsorMobile());
			target.setState(source.getState());
		    target.setToken(source.getToken());
		    target.setExpiryDate(source.getExpiryDate());
		}
		
	}

}
