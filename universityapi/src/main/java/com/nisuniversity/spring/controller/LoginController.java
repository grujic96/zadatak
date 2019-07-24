package com.nisuniversity.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class LoginController {

	
	@PostMapping("/login/{username}/{password}")
	public void login(@PathVariable("username") String username, @PathVariable("password") String password) {
		//TODO
	}
	
}
