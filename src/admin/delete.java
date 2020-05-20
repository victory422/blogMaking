package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
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
		CallFromDB call = new CallFromDB();
		
		RequestDispatcher dis = request.getRequestDispatcher("admin/alertConfirm.jsp");
		dis.forward(request, response);
		int number_board = 0;
		String delete_board = request.getParameter("delete_board");
		String num_str_board = request.getParameter("number_board");
		if(num_str_board!=null) {
			number_board = Integer.parseInt(num_str_board);
		}
		
		boolean lastCheck = false;
		String ch = (String) request.getAttribute("data");

		if(ch.equals("data")) lastCheck = true;
		if(delete_board!=null && lastCheck==true) {
				call.deleteBoard(number_board);
		}
		
		int number_member = 0;
		String delete_member = request.getParameter("delete_member");
		String num_str_member = request.getParameter("number_member");
		if(num_str_member!=null) {
			number_member = Integer.parseInt(num_str_member);
		}
		
		if(delete_member!=null) {
			call.deleteMember(number_member);
		}
		
		
		
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
