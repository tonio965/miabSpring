<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>remove group</title>
</head>
<body>

		<h2>groups</h2>
		<c:forEach items="${groups}" var="grup">
			<tr>
				<td>id: ${grup.id}</td>
				<td>name: ${grup.name}</td>
				<td>users: ${grup.users}</td>
				<br><br>
			
			</tr>
		</c:forEach>
		
		<form action="removeGrup" method="post">
		group: <select name="grup">
		    <c:forEach items="${groups}" var="group">
		        <option value="${group.id}">"id:" ${group.id} "name: "${group.name}</option>
		    </c:forEach>
		</select>
		<input type = "submit" value = "register" />
      </form>



</body>
</html>