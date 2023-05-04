<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="EmployeeMangement.model.Employee" %>
    <%@ page import="EmployeeMangement.EmployeeDAO.EmployeeDAO" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee List</h1>
<hr/>
<%
EmployeeDAO dao=new EmployeeDAO();
List<Employee> employeelist= dao.GetEmployees();
%>
<table>
<thead>
<tr>
<tbody>
   <tr>
       <%
            for(Employee employee:employeelist){
       %>
       <td><%=employee.id %></td>
       <td><%=employee.name %></td>
       <td><%=employee.email %></td>
       <td><%=employee.country %></td>
       <td><a href="EmployeeServlet?action=editform&id=<%=employee.getId()%>">Update</a></td>
       <td><a href="EmployeeServlet?action=delete&id=<%=employee.getId()%>">Delete</a></td>
       
       </tr>
       <%
            }
       %>
</tbody>
</thead>
</table>

</body>
</html>