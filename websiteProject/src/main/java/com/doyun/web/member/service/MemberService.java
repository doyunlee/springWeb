package com.doyun.web.member.service;

import com.doyun.web.Member;

public interface MemberService {
	void insert(Member vo);
	Member selectByIdPassword(Member vo);
}
