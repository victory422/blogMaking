<%@page import="org.apache.catalina.startup.SetAllPropertiesRule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
//	function test() {
//		var answer = confirm("삭제하시겠습니까?");
//		var form = document.createElement("form");
		
//		if(answer == true ) {
			alert("삭제되었습니다.");
			<% request.setAttribute("data", "data"); %>
//		}else {
//			alert("삭제가 취소되었습니다.");
//		}
//		document.form1.data.value=answer;
//	}
	</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	


<!--  	<form name="form1" method="get" action="admin/admin">
		<input type="hidden" name="data" value="data">
		<input type="submit" onclick="test()" name="test()" value="삭제">
	</form> 
-->
	
</body>
</html>