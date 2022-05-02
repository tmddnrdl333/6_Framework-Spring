package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.service.HouseService;

@RestController
@RequestMapping("/house")
public class HouseController {

	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private HouseService houseService;

	@GetMapping("/{aptNo}")
	public ResponseEntity<List<HouseDealDto>> houseDealList(@PathVariable("aptNo") int aptNo) throws Exception {
		List<HouseDealDto> list = houseService.getHouseDealInAptNo(aptNo);
		return new ResponseEntity<List<HouseDealDto>>(list, HttpStatus.OK);
	}

}
