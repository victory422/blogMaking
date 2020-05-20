
<%@page import="javax.xml.transform.Result"%>
<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@ page language="java" import="admin.CallFromDB" contentType="text/html; charset=UTF-8"
	import="sun.security.jca.GetInstance"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="admin" class="admin.CallFromDB" scope="page" />

    <%
 
    	CallFromDB db = CallFromDB.getInstance();
   		String nick = (String)session.getAttribute("login_name");
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
			
    		for(int j=0; j<arr.length; j++) {
    			if(j==3) {
    				out.print("<td>");
    				out.print("********");
    			}else {
	    			out.print("<td>");
	    			out.print(arr[j]);
    			}
    		}
    		out.print("</table>");
    		out.print("<br>");
    		out.print("<form method=\"post\" action=\"../member/PWrevise.jsp\">");
    		out.print("<input type=\"submit\" value=\"회원정보 수정하기\">");
    		out.print("</form>");
    		out.print("<form method=\"post\" action=\"../main/sub.jsp\">");
    		out.print("<input type=\"submit\" value=\"뒤로가기\">");
    		out.print("</form>");
    %>

	
    
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	
	</script>

<meta charset="UTF-8">
<title><%=nick %>님의 마이페이지</title>
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