<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
<a href="../main/main.jsp">되돌아가기</a>
<form action="loginCheck.jsp" method="post">
   <p align="center"><b>로그인</b></p>
      <p align="center">아이디 : <input type ="text" name="id"/></p>
      <p align="center">비밀번호 : <input type="password" name="password"/></p>
   <p align="center"><input type="submit" value="로그인하기"/><br></p>
</table>
</form>

<form action="IDfind.jsp" method="post">

<p align="center"><input type="submit" value="ID찾기"/><br></p>

</form>

<form action="PWfind.jsp" method="post">
   <p align="center"><input type="submit" value="PW찾기"><br></p>
</form>

</body>
</html>