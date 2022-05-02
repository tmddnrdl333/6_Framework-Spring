package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.MemberDto;

public interface MemberService {
	MemberDto login(Map<String, String> map);

	int idCheck(String checkId);

	void registMember(MemberDto memberDto);

	List<MemberDto> listMember();

	MemberDto getMember(String id);

	void updateMember(MemberDto memberDto);

	void deleteMember(String id);
}
