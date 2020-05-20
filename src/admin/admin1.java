package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class admin1
 */
@WebServlet("/admin1")
public class admin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin1() {
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

		
        HttpSession session = request.getSession();
		CallFromDB call = new CallFromDB();
		PrintWriter out = response.getWriter();
		
		String member_request = request.getParameter("member"); 
		String board_request = request.getParameter("board");

    	
		CallFromDB db = CallFromDB.getInstance();
    	
		if(member_request!=null) {

			out.print("<table border=\"1\">");
			out.print("<tr align=center bgcolor=\"#B0B0B0\">");
			for(int i=0; i<db.infoMember().length; i++) {
				out.print("<td>");
				out.print(db.infoMember()[i]);
			}
		for(int i = 0; i<call.CallingMember().size(); i++) {
			out.print("<tr>");
			for(int j = 0; j<call.CallingMember().get(i).length+2; j++) {
				if(j<call.CallingMember().get(i).length) {
				out.print("<td>");
				out.print(call.CallingMember().get(i)[j]);
				}
				else if(j==call.CallingMember().get(i).length) {
					out.print("<td><form method=\"get\" action=\"admin/user.jsp\">" + 
							 
							"<input type=\"hidden\" name=\"nick\" value=\""+call.CallingMember().get(i)[5]+"\">" + 
							"<input type=\"submit\" value=\"게시글보기\"></form>");
				}
				else if(j==(call.CallingMember().get(i).length+1)) {
					out.print("<td><form method=\"get\" action=\"delete\">" + 
							"<input type=\"hidden\" name=\"delete_member\" value=\"delete_member\">" + 
							"<input type=\"hidden\" name=\"number_member\" value=\""+call.CallingMember().get(i)[0]+"\">" + 
							"<input type=\"submit\" value=\"delete\"></form>");
				}
			}
			}
		out.print("</table>");
		}
		
		

		if(board_request!=null) {
			
			out.print("<table border=\"1\">");
			out.print("<tr align=center bgcolor=\"#B0B0B0\">");
			for(int i=0; i<db.infoBoard().length; i++) {
				out.print("<td>");
				out.print(db.infoBoard()[i]);
			}
			for(int i = 0; i<call.CallingBoard().size(); i++) {
					out.print("<tr>");
				for(int j = 0; j<call.CallingBoard().get(i).length; j++) {
					if(j==2){
						out.print("<td>");
						out.print("<a href=\"admin/text.jsp?number="+i+"\">내용(click)</a>");
					}else if (j==3) {
						out.print("<td>");
						out.print("<a href=\"admin/user.jsp?nick="+call.CallingBoard().get(i)[3]+"\">"+call.CallingBoard().get(i)[3]+"</a>");
					}
					else {
					out.print("<td>");
					out.print(call.CallingBoard().get(i)[j]);
					}
				}
			}
			out.print("</table>");
		}


		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
