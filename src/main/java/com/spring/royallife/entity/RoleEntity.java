package com.spring.royallife.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.royallife.enums.RoleName;

@Entity
@Table(name = "role")
public class RoleEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(value = EnumType.STRING)
	private RoleName name=RoleName.USER;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

}
