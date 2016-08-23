<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="edu.ap.todo.*"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todo list</title>
</head>
<body>
<br/><br/>
<form method=POST action="Result.jsp">
<table>
<h2>TO INSERT</h2>
<tr><td>Date : </td><td><input type="TEXT" name="startdate" size=20></td></tr>
<tr><td>Due date : </td><td><input type=TEXT name="enddate" size=20></td></tr>
<tr><td>Priority : </td><td><input type=TEXT name="priority" size=20></td></tr>
<tr><td>Description : </td><td><input type=TEXT name="description" size=20></td></tr>
<tr></tr>
<tr></tr>
<tr><td></td><td><input type=SUBMIT value="Save"></td></tr>
</table>
<table>
<h2>TODO LIST</h2>
<% 	
	try {
	TodoProxy todo = new TodoProxy();
	todo.list();}
catch (Exception ex){
	System.out.println(ex.getMessage());%>
	Empty
	<%
}
%>
</table>
</form>


</body>
</html>