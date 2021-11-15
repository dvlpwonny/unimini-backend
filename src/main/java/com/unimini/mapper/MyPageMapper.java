package com.unimini.mapper;
/**
 * @package : com.unimini.mapper
 * @name : MyPageMapper.java
 * @date : 2021-10-06 오후 4:39
 * @author : jeongwon.song
 * @version : 1.0.0
 * @modifyed :
 **/
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface MyPageMapper {

    Map<String, String> getUserInfo(Map<String, String> paramMap);

    int updateUser(Map<String, String> paramMap);

    int setLeaveComment(Map<String, String> paramMap);

}
