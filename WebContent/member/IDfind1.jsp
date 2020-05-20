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
	String name = request.getParameter("name");
	int birth = Integer.parseInt(request.getParameter("birth"));
	
	Connection conn = null;
  	Statement stmt = null;
  	PreparedStatement pstmt = null;
  	ResultSet rs =null;
  	Boolean connect = false;
  	String query_select = "select * from member1";
  	try {
  	  	Class.forName("com.mysql.jdbc.Driver");
  	  	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogProject","root","1234");
  	 	System.out.println("DB connect OK");
  	 	stmt = conn.createStatement();
  	 	rs = stmt.executeQuery(query_select);
  	 	String name1;
  	 	int birth1;
  	 	String id1;
  	 	
  	 	while(rs.next()) {
  	 		name1 = rs.getString("member_name");
  	 		birth1 = rs.getInt("member_birth");
  	 		if(name.equals(name1) && birth==birth1) {
  	 			out.println("<script>");
  	 			out.println("alert('회원님의 아이디는  " + rs.getString("member_id") + " 입니다')");
  	 			out.println("location.href='login1.jsp'");
  	 			out.println("</script>");
  	 		}
  	 	}
  	 	out.println("<script>");
		out.println("alert('회원가입한 정보가 없습니다.')");
		out.println("location.href='login1.jsp'");
		out.println("</script>");
  	}catch(Exception e) {
  		
  	}
%>
</body>
</html>