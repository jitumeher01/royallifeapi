/*package com.spring.royallife.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.royallife.converter.GiftConverter;
import com.spring.royallife.converter.UserConverter;
import com.spring.royallife.core.entity.GiftEntity;
import com.spring.royallife.dto.GiftData;
import com.spring.royallife.dto.UserData;

@Service
public class GiftConverterImpl implements GiftConverter{

	@Autowired
	UserConverter uc;
	
	public void convert(GiftEntity source, GiftData target) {
		if(source!=null){
			target.setAmount(source.getAmount());
			target.setCreateTime(source.getCreateTime());
			target.setExpiryTime(source.getExpiryTime());
			target.setId(source.getId());
			target.setImagePath(source.getImagePath());
			target.setMaturityAmount(source.getMaturityAmount());
			target.setRemaiHour(source.getRemaiHour());
			target.setStatus(source.getStatus());
			if(source.getSender()!=null){
				UserData sender=new UserData();
				uc.convert(source.getSender(), sender);
				target.setSender(sender);
			}
			if(source.getReceiver()!=null){
				UserData receiver=new UserData();
				uc.convert(source.getReceiver(), receiver);
				target.setReceiver(receiver);
			}
		}
		
	}

}
*/