package com.unimini.controller;
/**
* @package : com.unimini.controller
* @name : MapController.java
* @date : 2021-10-06 오후 4:38
* @author : jeongwon.song
* @version : 1.0.0
* @modifyed :
**/

import com.unimini.service.UnityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class UnityRestController {

    @Autowired
    UnityService unityService;

    /*
     *정렬 Category (검색)
     */
    @RequestMapping(value = "/unity/getCategorySort", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "정렬 카테고리", notes = "검색바의 카테고리를 정렬하여 보냄")
    public ResponseEntity getCategorySort() {
        List<Map<String, String>> categoryList = unityService.getCategorySort();
        Map<String, Object> result = new HashMap<>();
        result.put("result", categoryList);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /*
     * 이벤트 장소 핀 정보
     */
    @RequestMapping(value = "/unity/getPinInfo", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "핀 영역 및 최상위 카테고리", notes = "핀 영역 및 최상위 카테고리 데이터 전달")
    public ResponseEntity getPinInfo(
            @ApiParam(value = "카테고리 코드", required = false, example = "CAT000002") @RequestParam(value = "categoryCode", required = false) String categoryCode
            , @ApiParam(value = "이벤트 유형 코드", required = true, example = "EVT002") @RequestParam(value = "eventTypeCode", required = false) String eventTypeCode
            , @ApiParam(value = "시간 검색", required = false, example = "2021-11-06 17:00") @RequestParam(value = "timeSearch", required = false) String timeSearch) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("categoryCode", categoryCode);
        paramMap.put("eventTypeCode", eventTypeCode);
        paramMap.put("timeSearch", timeSearch);
        List<Map<String, String>> categoryList = unityService.getPinInfo(paramMap);
        Map<String, Object> result = new HashMap<>();
        result.put("result", categoryList);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /*
     * 밍글리스트
     */
    @RequestMapping(value = "/unity/getMingleList", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "밍글리스트", notes = "핀 클릭시 노출되는 밍글리스트")
    public ResponseEntity getMingleList(
            @ApiParam(value = "영역코드", required = false, example = "SECA0001") @RequestParam(value = "sectionCode", required = false) String sectionCode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("sectionCode", sectionCode);
        List<Map<String, String>> categoryList = unityService.getMingleList(paramMap);
        Map<String, Object> result = new HashMap<>();
        result.put("result", categoryList);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /*
     * 좋아요 리스트
     */
    @RequestMapping(value = "/unity/getLikeEventList", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "좋아요 리스트", notes = "홈화면에서의 좋아요 리스트")
    public ResponseEntity getLikeEventList(
            @ApiParam(value = "유저코드", required = false, example = "SYSTEM") @RequestParam(value = "userCode", required = false) String userCode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userCode", userCode);
        List<Map<String, String>> likeEventList = unityService.getLikeEventList(paramMap);
        Map<String, Object> result = new HashMap<>();
        result.put("result", likeEventList);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
