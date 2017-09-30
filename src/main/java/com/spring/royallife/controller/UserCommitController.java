//package com.spring.royallife.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.spring.royallife.dto.CommitData;
//import com.spring.royallife.dto.UserData;
//import com.spring.royallife.facade.CommitFacade;
//import com.spring.royallife.facade.UserFacade;
//import com.spring.royallife.service.UserService;
//
//@RestController
//@RequestMapping("/api/rest/user")
//public class UserCommitController {
//	@Autowired
//	private UserFacade userFacade;
//
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private CommitFacade commitFacade;
//	
//	@RequestMapping(value = "/commit", method = RequestMethod.GET)
//	public ResponseEntity<?> getCommit(@RequestHeader(value = "token") String token) {
//
//		UserData userdata = userFacade.verifyToken(token);
//		if (userdata != null) {
//
//			return ResponseEntity.status(HttpStatus.OK).body(commitFacade.getCommitDetails(userdata.getUserId()));
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
//		}
//
//	}
//	
//	@RequestMapping(value = "/addCommit", method = RequestMethod.POST)
//	public ResponseEntity<?> addCommit(@RequestHeader(value = "token") String token, @RequestBody CommitData commitData) {
//
//		UserData userdata = userFacade.verifyToken(token);
//		if (userdata != null) {
//             commitFacade.addCommit(commitData, userdata.getUserId());
//			return ResponseEntity.status(HttpStatus.OK).body(commitFacade.getCommitDetails(userdata.getUserId()));
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
//		}
//
//	}
//}
