package com.spring.royallife.facade;

import com.spring.royallife.dto.CommitData;
import com.spring.royallife.dto.UserData;

public interface CommitFacade {
	public UserData getCommitDetails(String userId);
	
	public void addCommit(CommitData commitData,String userId);
}
