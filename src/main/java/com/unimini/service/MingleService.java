package com.unimini.service;

import com.unimini.mapper.MingleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class MingleService {
	
	@Autowired
	MingleMapper mingleMapper;
	
	public List<Map<String, String>> getAllMingleList() {
		return mingleMapper.getAllMingleList();
	}

	public Map<String, String> getMingleInfo(String eventCode) {
		return mingleMapper.getMingleInfo(eventCode);
	}

	public List<Map<String, String>> getMingleUserInfo(String userId, String eventCode) {
		return mingleMapper.getMingleUserInfo(userId, eventCode);
	}


	public List<Map<String, String>> getApplicantUnizone(String eventCode) {
		return mingleMapper.getApplicantUnizone(eventCode);
	}
	public List<Map<String, String>> getParticipantUnizone(String eventCode) {
		return mingleMapper.getParticipantUnizone(eventCode);
	}
	public List<Map<String, String>> getRefuseUnizone(String eventCode) {
		return mingleMapper.getRefuseUnizone(eventCode);
	}

	public int setUserStatusCode(Map<String, String> paramMap) {
		return mingleMapper.setUserStatusCode(paramMap);
	}

	public Map<String, String> getMingleMyInfo(String userId, String eventCode) {
		return mingleMapper.getMingleMyInfo(userId, eventCode);
	}

	public void updateMingleLike(String isLikeForm_EventCode, String isLikeForm_UserId, String isLikeForm_Flag) {
		mingleMapper.updateMingleLike(isLikeForm_EventCode, isLikeForm_UserId, isLikeForm_Flag);
	}

	public void updateMingleIn(String isInForm_EventCode, String isInForm_UserId, String isInForm_Flag) {
		mingleMapper.updateMingleIn(isInForm_EventCode, isInForm_UserId, isInForm_Flag);
	}


	public List<Map<String, String>> getMingleReqUserList(String eventCode) {
		return mingleMapper.getMingleReqUserList(eventCode);
	}

	public void updateMingleAcpt(String isAcptForm_EventCode, String isAcptForm_UserId, String isAcptForm_Flag) {
		mingleMapper.updateMingleAcpt(isAcptForm_EventCode, isAcptForm_UserId, isAcptForm_Flag);
	}

	public List<Map<String, String>> getPlaceList(Map<String, Object> paramMap) {
		return mingleMapper.getPlaceList(paramMap);
	}

	@Transactional
	public int setMingle(Map<String, Object> paramMap) {
		int result;
		result = mingleMapper.setMingle(paramMap);
		
		paramMap.put("eventCode", result);
		
		mingleMapper.setChatRoom(paramMap);
		return result;
	}

	public List<Map<String, String>> getTotalMingleList(Map<String, String> paramMap) {
		return mingleMapper.getTotalMingleList(paramMap);
	}

	public List<Map<String, String>> getTotalMingleHourList(Map<String, String> paramMap) {
		return mingleMapper.getTotalMingleHourList(paramMap);
	}

	public void deleteMingle(String eventDeleteForm_EventCode, String eventDeleteForm_UserId) {
		mingleMapper.deleteMingle(eventDeleteForm_EventCode, eventDeleteForm_UserId);
	}

	public void editEvent(String eventEditForm_eventCode, String eventEditForm_title, String eventEditForm_detail) {
		mingleMapper.editEvent(eventEditForm_eventCode, eventEditForm_title, eventEditForm_detail);
	}

	public List<Map<String, String>> getPubChatHist(String eventCode) {
		return mingleMapper.getPubChatHist(eventCode);
	}

	public List<Map<String, String>> getPriChatHist(String eventCode) {
		return mingleMapper.getPriChatHist(eventCode);
	}

	public Map<String, String> getChatInfo(String eventCode) {
		return mingleMapper.getChatInfo(eventCode);
	}
}
