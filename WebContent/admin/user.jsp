
<%@page import="javax.xml.transform.Result"%>
<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@ page language="java" import="admin.CallFromDB" contentType="text/html; charset=UTF-8"
	import="sun.security.jca.GetInstance"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="admin" class="admin.CallFromDB" scope="page" />

    <%
    	CallFromDB db = CallFromDB.getInstance();
    	String nick = request.getParameter("nick");
    	String insert_query = "select * from blogproject.member1 where ninckname=\""+nick+"\"";
		
    	String[] arr = db.searchUser(insert_query);
		
    	out.print(nick+"의 정보");
    	out.print("<table border=\"1\">");
		out.print("<tr align=center bgcolor=\"#B0B0B0\">");
		for(int i=0; i<db.infoMember().length; i++) {
			out.print("<td>");
			out.print(db.infoMember()[i]);
		}
			out.print("<tr>");
			if(arr[0]==null) {
				out.print("<br>현재 사용하지 않는 계정입니다.");
			}else {
	    		for(int j=0; j<arr.length; j++) {
	    			out.print("<td>");
	    			out.print(arr[j]);
	    		}
			}
			
    		out.print("</table>");
    %>
    
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	
	</script>

<meta charset="UTF-8">
<title>UserList</title>
</head>
<body>
	<br><br><%=nick %>의 게시글
	<%
		out.print("<table border=\"1\">");
		out.print("<tr align=center bgcolor=\"#B0B0B0\">");
		out.print("<pre>");
		for(int i=0; i<db.infoBoard().length; i++) {
			out.print("<td>");
			out.print(db.infoBoard()[i]);
		}
		for(int i=0; i<db.searchUserBoard(nick).size(); i++) {
		out.print("<tr>");
			for(int j=0; j<db.searchUserBoard(nick).get(i).length; j++) {
				if(j==2) {
					out.print("<td width=\"100\">");
					out.print(db.searchUserBoard(nick).get(i)[j]);
				}else {
				out.print("<td>");
				out.print(db.searchUserBoard(nick).get(i)[j]);
				}
				
			}
		}
		out.print("</pre>");
	
	%>
	
	



</body>
</html>