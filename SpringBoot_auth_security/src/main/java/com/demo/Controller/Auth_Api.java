package com.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Auth_Api {
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	@GetMapping("/admin")
public String adminProces() {
		return "this is admin";
	}
	@GetMapping("/user")
	public String userProcess() {
		return "This is userprocess";
	}
}
