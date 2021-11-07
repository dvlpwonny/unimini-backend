package com.unimini.service;

import com.unimini.mapper.SignInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @package : com.unimini.mapper
 * @name : SignInService.java
 * @date : 2021-10-25 오후 10:25
 * @author : jeongwon.song
 * @version : 1.0.0
 * @modifyed :
 **/

@Service
public class SignInService {

    @Autowired
    SignInMapper signInMapper;

    public Map<String, String> getSignIn(Map<String, String> paramMap) {
        return signInMapper.getSignIn(paramMap);
    }

    // 아이디체크
    public Map<String, String> getIdCheck(Map<String, String> paramMap) {
        return signInMapper.getSignIn(paramMap);
    }
}
