<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<%session.invalidate(); %>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�α׾ƿ�</h1>
	<input type="button" value="�α׾ƿ�"onclick="main()">
	
<script type="text/javascript">
	function main() {
		alert("logout");
		location.href ="main.jsp?";
	}
</script>
</body>
</html>