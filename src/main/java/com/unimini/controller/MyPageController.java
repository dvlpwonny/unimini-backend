package com.unimini.controller;
/**
 * @package : com.unimini.controller
 * @name : MyPageController.java
 * @date : 2021-10-06 오후 4:38
 * @author : jeongwon.song
 * @version : 1.0.0
 * @modifyed :
 **/

import com.unimini.service.MyPageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyPageController {
    
    @Autowired
    MyPageService myPageService;

    /*
     *사용자 정보 조회
     */
    @PostMapping(value = "/myPage/getUserInfo")
    @ApiOperation(value = "사용자 정보 조회", notes = "My Page 사용자 정보 조회")
    public ResponseEntity getUserInfo(@ApiParam(value = "사용자 코드", required = true, example = "KHU1") @RequestParam(value = "userCode") String userCode,
                                      @ApiParam(value = "사용자 ID", required = true, example = "test@khu.ac.kr") @RequestParam(value = "userId") String userId) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userCode", userCode);
        paramMap.put("userId", userId);

        Map<String, String> userInfo = myPageService.getUserInfo(paramMap);

        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    /*
     *사용자 수정
     */
    @PostMapping(value = "/myPage/updateUser")
    @ApiOperation(value = "사용자 수정", notes = "My Page 사용자 수정")
    public Map<String, String> updateUserNickname(@ApiParam(value = "사용자 수정 Type", required = true, example = "nickname, profile,  password, mobileNo ") @RequestParam(value = "updateType") String updateType,
                                                  @ApiParam(value = "사용자 코드", required = true, example = "KHU1") @RequestParam(value = "userCode") String userCode,
                                                  @ApiParam(value = "사용자 ID", required = true, example = "test@khu.ac.kr") @RequestParam(value = "userId") String userId,
                                                  @ApiParam(value = "수정 값", required = true, example = "test@khu.ac.kr/ 개발하는 거북이 ... ") @RequestParam(value = "updateValue") String updateValue) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("updateType", updateType);
        paramMap.put("userCode", userCode);
        paramMap.put("userId", userId);
        paramMap.put("updateValue", updateValue);

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
