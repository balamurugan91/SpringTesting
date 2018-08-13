<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		
		<script src="js/jQuery1.8.2.js" type="text/javascript"></script>
		<script src="js/javascript.js" type="text/javascript"></script>
		<style type="text/css">
			div {color: red;}
		</style>
	</head> 
	<body>
	
		Text Box : <input type="text" id="comments"/><br/>
		Number : <input type="text" id="number"/><br/>
		Decimal :<input type="text" id="decimal"/><br/>
		Date : <input type="text" id="date"/><br/>
		File Path :<input type="text" id="filepath"/><br/>
		EMail :<input type="text" id="email"/><br/>
		Phone :<input type="text" id="phone"/><br/>
		Filter :<input type="text" id="filter"/><br/>
		<br/>
		<input type="button" id="submit" value="submit"/>
		<br/>
		<div id="errorMessageDiv"></div>
		<div id="successdiv"> </div>
	
	</body>
</html>
