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
			System.out.println( "���� �κ� : " + (String)request.getParameter("member_id"));
			
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
					System.out.println("����Ǵ� ī�װ� �� : " + strArr[i]);
					System.out.println("����� ī�װ� �� : " + arr.get(i));
				}
				
				blog.setBlog_id(rs.getString("blog_id"));
				blog.setBlog_name(rs.getString("blog_name"));
				blog.setBlog_category(arr);
				
				System.out.println("ī�װ� ���� �� ����� : " + blog.getBlog_category().get(0));
				
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
		
		//���� ���̵� ���
		System.out.println("���ǿ� ����� ���̵� : " + session.getAttribute("login_id"));
		System.out.println("���ǿ� ����� �г��� : " + session.getAttribute("login_name"));
		
		
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
