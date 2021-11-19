package com.unimini.controller;

import com.unimini.service.MingleService;
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
import java.util.List;
import java.util.Map;

@Controller
public class MyPageController {

    @Autowired
    MyPageService myPageService;
    @Autowired
    MingleService mingleService;

    @RequestMapping(value = "/myPage/myPageForm", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView myPage(Principal principal) {
        ModelAndView mav = new ModelAndView("myPage");
        Map<String, String> paramMap = new HashMap<>();
        /*paramMap.put("userId", userId);*/

        paramMap.put("userId", principal.getName());
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

    @RequestMapping(value = "/myPage/myEventList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView myEventList(Principal principal) {
        ModelAndView mav = new ModelAndView("myEventList");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", principal.getName());
        /*paramMap.put("userId", userId);*/
        List<Map<String, String>> expectMingleList = myPageService.getExpectMingle(paramMap);
        List<Map<String, String>> finishMingleList = myPageService.getFinishMingle(paramMap);

        mav.addObject("expectMingleList", expectMingleList);
        mav.addObject("finishMingleList", finishMingleList);

        return mav;
    }


    @ResponseBody
    @RequestMapping(value = "/myPage/setCloseMingle", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, String> setCloseMingle(@RequestBody Map<String, String> paramMap, Principal principal) {
        Map<String, String> resultMap = new HashMap<>();

        paramMap.put("updateUser", principal.getName());
        paramMap.put("eventStatusCode", "EVTSTS003");

        int resultNum = myPageService.setMingleStatus(paramMap);

        if (resultNum > 0) {
            resultMap.put("result", "success");
        }

        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/myPage/setEventScore", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, String> setEventScore(@RequestBody Map<String, String> paramMap, Principal principal) {
        Map<String, String> resultMap = new HashMap<>();

        paramMap.put("updateUser", principal.getName());

        int resultNum = myPageService.setRating(paramMap);

        if (resultNum > 0) {
            resultMap.put("result", "success");
        }

        return resultMap;
    }


    @ResponseBody
    @RequestMapping(value = "/myPage/setCancelMingle", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, String> setCancelMingle(@RequestBody Map<String, String> paramMap, Principal principal) {
        Map<String, String> resultMap = new HashMap<>();
        paramMap.put("userStatusCode", null);
        paramMap.put("userId", principal.getName());
        int resultNum = mingleService.setUserStatusCode(paramMap);
        if (resultNum > 0) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;
    }
}
