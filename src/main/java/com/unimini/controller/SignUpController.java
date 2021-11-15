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
        userService.createUserInfo(paramMap);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "success");

        return resultMap;
    }
}
