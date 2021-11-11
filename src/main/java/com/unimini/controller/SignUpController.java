package com.unimini.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class SignUpController {

    @GetMapping(value = "/signUp/signUpForm")
    public String signInForm() {
        return "signUp";
    }

    @PostMapping(value = "/signUp/signUp")
    public Map<String, String> signUp() {
        Map<String, String> resultMap = new HashMap<>();

        return resultMap;
    }
}
