package qotd;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddForm extends HttpServlet {
  // no need here to // get and keep a reference to the shared Model instance
  // private Model model = Model.getInstance();
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws IOException, ServletException {
    ServletContext sc = this.getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/add.jsp");
    // likewise: // request.setAttribute("quote", model.randomQuote()); 
    rd.forward(request, response);
  }
}