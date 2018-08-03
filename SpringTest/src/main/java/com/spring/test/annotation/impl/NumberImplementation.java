package com.spring.test.annotation.impl;

public class NumberImplementation {

	public boolean validate(String value) {
		return value.matches("-?\\d+(\\.\\d+)?");
	}
}
