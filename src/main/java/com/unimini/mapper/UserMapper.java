package com.unimini.mapper;

import com.unimini.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface UserMapper {

    User findUserByEmail(String userId);

    void createUserInfo(Map<String, Object> paramMap);
}
