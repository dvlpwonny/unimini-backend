package com.unimini.controller;

/**
 * @package : com.unimini.controller
 * @name : SIgnInController.java
 * @date : 2021-10-06 오후 4:38
 * @author : jeongwon.song
 * @version : 1.0.0
 * @modifyed :
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SignInController {

    @GetMapping(value = "/signIn/signInForm")
    public String signInForm() {
        return "signIn";
    }

}
