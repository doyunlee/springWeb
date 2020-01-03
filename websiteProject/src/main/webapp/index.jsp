<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form method="post" action="/web/member/login.do">
	ID : <input type="text" name="user_id"/><br>
	Password : <input type = "password" name="user_password"/><br>
	<input type="submit" value="로그인"/>
	<input type="reset" value="초기화"/>
</form>
<a href="/web/resources/html/joinApplication.html">회원가입</a>
</body>
</html>