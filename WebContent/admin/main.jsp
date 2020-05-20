
<%@ page language="java" import="admin.CallFromDB" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
	HttpSession checkSession = request.getSession();
	checkSession.getAttribute("login_id");
	String admin = "admin";
	boolean sessionOkay = admin.equals((String)checkSession.getAttribute("login_id"));
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>admin.main</title>
</head>
<body>

	<%
	CallFromDB call = CallFromDB.getInstance();
	int view = 3;
	int viewMember = 0;
	int viewBoard = 0;
	String view_str = "";
	if((String)request.getParameter("view")!=null) {
		view_str = (String)request.getParameter("view");
		view = Integer.parseInt(view_str);
	}
	if(sessionOkay) {
		%>
		<form method="post" action="main.jsp">
		<input type="radio" name="view" value="5">5개 씩
		<input type="radio" name="view" value="10">10개 씩
		<input type="submit" value="보기">
	</form>
	<br>
		
		
<%
	
	out.print("<table border=\"1\">");
	out.print("<tr align=center bgcolor=\"#B0B0B0\">");
	for(int i=0; i<call.infoMember().length; i++) {
		out.print("<td>");
		out.print(call.infoMember()[i]);
	}
	if(view<=call.CallingMember().size()) {
		viewMember = view;
	}else viewMember = call.CallingMember().size();
	for(int i = 0; i<viewMember; i++) {
		out.print("<tr>");
		for(int j = 0; j<call.CallingMember().get(i).length+2; j++) {
			if(j<call.CallingMember().get(i).length) {
			out.print("<td>");
			out.print(call.CallingMember().get(i)[j]);
			}
			else if(j==call.CallingMember().get(i).length) {
				out.print("<td><form method=\"get\" action=\"user.jsp\">" + 
						"<input type=\"hidden\" name=\"nick\" value=\""+call.CallingMember().get(i)[5]+"\">" + 
						"<input type=\"submit\" value=\"게시글보기\"></form>");
			}
			else if(j==(call.CallingMember().get(i).length+1)) {
				out.print("<td><form method=\"get\" action=\"delete\">" + 
						"<input type=\"hidden\" name=\"delete_member\" value=\"delete_member\">" + 
						"<input type=\"hidden\" name=\"number_member\" value=\""+call.CallingMember().get(i)[0]+"\">" + 
						"<input type=\"submit\" value=\"delete\"></form>");
		}
	}
	}
out.print("</table>");

	%>


	<form name="input" method="post" action ="../admin1">
		<input type="hidden" name="member">
		<input type="submit" value="Show All Members">
	</form>
	
	
	
	<br>
	<br>
	
	<%

	
	out.print("<table border=\"1\">");
	out.print("<tr align=center bgcolor=\"#B0B0B0\">");
	for(int i=0; i<call.infoBoard().length; i++) {
		out.print("<td>");
		out.print(call.infoBoard()[i]);
	}
	if(view<=call.CallingBoard().size()) {
		viewBoard = view;
	}else viewBoard = call.CallingBoard().size();
	for(int i = 0; i<viewBoard; i++) {
			out.print("<tr>");
		for(int j = 0; j<call.CallingBoard().get(i).length; j++) {
			if(j==2){
				out.print("<td>");
				out.print("<a href=\"text.jsp?number="+i+"\">내용(click)</a>");
			}else if (j==3) {
				out.print("<td>");
				out.print("<a href=\"user.jsp?nick="+call.CallingBoard().get(i)[3]+"\">"+call.CallingBoard().get(i)[3]+"</a>");
			}
			else {
			out.print("<td>");
			out.print(call.CallingBoard().get(i)[j]);
			}
		}
	}
	out.print("</table>");

	%>
	<form name="input" method="post" action ="../admin1">
		<input type="hidden" name="board">
		<input type="submit" value="Show All Board">
	</form>
	<br>
	<br>
	

	<br>
	<br>
	
	<form name="input" method="post" action ="../search">
		<input type="checkbox" name="check_id" value="check_id">ID
		<input type="checkbox" name="check_nick" value="check_nick"  checked="checked">NICKNAME
		<input type="checkbox" name="check_title" value="check_title" checked="checked">TITLE
		<input type="checkbox" name="check_text" value="check_text">TEXT
		<br>
		<input type="text" name="searchWord" value="검색어를 입력해주세요." onFocus="javascript:this.value=''">
		<input type="submit" value="search">
	</form>
	<br>
	<br>
	<form name="input" method="post" action ="words.jsp">
		
		<input type="submit" value="키워드분석">
	</form>
	
	
<%	}else out.print("세션을 확인해주세요."); %>
</body>
</html> 