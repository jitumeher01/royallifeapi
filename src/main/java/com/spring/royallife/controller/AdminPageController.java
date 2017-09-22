package com.spring.royallife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.royallife.entity.AdminEntity;
import com.spring.royallife.facade.AdminFacade;
import com.spring.royallife.form.UserForm;
import com.spring.royallife.service.AdminService;

@RestController("/api/rest/admin")
public class AdminPageController {
	
	@Autowired
	private AdminFacade adminFacade;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody UserForm userForm) {

		AdminEntity adminEntity = adminFacade.findByAdminIdAandPassword(userForm.getUserId(), userForm.getPassword());
		if (adminEntity != null) {
			return ResponseEntity.status(HttpStatus.OK).body(adminEntity);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Admin Id/Password !");
		}
	}
	
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUser(@RequestHeader(value = "token") String token) {
		AdminEntity adminEntity = adminService.verifyToken(token);
		if (adminEntity != null) {
			return ResponseEntity.status(HttpStatus.OK).body(adminFacade.findAllUser());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}
	
	@RequestMapping(value = "/singleUser", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@RequestHeader(value = "token") String token,@RequestBody UserForm userForm) {
		AdminEntity adminEntity = adminService.verifyToken(token);
		if (adminEntity != null) {
			return ResponseEntity.status(HttpStatus.OK).body(adminFacade.findUserById(userForm.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public ResponseEntity<?> updateUser(@RequestHeader(value = "token") String token,@RequestBody UserForm userForm) {
		AdminEntity adminEntity = adminService.verifyToken(token);
		if (adminEntity != null) {
			adminFacade.updateUser(userForm);
			return ResponseEntity.status(HttpStatus.OK).body("User Data Updated !");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

}
