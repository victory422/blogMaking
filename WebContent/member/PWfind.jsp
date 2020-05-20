<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function birthcheck() {
		if (document.pwfind.birth.value.length !=8){
			alert("생년월일을 입력하세요.");
			return false;
		}
		if(isNaN(document.pwfind.birth.value)) {
			alert("생년월일은 숫자만 입력가능합니다.");
			return false;
		}
}
</script>
</head>
<body>
<a href="login1.jsp">되돌아가기</a>
<p align="center"><b>패스워드 찾기</b></p>
<form action="PWfind1.jsp" method="post" name="pwfind" onsubmit="return birthcheck()">
	<p align="center">이름 : <input type="text" name = "name"></p>
	<p align="center">아이디 : <input type="text" name = "id"></p>
	<p align="center">생년월일 : <input type="text" name = "birth"></p>
	<p align="center"><select>
			<option value="A"><p align="center">질문</p></option>
			<option value="B">아버지의 이름은?</option>
			<option value="C">어머니의 이름은?</option>
			<option value="D">나의 보물1호는</option></select><input type="text" name = "find"></p>
	<p align="center"><input type="submit" value="패스워드찾기"></p>
</form>
</body>
</html>