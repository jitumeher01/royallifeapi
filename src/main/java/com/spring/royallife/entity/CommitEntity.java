package com.spring.royallife.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commit")
public class CommitEntity {

	@Id
	@GeneratedValue
	private Integer id;

	private Date commitDate;
	private Date maturityDate;
	private String commitAmount;
	private String maturityAmount;
	private String sendAmount;
	private String receiveAmount;
	private String name;
	private String planNo;

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

	@OneToOne
	@JoinColumn(name = "userId")
	private UserEntity user;

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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
