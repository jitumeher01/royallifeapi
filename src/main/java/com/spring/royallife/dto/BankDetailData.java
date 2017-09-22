package com.spring.royallife.dto;

public class BankDetailData {

	private Integer id;
	private String bankAccNo;
	private String bankAccName;
	private String bankName;
	private String branchName;
	private String ifsc;
	private String impsMobile;
	private String impsNo;
	private Boolean isDefault;

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getBankAccName() {
		return bankAccName;
	}

	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getImpsMobile() {
		return impsMobile;
	}

	public void setImpsMobile(String impsMobile) {
		this.impsMobile = impsMobile;
	}

	public String getImpsNo() {
		return impsNo;
	}

	public void setImpsNo(String impsNo) {
		this.impsNo = impsNo;
	}
}
