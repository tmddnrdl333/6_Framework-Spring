package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.mapper.HouseMapper;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseMapper houseMapper;

	@Override
	public List<HouseDealDto> getHouseDealInAptNo(int aptNo) throws SQLException {
		return houseMapper.getHouseDealInAptNo(aptNo);
	}

}
