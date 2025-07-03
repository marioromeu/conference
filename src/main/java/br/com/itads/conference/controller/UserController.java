package br.com.itads.conference.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itads.conference.domain.User;
import br.com.itads.conference.service.IUserService;

@RestController
public class UserController {

	IUserService userService;
	
	UserController(IUserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/user")
	public Boolean addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/user/{email}")
	public ResponseEntity<User> getUser(@PathVariable String email) {
		User user = userService.getUser(email);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}

}
