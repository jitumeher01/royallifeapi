package com.spring.royallife.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.royallife.entity.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Long>{
	RoleEntity findByRole(String role);
}
