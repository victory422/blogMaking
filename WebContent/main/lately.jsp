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
<meta charset="UTF-8">

<script type="text/javascript">
	function detail(value){
		document.getElementById(value).submit();
	}
</script>


<title>Insert title here</title>
		<%  Connection conn =null;
         Statement stmt = null;
         PreparedStatement pstmt =null;
         ResultSet rs = null;
         //String query_select = "SELECT * FROM board WHERE "+ key +"LIKE "+"%"+value+"%";
         String query_select = "SELECT * FROM board order by board_index desc limit 5";
         
         try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject","root","1234");
            try{
            stmt = conn.createStatement();
            //stmt.executeQuery(query_select);
            System.out.println("query : " + query_select);
            rs = stmt.executeQuery(query_select);
           }catch(Exception e){
               System.out.println("데이터 안들어감");
               System.out.println("e : " + e);
            }
         }catch(Exception e){
            System.out.println("ㄴㄴ");
         }
      %> 
</head>
<body>
		<table class="table table-bordered">
      		<tr>
               <th style="width:5%;">번호</th>
               <th style="width:55%;">제목</th>
               <th style="width:10%;">작성자</th> 
               <th style="width:10%">카페고리</th>
               <th style="width:20%">날짜</th>
            </tr>
	<% while (rs.next()) { %>
	
	<form id="<%=rs.getString("board_index")%>" action="../board/BoardSearch" method="post">
		<tr>
      		<td style="width:5%;">
      			<%=rs.getString("board_index") %></td>
   
      		<td><a href="javascript:detail(<%=rs.getString("board_index")%>);"><%=rs.getString("board_title")%></a></td>
      		<td style="width:10%;">
      			<%=rs.getString("board_writer") %>
      		</td>
      		<td style="width:10%;"><%=rs.getString("board_category") %></td>
      		<td style="width:20%;"><%=rs.getString("board_time") %></td>
      	</tr>
      	<input type="hidden" name="board_index" value="<%=rs.getString("board_index")%>" />
      	<input type="hidden" name="board_writer" value="<%=rs.getString("board_writer")%>" />
      	<input type="hidden" name="contentPage" value="../board/BoardDetail.jsp" />
      </form>
      <%} %>
      	</table>





<script type="text/javascript" src="/project_blog/WebContent/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>               
</body>
</html>