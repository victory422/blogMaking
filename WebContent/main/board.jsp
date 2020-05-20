
<%@page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html>
<head>
<link href="./bootstrap-4.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="./bootstrap-4.4.1-dist/css/custom.css" rel="stylesheet">
<% String title = (String)request.getParameter("board_title"); 


		Connection conn =null;
         Statement stmt = null;
         PreparedStatement pstmt =null;
         ResultSet rs = null;
         ResultSet rs1 = null;
         
         String query_select = "SELECT * FROM board WHERE board_title =" + "'" + title + "'"; 
         
         try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject","root","1234");
            try{
            stmt = conn.createStatement();
            System.out.println("query : " + query_select);
            
            rs = stmt.executeQuery(query_select);
            
            System.out.println("뭐야");
           }catch(Exception e){
               System.out.println("데이터 안들어감");
               System.out.println("e : " + e);
            }
         }catch(Exception e){
            System.out.println("ㄴㄴ");
         }
      %> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class ="container"> 	
 	    <table class="talbe table-bordered">
	       	 <% while (rs.next()) { %>
	      	<tr>
	     		<th>제목 : <%=rs.getString("board_title") %></th>
	     		<th>작성자 : <%=rs.getString("board_writer") %></th>
	     		<th>카페고리 : <%=rs.getString("board_category") %></th>
	      	</tr>
	      		<th>내용 :
	      			<%=rs.getString("board_text") %>
	      		</th>
	    	      <%} %>	
		</table>
	</div>
	
	
	
	
	
	
	
<script type="text/javascript" src="/project_blog/WebContent/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>         	
</body>
</html>