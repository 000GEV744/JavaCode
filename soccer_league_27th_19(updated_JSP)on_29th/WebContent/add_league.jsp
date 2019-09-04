<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add A New League....</h1><br/>

<% 
@SuppressWarnings("unchecked")
		List<String> err=(List<String>) request.getAttribute("ERROR");
        
          if(err!=null){
        	  out.println("<b>fix these error:</b><br> ");
        	  for(String s : err) {
        	  	out.println("<p style=\"color:red;\">"+s+"</p>");
        	  }
          }
%>	


	<form id="form-1" action="add_league.do" method="post">
	
		<label for="input-1">League Title</label>
		<input id="input-1" name="title" required="true" type="text"/><br/>
		<label for="input-2">Year</label>
		<input id="input-2" name="year" required="true" type="text"/><br/>
		<label for="input-3">Season</label>
		<select name="season">
		<option value="Unknown">Select...</option>
		<option value="Summer">SUMMER</option>
		<option value="Winter">WITER</option>
		<option value="Autumn">Autumn</option>
		<option value="Spring">Spring</option>
		</select><br/>
		<input type="submit" value="Add League" id="button-1"/>
		<input type="reset" value="Reset" id="button-2"/>
		
	</form>
	
</body>
</html>