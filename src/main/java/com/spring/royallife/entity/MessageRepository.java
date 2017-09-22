package com.spring.royallife.entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageEntity, String> {
	 List<MessageEntity> findByUserUserId(String userId);
}
