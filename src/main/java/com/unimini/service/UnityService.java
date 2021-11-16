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

    public List<Map<String, String>> getPinInfo(Map<String, String> paramMap) {
        return unityMapper.getPinInfo(paramMap);
    }

    public List<Map<String, String>> getMingleList(Map<String, String> paramMap) {
        return unityMapper.getMingleList(paramMap);
    }


    public List<Map<String, String>> getUnizoneList(Map<String, String> paramMap) {
        return unityMapper.getUnizoneList(paramMap);
    }


    public List<Map<String, String>> getLikeEventList(Map<String, String> paramMap) {
        return unityMapper.getLikeEventList(paramMap);
    }

    public int setLikeEvent(Map<String, String> paramMap) {
        return unityMapper.setLikeEvent(paramMap);
    }

    public int setWithEvent(Map<String, String> paramMap) {
        return unityMapper.setWithEvent(paramMap);
    }

    public Map<String, String> withEventCheck(Map<String, String> paramMap) {
        return unityMapper.withEventCheck(paramMap);
    }

    public Map<String, String> getProfileCode(Map<String, String> paramMap) {
        return unityMapper.getProfileCode(paramMap);
    }
}
