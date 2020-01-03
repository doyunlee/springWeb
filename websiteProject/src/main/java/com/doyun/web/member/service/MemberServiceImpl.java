package com.doyun.web.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.doyun.web.Member;
import com.doyun.web.member.dao.MemberDao;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	@Qualifier("memberDao")
	MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void insert(Member vo) {
		memberDao.insert(vo);
	}

	@Override
	public Member selectByIdPassword(Member vo) {
		return memberDao.selectByIdPassword(vo);
	}
}
