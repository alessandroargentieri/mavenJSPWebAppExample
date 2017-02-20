<%-- 
    Document   : ThirdPage
    Created on : 15-feb-2017, 9.46.25
    Author     : alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ThirdPage</title>
    </head>
    <body>
        <h1>This is ThirdPage.jsp!</h1>
        
        <p> visualizzo il parametro inviato dal form con una "expression" e una variabile implicita (request) </p>
        <%= request.getParameter("myparam") %>
        
        <p> visualizzo il parametro inviato dal form con una "scriptlet" e due variabili implicite (out e request). </p>
        <% out.append(request.getParameter("myparam")); %>
                
        <p> Visualizzo il parametro inviato dal form con l'Expression Language </p>
        ${param.myparam} <br/>
        ${"Hello man!"}
        
        <p> Parametro della request dall servlet: <%= request.getParameter("redirectToJSP") %> è perso dunque </p>
        <p> Parametro di sessione, invece rimane: <%=session.getAttribute("maracuia")%> </p>
        <% request.setAttribute("michael", "Mi chiamo Michael"); %>
        <p> Attributo (non parametro) richiesta letto con EL: ${requestScope["michael"]}!!! </p>
        <p> Parametro richiesta letto con EL: ${param.zucchemberg}</p>
        <p> Parametro richiesta letto con Scriptlet: <%= request.getParameter("zucchemberg") %> </p>
            
        
    </body>
</html>
