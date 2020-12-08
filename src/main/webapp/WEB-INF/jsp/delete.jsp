<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>users</h2>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>id: ${user.id}</td>
				<td>name: ${user.name}</td>
				<td>email: ${user.email}</td>
				<td>username: ${user.username}</td>
				<td>password: ${user.password}</td>
				<br><br>
			
			</tr>
		</c:forEach>
	</body>
</html>