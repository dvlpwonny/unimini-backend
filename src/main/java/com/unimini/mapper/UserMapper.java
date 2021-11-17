package com.unimini.mapper;

import com.unimini.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper {

    User findUserByEmail(String userId);

    void createUserInfo(Map<String, Object> paramMap);

    Map<String, String> checkUserId(Map<String, Object> paramMap);

    List<Map<String, String>> getMajor(Map<String, Object> paramMap);
}
