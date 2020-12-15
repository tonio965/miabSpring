<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add to group</title>
</head>
<body>
<h2>add user to group</h2>
<form action="addToGrup" method="post">
		group: <select name="grup">
		    <c:forEach items="${groups}" var="group">
		        <option value="${group.id}">"id:" ${group.id} "name: "${group.name}</option>
		    </c:forEach>
		</select>
		
		user: <select name="user">
		    <c:forEach items="${users}" var="user">
		        <option value="${user.id}">"id:" ${user.id} "name: "${user.username}</option>
		    </c:forEach>
		</select>
		<input type="submit" value="add"/> 
</form>

</body>
</html>