package com.spring.royallife.dto;

import java.util.Date;

public class GrowthRowData {
	private String id;
	private String userId;
	private String commitAmount;
	private String growthAmount;
	private String totalAmount;
	private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommitAmount() {
		return commitAmount;
	}

	public void setCommitAmount(String commitAmount) {
		this.commitAmount = commitAmount;
	}

	public String getGrowthAmount() {
		return growthAmount;
	}

	public void setGrowthAmount(String growthAmount) {
		this.growthAmount = growthAmount;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
