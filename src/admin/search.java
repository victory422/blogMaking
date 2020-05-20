package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		PrintWriter out = response.getWriter();

		ArrayList<String[]> arr = new ArrayList<String[]>();
		String nick = "ninckname";
		String id = "member_id";
		String ch_id = request.getParameter("check_id");
		String ch_nick = request.getParameter("check_nick");

		String ch_text = request.getParameter("check_text");
		String ch_title = request.getParameter("check_title");
		
		String searchWord = request.getParameter("searchWord");
		String where_nick = nick+" like \'%"+searchWord+"%\'";
		String where_id = id+" like \'%"+searchWord+"%\'";
		String where_nick_id = where_nick+" or "+where_id;
		
		
		String where = "";
		if(ch_id!=null && ch_nick!=null) {
			where = where_nick_id;
		}else if(ch_id!=null) {
			where = where_id;
		}else if(ch_nick!=null) {
			where = where_nick;
		}else System.out.println("come error");
		
		
		String query_select_member = "select * from blogproject.member1 where "+where;

		
		
		System.out.print(query_select_member);
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex1","root","1234");
			System.out.println("DB connect OK");
		
			try{
				stmt = conn.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
			}catch(Exception e) {
				System.out.println("query error");
			}
			//stmt.executeUpdate(query_insert);
			rs = stmt.executeQuery(query_select_member);
			String[] arr1 = new String[7];
			
			while(rs.next()){
				for(int i=0; i<arr1.length; i++) {
					arr1[i] = rs.getString(i+1);
				}
				arr.add(arr1);
				arr1 = new String[7];
			}
			
			conn.close();
			
		}catch(Exception e) {
			System.out.println("DB connect Error");	
		}
		CallFromDB db = CallFromDB.getInstance();
		if(arr!=null) {
			out.print("<table border=\"1\">");
			out.print("<tr><td> 회원");
			out.print("<table border=\"1\">");
			out.print("<tr align=center bgcolor=\"#B0B0B0\">");
			for(int i=0; i<db.infoMember().length; i++) {
				out.print("<td>");
				out.print(db.infoMember()[i]);
			}
			for(int i = 0; i<arr.size(); i++) {
				out.print("<tr>");
				for(int j = 0; j<arr.get(i).length+2; j++) {
					if(j<arr.get(i).length) {
					out.print("<td>");
					out.print(arr.get(i)[j]);
					}
					else if(j==arr.get(i).length) {
						out.print("<td><form method=\"get\" action=\"admin/user.jsp\">" + 
								"<input type=\"hidden\" name=\"nick\" value=\""+arr.get(i)[5]+"\">" + 
								"<input type=\"submit\" value=\"게시글보기\"></form>");
					}
					else if(j==(arr.get(i).length+1)) {
						out.print("<td><form method=\"get\" action=\"delete\">" + 
								"<input type=\"hidden\" name=\"delete_member\" value=\"delete_member\">" + 
								"<input type=\"hidden\" name=\"number_member\" value=\""+arr.get(i)[0]+"\">" + 
								"<input type=\"submit\" value=\"delete\"></form>");
					}
				}
				}
			out.print("</table>");
		}out.print("</table>");
		out.print("<table><tr><td><tr><tr><tr>");
		out.print("</table>");
		
		Connection conn2 = null;
		Statement stmt2 = null;
		ResultSet rs2 = null;
		
		String text = "board_text";
		String title = "board_title";
		
		String where_text = text+" like \'%"+searchWord+"%\'";
		String where_title = title+" like \'%"+searchWord+"%\'";
		String where_text_title = where_text+" or "+where_title;
		
		
		String where_board = "";
		if(ch_text!=null && ch_title!=null) {
			where_board = where_text_title;
		}else if(ch_text!=null) {
			where_board = where_text;
		}else if(ch_title!=null) {
			where_board = where_title;
		}else System.out.println("come error");
		
		
		String query_select_board = "select * from blogproject.board where "+where_board;
		
		System.out.println(query_select_board);
	
		ArrayList<String[]> arr_board = new ArrayList<String[]>();
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex1","root","1234");
			System.out.println("DB connect OK");
		
			try{
				stmt2 = conn2.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
			}catch(Exception e) {
				System.out.println("query error");
			}
			//stmt.executeUpdate(query_insert);
			rs2 = stmt2.executeQuery(query_select_board);
			String[] arr2 = new String[6];

			while(rs2.next()){
				for(int i=0; i<6; i++) {
					arr2[i] = rs2.getString(i+1);
				}
				arr_board.add(arr2);
				arr2 = new String[6];
			}
			

			conn.close();
			
		}catch(Exception e) {
			System.out.println("DB connect Error");	
		}

		if(arr_board!=null) {
			out.print("<table border=\"1\">");
			out.print("<tr><td> 게시글");
			
			out.print("<table border=\"1\">");
			out.print("<tr align=center bgcolor=\"#B0B0B0\">");
			for(int i=0; i<db.infoBoard().length; i++) {
				out.print("<td>");
				out.print(db.infoBoard()[i]);
			}
			for(int i = 0; i<arr_board.size(); i++) {
				out.print("<tr>");
			for(int j = 0; j<arr_board.get(i).length; j++) {
				if(j==2){
					out.print("<td>");
					out.print("<a href=\"admin/text(search).jsp?searchWord="+searchWord+"&check_text="+ch_text+""
							+ "&check_title="+ch_title+"&number="+i+"\">내용(click)</a>");
				}else if (j==3) {
					out.print("<td>");
					out.print("<a href=\"admin/user.jsp?nick="+arr_board.get(i)[3]+"\">"+arr_board.get(i)[3]+"</a>");
				}
				else {
				out.print("<td>");
				out.print(arr_board.get(i)[j]);
				}
			}
		}
			out.print("</table>");
		}out.print("</table>");
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
