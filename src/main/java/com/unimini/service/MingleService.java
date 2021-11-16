package com.unimini.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimini.mapper.MingleMapper;

import lombok.extern.slf4j.Slf4j;

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

}
