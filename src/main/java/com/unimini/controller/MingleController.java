package com.unimini.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MingleController {

	@GetMapping(value = "/makeMingleEvent")
	public String makeMingleEvent(@RequestParam Map<String, String> param, HttpServletRequest request) {
		
		//request.setAttribute("toDay", );
		
		
		
		return "makeMingleEvent";
	}

	@GetMapping(value = "/makeMingleEvent_searchPlace")
    public String makeMingleEvent_searchPlace(@RequestParam Map<String, String> param, HttpServletRequest request) {
		
		
		
        return "makeMingleEvent_searchPlace";
    }

}
