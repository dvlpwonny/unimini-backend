package com.unimini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventPageController {

	@GetMapping(value = "/EventContentForUser")
	public String EventContentForUser() {
		return "EventContentForUser";
	}
	
	@GetMapping(value = "/EventContentForHost")
	public String EventContentForHost() {
		return "EventContentForHost";
	}	
	
}
