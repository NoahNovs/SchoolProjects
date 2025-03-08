package qotd;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EditQuote extends HttpServlet {
  // get and keep a reference to the shared Model instance
  private Model model = Model.getInstance();
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws IOException, ServletException {
    Integer id = Integer.parseInt(request.getParameter("id")); 
    ServletContext sc = this.getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/edit.jsp");
    request.setAttribute("quote", model.retrieveQuote(id)); 
    rd.forward(request, response);
  }
}