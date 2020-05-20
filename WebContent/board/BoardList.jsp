<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" import="board.Board"%>
<% ArrayList<Board> boardArr = (ArrayList<Board>)request.getAttribute("board");%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

table {
margin:auto;
text-align:center;
}
</style>
<meta charset="utf-8">
<title></title>
</head>

<script type="text/javascript">
	function detail(value){
		document.getElementById("detail" + value).submit();
	}
</script>


<body>
	<table>
			<tr>
				<td></td>
			</tr>
		<% for(int i = 0; i < boardArr.size(); i++){ %>
			<form id="detail<%=i%>" action="../board/BoardDetail" method="post">
			<tr>	
				<td><%= boardArr.get(i).getBoard_index() %></td>
				<td><a href="javascript:detail(<%=i%>);"><%= boardArr.get(i).getBoard_title() %></a></td>
				<td><%= boardArr.get(i).getBoard_writer() %></td>
				<td><%= boardArr.get(i).getBoard_time() %></td>
			</tr>
			<input type="hidden" name="board_id" value="<%=boardArr.get(i).getBoard_index()%>" />
			<input type="hidden" name="contentPage" value="../board/BoardDetail.jsp" />
			</form>
		<%} %>
	</table>
</body>
</html>