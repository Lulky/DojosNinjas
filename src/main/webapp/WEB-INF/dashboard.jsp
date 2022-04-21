<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${dojo.name}</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="ninja" items="${dojo.getNinjas()}">
				<tr>
					<td><c:out value="${ninja.getFirst_name()}" /></td>
					<td><c:out value="${ninja.getLast_name()}" /></td>
					<td><c:out value="${ninja.getAge()}" /></td>
					
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>