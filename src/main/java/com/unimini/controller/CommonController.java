package com.unimini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

    // 총학페이지
    @RequestMapping(value = "/unityPage/studentCouncilPage1", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentCouncilPage1() {
        return "studentCouncilPage1";
    }

    // 총학페이지
    @RequestMapping(value = "/unityPage/studentCouncilPage2", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentCouncilPage2() {
        return "studentCouncilPage2";
    }

    // 총학페이지
    @RequestMapping(value = "/unityPage/studentCouncilPage3", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentCouncilPage3() {
        return "studentCouncilPage3";
    }

    // 총학페이지
    @RequestMapping(value = "/unityPage/studentCouncilPage4", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentCouncilPage4() {
        return "studentCouncilPage4";
    }

}
