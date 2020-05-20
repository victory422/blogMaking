<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   String id = request.getParameter("id");
   String password = request.getParameter("password");
   int birth = Integer.parseInt(request.getParameter("birth"));
   String ninckname = request.getParameter("ninckname");
   String find = request.getParameter("find");
   
   Connection conn = null;
     Statement stmt = null;
     PreparedStatement pstmt = null;
     ResultSet rs =null;
     Boolean connect = false;
     String query_insert = "insert into member1 values(null," + "'"+name+"'" + "," + "'" +id+ "'" +","+ "'" + password + "'" + "," + "'" +birth+ "'" + "," + "'" + ninckname + "'" + "," + "'" +find+ "'" + ")";
     String blog_insert = "insert into blog values(" +"'"+id+"'"+"," + "'게시판'" + "," + "'" +ninckname+ "'" +")";
     
     try {
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogProject","root","1234");
         System.out.println("DB connect OK");
         stmt = conn.createStatement();
         String sq1 = "select * from member1";
        pstmt = conn.prepareStatement(sq1);

        rs = pstmt.executeQuery();
        
         String id_check;
         String nickname;
         while(rs.next()) {
            id_check = rs.getString("member_id");
            nickname = rs.getString("ninckname");
            if(id.equals(id_check) && ninckname.equals(nickname)) {
            	out.println("<script>");
                out.println("alert('중복된 아이디와 닉네임입니다. 회원가입을 다시 진행해주세요.')");
                out.println("location.href='../main/main.jsp'");
                out.println("</script>");
            }
            else if(id.equals(id_check)) {
                  out.println("<script>");
               out.println("alert('중복된 아이디입니다. 회원가입을 다시 진행해주세요.')");
               out.println("location.href='../main/main.jsp'");
               out.println("</script>");
         }
            else if(ninckname.equals(nickname)) {
            	out.println("<script>");
                out.println("alert('중복된 닉네임입니다. 회원가입을 다시 진행해주세요.')");
                out.println("location.href='../main/main.jsp'");
                out.println("</script>");
            }
         }
       try {
          stmt.executeUpdate(query_insert);
          stmt.executeUpdate(blog_insert);
            System.out.println("insert OK");
              out.println("<script>");
          out.println("alert('회원가입성공!!')");
          out.println("location.href='../main/main.jsp'");
          out.println("</script>");
       }catch(Exception e) {
            e.printStackTrace();
         }
     }
         
     catch(Exception e) {
        e.printStackTrace();
     }
%>
</body>
</html>