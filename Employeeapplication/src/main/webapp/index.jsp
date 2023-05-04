<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="welcome1.jsp">
<tr><td>firstname</td><td><input type="text" value="" name="fname" />
       <tr><td>Lastname</td><td><input type="text" value="" name="Lname" />
       <tr><td></td><td><input type="submit" value="save" />
</form>
<h1>welcome</h1>
<h2><% out.print("welcome"); %>
<%= java.util.Calendar.getInstance().getTime() %></h2>
</body>
</html>