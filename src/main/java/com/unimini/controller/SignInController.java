package com.unimini.controller;

/**
 * @package : com.unimini.controller
 * @name : SIgnInController.java
 * @date : 2021-10-06 오후 4:38
 * @author : jeongwon.song
 * @version : 1.0.0
 * @modifyed :
 **/

import com.unimini.service.SignInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class SignInController {

    @Autowired
    SignInService signInService;

    @GetMapping(value = "/signIn/signInForm")
    public String signInForm() {
        return "signIn";
    }

    @ResponseBody
    @PostMapping(value = "/signIn/signIn")
    public ResponseEntity signIn(@RequestBody Map<String, String> paramMap) {

        Map<String, String> userInfo = signInService.getSignIn(paramMap);

        if (userInfo == null || userInfo.size() == 0) {
            Map<String, String> errMsg = new HashMap<>();
            errMsg.put("code","SI001.01"); // 아이디나 비밀번호가 틀린 경우
            errMsg.put("message", "아이디나 비밀번호를 확인해주세요.");

            return new ResponseEntity<>(errMsg, HttpStatus.OK);
        }

        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

}
