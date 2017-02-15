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
            request.setAttribute("who", "ForwardDispatcherPage");
	    request.getRequestDispatcher("SecondPage.jsp")
	           .forward(request, response);
        } else if(request.getParameterMap().containsKey("reload")){
            response.sendRedirect("gimmeFirstServlet?reloaded");
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
            out.append("<p> prova ad aggiungere all'url:<br/> * ?reload <br/> * ?anotherParam=Ciao <br/> * ?setAttributeAndForward ");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
