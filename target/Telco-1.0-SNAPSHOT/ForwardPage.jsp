<%-- 
    Document   : ForwardPage
    Created on : 15-feb-2017, 10.08.37
    Author     : alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ForwardPage</title>
    </head>
    <body>
        <jsp:forward page="SecondPage.jsp" >
	   <jsp:param name="who" value="ForwardPage" /> 
	</jsp:forward>
    </body>
</html>
