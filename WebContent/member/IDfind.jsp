<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check() {
	if (document.idfind.birth.value.length !=8){
		alert("생년월일을 입력하세요.");
		return false;
	}
	if(isNaN(document.idfind.birth.value)) {
		alert("생년월일은 숫자만 입력가능합니다.");
		return false;
	}
}
</script>
</head>
<body>
<a href="login1.jsp">되돌아가기</a>
<p align="center"><b>아이디 찾기</b></p>
<form action="IDfind1.jsp" method="post" name="idfind" onsubmit="return check()">
	<p align="center">이름 : <input type="text" name = "name"></p>
	<p align="center">생년월일 : <input type="text" name = "birth"></p>
	<p align="center"><input type="submit" value="아이디찾기"></p>
</form>
</body>
</html>