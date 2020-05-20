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
	<h1>로그아웃</h1>
	<input type="button" value="로그아웃"onclick="main()">
	
<script type="text/javascript">
	function main() {
		alert("logout");
		location.href ="main.jsp?";
	}
</script>
</body>
</html>