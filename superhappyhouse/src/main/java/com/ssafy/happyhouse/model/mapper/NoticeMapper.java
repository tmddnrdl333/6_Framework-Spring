package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.NoticeDto;

@Mapper
public interface NoticeMapper {

	NoticeDto getNotice(int articleNo) throws SQLException;

	List<NoticeDto> getNoticeListByCondition(Map<String, String> condition) throws SQLException;

	boolean writeNotice(NoticeDto noticeDto) throws SQLException;

	boolean modifyNotice(NoticeDto noticeDto) throws SQLException;

	boolean removeNotice(int noticeNo) throws SQLException;

}
