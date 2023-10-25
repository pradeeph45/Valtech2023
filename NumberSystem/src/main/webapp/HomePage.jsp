<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number System Converter</title>
<style>
h1{
 font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    text-align: center;
    color:orange;
}
label{
color:green;}
  body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    text-align: center;
  }
  form {
    background-color: #ffffff;
    border: 1px solid #ccc;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    border-radius: 5px;
  }
  select, input {
    width: 100%;
    padding: 10px;
    margin: 5px 0;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  input[type="submit"] {
    background-color: #007BFF;
    color: #fff;
    cursor: pointer;
  }
  input[type="submit"]:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>
<h1>
Choose a Number System
</h1>

<form action="number" method="get">
  <select name="number">
    <option value="Binary">Binary Number System</option>
    <option value="Octal">Octal Number System</option>
    <option value="Hexadecimal">Hexa Decimal Number System</option>
  </select>
  <br/>
 <label> Enter 1st Number:</label> <input type="text" name="num1"><br/>
  <label>Enter 2nd Number: </label><input type="text" name="num2"><br/>
  <input type="submit" value="Convert">
</form>

<%  
String result=" ";
result=(String)request.getAttribute("result");
%>

<% if (result != null) {
  out.print(result);
} %>
</body>
</html>
