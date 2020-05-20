<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.Board"%>
    
<% request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8"); 
	
	Board board = (Board)request.getAttribute("detail_board");
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<style type="text/css">
table {
margin:auto;
text-align:center;
}
</style>

<script type="text/javascript">
	function excute(value){
		if(value == 0){
			document.getElementById("boardUpdate").submit();
		}
		
		if(value == 1){
			var result = confirm("게시글을 삭제하시겠습니까?");
			
			if(result){
				document.getElementById("boardDelete").submit();
			}
		}
	}
</script>

<body>
	<form id="boardUpdate" action="../blog/MyBlog.jsp?contentPage=../board/BoardUpdate.jsp" method="post">
	<table>
		<tr>
			<td>제목 : </td>
			<td><%= board.getBoard_title() %></td>
			<input type="hidden" name="board_title" value="<%= board.getBoard_title() %>" />
		</tr>
		<tr>
			<td>작성자 : </td>
			<td><%= board.getBoard_writer() %></td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td><pre align="left"><%= board.getBoard_text() %></pre></td>
			<input type="hidden" name="board_text" value="<%= board.getBoard_text() %>" />
		</tr>
		<% if(session.getAttribute("login_name").equals(board.getBoard_writer())){ %>
			<tr>
					<td><input type="button" onclick="excute(0)" value="수정"/></td>
					<input type="hidden" name="board_id" value="<%=board.getBoard_index()%>" />
	</form>
				
				<form id="boardDelete" action="../board/BoardDelete" method="post">
					<td><input type="button" onclick="excute(1)" value="삭제"/></td>
					<input type="hidden" name="board_id" value="<%=board.getBoard_index()%>" />
					<input type="hidden" name="board_category" value="<%=board.getBoard_category() %>" />
				</form>
			</tr>
		<%}%>
	</table>
	
</body>
</html>