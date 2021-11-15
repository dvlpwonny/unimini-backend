package com.unimini.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MingleMapper {

	List<Map<String, String>> getAllMingleList();

}
