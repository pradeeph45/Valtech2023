<%@page import="com.valtech.training.springbootassignment.model.EmployeeModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<style >
a{
display: inline-block;
padding: :10px 20px;
font-size: 16px;
text-align: center;
text-decoration: none;
background-color: #4CAF50;
color: #fff;
border: 1px solid #4CAF50;
border-radius: 5px;
cursor: pointer;
}
a:hover {
	background-color:#45a049; 
}

</style>
</head>
<body>
<h1>List of Employees</h1>
<%List<EmployeeModel> em=(List<EmployeeModel>) request.getAttribute("employees");%>
<table border="1" width="30%" height="30%">
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Age</th>
<th>Experience</th>
<th>Seniority</th>
<th>Salary</th>
</tr>
<%for(EmployeeModel e:em){ 
request.setAttribute("e", e);
%>
<tr>
<td>${e.employeeId}</td>
<td>${e.employeeName}</td>
<td>${e.age}</td>
<td>${e.experience}</td>
<td>${e.seniority}</td>
<td>${e.salary}</td>
<td>
<a href="delete?employeeId=${e.employeeId}">Delete</a>
<a href="edit?employeeId=${e.employeeId}">Edit</a>
</td>
</tr>
<%} %>
<tfoot>
<td colspan="5" align="right">
<form action="new" method="get">
<input type="submit" name="submit" value="New Employee"/>

</form>
 </td>
</tfoot>
</table>
</body>
</html>