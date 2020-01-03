<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.doyun.web.Board"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- EL태그가 작동하지 않아 스크립트 태그로 대체 -->
</head>
<body>
<%
String seq = request.getParameter("seq");
String board_title = request.getParameter("board_title");
String board_writer = request.getParameter("board_writer");
String board_content = request.getParameter("board_content");
out.println(seq+board_title+board_writer+board_content);
%>
	<h1>글수정</h1>
	<a href="logoutProc.jsp">Log Out</a>
	<hr>

	<form action="/web/board/updateBoard.do" method="post">
		<table border="1">
			<tr>
				<td>번호</td>
				<td><input type="text" name="seq" value="<%=seq %>" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="board_title" value="<%=board_title %>"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="board_writer" value="<%=board_writer %>" readonly></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="board_content"><%=board_content %></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="새글 등록" ></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="/web/board/getBoardList.do">글 목록으로 가기</a>
</body>
</html>