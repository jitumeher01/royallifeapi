package com.spring.royallife.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.royallife.form.UserForm;
import com.spring.royallife.service.UserService;


@RestController
@RequestMapping("/api/rest")
public class IndexPageController {
	
	
	@Autowired
	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/public", method = RequestMethod.GET)
	public ResponseEntity<?> home() {
		return ResponseEntity.status(HttpStatus.OK).body("Welcome ToJiiii !");
	}
	
	
	@RequestMapping(value = "/public/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody UserForm userForm) {

		if (userService.findByUserId(userForm.getUserId()) != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate UserId");
		} else if (userService.findByUserId(userForm.getEmail()) != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate Email Id");
		} else {
			userService.register(userForm);
			return ResponseEntity.status(HttpStatus.CREATED).body("Registration done successfully");
		}
	}
}
