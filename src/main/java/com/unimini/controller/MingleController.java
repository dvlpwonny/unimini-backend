package com.unimini.controller;

import com.unimini.service.MingleService;
import com.unimini.service.UnityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Controller
public class MingleController {

	@Autowired
	MingleService mingleService;

	@Autowired
	UnityService unityService;

	@RequestMapping(value = "/mingle/makeMingleEvent", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView makeMingleEvent(Principal principal) {
		ModelAndView mav = new ModelAndView("makeMingleEvent");
		Calendar cal = Calendar.getInstance();
		
		/* u : Day of Week Number
		 * 1 = Monday, ..., 7 = Sunday */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E요일", Locale.KOREAN);
		String toDay = simpleDateFormat.format(cal.getTime());

		// category
		List<Map<String, String>> categoryList = unityService.getCategorySort();

		//



		mav.addObject("toDay",toDay);
		mav.addObject("categoryList", categoryList);

		log.info("MakeMingleEvent / toDay / " + toDay);
		
		return mav;
	}

	@RequestMapping(value = "/mingle/makeMingleEvent_searchPlace", method = {RequestMethod.GET, RequestMethod.POST})
    public String makeMingleEvent_searchPlace(Model model) {
		
        return "makeMingleEvent_searchPlace";
    }

    @ResponseBody
	@RequestMapping(value = "/mingle/getPlaceList", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> getPlaceList(@RequestBody Map<String, Object> paramMap) {
		Map<String, Object> resultMap = new HashMap<>();
		List<Map<String, String>> placeList = mingleService.getPlaceList(paramMap);

		resultMap.put("placeList", placeList);
		return resultMap;
	}

	@ResponseBody
	@RequestMapping(value = "/mingle/setMingle", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> setMingle(@RequestBody Map<String, Object> paramMap, Principal principal) {
		Map<String, Object> resultMap = new HashMap<>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		// 밍글 기초 데이터
		paramMap.put("eventTypeCode", "EVT001"); // 밍글
		paramMap.put("eventStatusCode", "EVTSTS001"); // 예정

		// 밍글 시간 데이터
		if (paramMap.get("eventDate").toString() != null) {
			int addDay = Integer.parseInt(paramMap.get("eventDate").toString());
			cal.add(Calendar.DATE, +addDay);

			String eventStartTime = df.format(cal.getTime()) + " " + paramMap.get("eventStartDate");
			String eventEndTime = df.format(cal.getTime()) + " " + paramMap.get("eventEndDate");

			paramMap.put("eventStartTime", eventStartTime);
			paramMap.put("eventEndTime", eventEndTime);
		}

		paramMap.put("createUser", principal.getName());
		paramMap.put("userId", principal.getName());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String publicChat  = UUID.randomUUID().toString() + "-" + simpleDateFormat.format(Calendar.getInstance());
		String privateChat = UUID.randomUUID().toString() + "-" + simpleDateFormat.format(Calendar.getInstance());		
		
		paramMap.put("publicChat", publicChat);
		paramMap.put("privateChat", privateChat);
		
		mingleService.setMingle(paramMap);

		resultMap.put("result", "success");

		return resultMap;
	}

	@RequestMapping(value = "/mingle/mingleDetail", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mingleDetail(@RequestParam String eventCode, Principal principal) {
//		public ModelAndView mingleDetail(Model model) {
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
		
//		String eventCode = "22";
//		String userId = "admin";
		
		Map<String, String> eventInfo      = mingleService.getMingleInfo(eventCode);
		List<Map<String, String>> userList = mingleService.getMingleUserInfo(userId, eventCode);
		List<Map<String, String>> reqUserList = mingleService.getMingleReqUserList(eventCode);
		Map<String, String> myInfo         = mingleService.getMingleMyInfo(userId, eventCode);		

		mav.addObject("eventInfo", eventInfo);
		mav.addObject("userList", userList);
		mav.addObject("reqUserList", reqUserList);
		mav.addObject("myInfo", myInfo);
		
		return mav;
	}
	
	@RequestMapping(value = "/mingle/mingleDetail_isLike", method = {RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> mingleDetail_isLike(@RequestParam String isLikeForm_EventCode, @RequestParam String isLikeForm_UserId, @RequestParam String isLikeForm_Flag) {
        
        mingleService.updateMingleLike(isLikeForm_EventCode, isLikeForm_UserId, isLikeForm_Flag);
        
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("result",true);
        
		return responseMap;
	}
	
	@RequestMapping(value = "/mingle/mingleDetail_isAcpt", method = {RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> mingleDetail_isAcpt(@RequestParam String isAcptForm_EventCode, @RequestParam String isAcptForm_UserId, @RequestParam String isAcptForm_Flag) {
        
        mingleService.updateMingleAcpt(isAcptForm_EventCode, isAcptForm_UserId, isAcptForm_Flag);
        
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("result",true);
        
		return responseMap;
	}	

	@RequestMapping(value = "/mingle/mingleDetail_isIn", method = {RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> mingleDetail_isIn(@RequestParam String isInForm_EventCode, @RequestParam String isInForm_UserId, @RequestParam String isInForm_Flag) {
        
        mingleService.updateMingleIn(isInForm_EventCode, isInForm_UserId, isInForm_Flag);
        
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("result",true);
        
		return responseMap;
	}
	
	@RequestMapping(value = "/mingle/mingleDetail_delEvent", method = {RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> mingleDetail_delEvent(@RequestParam String eventDeleteForm_EventCode, @RequestParam String eventDeleteForm_UserId) {
        
        mingleService.deleteMingle(eventDeleteForm_EventCode, eventDeleteForm_UserId);
        
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("result",true);
        
		return responseMap;
	}
	
	@RequestMapping(value = "/mingle/mingleDetail_edit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mingleDetail_edit(@RequestParam String eventEditForm_EventCode, @RequestParam String eventEditForm_UserId) {
		ModelAndView mav = new ModelAndView("EditMingleEvent");
		
		List<Map<String, String>> categoryList = unityService.getCategorySort();
		Map<String, String> eventInfo      = mingleService.getMingleInfo(eventEditForm_EventCode);

		mav.addObject("eventInfo", eventInfo);
		mav.addObject("categoryList", categoryList);

        return mav;
    }
	
	@RequestMapping(value = "/mingle/mingleDetail_editEvent", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
    public Map<String, Object> mingleDetail_editEvent(@RequestParam String eventEditForm_eventCode, @RequestParam String eventEditForm_title, @RequestParam String eventEditForm_detail) {
		
        mingleService.editEvent(eventEditForm_eventCode, eventEditForm_title, eventEditForm_detail);
        
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("result",true);

        return responseMap;
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
	public ModelAndView totalMigleList(@RequestParam(required = false) String day) {
		ModelAndView mav = new ModelAndView("totalEventList");
		Map<String, String> paramMap = new HashMap<>();
		List<Map<String, String>> calMapList = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("dd");
		DateFormat df3 = new SimpleDateFormat("E");
		if (day == null || day.equals("")) {
			day = df.format(cal.getTime());
		}
		paramMap.put("eventDate", day);

		List<Map<String, String>> mingleList = mingleService.getTotalMingleList(paramMap);
		List<Map<String, String>> hourList = mingleService.getTotalMingleHourList(paramMap);


		for (int i = 0; i < 7; i++) {
			Map<String, String> calMap = new HashMap<>();
			calMap.put("week", df3.format(cal.getTime()));
			calMap.put("day", df2.format(cal.getTime()));
			calMap.put("fullDay", df.format(cal.getTime()));
			calMapList.add(i, calMap);
			cal.add(Calendar.DATE, +1);
		}

		mav.addObject("mingleList", mingleList);
		mav.addObject("hourList", hourList);
		mav.addObject("calMapList", calMapList);
		mav.addObject("day", day);

		return mav;
	}

}
