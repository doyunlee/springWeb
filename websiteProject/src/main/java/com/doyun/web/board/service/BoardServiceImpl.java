package com.doyun.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.doyun.web.Board;
import com.doyun.web.board.dao.BoardDao;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("boardDao")
	BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public void insertBoard(Board board) {
		boardDao.insertBoard(board);
	}
	
	@Override
	public void deleteBoard(Board board) {
		boardDao.deleteBoard(board);
	}
	
	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}
	
	@Override
	public Board getBoardDetail(Board board) {
		return boardDao.getBoardDetail(board);
	}
	
	@Override
	public List<Board> getBoardList(int i, Board board) {
		return boardDao.getBoardList(i, board);
	}

}
