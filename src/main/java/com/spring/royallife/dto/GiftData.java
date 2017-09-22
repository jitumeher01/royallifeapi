package com.spring.royallife.dto;

import java.util.Date;

public class GiftData {

	private Integer id;
	private String amount;
	private String status;
	private String imagePath;
	private String maturityAmount;
	private Date expiryTime;
	private Date createTime;
	private String remaiHour;
	
	private UserData sender;
	private UserData receiver;
	
	
	public UserData getSender() {
		return sender;
	}
	public void setSender(UserData sender) {
		this.sender = sender;
	}
	public UserData getReceiver() {
		return receiver;
	}
	public void setReceiver(UserData receiver) {
		this.receiver = receiver;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(String maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
	public Date getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemaiHour() {
		return remaiHour;
	}
	public void setRemaiHour(String remaiHour) {
		this.remaiHour = remaiHour;
	}
	
	
}
