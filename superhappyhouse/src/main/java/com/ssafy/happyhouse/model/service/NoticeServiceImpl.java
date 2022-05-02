package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public NoticeDto getNotice(int articleNo) throws SQLException {
		return noticeMapper.getNotice(articleNo);
	}

	@Override
	public List<NoticeDto> getNoticeListByCondition(Map<String, String> condition) throws SQLException {
		return noticeMapper.getNoticeListByCondition(condition);
	}

	@Override
	public boolean writeNotice(NoticeDto noticeDto) throws SQLException {
		return noticeMapper.writeNotice(noticeDto);
	}

	@Override
	public boolean modifyNotice(NoticeDto noticeDto) throws SQLException {
		return noticeMapper.modifyNotice(noticeDto);
	}

	@Override
	public boolean removeNotice(int noticeNo) throws SQLException {
		return noticeMapper.removeNotice(noticeNo);
	}

}
