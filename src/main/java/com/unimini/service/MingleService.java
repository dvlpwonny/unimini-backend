package com.unimini.service;

import com.unimini.mapper.MingleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
