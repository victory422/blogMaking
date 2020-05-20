<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="blog.Blog"%>
<% 
	Blog blog_update = (Blog)session.getAttribute("blog");
	ArrayList<String> arr_update = new ArrayList<String>();
	
	for(int i = 0; i < 1000; i++){
		try{
			arr_update.add(i, blog_update.getBlog_category().get(i));
		}catch(Exception e){
			break;
		}
	}
	
	for(int i = 0; i < arr_update.size(); i++){
		if(arr_update.get(i).equals(" ")){
			arr_update.remove(i);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>

<script type="text/javascript">

</script>
<body>

<div id="write_center">
	<h2 align="center">
	<form action="../blog/BlogUpdate" method="post">
		<div>
			<% for(int i=0; i < 10; i++){ %>
				<% try{ String str = arr_update.get(i);%>
					<p>카테고리 <%=i+1%> : <input type="text" name="category(<%=i%>)" value="<%=arr_update.get(i)%>" /></p>
				<% }catch (Exception e){ %>
					<p>카테고리 <%=i+1%> : <input type="text" name="category(<%=i%>)" placeholder="카테고리를 입력하세요." autocomplete="off"></p>
				<% } %>
			<% } %>
			
			<input type="hidden" name="member_id" value="<%=blog_update.getBlog_id() %>" />
		</div>
		<input type="submit" value="확인" /> 
	</form>
	</h2>
</div>

</body>
</html>