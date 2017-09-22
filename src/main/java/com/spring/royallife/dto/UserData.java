package com.spring.royallife.dto;

import java.util.Date;
import java.util.List;

public class UserData {

	private Integer id;
	private String userId;
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String address;
	private String gender;
	private String sponsorId;
	private String sponsorName;
	private String sponsorMobile;
	private String state;
	private List<BankDetailData> bankDetailData;
	private CommitData commitData;

	private String token;
	private Date expiryDate;
	private boolean isComit;

	public boolean isComit() {
		return isComit;
	}

	public void setComit(boolean isComit) {
		this.isComit = isComit;
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

	public CommitData getCommitData() {
		return commitData;
	}

	public void setCommitData(CommitData commitData) {
		this.commitData = commitData;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<BankDetailData> getBankDetailData() {
		return bankDetailData;
	}

	public void setBankDetailData(List<BankDetailData> bankDetailData) {
		this.bankDetailData = bankDetailData;
	}

}
