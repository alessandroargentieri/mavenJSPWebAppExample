<%-- 
    Document   : index.jsp
    Created on : 15-feb-2017, 10.04.44
    Author     : alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- my custom css file into css folder -->
        <link rel="stylesheet" href="css/mycss.css">
        <!-- my custom font, specified here and into css file (go to see it) -->
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
	<!-- jquery obtained from the internet -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
	<!-- ajax-utils into js folder -->
	<script src="js/ajax-utils.js"></script>
	<!-- my custom javascript file in js folder -->
	<script src="js/script.js"></script> <!--it uses ajax-utils.js-->
        
    </head>
    <body>
        <h1>Hello Index File!</h1>
        
        <p> href diretto alla pagina jsp (non deve essere in WEB-INF): </p>
        <p> <a href="SecondPage.jsp"> Go to second Page </a> </p>

        <p> Evento click in javascript che visualizza un alert </p>
        <p> <u onclick="alertMe()"> Watch Javascript alert!  </u> </p>

        <script>
            function alertMe() {
                alert("Clicked!");
            }
        </script>

        <p> href diretto ad una JSP che fa direttamente il forward della richiesta ad un'altra JSP: </p>
        <p> <a href="ForwardPage.jsp">Go to forward page</a> </p>

        <p> href diretto ad una JSP che fa il forward ad un'altra JSP usando request.getRequestDispatcher (request è una variabile implicita) </p>
        <p> <a href="ForwardDispatcherPage.jsp">Go to forward dispatcher page</a> </p>

        <p> href diretto ad una Servlet che è mappata nel web.xml </p>
        <p> <a href="getFirstServlet">Go to FirstServlet</a> </p>

        <p> href diretto ad una Servlet che è mappata con l'annotation @WebServlet </p>
        <p> <a href="gimmeSecondServlet">Go to SecondServlet</a> </p>
        
        <p> from che invia un parametro via post a ThirdPage.jsp</p>
        <form action="ThirdPage.jsp" method="post">
            <input type="text" name="myparam"/>
            <input type="submit" name="submit"/>
        </form>
        
        
        
        
    </body>
</html>
