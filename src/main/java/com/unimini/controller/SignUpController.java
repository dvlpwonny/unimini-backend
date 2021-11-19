package com.unimini.controller;

import com.unimini.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class SignUpController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/signUp/signUpForm")
    public String signInForm() {
        return "signUp";
    }

    @ResponseBody
    @PostMapping(value = "/signUp/signUp")
    public Map<String,String> signUp(@RequestBody Map<String, Object> paramMap) {
        Map<String, String> resultMap = new HashMap<>();
        Map<String, String> userInfo = userService.checkUserId(paramMap);

        // 아이디체크
        if (userInfo != null && userInfo.size() > 0) {
            resultMap.put("result", "id Check");
            return resultMap;
        }

        userService.createUserInfo(paramMap);

        resultMap.put("result", "success");

        return resultMap;
    }

    @ResponseBody
    @PostMapping(value = "/signUp/getMajor")
    public Map<String, Object> getMajor(@RequestBody Map<String, Object> paramMap) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String, String>> majorList = userService.getMajor(paramMap);

        resultMap.put("majorList", majorList);

        return resultMap;
    }

}
