package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.Blog;

/**
 * Servlet implementation class BoardSearch
 */
@WebServlet("/board/BoardSearch")
public class BoardSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//닉네임 받아서 블로그 보여주기
		//index 로 클릭한 글 보여주기
		//해당 블로그 카테고리 불러오기
		HttpSession session = request.getSession();
		Board board = new Board();
		BoardDBConn DBConn = new BoardDBConn();
		ResultSet rs = null;
		Blog blog = new Blog();
		String str = null;
		ArrayList<String> arr = new ArrayList<String>();
		
		RequestDispatcher dis = request.getRequestDispatcher("../blog/MyBlog.jsp");
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		
System.out.println(request.getParameter("board_id"));
		
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM blogproject.board WHERE board_index = ?");
			
			pstmt.setString(1, (String)request.getParameter("board_index"));
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				board.setBoard_index(rs.getInt("board_index"));
				board.setBoard_title(rs.getString("board_title"));
				board.setBoard_text(rs.getString("board_text"));
				board.setBoard_writer(rs.getString("board_writer"));
				board.setBoard_category(rs.getString("board_category"));
				board.setBoard_time(rs.getString("board_time"));
				
				System.out.println(board.getBoard_index());
			}
			
			System.out.println( "index 부분 : " + board.getBoard_index());
			
			pstmt = conn.prepareStatement(
					"SELECT * FROM blogproject.blog WHERE blog_name = ?");
			
			pstmt.setString(1, (String)request.getParameter("board_writer"));
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
			
			System.out.println("code error");
			
		} finally {
			DBConn.close(conn);
			DBConn.close(pstmt);
			DBConn.close(rs);
		}
		
		request.setAttribute("detail_board", board);
		dis.forward(request, response);
	
		
		
	
	//////////////////////////////////////////////////////// Goblog

}
	
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
