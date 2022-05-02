package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.NoticeDto;

public interface NoticeService {
	NoticeDto getNotice(int articleNo) throws SQLException;

	List<NoticeDto> getNoticeListByCondition(Map<String, String> condition) throws SQLException;

	boolean writeNotice(NoticeDto noticeDto) throws SQLException;

	boolean modifyNotice(NoticeDto noticeDto) throws SQLException;

	boolean removeNotice(int noticeNo) throws SQLException;

}
