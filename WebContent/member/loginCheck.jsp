<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	Boolean connect = false;
	
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pass = request.getParameter("password");

	if(id.equals("admin") && pass.equals("admin")) {
		session.setAttribute("login_id", id);
		session.setAttribute("login_name", "admin");
		out.println("<script>");
		out.println("alert('login OK')");
		out.println("location.href='../admin/main.jsp'");
		out.println("</script>");
	}else if(id.equals("admin")) {
		out.println("<script>");
		out.println("alert('login NOT')");
		out.println("location.href='../main/login1.jsp'");
		out.println("</script>");
	}else {
	
	try {
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogProject","root","1234");

	
	String sq1 = "select * from member1";
	pstmt = conn.prepareStatement(sq1);

	rs = pstmt.executeQuery();

	String id_check;
	String password;
	String nickname;
	 while(rs.next()) {
		id_check = rs.getString("member_id");
		password = rs.getString("member_pw");
		nickname = rs.getString("ninckname");
		if(id.equals(id_check) && pass.equals(password)) {
			session.setAttribute("login_id" ,id);
			session.setAttribute("login_name" ,"admin");
			session.setAttribute("login_name", nickname);
			out.println("<script>");
			out.println("alert('login OK')");
			out.println("location.href='../main/sub.jsp'");
			out.println("</script>");
		}
	}
	 out.println("<script>");
		out.println("alert('login NOT')");
		out.println("location.href='login1.jsp'");
		out.println("</script>");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	System.out.println(session.getAttribute("login_id"));
	System.out.println(session.getAttribute("login_name"));
%>
</body>
</html>