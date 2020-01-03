package com.doyun.web.member.dao;

import com.doyun.web.Member;

public interface MemberDao {
	int insert(Member vo);
	Member selectByIdPassword(Member vo);
}
