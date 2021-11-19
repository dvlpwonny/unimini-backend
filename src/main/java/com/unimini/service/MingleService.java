package com.unimini.service;

import com.unimini.mapper.MingleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

	public List<Map<String, String>> getPlaceList(Map<String, Object> paramMap) {
		return mingleMapper.getPlaceList(paramMap);
	}

	@Transactional
	public int setMingle(Map<String, Object> paramMap) {
		int result;
		result = mingleMapper.setMingle(paramMap);
		result = mingleMapper.setMingleHost(paramMap);

		return result;
	}

}
