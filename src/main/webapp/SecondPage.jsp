<%-- 
    Document   : SecondPage
    Created on : 15-feb-2017, 9.46.11
    Author     : alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Second JSP Page</title>
    </head>
    <body>
        <h1>This is SecondPage.jsp</h1>
        
        <%@ include file="template/staticallyIncluded.jsp" %> <br/>
        <jsp:include page="template/dinamicallyIncluded.jsp" /> <br/>
        
        
        <% 
	   if(request.getParameterMap().containsKey("who")){
               String Who = request.getParameter("who");
               out.append("<p>Richiesta effettuata tramite forward da: " + Who + "</p>");
	   }
	
	   String Who = (String) request.getAttribute("who");
    	   if(Who != null){
              out.append("<p>Richiesta effettuata tramite forward da: " + Who + "</p>");
	   }
	%>
        <p> Provo a visualizzare il parametro della Servlet: 
            <%= request.getParameter("setAttributeAndForward")%>
        </p>
        
    </body>
</html>
