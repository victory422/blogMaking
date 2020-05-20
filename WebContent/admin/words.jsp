<%@page import="java.util.ArrayList"%>
<%@ page import="admin.CallFromDB" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>키워드 분석</title>
</head>
<body>
	<form>
	    <input type="text" name="view" value="필터 숫자를 입력해주세요" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" onFocus="javascript:this.value=''"/> 
		<input type="submit" value="확인">	
	</form>
<%
int number = 2;
if(request.getParameter("view")!=null) {
	number = Integer.parseInt(request.getParameter("view"));
}
CallFromDB db = CallFromDB.getInstance();
ArrayList<String> arr = new ArrayList<String>();
arr = db.CallingWords();
	out.print("<table>");
	out.print("<tr><td>");
	
	out.print("<table border=\"1\">");
	out.print("<tr align=center bgcolor=\"#B0B0B0\">");
	
	out.print("<td>내용");
	out.print("<td>반복수");


	for(int i = 0; i<db.wordsRank(arr,number).size(); i++) {
		out.print("<tr><td>");
		out.print(db.wordsRank(arr,number).get(i));
		out.print("<td>");
		out.print(db.wordsCount(arr,number).get(i));	
}
	out.print("</table>");
	out.print("<td>");
	out.print("<table  border=\"1\">");
	out.print("<tr align=center bgcolor=\"#B0B0B0\">");
	out.print("<td colspan='"+(db.exceptWord().size())+"'> 삭제된 단어");
	out.print("<td colspan='1'>추가");
	out.print("<td colspan='1'>삭제");
	out.print("<tr>");

	for(int i = 0; i<db.exceptWord().size(); i++) {
		out.print("<td>");
		out.print(db.exceptWord().get(i));
	}out.print("<td>");
	out.print("<form method=\"get\" action=\"../keywordDB\"");
	out.print("<td><input type='text' name='add' value=''> ");
	out.print("<input type='submit' value='확인' >");
	out.print("</form>");
	out.print("<form method=\"get\" action=\"../keywordDB\"");
	out.print("<tr><td><input type='text' name='remove' value=''> ");
	out.print("<input type='submit' value='확인' >");
	out.print("</form>");
	out.print("</table>");
	
	out.print("</table>");
//db.exceptAddWord(a);
//db.exceptRemoveWord("!");
%>



</body>
</html>