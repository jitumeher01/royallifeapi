package com.spring.royallife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.royallife.facade.UserFacade;
import com.spring.royallife.form.BankForm;
import com.spring.royallife.form.MessageForm;
import com.spring.royallife.form.UserForm;

@RestController
@RequestMapping("/api/rest/user")
public class UserPageController {

	@Autowired
	private UserFacade userFacade;

	@RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("userId") String userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userFacade.getProfile(userId));
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public ResponseEntity<?> updateProfile(@RequestBody UserForm userForm) {
		userFacade.updateProfile(userForm);
		return ResponseEntity.status(HttpStatus.OK).body("Success !");
	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST,headers="Accept=application/json" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePassword(@RequestBody UserForm userForm) throws Exception {

		if (userForm.getPassword().equals(userForm.getRePassword())) {
			userFacade.updatePassword(userForm);
		} else {
			throw new Exception("Password and Re password mismatch !");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Update Password Successfully !");
	}

	@RequestMapping(value = "/bank/all/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllBank(@PathVariable("userId") String userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllBank(userId));
	}

	@RequestMapping(value = "/addBank", method = RequestMethod.POST)
	public ResponseEntity<?> addBank(@RequestBody BankForm bankForm) {
		userFacade.addBank(bankForm);
		return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllBank(bankForm.getUserId()));
	}

	@RequestMapping(value = "/updateBank", method = RequestMethod.POST)
	public ResponseEntity<?> updateBank(@RequestBody BankForm bankForm) {
		userFacade.updateBank(bankForm);
		return ResponseEntity.status(HttpStatus.OK).body("Success !");
	}

	@RequestMapping(value = "/setDefaultBank/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> setDefaultBank(@PathVariable("id") Integer id) {
		BankForm bankForm = new BankForm();
		bankForm.setId(id);
		userFacade.defaultBank(bankForm);
		return ResponseEntity.status(HttpStatus.OK).body("Success !");
	}

	@RequestMapping(value = "/deleteBank/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteBank(@PathVariable("id") Integer id) {

		userFacade.deleteBank(id);

		return ResponseEntity.status(HttpStatus.OK).body("Success !");
	}

	@RequestMapping(value = "/friend/all/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> allFriend(@PathVariable("userId") String userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userFacade.getFriend(userId));
	}

	@RequestMapping(value = "/message/all/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> message(@PathVariable(value = "userId") String userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllMessage(userId));
	}

	@RequestMapping(value = "/message/add", method = RequestMethod.POST)
	public ResponseEntity<?> addMessage(@RequestBody MessageForm messageForm) {
		userFacade.addMessage(messageForm);
		return ResponseEntity.status(HttpStatus.OK).body("Success !");
	}

	@RequestMapping(value = "/searchUsers", method = RequestMethod.GET)
	public ResponseEntity<?> searchUsers(@RequestBody UserForm userForm) {
		return ResponseEntity.status(HttpStatus.OK).body(userFacade.searchListUSer(userForm.getUserId()));
	}

	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public ResponseEntity<?> listUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllUser());
	}

}
