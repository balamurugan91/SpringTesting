package com.spring.test.model;

import com.spring.test.annotations.Date;
import com.spring.test.annotations.Length;
import com.spring.test.annotations.ReplaceSingleQuote;

public class TestModel {

	@Length(minLength=5)
	@ReplaceSingleQuote
	private String filter;
	
	@Date
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
