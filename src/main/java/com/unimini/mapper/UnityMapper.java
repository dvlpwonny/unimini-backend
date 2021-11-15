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
public interface UnityMapper {

    List<Map<String, String>> getCategorySort();

    List<Map<String, String>> getPinInfo(Map<String, String> paramMap);

    List<Map<String, String>> getMingleList(Map<String, String> paramMap);

    List<Map<String, String>> getUnizoneList(Map<String, String> paramMap);

    List<Map<String, String>> getLikeEventList(Map<String, String> paramMap);

    int setLikeEvent(Map<String, String> paramMap);

    int setWithEvent(Map<String, String> paramMap);

    Map<String, String> getProfileCode(Map<String, String> paramMap);
}
