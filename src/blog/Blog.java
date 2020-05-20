package blog;

import java.util.*;

public class Blog {
	
	private String blog_id = "";
	private ArrayList<String> blog_category = new ArrayList<String>();
	private String blog_name = "";
	
	public Blog() {	}

	public Blog(String blog_id, ArrayList<String> blog_category, String blog_name) {
		super();
		this.blog_id = blog_id;
		this.blog_category = blog_category;
		this.blog_name = blog_name;
	}

	public String getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}

	public ArrayList<String> getBlog_category() {
		return blog_category;
	}

	public void setBlog_category(ArrayList<String> blog_category) {
		this.blog_category = blog_category;
	}

	public String getBlog_name() {
		return blog_name;
	}

	public void setBlog_name(String blog_name) {
		this.blog_name = blog_name;
	}
	
	

}
