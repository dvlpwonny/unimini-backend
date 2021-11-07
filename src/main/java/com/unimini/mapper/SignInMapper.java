package com.unimini.mapper;
/**
 * @package : com.unimini.mapper
 * @name : SignInMapper.java
 * @date : 2021-10-25 오후 10:25
 * @author : jeongwon.song
 * @version : 1.0.0
 * @modifyed :
 **/
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface SignInMapper {

    Map<String, String> getSignIn(Map<String, String> paramMap);

    Map<String, String> getIdCheck(Map<String, String> paramMap);
}
