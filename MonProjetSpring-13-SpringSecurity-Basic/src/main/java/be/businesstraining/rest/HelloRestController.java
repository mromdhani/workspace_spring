package be.businesstraining.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@GetMapping("/public")
	public String sayPublicMessage() {
		return "Hello, This is a public Message";
	}
	@GetMapping("/secret")
	public String sayASecretMessage() {
		return "Secret, Secret, Keep It ...";
	}
	

}
