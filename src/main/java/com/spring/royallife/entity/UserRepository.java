package com.spring.royallife.entity;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserEntity, String> {
	UserEntity findByUserId(String userId);
	 @Query("select u from UserEntity u where u.userId = :userId AND u.password=:password")
	 UserEntity findByUserIdPassword(@Param("userId") String userId, @Param("password") String password);
	 
	 UserEntity findByUserIdAndPassword(String userId, String password);
	 
	 UserEntity findByToken(String token);
	 
	 List<UserEntity> findFriendsBySponsorId(String sponsorId);
	 
	 @Query("select u from UserEntity u where u.userId LIKE '%:userId%'")
	 List<UserEntity> searchUserList(String userId);
 
	 
}
