package com.spring.royallife.facade;

import com.spring.royallife.dto.CommitData;
import com.spring.royallife.dto.UserData;

public interface CommitFacade {
	public UserData getCommitDetails(String userId) throws Exception;
	void addCommit(CommitData commitData);
}
