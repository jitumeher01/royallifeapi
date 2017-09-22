package com.spring.royallife.converter;

import com.spring.royallife.dto.CommitData;
import com.spring.royallife.entity.CommitEntity;

public interface CommitConverter {
	public void convert(CommitEntity source, CommitData target);
}
