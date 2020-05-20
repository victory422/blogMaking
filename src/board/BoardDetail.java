package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/board/BoardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetail() {
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
		
		Board board = new Board();
		BoardDBConn DBConn = new BoardDBConn();
		ResultSet rs = null;
		
		RequestDispatcher dis = request.getRequestDispatcher("../blog/MyBlog.jsp");
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		
		System.out.println(request.getParameter("board_id"));
		
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM blogproject.board WHERE board_index = ?");
			
			pstmt.setString(1, (String)request.getParameter("board_id"));
			
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
