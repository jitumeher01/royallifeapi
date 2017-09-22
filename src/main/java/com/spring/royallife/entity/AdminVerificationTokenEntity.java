package com.spring.royallife.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="admin_verification_token")
public class AdminVerificationTokenEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String token;
	private Date expiryDate;
	
	
	@OneToOne
	@JsonIgnore
	private AdminEntity adminUser;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public AdminEntity getAdminUser() {
		return adminUser;
	}


	public void setAdminUser(AdminEntity adminUser) {
		this.adminUser = adminUser;
	}
}
