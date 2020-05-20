<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Boolean connect = false;
	String temp = "";
	ArrayList<String[]> arr = new ArrayList<String[]>();
	

//	String query_create = "create table student(id int not null auto_increment primary key, name varchar(10))";
//	String query_insert = "insert into student values(null, '홍길동')";
	String query_select = "select * from blogproject.member1";
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject","root","1234");
		System.out.println("DB connect OK");
	
		try{
			stmt = conn.createStatement();
//			stmt.executeUpdate(query_create);
			System.out.println("query ok");
		}catch(Exception e) {
			System.out.println("query error");
		}
		//stmt.executeUpdate(query_insert);
		rs = stmt.executeQuery(query_select);
		String[] arr1 = new String[7];

		int count = 0;
		while(rs.next()){
			temp += rs.getString(1)+",";
			temp += rs.getString(2)+",";
			temp += rs.getString(3)+",";
			temp += rs.getString(4)+",";
			temp += rs.getString(5)+",";
			temp += rs.getString(6)+",";
			temp += rs.getString(7)+"<br>";
			arr1=temp.split(",");
			arr.add(arr1);
			temp="";
		}
		out.print("arr : " +arr.get(0)[0]);
		

		conn.close();
		
	}catch(Exception e) {
		System.out.println("DB connect Error");	
	}
%>
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>





</body>
</html>