<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>International cd Details</title>
</head>
<body>
<h3>International cd Details: </h3>
<form id="form-1" action="save_international" method="post">
	<table id="table-1">
		
			<tr>
				<td><b>Language: </b></td>
				<td><input id="input-1" name="language" required="true" type="text"/></td>
			</tr>	
			<tr>
				<td><b>Region: </b></td>
				<td><input id="input-1" name="region" required="true" type="text" /></td>
			</tr>
			
	</table>
	<br>
	<td><input type="submit" value="SAVE CD" id="button-1"/></td> 
</form>
</body>
</html>