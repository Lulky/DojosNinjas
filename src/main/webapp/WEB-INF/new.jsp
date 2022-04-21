<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<form:form action="/ninjas/crear" method="POST" modelAttribute="ninja">
	<div class="form-group">
		<form:label path="dojo">Dojo:</form:label>
		<form:select path="dojo" class="form-control">
			<c:forEach var="d" items="${dojos}">
				<form:option value="${d.id}">${d.name}</form:option>
			</c:forEach>
		</form:select>
	</div>
	
	<div class="form-group">
		<form:label path="first_name">First Name:</form:label>
		<form:input path="first_name" type="text"/>
		<form:errors path="first_name"/>
	</div>
	
	<div class="form-group">
		<form:label path="last_name">Last Name:</form:label>
		<form:input path="last_name" type="text"/>
		<form:errors path="last_name"/>
	</div>
	
	<div class="form-group">
		<form:label path="age">Age:</form:label>
		<form:input path="age" type="number" min="1" max="99"/>
		<form:errors path="age"/>
	</div>
	<input type="submit" value="Create" class="btn btn-success">
	</form:form>
</body>
</html>