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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MapController {

    @Autowired
    MapService mapService;

    /*
     *정렬 Category (검색)
     */
    @RequestMapping(value = "/map/getCategorySort", method = {RequestMethod.GET})
    @ApiOperation(value = "정렬 카테고리", notes = "검색바의 카테고리를 정렬하여 보냄")
    public ResponseEntity getCategorySort() {
        List<Map<String, String>> categoryList = mapService.getCategorySort();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
