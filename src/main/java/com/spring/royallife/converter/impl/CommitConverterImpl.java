package com.spring.royallife.converter.impl;

import org.springframework.stereotype.Service;

import com.spring.royallife.converter.CommitConverter;
import com.spring.royallife.dto.CommitData;
import com.spring.royallife.entity.CommitEntity;

@Service
public class CommitConverterImpl implements CommitConverter {

	public void convert(CommitEntity source, CommitData target) {
		if(source!=null){
			target.setCommitAmount(source.getCommitAmount());
			target.setCommitDate(source.getCommitDate());
			target.setId(source.getId());
			target.setMaturityAmount(source.getMaturityAmount());
			target.setMaturityDate(source.getMaturityDate());
			target.setName(source.getName());
			target.setPlanNo(source.getPlanNo());
			target.setReceiveAmount(source.getReceiveAmount());
			target.setSendAmount(source.getSendAmount());
		}
		
	}

}
