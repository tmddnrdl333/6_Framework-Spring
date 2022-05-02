package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.MemberDto;

@Mapper
public interface MemberMapper {

	MemberDto login(Map<String, String> map);

	int idCheck(String checkId);

	void registMember(MemberDto memberDto);

	List<MemberDto> listMember();

	MemberDto getMember(String id);

	void updateMember(MemberDto memberDto);

	void deleteMember(String id);

}
