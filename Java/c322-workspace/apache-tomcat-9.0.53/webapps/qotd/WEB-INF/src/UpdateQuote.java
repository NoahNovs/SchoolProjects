package qotd;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateQuote extends HttpServlet {
  // get and keep a reference to the shared Model instance
  private Model model = Model.getInstance();
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws IOException, ServletException {
    Integer id = Integer.parseInt(request.getParameter("id")); 
    String author = request.getParameter("author"); 
    String quote = request.getParameter("quote"); 
    model.updateQuote(id, new Quote(id, author, quote)); 
    ServletContext sc = this.getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/list.jsp");
    request.setAttribute("quotes", model.retrieveAll());
    rd.forward(request, response);
  }
}