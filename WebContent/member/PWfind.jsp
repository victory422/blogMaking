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
			alert("��������� �Է��ϼ���.");
			return false;
		}
		if(isNaN(document.pwfind.birth.value)) {
			alert("��������� ���ڸ� �Է°����մϴ�.");
			return false;
		}
}
</script>
</head>
<body>
<a href="login1.jsp">�ǵ��ư���</a>
<p align="center"><b>�н����� ã��</b></p>
<form action="PWfind1.jsp" method="post" name="pwfind" onsubmit="return birthcheck()">
	<p align="center">�̸� : <input type="text" name = "name"></p>
	<p align="center">���̵� : <input type="text" name = "id"></p>
	<p align="center">������� : <input type="text" name = "birth"></p>
	<p align="center"><select>
			<option value="A"><p align="center">����</p></option>
			<option value="B">�ƹ����� �̸���?</option>
			<option value="C">��Ӵ��� �̸���?</option>
			<option value="D">���� ����1ȣ��</option></select><input type="text" name = "find"></p>
	<p align="center"><input type="submit" value="�н�����ã��"></p>
</form>
</body>
</html>