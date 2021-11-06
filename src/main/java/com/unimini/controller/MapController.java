package com.unimini.controller;
/**
* @package : com.unimini.controller
* @name : MapController.java
* @date : 2021-10-06 오후 4:38
* @author : jeongwon.song
* @version : 1.0.0
* @modifyed :
**/

import com.unimini.service.MapService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class MapController {

    @Autowired
    MapService mapService;

    /*
     *정렬 Category (검색)
     */
    @RequestMapping(value = "/map/getCategorySort", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "정렬 카테고리", notes = "검색바의 카테고리를 정렬하여 보냄")
    public ResponseEntity getCategorySort() {
        List<Map<String, String>> categoryList = mapService.getCategorySort();
        Map<String, Object> result = new HashMap<>();
        result.put("result", categoryList);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /*
     * 이벤트 장소 핀 정보
     */
    @RequestMapping(value = "/map/getPinInfo", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "핀 영역 및 최상위 카테고리", notes = "검색바의 카테고리를 정렬하여 보냄")
    public ResponseEntity getPinInfo() {
        List<Map<String, String>> categoryList = mapService.getPinInfo();
        Map<String, Object> result = new HashMap<>();
        result.put("result", categoryList);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
