package com.spring.royallife.entity;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BankRepository extends CrudRepository<BankEntity, String> {
	 Set<BankEntity> findByUserUserId(String userId);
	 
	 @Query("select u from BankEntity u where u.id = :id")
	 BankEntity findById(@Param("id") Integer id);
}
