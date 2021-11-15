package com.unimini.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class MingleController {

	@GetMapping(value = "/mingle/makeMingleEvent")
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

	@RequestMapping(value = "/mingle/makeMingleEvent_searchPlace", method = {RequestMethod.GET, RequestMethod.POST})
    public String makeMingleEvent_searchPlace(Model model) {
		
		
		
        return "makeMingleEvent_searchPlace";
    }

	@GetMapping(value = "/mingle/mingleDetail")
	public String mingleDetail(Model model) {
		Map<String, String> eventInfo = MakeTempEventInfo();
		List<Map<String, String>> userList = MakeTempUserList();
		
		model.addAttribute("eventInfo", eventInfo);
		model.addAttribute("userList", userList);
		
		return "EventContent";
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
	
	@GetMapping(value = "/mingle/totalMigleList")
	public String totalMigleList(Model model) {

		return "EventContent";
	}

}
