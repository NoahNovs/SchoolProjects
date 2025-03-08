<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="qotd.Quote" %>
<%
   String me = request.getContextPath();
   ArrayList<Quote> quotes = (ArrayList<Quote>)request.getAttribute("quotes"); 
 %>

<table>
<tr> <td> <a href="<%=me%>/random">Home</a>
     <td align=right> <a href="<%=me%>/add/form">New Quote</a>
<%
   for (Quote quote : quotes) { %>

<tr> <td> <a href="<%=me%>/edit?id=<%=quote.id()%>"><%=quote.author()%></a> 
     <td> <%=quote.quote()%>

<% } %>

</table> <p> Press <a href="<%=me%>/save">here</a> to save this permanently to database on disk. 