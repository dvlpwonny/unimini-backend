package com.unimini.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventPageController {

	@GetMapping(value = "/EventContentForHost")
	public String EventContentForHost(Model model) {
		
		
		return "EventContentForHost";
	}
	
	@GetMapping(value = "/EventContentForUser")
	public String EventContentForUser(Model model) {
		List<Map<String, String>> userList = new ArrayList<>();
		
		
		return "EventContentForUser";
	}
	

	
}
