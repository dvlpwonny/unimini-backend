package com.unimini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MingleController {

	@GetMapping(value = "/makeMingleEvent")
	public String makeMingleEvent() {
		return "makeMingleEvent";
	}

	@GetMapping(value = "/makeMingleEvent_searchPlace")
    public String makeMingleEvent_searchPlace() {
        return "makeMingleEvent_searchPlace";
    }

}
