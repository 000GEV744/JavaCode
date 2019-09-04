

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert CD Data</title>
</head>
<body>
<h1>CD Details: </h1>
<form id="form-1" action="controller.one" method="post">
	<table id="table-1">
		
			<tr>
				<td><b>Artist: </b></td>
				<td><input id="input-1" name="artist" required="true" type="text"/></td>
			</tr>	
			<tr>
				<td><b>Title: </b></td>
				<td><input id="input-1" name="title" required="true" type="text" /></td>
			</tr>
			<tr>
				<td><b>Purchase Date: </b></td>
				<td><input id="input-2" name="purchasedate" required="true" type="text" /></td>
			</tr>
				<tr>
				<td><b>Cost: </b></td>
				<td><input id="input-1" name="cost" required="true" type="text"/></td>
				</tr>
				<tr>
				<td><b>CD Type: </b></td>
				<td><select name="CDType">
						<option value="Unknown">Select...</option>
						<option value="Normal_CD">Normal CD</option>
						<option value="International_CD">International CD</option>
						<option value="Special_Edition">Special Edition</option>
				</select></td>
				</tr>
	</table>
	<br>
	<td><input type="submit" value="SAVE" id="button-1"/></td> 
</form>
</body>
</html>