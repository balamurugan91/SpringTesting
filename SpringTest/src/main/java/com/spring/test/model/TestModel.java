package com.spring.test.model;

import com.spring.test.annotations.Date;
import com.spring.test.annotations.Decimal;
import com.spring.test.annotations.EMail;
import com.spring.test.annotations.FilePath;
import com.spring.test.annotations.Filter;
import com.spring.test.annotations.NoSpecialCharacters;
import com.spring.test.annotations.NotNull;
import com.spring.test.annotations.Number;
import com.spring.test.annotations.PhoneNumber;

public class TestModel {

	@NotNull
	@NoSpecialCharacters(allowedCharacters= {" ",","})
	private String comments;
	
	@Number
	private String number;
	
	@Decimal
	private String decimal;
	
	@Date(format="MM/dd/yyyy")
	private String date;
	
	@FilePath
	private String filepath;
	
	@EMail
	private String email;
	
	@PhoneNumber
	private String phone;
	
	@Filter
	private String filter;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}

}
