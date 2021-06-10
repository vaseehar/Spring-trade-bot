<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
label {
	display: inline-block;
	width: 200px;
	margin: 5px;
	text-align: left;
}

input[type=text], input[type=password], select {
	width: 200px;
}

button {
	padding: 10px;
	margin: 10px;
}

.error {
	color: red;
	font-style: italic;
}
</style>
</head>
<c:if test="${message ne null}">
	<h1>${message}</h1>
</c:if>
<body>
	<div align="center">
		<form:form method="post" modelAttribute="userRegModel"
			action="doRegister">
			<form:errors cssClass="error"></form:errors>
			</br>
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName" />
			<form:errors path="firstName" cssClass="error" />

			</br>
			<form:label path="lastName">Last Name:</form:label>
			<form:input path="lastName" />
			<form:errors path="lastName" cssClass="error" />
			</br>


			<form:label path="countryCode">Country code;</form:label>
			<form:input path="countryCode" />
			<form:errors path="countryCode" cssClass="error" />
			</br>

			<form:label path="mobile">mobile:</form:label>
			<form:input path="mobile" />
			<form:errors path="mobile" cssClass="error" />
			</br>

			<form:label path="password">password</form:label>
			<form:password path="password" />
			<form:errors path="password" cssClass="error" />
			</br>
			
			<form:label path="confirmPassword">Confirm password</form:label>
			<form:password path="confirmPassword" />
			<form:errors path="confirmPassword" cssClass="error" />
			</br>

			<form:label path="binanceApiKey">API key</form:label>
			<form:input path="binanceApiKey" />
			<form:errors path="binanceApiKey" cssClass="error" />
			</br>

			<form:label path="binanceApiSecret">API Secret</form:label>
			<form:input path="binanceApiSecret" />
			<form:errors path="binanceApiSecret" cssClass="error" />
			</br>

			<input type="submit" value="Register">
		</form:form>
	</div>

</body>
</html>