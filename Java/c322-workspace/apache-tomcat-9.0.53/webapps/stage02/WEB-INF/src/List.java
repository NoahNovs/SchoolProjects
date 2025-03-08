package rctmpx;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class List extends HttpServlet {
 // get and keep a reference to the shared Model instance
  private Model model = Model.getInstance();
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws IOException, ServletException {

    String add = request.getParameter("add");
    if (add == null) { } else {
      model.addTask(add);
    }

    String delete = request.getParameter("delete");
    if (delete == null) { } else {
      model.delete(Integer.parseInt(delete));
    }

    String input = request.getParameter("input");
    if (input == null) {

    } else if ("save".equals(input)) {
      try {
        model.save();
      } catch (Exception e) {

      }
    } else if ("reset".equals(input)) {
      try {
        model.reset();
      } catch (Exception e) {

      }
    } else {

    }

    ServletContext sc = this.getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/list.jsp");
    request.setAttribute("tasks", model.retrieveAll());
    rd.forward(request, response);
  }
}