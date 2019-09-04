<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>
<head><title>Hello</title></head>
    <body bgcolor="sky blue">
        
        <h2>Hello, my name is Duke. What's yours?</h2>
        <form method="get">
        <label>Enter Name: </label>
            <input type="text" name="username" size="25">
            <p></p><br>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>

        <c:if test="${fn:length(param.username) > 0}" >
            <jsp:include page="response.jsp"/>
        </c:if>
</body>
</html>