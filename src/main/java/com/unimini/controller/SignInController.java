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
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class SignInController {

    @Autowired
    SignInService signInService;

    @PostMapping(value = "/signIn/signIn")
    @ApiOperation(value = "로그인", notes = "로그인 사용자 체크")
    public ResponseEntity signIn(@RequestBody Map<String, String> paramMap) {

        Map<String, String> userInfo = signInService.getSignIn(paramMap);

        if (userInfo == null || userInfo.size() == 0) {
            Map<String, String> errMsg = new HashMap<>();
            errMsg.put("code","SI001.01"); // 아이디나 비밀번호가 틀린 경우
            errMsg.put("message", "아이디나 비밀번호를 확인해주세요.");
            // todo 비밀번호 5번 체킹

            // todo 비밀번호 오류 update

            return new ResponseEntity<>(errMsg, HttpStatus.OK);
        }

        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

}
