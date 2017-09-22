package com.spring.royallife.converter.impl;

import org.springframework.stereotype.Service;

import com.spring.royallife.converter.BankDetailsConverter;
import com.spring.royallife.dto.BankDetailData;
import com.spring.royallife.entity.BankEntity;

@Service
public class BankDetailsConverterImpl implements BankDetailsConverter{

	
	
	public void convert(BankEntity bankDetailEntity, BankDetailData bankDetailData) {
		
		if(bankDetailEntity!=null){
			bankDetailData.setBankAccName(bankDetailEntity.getBankAccName());
			bankDetailData.setBankAccNo(bankDetailEntity.getBankAccNo());
			bankDetailData.setBankName(bankDetailEntity.getBankName());
			bankDetailData.setBranchName(bankDetailEntity.getBranchName());
			bankDetailData.setId(bankDetailEntity.getId());
			bankDetailData.setIfsc(bankDetailEntity.getIfscCode());
			bankDetailData.setIsDefault(bankDetailEntity.getIsDefault());	
		}
		
	}

}
