<%@page import="com.valtech.training.springbootassignment.model.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%EmployeeModel e=(EmployeeModel) request.getAttribute("employees"); %>
<form method="post" action="save?employeeId=<%=e.getEmployeeId()%> ">
<table border="1" width="30%" height="30%">
<tr>
<td>Employee ID</td>
<td><input type="text" disabled="disabled" name="employeeId" value="<%=e.getEmployeeId()%>"/></td>
</tr>
<tr>
<td>Employee Name</td>
<td><input type="text" name="employeeName" value="<%=e.getEmployeeName()%>"/></td>
</tr>

<tr>
<td>Age</td>
<td><input type="text"  name="age" value="<%=e.getAge()%>"/></td>
</tr>
<tr>
<td>Experience</td>
<td><input type="text"  name="experience" value="<%=e.getExperience()%>"/></td>
</tr>
<tr>
<td>Seniority</td>
<td><input type="text"  name="seniority" value="<%=e.getSeniority()%>"/></td>
</tr>
<tr>
<td>Salary</td>
<td><input type="text"  name="salary" value="<%=e.getSalary()%>"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="submit" value="Create"/>
                <input type="submit" name="cancel" value="Cancel">
                </td>

</tr>
</table>
</form>
</form>
</body>
</html>