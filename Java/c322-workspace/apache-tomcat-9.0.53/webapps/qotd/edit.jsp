<%@ page language="java" import="qotd.Quote" %>

<%
   String me = request.getContextPath();

   Quote quote = (Quote)request.getAttribute("quote");

 %>

<form action="<%=me%>/update/quote">

<table> 
  <tr> <td> Author: <td> <input type=text size=40 name=author value="<%=quote.author()%>"> 
  <tr> <td> Quote:  <td> <textarea rows=6 cols=40 name=quote><%=quote.quote()%></textarea>

  <tr> <td colspan=2> 
    <table>
      <tr> 
        <td valign=center> 
            <input type=submit name=action value=Update>
            <input type=hidden name=id value=<%=quote.id()%>>
          </form> 
        <td valign=center> <br>
          <form action="<%=me%>/delete">
            <input type=hidden name=id value=<%=quote.id()%>>
            <input type=submit name=action value=Delete>
          </form> 
    </table> 
</table>