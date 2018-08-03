package com.spring.test.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.log4j.Logger;

public class SQLInjectionFilterImplementation extends HttpServletRequestWrapper{
		private static Logger logger = Logger.getLogger(RequestWrapper.class);
		
		public SQLInjectionFilterImplementation(HttpServletRequest servletRequest) {
			super(servletRequest);
		}

		public String[] getParameterValues(String parameter) {
			logger.info("InarameterValues .. parameter .......");
			String[] values = super.getParameterValues(parameter);
			if (values == null) {
				return null;
			}
			int count = values.length;
			String[] encodedValues = new String[count];
			for (int i = 0; i < count; i++) {
				encodedValues[i] = removeSQLInjectionAttacks(values[i]);
			}
			return encodedValues;
		}

		public String getParameter(String parameter) {
			logger.info("InParameter .. parameter .......");
			String value = super.getParameter(parameter);
			if (value == null) {
				return null;
			}
			logger.info("InParameter RequestWrapper ........ value .......");
			return removeSQLInjectionAttacks(value);
		}

		public String getHeader(String name) {
			logger.info("In Header .. parameter .......");
			String value = super.getHeader(name);
			if (value == null)
				return null;
			logger.info("In Header RequestWrapper ........... value ....");
			return removeSQLInjectionAttacks(value);
		}

		private String removeSQLInjectionAttacks(String value) {
			logger.info("In SQLInjection RequestWrapper ..............." + value);
			
			value = value.replaceAll("'", "''");

			logger.info("Out SQLInjection RequestWrapper ........ value ......." + value);
			return value;
		}
}
