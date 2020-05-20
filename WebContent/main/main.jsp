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
<title>메인</title>
<style>
header{
height:90px;
}
</style>
</head>
<body background ="img/22.jpg">
<br><br><br><br><br><br><br><br><br><br><br><br>
      <form>
         <p align="center">      <input type ="button" value ="로그인" onclick="login()"> </p><br>
            
          <p align="center">     <input type ="button" value="회원가입"onclick="joinform()"> </p>  
        </form>       
   
   
   <script type="text/javascript">
   function login(){
       location.href= "../member/login1.jsp?";
    } 
   function joinform(){
       location.href= "../member/joinform.jsp?";
    }
   function logout(){
       location.href= "../member/logout.jsp?";
    }
   function admin(){
       location.href= "../admin/main.jsp?";
    }
   
   
   </script>
   
<script type="text/javascript" src="/project_blog/WebContent/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>         
</body>
</html>