package com.doyun.web;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardMapper implements RowMapper<Board>{

	@Override
	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
		Board board = new Board();
		board.setSeq(rs.getInt("seq"));
		board.setBoard_title(rs.getString("board_title"));
		board.setBoard_content(rs.getString("board_content"));
		board.setBoard_writer(rs.getString("board_writer"));
		board.setBoard_regDate(rs.getDate("board_regDate"));
		return board;
	}

}
