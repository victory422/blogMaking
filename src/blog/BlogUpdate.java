package blog;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDBConn;

/**
 * Servlet implementation class BlogUpdate
 */
@WebServlet("/blog/BlogUpdate")
public class BlogUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		RequestDispatcher dis = request.getRequestDispatcher("../blog/GoBlog?member_id=" + request.getParameter("member_id"));
		HttpSession session = request.getSession();
		BoardDBConn DBConn = new BoardDBConn();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		
		String category = "";
		int result = 0;
		Blog blog = (Blog)session.getAttribute("blog");
		
		System.out.println("블로그 정보 잘 넘어왔는지 : " + blog.getBlog_id());
		
		for(int i = 0; i < 10; i++) {
			try {
				category += request.getParameter("category(" + i + ")") + ",";
			} catch (Exception e) {
				break;
			}
		}
		
		System.out.println("카테고리 값 잘 입력 됬는지 : " + category);
		
		try {
			
			pstmt=conn.prepareStatement("update blogproject.blog set blog_category=? where blog_id=?");
			
			pstmt.setString(1, category);
			pstmt.setString(2, blog.getBlog_id());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("query error");
		} catch(Exception e) {
			System.out.println("etc error");
			e.printStackTrace();
		} finally {
			DBConn.close(conn);
			DBConn.close(pstmt);
		}
		
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
