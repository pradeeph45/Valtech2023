<%@page import="com.valtech.training.springbootassignment.model.EmployeeModel"%>
<%@page import="com.valtech.training.springbootassignment.model.DepartmentModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department List</title>
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
<h1>List of Departments</h1>
<% List<DepartmentModel> dm=(List<DepartmentModel>) request.getAttribute("departments"); %>
<table border="1" width="30%" height="30%">
<tr>
<th>Department ID</th>
<th>Department Name</th>
<th>Department Location</th>
</tr>
<%for(DepartmentModel d:dm){
	request.setAttribute("d", d);
	%>
<tr>
<td>${d.departmentId}</td>
<td>${d.departmentName}</td>
<td>${d.departmentLocation}</td>
<td>
<a href="delete?departmentId=${d.departmentId}">Delete</a>
<a href="edit?departmentId=${d.departmentId}">Edit</a>
</td>
</tr>
<%} %>
<tfoot>
<td colspan="5" align="right">
<form action="new" method="get">
<input type="submit" name="submit" value="New Department"/>

</form>
 </td>
</tfoot>
</table>
</body>
</html>