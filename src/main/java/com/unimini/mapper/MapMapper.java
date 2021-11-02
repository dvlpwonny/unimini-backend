package com.unimini.mapper;
/**
* @package : com.unimini.mapper
* @name : MapMapper.java
* @date : 2021-10-06 오후 4:39
* @author : jeongwon.song
* @version : 1.0.0
* @modifyed :
**/
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MapMapper {

    List<Map<String, String>> getCategorySort();
}
