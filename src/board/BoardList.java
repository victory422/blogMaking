package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class BoardList
 */
@WebServlet(urlPatterns={"/board/BoardList"})
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
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
		
		ArrayList<Board> boardArr = new ArrayList<Board>();
		HttpSession session = request.getSession();
		BoardDBConn DBConn = new BoardDBConn();
		ResultSet rs = null;
		RequestDispatcher dis = request.getRequestDispatcher("../blog/MyBlog.jsp");
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		
		System.out.println("서블릿 넘어온 닉네임 값 : " + request.getParameter("nickName"));
		
		try { 
				pstmt = conn.prepareStatement(
						"SELECT * FROM blogproject.board WHERE board_writer = ? ORDER BY board_index");
				
				pstmt.setString(1, (String)request.getParameter("nickName"));
				rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoard_index(rs.getInt("board_index"));
				board.setBoard_title(rs.getString("board_title"));
				board.setBoard_text(rs.getString("board_text"));
				board.setBoard_writer(rs.getString("board_writer"));
				board.setBoard_category(rs.getString("board_category"));
				board.setBoard_time(rs.getString("board_time"));
				
				boardArr.add(board);
			}
			
			//값 제대로 출력 되는지 확인하는 구문 (콘솔에서 확인)
			for(int i=0; i < boardArr.size(); i++) {
				System.out.println(boardArr.get(i).getBoard_index());
			}
			
			System.out.println(request.getParameter("contentPage"));
			
			
			//나중에 지울것
//			request.setAttribute("contentPage", "../board/BoardList.jsp");
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("boardList query error");
		} catch (Exception e) {
			System.out.println("code error");
		} finally {
			DBConn.close(conn);
			DBConn.close(pstmt);
			DBConn.close(rs);
		}
		
		request.setAttribute("board", boardArr);
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
