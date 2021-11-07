package com.unimini.service;
/**
* @package : com.unimini.service
* @name : MapService.java
* @date : 2021-10-06 오후 4:39
* @author : jeongwon.song
* @version : 1.0.0
* @modifyed :
**/
import com.unimini.mapper.UnityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UnityService {

    @Autowired
    UnityMapper unityMapper;

    public List<Map<String, String>> getCategorySort() {
        return unityMapper.getCategorySort();
    }

    public List<Map<String, String>> getPinInfo() {
        return unityMapper.getPinInfo();
    }

    public List<Map<String, String>> getMingleList(Map<String, String> paramMap) {
        return unityMapper.getMingleList(paramMap);
    }

    public List<Map<String, String>> getLikeEventList(Map<String, String> paramMap) {
        return unityMapper.getLikeEventList(paramMap);
    }
}