package com.spring.royallife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.royallife.dto.CommitData;
import com.spring.royallife.facade.CommitFacade;

@RestController
@RequestMapping("/api/rest/user")
public class UserCommitController {
	
	@Autowired
	private CommitFacade commitFacade;
	
	@RequestMapping(value = "/commit/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getCommit(@PathVariable("userId") String userId) throws Exception {
			return ResponseEntity.status(HttpStatus.OK).body(commitFacade.getCommitDetails(userId));
	}
	
	@RequestMapping(value = "/addCommit", method = RequestMethod.POST)
	public ResponseEntity<?> addCommit(@RequestBody CommitData commitData) {
             commitFacade.addCommit(commitData);
			return ResponseEntity.status(HttpStatus.OK).body("Success !");
	}
}
