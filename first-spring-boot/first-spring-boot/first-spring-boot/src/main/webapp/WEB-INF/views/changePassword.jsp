<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<form action="changePassword" method="post">
<table>
<tr>
<td>Old Password:</td>
<td><input type="password" name="oldPassword"/></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="newPassword"/></td>
</tr>
<tr>
<td>Confirm Password:</td>
<td><input type="password" name="confirmPassword"/></td>
</tr>

<tr>
<td colspan="2"> 
<input type="submit" name="submit" value="Change Password"/></td>
</tr>
</table>
</form>
</body>
</html>