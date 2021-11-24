package com.sample.Banking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/callApi")
	public String apiCall() {
		return "Welcome to spring boot project sharmila";
		}
	
	@GetMapping("")
	public String viewHome() {
		return "Register";
		}
	
}
