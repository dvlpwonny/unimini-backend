package com.unimini.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MingleMapper {

	List<Map<String, String>> getAllMingleList();
	Map<String, String> getMingleInfo(String eventCode);
	List<Map<String, String>> getMingleUserInfo(String userId, String eventCode);

}
