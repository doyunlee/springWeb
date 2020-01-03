package com.doyun.web.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.doyun.web.Member;
import com.doyun.web.exception.DuplicateMemberException;
import com.doyun.web.exception.EmptyResultData;
import com.doyun.web.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	@Qualifier("memberService")
	MemberService service;

	/* 시작페이지 index.jsp로 가는 페이지 */
	@RequestMapping(value = "/")
	public String indexPage(Model model, HttpServletRequest request) {
		return "/index.jsp";
	}

	// index.jsp에서 로그인 클릭시
	// RequestParam어노테이션 사용
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public String login(Model model, @RequestParam("user_id") String id, @RequestParam("user_password") String pwd) throws EmptyResultData {
		if(id == null || pwd == null) {
			throw new IllegalAccessError("아이디 또는 비밀번호를 입력해야 합니다");
		}
		
		Member member = new Member();

		member.setUser_id(id);
		member.setUser_password(pwd);

		try {
			member = service.selectByIdPassword(member);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return "/index.jsp";
		}

		// getUser_name님 환영합니다! 메시지 출력
		model.addAttribute("user_name", member.getUser_name());
		
		return "/board/getBoardList.do";
	}

	// joinApplication.html에서 가입하기 버튼 클릭시
	// 커멘드 객체 사용
	@RequestMapping(value = "/member/memJoin.do", method = RequestMethod.POST)
	public String memJoin(Member vo) {
		try {
			service.insert(vo);
		} catch (DuplicateMemberException e) {
			e.printStackTrace();
		}

		return "/memJoinOk.jsp";
	}

}