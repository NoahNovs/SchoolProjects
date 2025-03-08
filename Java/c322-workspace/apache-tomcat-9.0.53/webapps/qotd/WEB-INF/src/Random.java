package qotd;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Random extends HttpServlet {
 // get and keep a reference to the shared Model instance
  private Model model = Model.getInstance();
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws IOException, ServletException {
    ServletContext sc = this.getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/random.jsp");
    request.setAttribute("quote", model.randomQuote()); 
    rd.forward(request, response);
  }
}