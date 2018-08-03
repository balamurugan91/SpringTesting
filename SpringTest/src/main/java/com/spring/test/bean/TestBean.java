package com.spring.test.bean;



import com.spring.test.annotations.SQLInjectionSafe;

public class TestBean {

	//@SQLInjectionSafe(message="Invalid filter")
	private String filter;
	
	
	@SQLInjectionSafe(message="Invalid Comments")
	private String comments;
	
	public String getFilter() {
		return filter;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	
}
