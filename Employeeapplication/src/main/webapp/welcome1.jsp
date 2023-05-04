<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
<%!
String GetMessage(){
     return "welcome; ";	
}
%>
<%String firstname=request.getParameter("fname");
String Lastname=request.getParameter("Lname");
out.print(GetMessage() + firstname+" "+Lastname);
session.setAttribute("fullname",firstname+" "+Lastname);

%> 
<form action="Report.jsp">
<input type="submit" value="report" />
</form>
</h1>

</body>
</html>