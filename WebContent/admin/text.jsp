<%@page import="java.util.ArrayList"%>
<%@ page import="admin.CallFromDB" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="admin" class="admin.CallFromDB" scope="page" />
<%
	int number = 0;
	if(request.getParameter("number")!=null) {
		number = Integer.parseInt(request.getParameter("number"));
	}
	ArrayList<String[]> arr = new ArrayList<String[]>();
	//String searchWord, String ch_text, String ch_title

	arr = admin.CallingBoard();
%>

<html>
<head>
<meta charset="UTF-8">
<title>Text List</title>
</head>
<body>
	
	<table border="1">
		<tr align=center bgcolor="#B0B0B0">
		<td><%=arr.get(number)[0] %>
		<td><%=arr.get(number)[1] %>
		<td><%=arr.get(number)[3] %>
		<td><%=arr.get(number)[4] %>
		<td><%=arr.get(number)[5] %>
		<td><form method="post" action="user.jsp">
				<input type="hidden" name="nick" value="<%=arr.get(number)[3]%>">
				<input type="submit" value="계정정보">
			</form>
		<td><form method="post" action="../delete">
				<input type="hidden" name="delete_board" value="delete_board">
				<input type="hidden" name="number_board" value="<%=arr.get(number)[0]%>">
				<input type="submit" value="게시글 삭제">
			</form>
		
		<tr><td colspan="7"><pre><%=arr.get(number)[2] %></pre>
		

	</table>

				

</body>
</html>