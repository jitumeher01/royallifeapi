package com.spring.royallife.converter;

import com.spring.royallife.dto.MessageData;
import com.spring.royallife.entity.MessageEntity;

public interface MessageConverter {
	public void convert(MessageEntity source, MessageData target);
}
