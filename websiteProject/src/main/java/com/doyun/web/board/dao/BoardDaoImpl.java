package com.doyun.web.board.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.doyun.web.Board;
import com.doyun.web.BoardMapper;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String username="C##doyun";
	private String userpw="1234";
	
	private NamedParameterJdbcTemplate template;
	private DriverManagerDataSource dataSource;
	
	public BoardDaoImpl() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(userpw);
		
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	private String insertQuery = "INSERT INTO MYBOARD VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM MYBOARD), :board_title, :board_content, :board_writer, sysdate)";
	private String deleteQuery = "DELETE FROM MYBOARD WHERE SEQ = :seq";
	private String getBoardDetailQuery = "SELECT * FROM MYBOARD WHERE SEQ = :seq AND BOARD_TITLE = :board_title";
	private String updateQuery = "UPDATE MYBOARD SET BOARD_TITLE = :board_title, BOARD_CONTENT = :board_content, BOARD_REGDATE = sysdate WHERE SEQ = :seq";
	private String getBoardListQuery = "SELECT * FROM MYBOARD\r\n" + 
			" WHERE 1 = 1\r\n" + 
			"   AND (\r\n" + 
			"		   (:io = 0)-- 전체검색 \r\n" + 
			"			OR\r\n" + 
			"		   (:io = 1 AND BOARD_TITLE LIKE '%'||:title||'%') -- 제목으로 검색\r\n" + 
			"			OR\r\n" + 
			"		   (:io = 2 AND BOARD_WRITER = :writer) -- 작성자로 검색\r\n" + 
			"	   ) ORDER BY SEQ DESC";
	
	public void insertBoard(Board board) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(board);
		template.update(insertQuery, paramSource);

	}

	public void deleteBoard(Board board) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(board);
		template.update(deleteQuery, paramSource);
	}
	
	public void updateBoard(Board board) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(board);
		template.update(updateQuery, paramSource);
	}
	
	public Board getBoardDetail(Board board) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(board);
		return template.queryForObject(getBoardDetailQuery, paramSource, new BoardMapper());
	}
	public List<Board> getBoardList(int i, Board board) {
		List<Board> boardList = new ArrayList<Board>();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("io", i, Types.VARCHAR);
		paramMap.addValue("title", board.getBoard_title(), Types.VARCHAR);
		paramMap.addValue("writer", board.getBoard_writer(), Types.VARCHAR);
		return template.query(getBoardListQuery, paramMap, new BoardMapper());
	}
}
