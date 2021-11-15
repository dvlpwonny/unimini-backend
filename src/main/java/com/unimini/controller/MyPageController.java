package com.unimini.controller;

import com.unimini.service.MyPageService;
import com.unimini.vo.UserInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyPageController {

    @Autowired
    MyPageService myPageService;

    @GetMapping(value = "/myPage/myPageForm")
    public ModelAndView myPage(Principal principal) {
        ModelAndView mav = new ModelAndView("myPage");
        Map<String, String> paramMap = new HashMap<>();

        paramMap.put("userId", principal.getName());
        Map<String, String> userInfo = myPageService.getUserInfo(paramMap);
        mav.addObject("userInfo", userInfo);

        return mav;
    }

    @GetMapping(value = "/myPage/leaveCommentForm")
    public ModelAndView myPageLeaveComment() {
        ModelAndView mav = new ModelAndView("myPage_leaveComment");
        return mav;
    }

    @GetMapping(value = "/myPage/myEventList")
    public ModelAndView myEventList(UserInfo user) {
        ModelAndView mav = new ModelAndView("myEventList");

        return mav;
    }
    
    /*@GetMapping(value = "/myPage_changeNickname")
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
    }*/

    /*
     *사용자 정보 조회
     */
    @PostMapping(value = "/myPage/getUserInfo")
    @ApiOperation(value = "사용자 정보 조회", notes = "My Page 사용자 정보 조회")
    public ResponseEntity getUserInfo(@RequestBody Map<String, String> paramMap) {

        Map<String, String> userInfo = myPageService.getUserInfo(paramMap);

        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    /*
     *사용자 수정
     */
    @PostMapping(value = "/myPage/updateUser")
    @ApiOperation(value = "사용자 수정", notes = "My Page 사용자 수정")
    public Map<String, String> updateUserNickname(@RequestBody Map<String, String> paramMap) {

        int resultNum = myPageService.updateUser(paramMap);

        Map<String, String> resultMap = new HashMap<>();

        if (resultNum == -1) {
            resultMap.put("code", "4..."); //todo code 값 수정
            resultMap.put("message", "수정에 실패하였습니다");
        } else {
            resultMap.put("code", "200");
            resultMap.put("message", "수정이 완료되었습니다.");
        }

        return resultMap;
    }
    
}
