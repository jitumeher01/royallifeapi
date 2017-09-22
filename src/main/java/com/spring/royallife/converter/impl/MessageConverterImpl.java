package com.spring.royallife.converter.impl;

import org.springframework.stereotype.Service;

import com.spring.royallife.converter.MessageConverter;
import com.spring.royallife.dto.MessageData;
import com.spring.royallife.entity.MessageEntity;
@Service
public class MessageConverterImpl implements MessageConverter {

	@Override
	public void convert(MessageEntity source, MessageData target) {
		if(source!=null){
			target.setId(source.getId());
			target.setDate(source.getDate());
			target.setMessage(source.getMessage());
			target.setReceiverId(source.getReceiverId());
			target.setSenderId(source.getSenderId());
			target.setSubject(source.getSubject());
		}
	}

}
