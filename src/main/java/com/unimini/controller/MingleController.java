package com.unimini.controller;

import com.unimini.service.MingleService;
import com.unimini.service.UnityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class MingleController {

	@Autowired
	MingleService mingleService;

	@Autowired
	UnityService unityService;

	@RequestMapping(value = "/mingle/makeMingleEvent", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView makeMingleEvent(@RequestParam String userId) {
		ModelAndView mav = new ModelAndView("makeMingleEvent");
		Calendar cal = Calendar.getInstance();
		
		/* u : Day of Week Number
		 * 1 = Monday, ..., 7 = Sunday */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss u");
		String toDay = simpleDateFormat.format(cal.getTime());

		// category
		List<Map<String, String>> categoryList = unityService.getCategorySort();



		mav.addObject("toDay",toDay);
		mav.addObject("categoryList", categoryList);

		log.info("MakeMingleEvent / toDay / " + toDay);
		
		return mav;
	}

	@RequestMapping(value = "/mingle/makeMingleEvent_searchPlace", method = {RequestMethod.GET, RequestMethod.POST})
    public String makeMingleEvent_searchPlace(Model model) {
		List<Map<String, String>> placeList = mingleService.getAllMingleList();

		model.addAttribute("placeList",placeList);
		
        return "makeMingleEvent_searchPlace";
    }

	@RequestMapping(value = "/mingle/mingleDetail", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mingleDetail(Model model) {
	//	public ModelAndView mingleDetail(@RequestParam String userId, @RequestParam String eventCode) {
		ModelAndView mav = new ModelAndView("EventContent");
		
		String eventCode = "22";
		String userId = "admin";
		
		Map<String, String> eventInfo      = mingleService.getMingleInfo(eventCode);
		List<Map<String, String>> userList = mingleService.getMingleUserInfo(userId, eventCode);

		log.info("Event Info : " +eventInfo.toString());
		
		for(int i=0; i<userList.size(); i++) {
			log.info("User List : " + userList.get(i).toString());
		}
		
		mav.addObject("eventInfo", eventInfo);
		mav.addObject("userList", userList);
		
		return mav;
	}

	///////////어드민 상세 페이지 (유니존)
	@RequestMapping(value = "/mingle/unizoneDetailAdmin", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView unizoneDetailAdmin(@RequestParam String eventCode) {
		ModelAndView mav = new ModelAndView("EventContentForAdmin");


		return mav;
	}

	@RequestMapping(value = "/mingle/totalMigleList", method = {RequestMethod.GET, RequestMethod.POST})
	public String totalMigleList() {

		return "myEventList";
	}

}
