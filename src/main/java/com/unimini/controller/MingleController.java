package com.unimini.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MingleController {

	@GetMapping(value = "/makeMingleEvent")
	public String makeMingleEvent(Model model) {
		
		Calendar cal = Calendar.getInstance();
		
		/* u : Day of Week Number
		 * 1 = Monday, ..., 7 = Sunday */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss u");
		String toDay = simpleDateFormat.format(cal.getTime());
		
		model.addAttribute("toDay",toDay);
		
		log.info("MakeMingleEvent / toDay / " + toDay);
		
		return "makeMingleEvent";
	}

	@GetMapping(value = "/makeMingleEvent_searchPlace")
    public String makeMingleEvent_searchPlace(Model model) {
		
		
		
        return "makeMingleEvent_searchPlace";
    }

}
