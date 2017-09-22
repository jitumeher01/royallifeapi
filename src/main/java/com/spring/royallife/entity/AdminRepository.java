package com.spring.royallife.entity;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminEntity, String> {
	
	AdminEntity findByAdminIdAndPassword(String adminId, String password);
	AdminEntity findByToken(String token);

}
