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

	@GetMapping(value = "/EventContent")
	public String EventContent(Model model) {
		
		Map<String, String> eventInfo = MakeTempEventInfo();
		List<Map<String, String>> userList = MakeTempUserList();
		
		model.addAttribute("eventInfo", eventInfo);
		model.addAttribute("userList", userList);
		
		return "EventContent";
	}

	@GetMapping(value = "/EventContent2")
	public String EventContent2(Model model) {
		
		Map<String, String> eventInfo = MakeTempEventInfo();
		List<Map<String, String>> userList = MakeTempUserList();
		
		model.addAttribute("eventInfo", eventInfo);
		model.addAttribute("userList", userList);
		
		return "EventContent2";
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

	@GetMapping(value = "/EventContentForHost")
	public String EventContentForHost(Model model) {
		/* EventContent 페이지의 Host 버전 */
		return "EventContentForHost";
	}

	@GetMapping(value = "/EventContentForUser")
	public String EventContentForUser(Model model) {
		/* EventContent 페이지의 User 버전 */
		return "EventContentForUser";
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
	
	
}
