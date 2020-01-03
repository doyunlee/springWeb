package com.doyun.web.member.dao;

import java.sql.Types;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.doyun.web.Member;
import com.doyun.web.MemberMapper;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String username="C##doyun";
	private String userpw="1234";
	
	private NamedParameterJdbcTemplate template;
	private DriverManagerDataSource dataSource;
	
	public MemberDaoImpl() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(userpw);
		
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	private String insertQuery = "INSERT INTO MYUSER VALUES("
			+"(SELECT NVL(MAX(SEQ), 0) + 1 FROM MYUSER)"
			+", :user_id"
			+", :user_password"
			+", :user_name"
			+", :user_email"
			+", :user_gender"
			+", :user_age"
			+", :user_tel"
			+")";
	private String deleteQuery ="DELETE FROM MYUSER WHERE 1 = 1 AND user_id = :user_id";
	private String updateQuery ="UPDATE MYUSER SET "
			  + "USER_PASSWORD = :user_password "
			  + ", USER_EMAIL = :user_email "
			  + ", USER_TEL = :user_tel "
			  + "WHERE USER_ID = :user_id ";
	private String selectByIdPasswordQuery = "SELECT * FROM MYUSER " + 
			"WHERE USER_ID = :user_id " + 
			"  AND USER_PASSWORD = :user_password ";

	@Override
	public int insert(Member vo) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(vo);
		int insertedCount = template.update(insertQuery, paramSource);
		//성공시 1, 실패시 0
		if(insertedCount > 0) {
			System.out.println("insert Succeeded");
		}
		return insertedCount;
	}
	
	@Override
	public Member selectByIdPassword(Member vo) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("user_id", vo.getUser_id(), Types.VARCHAR);
		paramSource.addValue("user_password", vo.getUser_password(), Types.VARCHAR);
		return template.queryForObject(selectByIdPasswordQuery, paramSource, new MemberMapper());
	}
}
