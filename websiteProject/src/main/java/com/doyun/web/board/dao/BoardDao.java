package com.doyun.web.board.dao;

import java.util.List;

import com.doyun.web.Board;

public interface BoardDao {
	void insertBoard(Board board);
	void deleteBoard(Board board);
	Board getBoardDetail(Board board);
	void updateBoard(Board board);
	List<Board> getBoardList(int i, Board board);
}
