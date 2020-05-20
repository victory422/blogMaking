<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../blog/MyPage.jsp">되돌아가기</a>
<p align="center"><b>패스워드 수정</b></p>
<form action="PWrevise1.jsp" method="post">
<p align="center">아이디: <input type="text" name = "id"></p>
	<p align="center">현재패스워드 : <input type="text" name = "pw"></p>
	<p align="center">수정할패스워드 : <input type="text" name = "repw"></p>
	<p align="center">수정할패스워드 다시 : <input type="text" name = "repw1"></p>
	<p align="center"><input type="submit" value="패스워드변경"></p>
	</form>
</body>
</html>