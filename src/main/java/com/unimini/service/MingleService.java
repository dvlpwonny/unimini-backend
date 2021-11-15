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

}
