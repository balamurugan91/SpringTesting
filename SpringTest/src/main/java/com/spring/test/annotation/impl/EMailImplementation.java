package com.spring.test.annotation.impl;

public class EMailImplementation {

	public static boolean validate(Object value, boolean allowEmpty) {

		if (value == null || value.equals("")) {
			if (allowEmpty)
				return true;
			else
				return false;
		} else {
			return value.toString().matches("^([a-zA-Z0-9_.+-])+\\@(([a-zA-Z0-9-])+\\.)+([a-zA-Z0-9]{2,4})+$");
		}
	}
}
