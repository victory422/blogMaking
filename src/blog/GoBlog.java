package blog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDBConn;

import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class GoBlog
 */
@WebServlet("/blog/GoBlog")
public class GoBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		BoardDBConn DBConn = new BoardDBConn();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Blog blog = new Blog();
		String str = null;
		ArrayList<String> arr = new ArrayList<String>();
		
		HttpSession session = request.getSession();

		RequestDispatcher dis = request.getRequestDispatcher("../blog/MyBlog.jsp");
		
		try {
			System.out.println( "서블렛 부분 : " + (String)request.getParameter("member_id"));
			
			pstmt = conn.prepareStatement(
					"SELECT * FROM blogproject.blog WHERE blog_id = ?");
			
			pstmt.setString(1, (String)request.getParameter("member_id"));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("blog_category"));
				str = rs.getString("blog_category");
				System.out.println(str);
				String[] strArr = str.split(",");
				
				for(int i = 0; i < strArr.length; i++) {
					arr.add(strArr[i]);
					System.out.println("저장되는 카테고리 값 : " + strArr[i]);
					System.out.println("저장된 카테고리 값 : " + arr.get(i));
				}
				
				blog.setBlog_id(rs.getString("blog_id"));
				blog.setBlog_name(rs.getString("blog_name"));
				blog.setBlog_category(arr);
				
				System.out.println("카테고리 저장 잘 됬는지 : " + blog.getBlog_category().get(0));
				
				session.setAttribute("blog", blog);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("query error");
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			DBConn.close(conn);
			DBConn.close(pstmt);
			DBConn.close(rs);
		}
		
		//세션 아이디 출력
		System.out.println("세션에 저장된 아이디 : " + session.getAttribute("login_id"));
		System.out.println("세션에 저장된 닉네임 : " + session.getAttribute("login_name"));
		
		
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
