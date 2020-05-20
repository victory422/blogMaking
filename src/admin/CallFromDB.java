package admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.Spliterator;

import javax.servlet.RequestDispatcher;
import org.apache.catalina.connector.Request;

public class CallFromDB {

	private static CallFromDB instance;

	public static CallFromDB getInstance() {
		if (instance == null) {
			instance = new CallFromDB();
		}
		return instance;
	}

	private ArrayList<String[]> CallingBoard;
	private ArrayList<String[]> CallingMember;
	private ArrayList<String> CallingWords;
	private String[] info_member = { "num", "name", "ID", "PW", "birth", "nickName", "findingKey" };
	private String[] info_board = { "num", "title", "text", "writer", "category", "time" };
	private String[] info_qna = { "number", "id", "question", "answer", "답변완료", "time", "password" };

	public String[] infoMember() {
		return info_member;
	}

	public String[] infoBoard() {
		return info_board;
	}

	public String[] infoQna() {
		return info_qna;
	}

	public ArrayList<String[]> CallingMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// PreparedStatement pstmt = null;
		// Boolean connect = false;
		String temp = "";
		ArrayList<String[]> arr = new ArrayList<String[]>();

		String query_select = "select * from blogproject.member1";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject", "root", "1234");
			System.out.println("DB connect OK");

			try {
				stmt = conn.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
			} catch (Exception e) {
				System.out.println("query error");
			}
			// stmt.executeUpdate(query_insert);
			rs = stmt.executeQuery(query_select);
			String[] arr1 = new String[7];

