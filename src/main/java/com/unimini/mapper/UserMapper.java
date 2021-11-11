package com.unimini.mapper;

import com.unimini.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    User findUserByEmail(String userId);
}
