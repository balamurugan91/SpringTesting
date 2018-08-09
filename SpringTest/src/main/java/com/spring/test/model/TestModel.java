package com.spring.test.model;

import com.spring.test.annotations.Date;
import com.spring.test.annotations.Decimal;
import com.spring.test.annotations.FilePath;
import com.spring.test.annotations.NoSpecialCharacters;
import com.spring.test.annotations.NotNull;
import com.spring.test.annotations.Number;

public class TestModel {

	@NotNull
	@NoSpecialCharacters(allowedCharacters= {" ",""})
	private String comments;
	
	@Number(allowEmpty=true)
	private String number;
	
	@Decimal(allowEmpty=false)
	private String decimal;
	
	@Date(format="MM/dd/yyyy")
	private String date;
	
	@FilePath
	private String filepath;
	
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDecimal() {
		return decimal;
	}
	public void setDecimal(String decimal) {
		this.decimal = decimal;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

}