			while (rs.next()) {
				for (int i = 0; i < arr1.length; i++) {
					arr1[i] = rs.getString(i + 1);
				}
				arr.add(arr1);
				arr1 = new String[7];
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("DB connect Error");
		}
		CallingMember = arr;
		return CallingMember;
	}

	public ArrayList<String[]> CallingBoard() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// PreparedStatement pstmt = null;
		// Boolean connect = false;

		ArrayList<String[]> arr = new ArrayList<String[]>();

		String query_select = "select * from blogproject.board";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject", "root", "1234");
			System.out.println("DB connect OK");

			try {
				stmt = conn.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
			} catch (Exception e) {
				System.out.println("query error");
			}
			// stmt.executeUpdate(query_insert);
			rs = stmt.executeQuery(query_select);
			String[] arr1 = new String[6];

			while (rs.next()) {
				for (int i = 0; i < arr1.length; i++) {
					arr1[i] = rs.getString(i + 1);
				}
				arr.add(arr1);
				arr1 = new String[6];
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("DB connect Error");
		}
		CallingBoard = arr;
		return CallingBoard;
	}

	
	public String exceptingWord(String temp) {
		ArrayList<String> arr = exceptWord();

		for(int i = 0; i<arr.size(); i++) {
			temp = temp.replace(arr.get(i), " ");
		}
		
		return temp;
	}
	
	
	public ArrayList<String> exceptWord() {
		ArrayList<String> arr = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// PreparedStatement pstmt = null;
		// Boolean connect = false;

		String query_select = "select * from blogproject.except";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject", "root", "1234");
			System.out.println("DB connect OK");

			try {
				stmt = conn.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
			} catch (Exception e) {
				System.out.println("query error");
			}
			// stmt.executeUpdate(query_insert);
			rs = stmt.executeQuery(query_select);
			
			while (rs.next()) {
				if(rs.getString(2).equals("null")) {
				}else arr.add(rs.getString(2));
			}
			
			conn.close();

		} catch (Exception e) {
			System.out.println("DB connect Error");
		}

		return arr;
	}
	
	
	public void exceptAddWord(String str) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// PreparedStatement pstmt = null;
		// Boolean connect = false;
		
		String query_insert = "insert into blogproject.except values(null, \"" +str+"\");";
		System.out.println(query_insert);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject", "root", "1234");
			System.out.println("DB connect OK");

			try {
				stmt = conn.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
				stmt.executeUpdate(query_insert);
				System.out.println("insert OK");
			} catch (Exception e) {
				System.out.println("query error");
			}
		
		       

		} catch (Exception e) {
			System.out.println("DB connect Error");
		}
	}
	
	
	public void exceptRemoveWord(String str) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// PreparedStatement pstmt = null;
		// Boolean connect = false;
		
		String query_delete = "delete from blogproject.except where words=\""+str+"\"";
		System.out.println(query_delete);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject", "root", "1234");
			System.out.println("DB connect OK");

			try {
				stmt = conn.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
				stmt.executeUpdate(query_delete);
				System.out.println("delete OK");
			} catch (Exception e) {
				System.out.println("query error");
			}
		
		       

		} catch (Exception e) {
			System.out.println("DB connect Error");
		}
	}
	
	
	public ArrayList<String> CallingWords() {
		CallFromDB db = CallFromDB.getInstance();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// PreparedStatement pstmt = null;
		// Boolean connect = false;

		ArrayList<String> arr = new ArrayList<String>();

		String query_select = "select * from blogproject.board";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject", "root", "1234");
			System.out.println("DB connect OK");

			try {
				stmt = conn.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
			} catch (Exception e) {
				System.out.println("query error");
			}
			// stmt.executeUpdate(query_insert);
			rs = stmt.executeQuery(query_select);
			
			String temp = "";
			while (rs.next()) {
				temp = rs.getString(3);
				temp = db.exceptingWord(temp);
				String[] sp = temp.split("\\s");
				for(int i=0; i<sp.length; i++) {
					if(sp[i].equals("")) {
					}else arr.add(sp[i]);
			}
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("DB connect Error");
		}
		CallingWords = arr;
		return CallingWords;
	}
	

	public ArrayList<String[]> getCallingBoard() {
		return CallingBoard();
	}

	public void setCallingBoard(ArrayList<String[]> callingBoard) {
	}

	public ArrayList<String[]> getCallingMember() {
		return CallingMember();
	}

	public void setCallingMember(ArrayList<String[]> callingMember) {
	}



	public void deleteBoard(int state) {
		Connection conn = null;
		Statement stmt = null;
		String query_delete = "delete from blogproject.board where board_index=" + state;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject", "root", "1234");
			System.out.println("DB connect OK");

			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(query_delete);
				System.out.println("query ok");
			} catch (Exception e) {
				System.out.println("query error");
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("DB connect Error");
		}
	}

	public void deleteMember(int state) {
		Connection conn = null;
		Statement stmt = null;
		String query_delete = "delete from blogproject.member1 where number=" + state;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject", "root", "1234");
			System.out.println("DB connect OK");

			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(query_delete);
				System.out.println("query ok");
			} catch (Exception e) {
				System.out.println("query error");
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("DB connect Error");
		}

	}

	public String[] searchUser(String insert_query) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String[] arr = new String[7];
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject", "root", "1234");
			System.out.println("DB connect OK");

			try {
				stmt = conn.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
			} catch (Exception e) {
				System.out.println("query error");
			}
			// stmt.executeUpdate(query_insert);
			rs = stmt.executeQuery(insert_query);

			while (rs.next()) {
				for (int i = 0; i < arr.length; i++) {
					arr[i] = rs.getString(i + 1);
				}
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("DB connect Error");
		}
		return arr;
	}

	public ArrayList<String[]> searchUserBoard(String nick) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String[] arr2 = new String[6];
		ArrayList<String[]> arr = new ArrayList<>();
		String insert_query = "select * from blogproject.board where board_writer=\"" + nick + "\"";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogproject", "root", "1234");
			System.out.println("DB connect OK");

			try {
				stmt = conn.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
			} catch (Exception e) {
				System.out.println("query error");
			}
			// stmt.executeUpdate(query_insert);
			rs = stmt.executeQuery(insert_query);

			while (rs.next()) {
				for (int i = 0; i < arr2.length; i++) {
					arr2[i] = rs.getString(i + 1);
				}
				arr.add(arr2);
				arr2 = new String[6];
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("DB connect Error");
		}
		return arr;
	}

	public ArrayList<String[]> searchTextList(String searchWord, String ch_text, String ch_title) {
		Connection conn2 = null;
		Statement stmt2 = null;
		ResultSet rs2 = null;
		
		String text = "board_text";
		String title = "board_title";
		
		String where_text = text+" like \'%"+searchWord+"%\'";
		String where_title = title+" like \'%"+searchWord+"%\'";
		String where_text_title = where_text+" or "+where_title;
		
		
		String where_board = "";
		if(ch_text!=null && ch_title!=null) {
			where_board = where_text_title;
		}else if(ch_text!=null) {
			where_board = where_text;
		}else if(ch_title!=null) {
			where_board = where_title;
		}else System.out.println("come error");
		
		
		String query_select_board = "select * from blogproject.board where "+where_board;
		
		System.out.println(query_select_board);
	
		ArrayList<String[]> arr_board = new ArrayList<String[]>();
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex1","root","1234");
			System.out.println("DB connect OK");
		
			try{
				stmt2 = conn2.createStatement();
//				stmt.executeUpdate(query_create);
				System.out.println("query ok");
			}catch(Exception e) {
				System.out.println("query error");
			}
			//stmt.executeUpdate(query_insert);
			rs2 = stmt2.executeQuery(query_select_board);
			String[] arr2 = new String[6];

			while(rs2.next()){
				for(int i=0; i<6; i++) {
					arr2[i] = rs2.getString(i+1);
				}
				arr_board.add(arr2);
				arr2 = new String[6];
			}
			

			conn2.close();
			
		}catch(Exception e) {
			System.out.println("DB connect Error");	
		}
		return arr_board;
	}
	
	
	public ArrayList<Integer> wordsCount(ArrayList<String> arr, int number) {

        /** 원본 데이터 유형 */
        ArrayList<String> itemList = arr;

        /** 원본 데이터 유형별 중복개수 */
        ArrayList<Integer> cntList = new ArrayList<Integer>();        

        //1. 데이터 유형 및 개수를 설정한다.

        for(int index = 0 ; index < itemList.size() ; index++){
                //1.1.2 item이 몇개 들어있는지 세어서 cntList에 추가한다.
                int cnt = 0;
                for(int searchIndex = index; searchIndex < itemList.size(); searchIndex++){
                    if(itemList.get(index).equals(itemList.get(searchIndex))) {
                        cnt++;
                    }
                }
                cntList.add(cnt);


        }//end 데이터 유형 및 개수를 설정
        
        
        //중복 값 버리기
        ArrayList<String> arr2 = new ArrayList<String>();
        ArrayList<Integer> arrInt = new ArrayList<Integer>();
        
    	for(int i = 0; i<arr.size(); i++) {
    			if(!arr2.contains(arr.get(i))) {
    				if(number<=cntList.get(i)) {
    				arr2.add(arr.get(i));
    				arrInt.add(cntList.get(i));
    				}
    			}
    	} //중복버리기 끝
    	
    	//오름차순 정렬하기
        int temp = 0;
        String temp_str="";
        for(int j=0; j<arrInt.size()-1; j++) {
        	for(int i=0; i<arrInt.size()-1; i++) {
	        	if(arrInt.get(i)<arrInt.get(i+1)) {
	        		temp = arrInt.get(i);
	        		temp_str=arr2.get(i);
	        		arrInt.set(i,arrInt.get(i+1));
	        		arr2.set(i,arr2.get(i+1));
	        		arrInt.set(i+1,temp);
	        		arr2.set(i+1,temp_str);
	        	}
        	}
        }

		return arrInt;
	}
	
	
	
	public ArrayList<String> wordsRank(ArrayList<String> arr, int number) {

        /** 원본 데이터 유형 */
        ArrayList<String> itemList = arr;

        /** 원본 데이터 유형별 중복개수 */
        ArrayList<Integer> cntList = new ArrayList<Integer>();        

        //1. 데이터 유형 및 개수를 설정한다.

        for(int index = 0 ; index < itemList.size() ; index++){
                //1.1.2 item이 몇개 들어있는지 세어서 cntList에 추가한다.
                int cnt = 0;
                for(int searchIndex = index; searchIndex < itemList.size(); searchIndex++){
                    if(itemList.get(index).equals(itemList.get(searchIndex))) {
                        cnt++;
                    }
                }
                cntList.add(cnt);
        }//end 데이터 유형 및 개수를 설정
        
        
        //중복 값 버리기
        ArrayList<String> arr2 = new ArrayList<String>();
        ArrayList<Integer> arrInt = new ArrayList<Integer>();
        
    	for(int i = 0; i<arr.size(); i++) {
    			if(!arr2.contains(arr.get(i))) {
    				if(number<=cntList.get(i)) {
    				arr2.add(arr.get(i));
    				arrInt.add(cntList.get(i));
    				}
    			}
    	} //중복버리기 끝
    	
    	//오름차순 정렬하기
        int temp = 0;
        String temp_str="";
        for(int j=0; j<arrInt.size()-1; j++) {	
        	for(int i=0; i<arrInt.size()-1; i++) {
	        	if(arrInt.get(i)<arrInt.get(i+1)) {
	        		temp = arrInt.get(i);
	        		temp_str=arr2.get(i);
	        		arrInt.set(i,arrInt.get(i+1));
	        		arr2.set(i,arr2.get(i+1));
	        		arrInt.set(i+1,temp);
	        		arr2.set(i+1,temp_str);
	        	}
        	}
        }

		return arr2;
	}
	

}
