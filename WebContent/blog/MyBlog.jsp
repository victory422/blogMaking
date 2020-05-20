<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "blog.Blog" import = "java.util.*"%>
<% request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String contentPage=request.getParameter("contentPage");
	
	Blog blog = (Blog)session.getAttribute("blog");
	
	ArrayList<String> arr = new ArrayList<String>();
	
	for(int i = 0; i < 1000; i++){
		try{
			arr.add(i, blog.getBlog_category().get(i));
		}catch(Exception e){
			break;
		}
	}
	
	if(contentPage==null){
		contentPage="../board/BoardList_ready.jsp?nickName="+blog.getBlog_name();	
	}
	
	 for(int i = 0; i < arr.size(); i++){
		System.out.println("저장 된거 맞긴 해? : " + arr.get(i));
	} 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style type="text/css">
	
	#back{
		width : 1800px;
		height : 4000px;
		float : center;
		text-align : center;
		background : green;
		margin : 2%;
	}

	#top_bar{
		width : 90%;
		height : 200px;
		display : inline-block;
		margin : 3%;
		background : white;
	}
	
	#center_blog{
		align : center;
		margin : 80px;
	}
	
	#left_bar{
		float : left;
		width : 200px;
		height : 3000px;
		background : white;
		text-align : center;
		margin : 5%;
	}
	
	#top_back{
		width : 100%;
		height : 200px;
	}
	
	#right_bar{
		width : 1350px;
		height : 3000px;
		margin : 5% 20% 0%;
		background : white;
	}

</style>

<script type="text/javascript">
	function switchPage(value){
		if(value == "0"){
			location.href="../blog/MyBlog.jsp?contentPage=../board/BoardWrite.jsp";
		}
		
		if(value == "1"){
			location.href="../blog/MyBlog.jsp?contentPage=../blog/BlogUpdate.jsp";
		}
	}
	
	function choiceCategory(value){
		document.getElementById("category" + value).submit();
	}
	
	function goMain(){
		location.href="../main/sub.jsp";
	}
	
</script>

</head>
<body>


	<div id="back">
		<div id="top_back">
			<div id="top_bar">
				<p align="left"><button onclick="javascript:goMain();" value="메인페이지">메인페이지</button></p>
				<h1 id="center_blog" align="center"><%=blog.getBlog_name()%> 님의 블로그</h1>
			</div>
		</div>
		
		<div id="left_bar">
		
			<%
			String checkSession = (String)session.getAttribute("login_id");
			String checkId = blog.getBlog_id();
			
			if(checkSession.equals(checkId)) {
			out.print("<button id=\"write\" onclick=\"switchPage(0)\">글 쓰기</button><br><br>");
			out.print("<button id=\"blogUpdate\" onclick=\"switchPage(1)\">블로그 관리</button><br><br>");
			}
			%>	
			
			<p><a href="../blog/GoBlog?member_id=<%=blog.getBlog_id()%>">전체보기</a></p>
			
			<% for(int i = 0; i < arr.size(); i++) {%>
				<form id="category<%=i%>" action="../board/BoardCategory" method="post">
					<p><a href="javascript:choiceCategory(<%=i%>);"><%=arr.get(i)%></a></p>	
					<input type="hidden" name="category_name" value="<%=arr.get(i)%>" />
					<input type="hidden" name="nickName" value="<%=blog.getBlog_name() %>" /> 
					<input type="hidden" name="contentPage" value="../board/BoardList.jsp" />
				</form>	
			<% } %> 
		</div>
		
		<div id="right_bar">
			<jsp:include page="<%=contentPage%>" />
		</div>
	</div>

</body>
</html>