package com.unimini.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MingleMapper {

	List<Map<String, String>> getAllMingleList();
	Map<String, String> getMingleInfo(String eventCode);
	List<Map<String, String>> getMingleUserInfo(String userId, String eventCode);

	List<Map<String, String>> getApplicantUnizone(String eventCode);
	List<Map<String, String>> getParticipantUnizone(String eventCode);
	List<Map<String, String>> getRefuseUnizone(String eventCode);
	int setUserStatusCode(Map<String, String> paramMap);
	Map<String, String> getMingleMyInfo(String userId, String eventCode);
	void updateMingleLike(String isLikeForm_EventCode, String isLikeForm_UserId, String isLikeForm_Flag);
	void updateMingleIn(String isInForm_EventCode, String isInForm_UserId, String isInForm_Flag);
	List<Map<String, String>> getMingleReqUserList(String eventCode);
	void updateMingleAcpt(String isAcptForm_EventCode, String isAcptForm_UserId, String isAcptForm_Flag);
	
	List<Map<String, String>> getPlaceList(Map<String, Object> paramMap);

	int setMingle(Map<String, Object> paramMap);
	int setMingleHost(Map<String, Object> paramMap);

	List<Map<String, String>> getTotalMingleList(Map<String, String> paramMap);
	List<Map<String, String>> getTotalMingleHourList(Map<String, String> paramMap);
	void deleteMingle(String eventDeleteForm_EventCode, String eventDeleteForm_UserId);
	void editEvent(String eventEditForm_eventCode, String eventEditForm_title, String eventEditForm_detail);
	
	void setChatRoom(Map<String, Object> paramMap);
	Map<String, String> getChatInfo(String eventCode);
	List<Map<String, String>> getPubChatHist(String eventCode);
	List<Map<String, String>> getPriChatHist(String eventCode);
}
