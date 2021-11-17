package com.unimini.controller;

import com.unimini.service.MingleService;
import com.unimini.service.UnityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
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
	public ModelAndView mingleDetail(@RequestParam String eventCode, Principal principal) {
	//	public ModelAndView mingleDetail(@RequestParam String userId, @RequestParam String eventCode) {
		///// 유니존 admin
			if (eventCode.equals("23") || eventCode.equals("24") || eventCode.equals("25") || eventCode.equals("26") || eventCode.equals("27")
				|| eventCode.equals("35") || eventCode.equals("36") || eventCode.equals("37") || eventCode.equals("38") || eventCode.equals("39")
				|| eventCode.equals("40") || eventCode.equals("41")	|| eventCode.equals("42") || eventCode.equals("43") || eventCode.equals("44")) {

			ModelAndView mav = new ModelAndView("EventContentForAdmin");
			// 함께하기 신청자
			List<Map<String, String>> applicantList = mingleService.getApplicantUnizone(eventCode);
			// 수락된 신청자
			List<Map<String, String>> participantList = mingleService.getParticipantUnizone(eventCode);
			// 거절된 참가자
			List<Map<String, String>> refuseList = mingleService.getRefuseUnizone(eventCode);
				// 이벤트 정보
			Map<String, String> mingleInfo = mingleService.getMingleInfo(eventCode);

			mav.addObject("applicantList", applicantList);
			mav.addObject("participantList", participantList);
			mav.addObject("refuseList", refuseList);
			mav.addObject("mingleInfo", mingleInfo);

			return mav;
		}

		ModelAndView mav = new ModelAndView("EventContent");
		
		eventCode = "22";
		String userId = principal.getName();
		
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
		// 함께하기 신청자
		List<Map<String, String>> applicantList = mingleService.getApplicantUnizone(eventCode);
		// 수락된 신청자
		List<Map<String, String>> participantList = mingleService.getParticipantUnizone(eventCode);
		// 거절된 참가자
		List<Map<String, String>> refuseList = mingleService.getRefuseUnizone(eventCode);
		// 이벤트 정보
		Map<String, String> mingleInfo = mingleService.getMingleInfo(eventCode);

		mav.addObject("applicantList", applicantList);
		mav.addObject("participantList", participantList);
		mav.addObject("refuseList", refuseList);
		mav.addObject("mingleInfo", mingleInfo);

		return mav;
	}

	// 참가자 삭제
	@ResponseBody
	@RequestMapping(value = "/mingle/setUnizoneParticipantCancel", method = {RequestMethod.POST})
	public Map<String, String> setUnizoneParticipantCancel(@RequestBody Map<String, String> paramMap) {
		Map<String, String> resultMap = new HashMap<>();
		paramMap.put("userStatusCode", null);
		int resultNum = mingleService.setUserStatusCode(paramMap);
		if (resultNum > 0) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}

		return resultMap;
	}

	// 함께하기 거절
	@ResponseBody
	@RequestMapping(value = "/mingle/setUnizoneApplicantRefuse", method = {RequestMethod.POST})
	public Map<String, String> setUnizoneApplicantRefuse(@RequestBody Map<String, String> paramMap) {
		Map<String, String> resultMap = new HashMap<>();
		paramMap.put("userStatusCode", "EVTUSRST005");
		int resultNum = mingleService.setUserStatusCode(paramMap);
		if (resultNum > 0) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}

		return resultMap;
	}

	// 함께하기 수락
	@ResponseBody
	@RequestMapping(value = "/mingle/setUnizoneParticipantAccept", method = {RequestMethod.POST})
	public Map<String, String> setUnizoneParticipantAccept(@RequestBody Map<String, String> paramMap) {
		Map<String, String> resultMap = new HashMap<>();
		paramMap.put("userStatusCode", "EVTUSRST003");
		int resultNum = mingleService.setUserStatusCode(paramMap);
		if (resultNum > 0) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}

		return resultMap;
	}
	
	@RequestMapping(value = "/mingle/totalMigleList", method = {RequestMethod.GET, RequestMethod.POST})
	public String totalMigleList() {

		return "myEventList";
	}

}
