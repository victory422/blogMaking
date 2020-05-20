package board;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardCategory
 */
@WebServlet("/board/BoardCategory")
public class BoardCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCategory() {
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
		
		ArrayList<Board> boardArr = new ArrayList<Board>();
		BoardDBConn DBConn = new BoardDBConn();
		HttpSession session = request.getSession();
		ResultSet rs = null;
		RequestDispatcher dis = request.getRequestDispatcher("../blog/MyBlog.jsp");
		
		String index = (String)request.getParameter("index");
		System.out.println("보드 넘버 : " + index);
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		
		
		System.out.println("서블릿 넘어온 닉네임 값 : " + request.getParameter("nickName"));
		System.out.println("서블릿 넘어온 카테고리 값 : " + request.getParameter("category_name"));
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM blogproject.board WHERE board_writer = ? AND board_category = ? ORDER BY board_index");
			
			pstmt.setString(1, (String)request.getParameter("nickName"));
			pstmt.setString(2, (String)request.getParameter("category_name"));
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
			
			System.out.println("콘텐트페이지 : " + request.getParameter("contentPage"));
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Category query error");
		} catch (Exception e) {
			System.out.println("etc error");
			e.printStackTrace();
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
