package com.unimini.controller;

import com.unimini.vo.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

    @GetMapping(value = "/signUp")
    public String signUp() {
        return "signUp";
    }

    @GetMapping(value = "/findPassword")
    public String findPassword() {
        return "findPassword";
    }
    
    @PostMapping(value = "/uniMap")
    public ModelAndView uniMap(ModelAndView mav, Authentication authentication) {
        UserInfo userInfo = (UserInfo) authentication.getPrincipal();
        mav.addObject("userInfo", userInfo);

        mav.setViewName("uniMap");
        return mav;
    }

}
