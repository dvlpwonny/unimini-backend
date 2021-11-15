package com.unimini.service;
/**
 * @package : com.unimini.mapper
 * @name : MyPageService.java
 * @date : 2021-10-06 오후 4:39
 * @author : jeongwon.song
 * @version : 1.0.0
 * @modifyed :
 **/

import com.unimini.mapper.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MyPageService {

    @Autowired
    MyPageMapper myPageMapper;


    public Map<String, String> getUserInfo(Map<String, String> paramMap) {
        return myPageMapper.getUserInfo(paramMap);
    }

    public int updateUser(Map<String, String> paramMap) {
        return myPageMapper.updateUser(paramMap);
    }

    public int setLeaveComment(Map<String, String> paramMap) {
        return myPageMapper.setLeaveComment(paramMap);
    }
}
