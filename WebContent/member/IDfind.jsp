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
		alert("��������� �Է��ϼ���.");
		return false;
	}
	if(isNaN(document.idfind.birth.value)) {
		alert("��������� ���ڸ� �Է°����մϴ�.");
		return false;
	}
}
</script>
</head>
<body>
<a href="login1.jsp">�ǵ��ư���</a>
<p align="center"><b>���̵� ã��</b></p>
<form action="IDfind1.jsp" method="post" name="idfind" onsubmit="return check()">
	<p align="center">�̸� : <input type="text" name = "name"></p>
	<p align="center">������� : <input type="text" name = "birth"></p>
	<p align="center"><input type="submit" value="���̵�ã��"></p>
</form>
</body>
</html>