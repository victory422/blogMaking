package board;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/board/BoardUpdate")
public class BoardUpdate extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
//      response.getWriter().append("Served at: ").append(request.getContextPath());
      
      response.setCharacterEncoding("utf-8");
      request.setCharacterEncoding("utf-8");
      
      int rs = 0;
      BoardDBConn DBConn = new BoardDBConn();
      
      Connection conn = DBConn.getConnection();
      PreparedStatement pstmt = null;
      
      try {
         pstmt = conn.prepareStatement(
               "UPDATE blogproject.board SET " +
               "board_title = ?," + 
               "board_text = ?," + 
               "board_category = ?" +
               "WHERE board_index = ?");
         
         pstmt.setString(1, request.getParameter("update_title"));
         pstmt.setString(2, request.getParameter("update_text"));
         pstmt.setString(3, request.getParameter("update_category"));
         pstmt.setString(4, request.getParameter("update_id"));
         
         System.out.println(request.getParameter("update_title"));
         System.out.println(request.getParameter("update_text"));
         System.out.println(request.getParameter("update_category"));
         System.out.println(request.getParameter("update_id"));
         
         rs=pstmt.executeUpdate();
         System.out.println(request.getParameter("write_id") + "개 게시글이 수정되었습니다.");
         conn.commit();
      
      } catch (SQLException e) {
         // TODO: handle exception
         System.out.println("query error");
         try {
            conn.rollback();
         }catch(SQLException e2) {
            
         }
      } catch (Exception e) {
         System.out.println("etc error");
      } finally {
         DBConn.close(conn);
         DBConn.close(pstmt);
      }
      
      response.sendRedirect("../board/BoardDetail?contentPage=../board/BoardDetail.jsp&board_id=" +
                        request.getParameter("update_id"));
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}