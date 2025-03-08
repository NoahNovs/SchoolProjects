<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="rctmpx.Task" %>
<%
   String me = request.getContextPath();

   ArrayList<Task> tasks = (ArrayList<Task>)request.getAttribute("tasks");

   for (Task task : tasks) { %>
<form action="<%=me%>/extra/butter">
      <input type=checkbox
             name=delete
             onClick=submit()
             value=<%=task.id()%>
       > (<%=task.id()%>, <%=task.task()%>)
</form>
<% } %>

<form action="<%=me%>/extra/butter">
  Add task: <input type=text name=add>
  <input type=submit name=action value=Add>
</form>

<p> Press <a href="<%=me%>/extra/butter?input=save">here</a> to save this permanently to database on disk.

<p> Press <a href="<%=me%>/extra/butter?input=reset">here</a> to reload the database from the disk.