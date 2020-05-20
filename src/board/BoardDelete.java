package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class BoardDelete
 */
@WebServlet("/board/BoardDelete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDelete() {
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
		
		int rs = 0;
		
		BoardDBConn DBConn = new BoardDBConn();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(
					"Delete from blogproject.board WHERE board_index = ?");
			
			pstmt.setString(1, request.getParameter("board_id"));
			
			rs = pstmt.executeUpdate();
			System.out.println(rs + "개가 삭제되었습니다.");
			conn.commit();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("query error");
			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			System.out.println("etc error");
		} finally {
			DBConn.close(conn);
			DBConn.close(pstmt);
		}
		
		response.sendRedirect("../blog/MyBlog.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
