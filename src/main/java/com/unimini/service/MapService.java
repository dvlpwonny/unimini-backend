package com.unimini.service;
/**
* @package : com.unimini.service
* @name : MapService.java
* @date : 2021-10-06 오후 4:39
* @author : jeongwon.song
* @version : 1.0.0
* @modifyed :
**/
import com.unimini.mapper.MapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MapService {

    @Autowired
    MapMapper mapMapper;

    public List<Map<String, String>> getCategorySort() {
        return mapMapper.getCategorySort();
    }
}
