<%@page import="com.valtech.training.springbootassignment.model.DepartmentModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%DepartmentModel d=(DepartmentModel) request.getAttribute("departments"); %>
<form method="post" action="save?departmentId=<%=d.getDepartmentId()%> ">
<table border="1" width="30%" height="30%">
<tr>
<td>Department ID</td>
<td><input type="text" disabled="disabled" name="departmentId" value="<%=d.getDepartmentId()%>"/></td>
</tr>
<tr>
<td>Department Name</td>
<td><input type="text" name="departmentName" value="<%=d.getDepartmentName()%>"/></td>
</tr>

<tr>
<td>Department Location</td>
<td><input type="text"  name="departmentLocation" value="<%=d.getDepartmentLocation()%>"/></td>
</tr>
>
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