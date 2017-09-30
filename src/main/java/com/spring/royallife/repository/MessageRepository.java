package com.spring.royallife.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.royallife.entity.MessageEntity;

public interface MessageRepository extends CrudRepository<MessageEntity, String> {
	 List<MessageEntity> findByUserUserId(String userId);
}
