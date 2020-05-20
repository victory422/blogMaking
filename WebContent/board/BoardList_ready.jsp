<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>



<body onLoad="calls()">
	<form id="go" action="../board/BoardList" method="post">
		<input type="hidden" id="contentPage" name="contentPage" value="../board/BoardList.jsp">
		<input type="hidden" name="nickName" value="<%=request.getParameter("nickName")%>">
	</form>
</body>

<script type="text/javascript">
function calls(){
	window.onload = document.getElementById('go').submit();
}
</script>

</html>