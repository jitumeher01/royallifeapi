package com.spring.royallife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.royallife.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, String> {
	UserEntity findByUserId(String userId);
	 
	UserEntity findByUserIdAndPassword(String userId, String password);
	 
	List<UserEntity> findFriendsBySponsorId(String sponsorId);
	 
	@Query("select u from UserEntity u where u.userId LIKE '%:userId%'")
	List<UserEntity> searchUserList(String userId);
 
	 
}
