<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.doyun.web.member.dao.MemberDaoImpl"%>
<%@page import="com.doyun.web.Member"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//컨트롤러 getBoardList에서 받아온 boardList
	List<Member> boardList = (List<Member>) session.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
	<h1>글 목록</h1>
	<h3>
		${user_name} 회원님 환영합니다.<a href="/web/logoutProc.jsp">Log-Out</a>
	</h3>
	<form action="/web/board/getBoardList.do" method="get">
		<table border="1">
			<tr>
				<td><select name="searchCondition">
						<c:forEach items="${conditionMap }" var="option">
							<option value="${option.value }">${option.key }</option>
						</c:forEach>


				</select> <input type="text" name="searchKeyword" /> <input type="submit"
					value="검색" /></td>
			</tr>
		</table>
	</form>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.seq }</td>
				<td><a
					href="/web/board/getBoard.do?seq=${board.seq }&board_title=${board.board_title}">${board.board_title }</a></td>
				<td>${board.board_writer }</td>
				<td>${board.board_regDate }</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="/web/insertBoard.jsp">새글 작성</a>
</body>
</html>