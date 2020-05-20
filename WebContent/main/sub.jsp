<%@ page language="java" import="admin.CallFromDB" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");%>

<!DOCTYPE html>
<html>
<head>
<link href="./bootstrap-4.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="./bootstrap-4.4.1-dist/css/custom.css" rel="stylesheet">
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
	<%session.setAttribute("name", request.getParameter("member_name")); 
	CallFromDB db = CallFromDB.getInstance();
	String nick = (String)session.getAttribute("login_name");
	%>
<title><%=nick%>님의 블로그</title>
<style>
header{
height:90px;
}

</style>

</head>

<body background="img/22.jpg" >
   <div class ="container">
      <div style="float: left; width:100%;height:80px;">
      <header>
      	<div class="row">
         	<div class="col-md-4">
         		
         	</div>
            <div class="col-md-4"></div>
	            <div class="col-md-4">
	            <table>
	            <form id="search" action="../main/db.jsp" method="post">
	            <tr>
	            	<td>
	            		<select name="search_key" id="search_key">
						  <option value="board_title">제목</option>
						  <option value="board_text">내용</option>
						  <option value="board_writer">작성자</option>
						</select>	            		
	            	</td>
		            <td><input type ="text" name="search_value" id="search_value"></td>
                  <td><input type ="button"value="검색" onclick="search_func2()"></td>
		        </tr>
		        </form>
		       	</table>
		        </div>
            </form>
        </div><br>
        <div class="row">
            <div class="col-md-10"></div>
            <div class="col-md-2">
            	<input type ="button" value="로그아웃" onclick="logout()">
            </div>
        </div>
        </header>
      </div>
	  <div style="float: left; width:20%; height:1000px">
	      <div><h3>환영합니다!!<br><%=(String)session.getAttribute("login_id") %> 님</h3></div><br>
	      <div style="float:left; width:90%; height:10">
				<form method="post" action="../blog/MyPage.jsp">
					<input type="hidden" name="nick" value="<%=nick%>">
		      		<input type="submit" value ="마이페이지">
	      		</form><br>
	      		<form action="../blog/GoBlog" id="go_my_blog" method="post">
	      			<input type="button" value="내 블로그" onclick="goBlog()">
	      			<input type="hidden" name="member_id" value="<%=session.getAttribute("login_id")%>"/>
	      		</form> 		
	      </div> 
      </div>
      <div style="float: left; width:80%; height:1000px">
        <div><h1>최신글</h1></div> 
       	 	<table class="talbe table-bordered">
       	 	<jsp:include page="lately.jsp" />
       	 
          </table>
      </div>

   </div>
   
 <script type="text/javascript">
 	function search_func(){
 		var search_value = document.getElementById("search_value").value;
 		
 		var search_key = $("#search_key option:selected").val();
 		location.href= "db.jsp?search_key="+search_key +"&search_value="+ search_value;
 		
 	} 
 	function logout(){
 		alert("logout");
 		location.href= "../member/logOut.jsp";
 	}
 	function main(){
 		location.href= "sub.jsp";
 	 	
 	}
	function goBlog(){
		document.getElementById("go_my_blog").submit();
	}	
 	
	 function search_func2(){
	      document.getElementById("search").submit();
	   }
 </script>
   
   
   
   
   
   
   
   
   
   
<script type="text/javascript" src="/project_blog/WebContent/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>         
</body>








