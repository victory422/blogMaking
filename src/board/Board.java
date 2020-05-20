package board;

public class Board {

	private int board_index = 0;
	private String board_title = "";
	private String board_text = "";
	private String board_writer = "";
	private String board_category = "";
	private String board_time = "";
	
	public Board() {
	}

	public Board(String board_title, String board_text, String board_writer, String board_category, String board_time) {
		this.board_title = board_title;
		this.board_text = board_text;
		this.board_writer = board_writer;
		this.board_category = board_category;
		this.board_time = board_time;
	}
	
	public int getBoard_index() {
		return board_index;
	}
	
	public void setBoard_index(int board_index){
		this.board_index = board_index;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_text() {
		return board_text;
	}

	public void setBoard_text(String board_text) {
		this.board_text = board_text;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public String getBoard_category() {
		return board_category;
	}

	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}

	public String getBoard_time() {
		return board_time;
	}

	public void setBoard_time(String board_time) {
		this.board_time = board_time;
	}
	
	
}
