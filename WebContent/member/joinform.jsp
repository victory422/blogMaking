<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript">
function joinCheck() {
	if (document.userInfo.name.value==""){
		alert("이름을 입력하세요.");
		return false;
	}
	if (document.userInfo.id.value==""){
		alert("아이디를 입력하세요.");
		return false;
	}
	if (document.userInfo.password.value==""){
		alert("패스워드를 입력하세요.");
		return false;
	}
	if (document.userInfo.birth.value.length !=8){
		alert("생년월일을 입력하세요.");
		return false;
	}
	if(isNaN(document.userInfo.birth.value)) {
		alert("생년월일은 숫자만 입력가능합니다.");
		return false;
	}
	if (document.userInfo.ninckname.value==""){
		alert("닉네임을 입력하세요.");
		return false;
	}
	if (document.userInfo.find.value==""){
		alert("질문을 입력하세요.");
		return false;
	}
}
</script>
</head>
<body>
<a href="../main/main.jsp">되돌아가기</a>
<form action="joinok.jsp" method="post" name="userInfo" onsubmit="return joinCheck()">
<table width="400" align="center" border="1">
	<tr><th colspan="2">회원가입</th></tr>
	<tr>
		<td width="200" align="center">이름</td>
		<td width="200" align="center"><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td width="200" align="center">아이디</td>
		<td width="200" align="center"><input type="text" name="id"/></td>
	</tr>
	<tr>
		<td width="200" align="center">패스워드</td>
		<td width="200" align="center"><input type="password" name="password"/></td>
	</tr>
	<tr>
		<td width="200" align="center">생년월일 : ex)19940605</td>
		<td width="200" align="center"><input type="text" name="birth"/></td>
	</tr>
	<tr>
		<td width="200" align="center">닉네임</td>
		<td width="200" align="center"><input type="text" name="ninckname"/></td>
	</tr>
	<tr>
		<td width="200" align="center"><select>
			<option value="A"><p align="center">질문</p></option>
			<option value="B">아버지의 이름은?</option>
			<option value="C">어머니의 이름은?</option>
			<option value="D">나의 보물1호는</option></select></td>
		<td width="200" align="center"><input type="text" name="find"/></td>
	</tr>
	<tr>
		<td width="200" align="center"><input type="submit" value="회원가입"/>
		<td width="200" align="center"><input type="reset" value="다시작성"/>
	</tr>
</table>
</form>
</body>
</html>