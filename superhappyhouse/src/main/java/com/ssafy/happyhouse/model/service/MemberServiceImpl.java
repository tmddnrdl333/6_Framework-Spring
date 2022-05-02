package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberDto login(Map<String, String> map) {
		return memberMapper.login(map);
	}

	@Override
	public int idCheck(String checkId) {
		return memberMapper.idCheck(checkId); // 0 or 1
	}

	@Override
	public void registMember(MemberDto memberDto) {
		memberMapper.registMember(memberDto);
	}

	@Override
	public List<MemberDto> listMember() {
		return memberMapper.listMember();
	}

	@Override
	public MemberDto getMember(String id) {
		return memberMapper.getMember(id);
	}

	@Override
	public void updateMember(MemberDto memberDto) {
		memberMapper.updateMember(memberDto);
	}

	@Override
	public void deleteMember(String id) {
		memberMapper.deleteMember(id);
	}

}
