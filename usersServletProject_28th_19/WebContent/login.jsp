<%@page import="comm.example.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login Admin</h1>

<% 

		String err=(String) request.getAttribute("ERROR");
        if(err!=null){
        	
        out.println("<b>fix these error:</b><br> ");
        out.println("<p style=\"color:red;\">"+err+"</p>");
}       
%>	
<c:if text="${SUCCESS.equals(\"password\") }">
<jsp:useBean id="myBean" class="comm.example.model.Users" scope="session">
    <jsp:setProperty name="myBean" property="email" param="email"/>
    <jsp:setProperty name="myBean" property="password" param="password"/>
    <jsp:getPorperty name="mybean" property="password"/>
</jsp:useBean>
</c:if>

	<form id="form-1" action="login" method="post">
		<table id="table-1">
			<tr>
				<th>Email</th>
				<th><input id="input-1" name="email" required type="email"/></th>
			</tr>
		
			<tr>
				<th>Password</th>
				<td><input id="input-2" name="password" required type="password"/></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Submit" id="button-1"/>
	</form>
</body>
</html>