<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action='EmployeeServlet' name="frmAddUser">
<input type="hidden" name="action" value="insert"/>
<p><b>Add New Record</b></p>
<table>
<tr>
<td>Employee Id</td>
<td><input type="text" name="id" /></td>
</tr>
<tr>
<td>Employee Name</td>
<td><input type="text" name="name" /></td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="email" /></td>
</tr>
<tr>
<td>Password</td>
<td><input type="text" name="password" /></td>
</tr>
<tr>
<td>Country</td>
<td><input type="text" name="country" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="submit" /></td>
</tr>
</table>
</form>
<p><a href="EmployeeServlet?action=EmployeeList">View-All-Records</a></p>
</body>
</html>