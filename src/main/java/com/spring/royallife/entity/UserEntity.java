package com.spring.royallife.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_table")
public class UserEntity {

	@Id
	private String userId;
	private String password;
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String state;
	private String gender;
	private String sponsorId;
	private String sponsorName;
	private String sponsorMobile;
	
	private String token;
	private Date expiryDate;



	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<BankEntity> bankEntity = new HashSet<BankEntity>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	@Fetch(value = FetchMode.SUBSELECT)
	private List<MessageEntity> messages = new ArrayList<MessageEntity>();
	

	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	@JsonIgnore
	private CommitEntity commit = new CommitEntity();
	
	

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

	public Set<BankEntity> getBankEntity() {
		return bankEntity;
	}

	public void setBankEntity(Set<BankEntity> bankEntity) {
		this.bankEntity = bankEntity;
	}

	public CommitEntity getCommit() {
		return commit;
	}

	public void setCommit(CommitEntity commit) {
		this.commit = commit;
	}

	public List<MessageEntity> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageEntity> messages) {
		this.messages = messages;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public String getSponsorMobile() {
		return sponsorMobile;
	}

	public void setSponsorMobile(String sponsorMobile) {
		this.sponsorMobile = sponsorMobile;
	}

}
