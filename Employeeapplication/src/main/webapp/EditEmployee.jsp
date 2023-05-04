<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="EmployeeMangement.model.Employee" %>
    <%@ page import="EmployeeMangement.EmployeeDAO.EmployeeDAO" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

</head>

<body>

<%

Employee employee = new Employee();

%>

<%

EmployeeDAO dao = new EmployeeDAO();

%>

<form method="POST" action='EmployeeServlet' name="frmEditUser">

<input type="hidden" name="action" value="edit" />

<p><b>Edit Employee</b></p>

<%

String eid = request.getParameter("id");

if (!((eid) == null)) {

int id = Integer.parseInt(eid);

employee = dao.SelectEmployeeByid(id);
out.print(employee);
%>

<table>

<tr>

<td>Employee ID</td>

<td><input type="text" name="id" readonly="readonly"

value="<%=employee.getId()%>"></td>

</tr>

<tr>

<td>First Name</td>

<td><input type="text" name="name" value="<%=employee.getName()%>" /></td>

</tr>

<tr>

<td>Email</td>

<td><input type="text" name="email" value="<%=employee.getEmail() %>" /></td>

</tr>

<tr>

<td>Password</td>

<td><input type="text" name="password" value="<%=employee.getPassword() %>" /></td>

</tr>

<tr>

<td>Country</td>

<td><input type="text" name="country" value="<%=employee.getCountry() %>" /></td>

</tr>

<tr>

<td></td>

<td><input type="submit" value="Update" /></td>

</tr>

</table>

<%

} else

out.println("ID Not Found");

%>

</form>

<p><a href="EmployeeServlet?action=EmployeeList">View-All-Records</a></p>

</body>

</html>