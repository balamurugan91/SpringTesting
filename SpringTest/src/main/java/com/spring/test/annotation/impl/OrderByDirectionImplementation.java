package com.spring.test.annotation.impl;

public class OrderByDirectionImplementation {

	public static boolean validate(Object value) {
		if (value != null && (value.toString().equalsIgnoreCase("asc") || value.toString().equalsIgnoreCase("desc"))) {
			return true;
		} else {
			return false;
		}
	}
}
