package com.spring.royallife.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.royallife.dto.UserData;
import com.spring.royallife.entity.UserEntity;
import com.spring.royallife.facade.UserFacade;
import com.spring.royallife.form.BankForm;
import com.spring.royallife.form.MessageForm;
import com.spring.royallife.form.UserForm;
import com.spring.royallife.service.UserService;

@RestController
@RequestMapping("/api/rest/user")
public class UserPageController {
	private static final Logger logger = LoggerFactory.getLogger(UserPageController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private UserFacade userFacade;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<?> home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		UserEntity userEntity = userService.findByUserId("jitumeher");
		if (userEntity != null) {
			Hibernate.initialize(userEntity.getBankEntity());
		}

		return ResponseEntity.status(HttpStatus.OK).body("Welcome To Royal Life !");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody UserForm userForm) {
		UserData userData = userFacade.findByUserIdAndPassword(userForm.getUserId(), userForm.getPassword());
		if (userData != null) {
			return ResponseEntity.status(HttpStatus.OK).body(userData);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid User Id/Password !");
		}
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@RequestHeader(value = "token") String token) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {
			return ResponseEntity.status(HttpStatus.OK).body(userdata);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public ResponseEntity<?> updateProfile(@RequestBody UserForm userForm,
			@RequestHeader(value = "token") String token) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {
			userFacade.updateProfile(userForm);
			return ResponseEntity.status(HttpStatus.OK).body(userFacade.getUserById(userdata.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ResponseEntity<?> updatePassword(@RequestBody UserForm userForm,
			@RequestHeader(value = "token") String token) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {
			if (userForm.getPassword().equals(userForm.getRePassword())) {
				if (userForm.getOldPassword().equals(userdata.getPassword())) {
					userForm.setUserId(userdata.getUserId());
					userFacade.updatePassword(userForm);

					return ResponseEntity.status(HttpStatus.OK).body("Update Password Successfully !");
				} else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wrong Old Password !");
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Password and Re password mismatch !");
			}

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/bank/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllBank(@RequestHeader(value = "token") String token) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {
			return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllBank(userdata.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/addBank", method = RequestMethod.POST)
	public ResponseEntity<?> addBank(@RequestHeader(value = "token") String token, @RequestBody BankForm bankForm) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {
			bankForm.setUserId(userdata.getUserId());
			userFacade.addBank(bankForm);
			return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllBank(userdata.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/updateBank", method = RequestMethod.POST)
	public ResponseEntity<?> updateBank(@RequestHeader(value = "token") String token, @RequestBody BankForm bankForm) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {
			userFacade.updateBank(bankForm);
			return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllBank(userdata.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/setDefaultBank/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> setDefaultBank(@RequestHeader(value = "token") String token,
			@PathVariable("id") Integer id) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {
			BankForm bankForm = new BankForm();
			bankForm.setUserId(userdata.getUserId());
			bankForm.setId(id);
			userFacade.defaultBank(bankForm);
			return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllBank(userdata.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/deleteBank/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteBank(@RequestHeader(value = "token") String token, @PathVariable("id") Integer id) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {
			userFacade.deleteBank(id);
			return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllBank(userdata.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/friend/all", method = RequestMethod.GET)
	public ResponseEntity<?> allFriend(@RequestHeader(value = "token") String token) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {

			return ResponseEntity.status(HttpStatus.OK).body(userFacade.getFriend(userdata.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/message/all", method = RequestMethod.GET)
	public ResponseEntity<?> message(@RequestHeader(value = "token") String token) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {

			return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllMessage(userdata.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/message/add", method = RequestMethod.POST)
	public ResponseEntity<?> addMessage(@RequestHeader(value = "token") String token,
			@RequestBody MessageForm messageForm) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {
			userFacade.addMessage(messageForm);
			return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllMessage(userdata.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/searchUsers", method = RequestMethod.GET)
	public ResponseEntity<?> searchUsers(@RequestHeader(value = "token") String token, @RequestBody UserForm userForm) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {

			return ResponseEntity.status(HttpStatus.OK).body(userFacade.searchListUSer(userForm.getUserId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public ResponseEntity<?> listUser(@RequestHeader(value = "token") String token) {
		UserData userdata = userFacade.verifyToken(token);
		if (userdata != null) {

			return ResponseEntity.status(HttpStatus.OK).body(userFacade.getAllUser());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session Time Out !");
		}
	}

}
