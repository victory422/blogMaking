package board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/board/BoardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWrite() {
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
		
		int rs = 0;
		Board board = new Board();
		BoardDBConn DBConn = new BoardDBConn();
		HttpSession session = request.getSession();

		Date today = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		
		board.setBoard_title(request.getParameter("write_title"));
		board.setBoard_writer((String)session.getAttribute("login_name"));
		board.setBoard_category(request.getParameter("write_category"));
		board.setBoard_text(request.getParameter("write_text"));
		board.setBoard_time((String)time.format(today));
		
		try {
			pstmt = conn.prepareStatement(
					"insert into blogproject.board values(?,?,?,?,?,?)");
			
			pstmt.setString(1, null);
			pstmt.setString(2, board.getBoard_title());
			pstmt.setString(3, board.getBoard_text());
			pstmt.setString(4, board.getBoard_writer());
			pstmt.setString(5, board.getBoard_category());
			pstmt.setString(6, board.getBoard_time());
			
			rs=pstmt.executeUpdate();
			System.out.println(rs + "개 계정이 DB에 삽입되었습니다.");
			
		} catch (SQLException e) {
			System.out.println("query error");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
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
