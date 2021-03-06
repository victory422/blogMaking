<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="blog.Blog"%>
<% request.setCharacterEncoding("UTF-8");
   response.setCharacterEncoding("UTF-8");
   
   Blog writeBlog = (Blog)session.getAttribute("blog");
   ArrayList<String> writeArr = new ArrayList<String>();
   
   for(int i = 0; i < 1000; i++){
      try{
         writeArr.add(i, writeBlog.getBlog_category().get(i));
      }catch(Exception e){
         break;
      }
   }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style type="text/css">

   
   #write_center{
      width : 80%;
      height : 50%;
      background : gray;
      margin : 5% 10%;
   }

</style>

<script type="text/javascript">

   var f = document.getElementById("write_text").value;
   f = f.replace(/(?:\r\n|\r|\n)/g, '<br>');
   document.getElementById("write_text").value = f;
   
   function go_back(){
      location.href="../blog/MyBlog.jsp";
   }
</script>

</head>
<body>

   
         <div id="write_center">
            <form action="../board/BoardWrite" method="post">
            <table id="write_table">
               <tr>
                  <td align="left">제목</td>
                  <td align="left"><input type="text" size="40" name="write_title"></td>
               </tr>
               <tr>
                  <td align="left">카테고리</td>
                  <td align="left"><select name="write_category">
                     <% for(int i = 0; i < writeArr.size(); i++) {%>
                        <option value="<%= writeArr.get(i) %>"><%= writeArr.get(i) %></option>
                     <% } %>
                  </select></td>
               </tr>
               <tr>
                  <td align="left">내용</td>
                  <td align="left"><textarea id="write_text" name="write_text" cols="100" rows="50" placeholder="내용을 입력하세요."></textarea></td>
               </tr>
               <tr></tr>
               <tr>
                  <td></td>
                  <td><input type="submit" value="등록"><input type="button" onclick="go_back()" value="취소"></td>
               </tr>
            </table>
            </form>
         </div>
      

</body>
</html>