package com.spring.test.annotation.impl;

public class FilterImplementation {

	public static String implement(Object value) {
		
		String stringValue = "";
		
		if (!(value == null || value.toString().equals(""))) {
			
			stringValue = value.toString();
			
			for (String pattern : sqlRegexps) {

				
				stringValue = stringValue.replaceAll(pattern, "");

			}
		}
		return stringValue;
	}

	public static final String SQL_TYPES = "TABLE, TABLESPACE, PROCEDURE, FUNCTION, TRIGGER, KEY, VIEW, MATERIALIZED VIEW, LIBRARY"
			+ "DATABASE LINK, DBLINK, INDEX, CONSTRAINT, TRIGGER, USER, SCHEMA, DATABASE, PLUGGABLE DATABASE, BUCKET, "
			+ "CLUSTER, COMMENT, SYNONYM, TYPE, JAVA, SESSION, ROLE, PACKAGE, PACKAGE BODY, OPERATOR"
			+ "SEQUENCE, RESTORE POINT, PFILE, CLASS, CURSOR, OBJECT, RULE, USER, DATASET, DATASTORE, "
			+ "COLUMN, FIELD, OPERATOR";
	private static final String[] sqlRegexps = { "(?i)(.*)(\\b)+SELECT(\\b)+\\s.*(\\b)+FROM(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+INSERT(\\b)+\\s.*(\\b)+INTO(\\b)+\\s.*(.*)", "(?i)(.*)(\\b)+UPDATE(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+DELETE(\\b)+\\s.*(\\b)+FROM(\\b)+\\s.*(.*)", "(?i)(.*)(\\b)+UPSERT(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+SAVEPOINT(\\b)+\\s.*(.*)", "(?i)(.*)(\\b)+CALL(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+ROLLBACK(\\b)+\\s.*(.*)", "(?i)(.*)(\\b)+KILL(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+DROP(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+CREATE(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+ALTER(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+TRUNCATE(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+LOCK(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+UNLOCK(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+RELEASE(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
			"(?i)(.*)(\\b)+DESC(\\b)+(\\w)*\\s.*(.*)", "(?i)(.*)(\\b)+DESCRIBE(\\b)+(\\w)*\\s.*(.*)",
			"(.*)(/\\*|\\*/|;){1,}(.*)", "(.*)(-){2,}(.*)", "(')"};

	
}
