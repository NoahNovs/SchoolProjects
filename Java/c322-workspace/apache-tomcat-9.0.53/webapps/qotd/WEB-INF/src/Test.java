package qotd;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Test extends HttpServlet {
  // Get (and keep!) a reference to the shared Model instance
  Model model = Model.getInstance();
  // the following method drives the testing
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws IOException, 
                                                         ServletException {
    String action = request.getParameter("action");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    if (action == null) { 
      out.println("Try with ?action=(random|list|reset|save|update&id=...|add&author=...&amp;quote=...)");  
    } else { 
      if (action.equals("random")) {
        out.println( model.randomQuote() );
      } else if (action.equals("list")) {
        out.println( model.retrieveAll() );
      } else if (action.equals("delete")) {
        String what = request.getParameter("id");
        model.delete(Integer.parseInt(what));
        out.println( model.retrieveAll() );
      } else if (action.equals("add")) {
        String author = request.getParameter("author");
        String quote  = request.getParameter("quote");
        model.addQuote(author, quote);
        out.println( model.retrieveAll() );
      } else if (action.equals("update")) {
        Integer where = Integer.parseInt( request.getParameter("id") );
        String author = request.getParameter("author");
        String quote  = request.getParameter("quote");
        model.updateQuote( where, new Quote( where, author, quote ) );
        out.println( model.retrieveAll() );
      } else if (action.equals("reset")) {
        try {
          model.reset();
          out.println( model.retrieveAll() );
        } catch (Exception e) { }
      } else if (action.equals("save")) {
        try {
          model.save(); 
          out.println("Database saved to disk.");	
        } catch (Exception e) { }
      }
    } 
  }
}