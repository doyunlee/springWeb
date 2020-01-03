package com.doyun.web;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member();
		
		member.setSeq(rs.getString("seq"));
		member.setUser_id(rs.getString("user_id"));
		member.setUser_password(rs.getString("user_password"));
		member.setUser_name(rs.getString("user_name"));
		member.setUser_email(rs.getString("user_email"));
		member.setUser_gender(rs.getString("user_gender"));
		member.setUser_age(rs.getInt("user_age"));
		member.setUser_tel(rs.getString("user_tel"));
		
		return member;
	}

}
