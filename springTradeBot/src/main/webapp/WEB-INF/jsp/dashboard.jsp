<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Binance API details</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="dashboard.js">
</script>
</head>
<body>
    <%@ include file="userDetailsFragment.jspf" %>
	<form action="startTrade" method="post">
	<label for="currency" value="Select ur currency:">Select ur currency:</label>
	<select name="currency" id="currency" onchange="myFunction()">
	<option value="USDT">USDT</option>
	<option value="BUSD">BUSD</option>
	</select>
		<p id="greeting"></p>
		<div id="feedback"></div>
		<div id="listOfcurrencies">
		</div>
		<div id="submitButton" disabled="disabled">
		<input type="submit" value="start autotrade">
		</div>
	</form>
</body>
</html>