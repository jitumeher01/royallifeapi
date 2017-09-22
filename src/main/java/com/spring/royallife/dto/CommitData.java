package com.spring.royallife.dto;

import java.util.Date;

public class CommitData {

	private Integer id;

	private Date commitDate;
	private Date maturityDate;
	private String commitAmount;
	private String maturityAmount;
	private String sendAmount;
	private String receiveAmount;
	
	private String name;
	private String planNo;
	private String plan;
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCommitDate() {
		return commitDate;
	}
	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public String getCommitAmount() {
		return commitAmount;
	}
	public void setCommitAmount(String commitAmount) {
		this.commitAmount = commitAmount;
	}
	public String getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(String maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
	public String getSendAmount() {
		return sendAmount;
	}
	public void setSendAmount(String sendAmount) {
		this.sendAmount = sendAmount;
	}
	public String getReceiveAmount() {
		return receiveAmount;
	}
	public void setReceiveAmount(String receiveAmount) {
		this.receiveAmount = receiveAmount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlanNo() {
		return planNo;
	}
	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}

	

}
