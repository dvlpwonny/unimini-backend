package com.unimini.controller;

import com.unimini.service.MingleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Controller
public class MingleController {

	@Autowired
	MingleService mingleService;

	@RequestMapping(value = "/mingle/makeMingleEvent", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView makeMingleEvent(@RequestParam String userId) {
		ModelAndView mav = new ModelAndView("makeMingleEvent");
		Calendar cal = Calendar.getInstance();
		
		/* u : Day of Week Number
		 * 1 = Monday, ..., 7 = Sunday */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss u");
		String toDay = simpleDateFormat.format(cal.getTime());

		mav.addObject("toDay",toDay);
		
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
	public ModelAndView mingleDetail(@RequestParam String userId, @RequestParam String eventCode) {
		ModelAndView mav = new ModelAndView("EventContent");
		Map<String, String> eventInfo = MakeTempEventInfo();
		List<Map<String, String>> userList = MakeTempUserList();

		mav.addObject("eventInfo", eventInfo);
		mav.addObject("userList", userList);
		
		return mav;
	}

	private Map<String, String> MakeTempEventInfo() {
		Map<String, String> eventInfo = new HashMap<String, String>();
		eventInfo.put("eventCode", "1");
		eventInfo.put("eventName", "테스트 밍글 입니다.");
		eventInfo.put("eventTypeCode", "EVT002");
		eventInfo.put("eventStatusCode", "EVTSTS001");
		eventInfo.put("placeCode", "PLCE000008");
		eventInfo.put("placeName", "임의 장소 구역");		
		
		eventInfo.put("eventStartTime", "2021-11-17 14:30:00");
		eventInfo.put("eventStartTime_yyyymmdd", "2021-11-17");
		eventInfo.put("eventStartTime_hhmmss", "14:30:00");
		eventInfo.put("eventStartTime_u", "월요일");
		
		eventInfo.put("eventEndTime", "2021-11-17 17:30:00");
		eventInfo.put("eventEndTime_yyyymmdd", "2021-11-17");
		eventInfo.put("eventEndTime_hhmmss", "17:30:00");
		eventInfo.put("eventEndTime_u", "월요일");
		
		return eventInfo;
	}	
	
	private List<Map<String, String>> MakeTempUserList() {
		List<Map<String, String>> userList = new ArrayList<>();
		
		Map<String, String> user1 = new HashMap<String, String>();
		user1.put("userCode", "001");
		user1.put("userName", "T유저01");
		user1.put("profileImagePath", "/static/image/profile/profile11.png");
		user1.put("likeFlag", "Y");
		user1.put("hostFlag", "Y");
		userList.add(user1);
		
		Map<String, String> user2 = new HashMap<String, String>();
		user2.put("userCode", "002");
		user2.put("userName", "T유저02");
		user2.put("profileImagePath", "/static/image/profile/profile12.png");
		user2.put("likeFlag", "Y");
		user2.put("hostFlag", "N");
		userList.add(user2);
		
		Map<String, String> user3 = new HashMap<String, String>();
		user3.put("userCode", "003");
		user3.put("userName", "T유저03");
		user3.put("profileImagePath", "/static/image/profile/profile10.png");
		user3.put("likeFlag", "N");
		user3.put("hostFlag", "N");
		userList.add(user3);
		
		Map<String, String> user4 = new HashMap<String, String>();
		user4.put("userCode", "004");
		user4.put("userName", "T유저04");
		user4.put("profileImagePath", "/static/image/profile/profile9.png");
		user4.put("likeFlag", "N");
		user4.put("hostFlag", "N");
		userList.add(user4);
		
		return userList;
	}

	@RequestMapping(value = "/mingle/totalMigleList", method = {RequestMethod.GET, RequestMethod.POST})
	public String totalMigleList() {

		return "myEventList";
	}

}
