package com.unimini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

    @GetMapping(value = "/myPage")
    public String myPage() {
        return "myPage";
    }
    
    @GetMapping(value = "/myPage_changeNickname")
    public String myPage_changeNickname() {
        return "myPage_changeNickname";
    }

    @GetMapping(value = "/myPage_changePassword")
    public String myPage_changePassword() {
        return "myPage_changePassword";
    }

    @GetMapping(value = "/myPage_changePhone")
    public String myPage_changePhone() {
        return "myPage_changePhone";
    }

    @GetMapping(value = "/myPage_leaveComment")
    public String myPage_leaveComment() {
        return "myPage_leaveComment";
    }

    @GetMapping(value = "/myPage_changeProfile")
    public String myPage_changeProfile() {
        return "myPage_changeProfile";
    }
    
    
    
}
