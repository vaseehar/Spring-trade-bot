<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="validate" method="post">
<c:out value="${message}" >${message}</c:out>
<c:if test="${not empty message}">
<h1 style="color: green" id="message">${message}</h1>
</c:if>
<c:if test="${not empty error } ">
<h1 style="color: red">${error}</h1>
</c:if>
mobile:<input type="text" name="mobile">
password:<input type="password" name="password">
<input type="submit" value="login">
</form>
</body>
</html>