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
    public ResponseEntity getPinInfo() {
        List<Map<String, String>> categoryList = unityService.getPinInfo();
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

}
