package com.spring.test.model;

import com.spring.test.annotations.Date;
import com.spring.test.annotations.Length;

public class TestModel {

	@Length(minLength=5)
	private String filter;
	
	@Date(allowEmpty = false)
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
