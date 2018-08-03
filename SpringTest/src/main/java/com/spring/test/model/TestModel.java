package com.spring.test.model;

import com.spring.test.annotations.Length;
import com.spring.test.annotations.ReplaceSingleQuote;

public class TestModel {

	@Length(value=10)
	@ReplaceSingleQuote
	private String filter;
	
	private String comments;

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
