<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.doyun.web.Board"%>
<% Board board = (Board)session.getAttribute("board"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type = "text/javascript">
	function mySubmit(){
		document.myForm.action='/web/board/deleteBoard.do';
		document.myForm.submit();
	}
</script>

</head>
<body>
	<h1>글상세</h1>
	<form name="myForm" action="/web/updateBoard.jsp" method="post">
		<table border="1">
			<tr>
				<td>번호</td>
				<td>${board.seq }<input type="hidden" name="seq" value="${board.seq }"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${board.board_title }<input type="hidden" name="board_title" value="${board.board_title }"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.board_writer }<input type="hidden" name="board_writer" value="${board.board_writer }"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${board.board_content }<input type="hidden" name="board_content" value="${board.board_content }"/></td>
			</tr>
			<tr>
				<td>등록/수정일</td>
				<td>${board.board_regDate }</td>
			</tr>
			<tr>
				<td><input type="submit" value="글수정"/>&nbsp;
				<input type="button" value="글삭제" onclick='mySubmit()'/></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="getBoardList.do">글 목록으로 가기</a>
</body>
</html>