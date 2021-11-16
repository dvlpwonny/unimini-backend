package com.unimini.controller;

import com.unimini.service.MyPageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyPageController {

    @Autowired
    MyPageService myPageService;

    @RequestMapping(value = "/myPage/myPageForm", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView myPage(@RequestParam String userId) {
        ModelAndView mav = new ModelAndView("myPage");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", userId);

        /*paramMap.put("userId", principal.getName());*/
        Map<String, String> userInfo = myPageService.getUserInfo(paramMap);
        mav.addObject("userInfo", userInfo);

        return mav;
    }

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

    @GetMapping(value = "/myPage/leaveCommentForm")
    public ModelAndView myPageLeaveCommentForm() {
        ModelAndView mav = new ModelAndView("myPage_leaveComment");
        return mav;
    }

    @ResponseBody
    @PostMapping(value = "/myPage/leaveComment")
    public Map<String, String> leaveComment(@RequestBody Map<String, String> paramMap, Principal principal) {
        paramMap.put("createUser", principal.getName());
        int resultNum = myPageService.setLeaveComment(paramMap);

        Map<String, String> resultMap = new HashMap<>();
        if (resultNum > 0) {
            resultMap.put("result", "success");
        }

        return resultMap;
    }

    @GetMapping(value = "/myPage/reportCommentForm")
    public ModelAndView reportCommentForm() {
        ModelAndView mav = new ModelAndView("myPage_reportComment");
        return mav;
    }

}
