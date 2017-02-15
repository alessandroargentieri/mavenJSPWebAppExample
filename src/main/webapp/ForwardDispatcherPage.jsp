<%-- 
    Document   : ForwardDispatcherPage
    Created on : 15-feb-2017, 10.08.57
    Author     : alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ForwardDispatcherPage</title>
    </head>
    <body>
       <% 
	   request.setAttribute("who", "ForwardDispatcherPage");
	   request.getRequestDispatcher("SecondPage.jsp")
	          .forward(request, response);
	%>
    </body>
</html>
