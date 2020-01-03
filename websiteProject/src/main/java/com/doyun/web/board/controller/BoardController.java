package com.doyun.web.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.doyun.web.Board;
import com.doyun.web.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	BoardService service;

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("작성자", "WRITER");
		return conditionMap;
	}

	@RequestMapping(value = "/board/getBoardList.do")
	public String getBoardList(@RequestParam(value = "searchCondition", required = false) String condition,
			@RequestParam(value = "searchKeyword", required = false) String keyword, Board board, Model model) {
		
		int io = 0;

		if (condition != null && condition.equals("TITLE") && keyword != null) {
			// 제목으로 검색 :io = 1 and board_title = 'keyword'
			io = 1;
		} else if (condition != null && condition.equals("WRITER") && keyword != null) {
			// 작성자로 검색 :io = 2 and board_writer = 'keyword'
			io = 2;
		} else {
			// keyword가 null일때
			io = 0;
		}

		board.setBoard_title(keyword);
		board.setBoard_writer(keyword);
		model.addAttribute("boardList", service.getBoardList(io, board));

		return "/boardList.jsp";
	}

//	// Model
//	@RequestMapping(value = "/board/getBoardList.do", method = RequestMethod.POST)
//	public String getBoardList(Board board, Model model) {
//		model.addAttribute("boardList", service.getBoardList(board));
//		return "/boardList.jsp";
//	}

	@RequestMapping(value = "/board/insertBoard.do")
	public String insertBoard(Board board) {
		service.insertBoard(board);
		return "/board/getBoardList.do";
	}

	@RequestMapping(value = "/board/updateBoard.do")
	public String updateBoard(Board board) {
		service.updateBoard(board);
		return "/board/getBoardList.do";
	}

	@RequestMapping(value = "/board/deleteBoard.do")
	public String deleteBoard(Board board) {
		service.deleteBoard(board);
		return "/board/getBoardList.do";
	}

	@RequestMapping(value = "/board/getBoard.do")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", service.getBoardDetail(board));
		return "/board.jsp";
	}

}
