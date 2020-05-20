<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String repw = request.getParameter("repw");
	String repw1 = request.getParameter("repw1");

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	Boolean connect = false;
	String query_select = "select * from member1";
	String query_update = "update member1 set member_pw = '"+repw+"' where member_id='"+id+"'";
	
	try {
  	  	Class.forName("com.mysql.jdbc.Driver");
  	  	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogProject","root","1234");
  	 	System.out.println("DB connect OK(password)");
  	 	stmt = conn.createStatement();
  	 	rs = stmt.executeQuery(query_select);
  	 	
  	 	String id1;
  	 	String pw1;
  	 	while(rs.next()) {
   	 		id1 = rs.getString("member_id");
  	 		pw1 = rs.getString("member_pw");
  	 		if(session.getAttribute("login_id").equals(id1) && pw.equals(pw1)) {
  	 			rs.close();
  	 			stmt = conn.createStatement();
  	 			stmt.executeUpdate(query_update);
  	 			out.println("<script>");
  	 			out.println("alert('패스워드 변경완료')");
  	 			out.println("location.href='../main/sub.jsp'");
  	 			out.println("</script>");
  	 		}
  	 	}
  	 	out.println("<script>");
		out.println("alert('패스워드 변경실패')");
		out.println("location.href='../main/sub.jsp'");
		out.println("</script>");
	}catch(Exception e) {
	}
%>
</body>
</html>