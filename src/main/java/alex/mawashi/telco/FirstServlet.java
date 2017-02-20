package alex.mawashi.telco;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if (request.getParameterMap().containsKey("anotherParam")) {
            String anotherParam = request.getParameter("anotherParam");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FirstServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FirstServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>Questa pagina è generata dalla servlet con PrintWriter</p>");
            out.append("<p> Parametro inviato: " + anotherParam + " </p>");
            out.println("</body>");
            out.println("</html>");
        } else if(request.getParameterMap().containsKey("setAttributeAndForward")){
            //non cambia l'url xkè è la stessa richiesta http, quindi anche i parametri GET e POST inviati alla servlet permangono
            request.setAttribute("who", "ForwardDispatcherPage");
	    request.getRequestDispatcher("SecondPage.jsp")
	           .forward(request, response);   //non visualizza l'url della pagina ma della servlet
        } else if(request.getParameterMap().containsKey("reload")){
            response.sendRedirect("gimmeFirstServlet?reloaded");
        } else if(request.getParameterMap().containsKey("redirectToJSP")){
            //con il response.sendRedirect("...") visualizza l'url della pagina puntata
            //ed effettua una seconda richiesta, quindi i parametri della richiesta fatta alla servlet sono perduti (a meno che si inseriscano nella session)
            request.getSession().setAttribute("maracuia", "chitastra");
           // response.sendRedirect("/WEB-INF/view/innerJsp.jsp");  //cambia l'url visualizzato "ThirdPage.jsp"
           response.sendRedirect("ThirdPage.jsp?zucchemberg=kimono");
        } else if(request.getParameterMap().containsKey("reloaded")){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FirstServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FirstServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>Questa pagina è ricaricata e generata da doGet()</p>");
            out.println("</body>");
            out.println("</html>");
        }else if(request.getParameterMap().containsKey("goToInnerJSP")){
            request.getRequestDispatcher("/WEB-INF/view/innerJsp.jsp")
	           .forward(request, response);
            
        }else if(request.getParameterMap().containsKey("forwardToOtherServlet")){
            request.getRequestDispatcher("gimmeSecondServlet")
	           .forward(request, response);
        }else{
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FirstServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FirstServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>Questa pagina è generata da doGet() con PrintWriter</p>");
            out.append("<p> prova ad aggiungere all'url:<br/> * ?reload <br/> * ?anotherParam=Ciao <br/> * ?setAttributeAndForward <br/> * ?goToInnerJSP <br/> * ?redirectToJSP <br/> * ?forwardToOtherServlet ");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
