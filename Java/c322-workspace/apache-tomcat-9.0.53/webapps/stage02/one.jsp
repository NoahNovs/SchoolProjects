<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="rctmpx.Task" %>
<%
   String message = (String) session.getAttribute("message");
   if (message == null) {
     message = "Welcome.";
     ArrayList<Task> tasks = new ArrayList<Task>(); // initialize state
     session.setAttribute( "count", "0" ); // also initialize state and save immediately
     session.setAttribute( "tasks", tasks ); // save state
     session.setAttribute( "message", message );
   } else {
     int count = Integer.parseInt((String) session.getAttribute("count")) + 1;
     ArrayList<Task> tasks = (ArrayList<Task>) session.getAttribute("tasks");
     message = "You have " + count + " transactions so far."; // retrieve state
     String input = request.getParameter("add"); // read inputs
     String delete = request.getParameter("delete");
     // update state according to input
     if (delete == null) { } else {
       for (int i = 0; i < tasks.size(); i++) {
         Task t = tasks.get(i);
         if (t.id() == Integer.parseInt(delete)) {
           tasks.remove(i);
           break;
         }
       }
     }
     if (input == null) { } else { tasks.add( new Task(count, input) ); }
     // report state (and also get ready for more input)
     for (Task task : tasks) { %>
<form><input type=checkbox
             name=delete
             onClick=submit()
             value=<%=task.id()%>
       > (<%=task.id()%>, <%=task.task()%>)
</form>
<%   }
     session.setAttribute("tasks", tasks);
     session.setAttribute( "count", count + "" );
   } %>
<%=message%> <p>
<form>
  Add task: <input type=text name=add>
  <input type=submit name=action value=Add>
</form>
