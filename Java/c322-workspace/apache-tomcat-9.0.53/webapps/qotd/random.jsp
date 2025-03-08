<%

   String me = request.getContextPath();

 %>

<table>
<tr> <td> <a href="<%=me%>/random">Home</a>
     <td align=right> <a href="<%=me%>/list/all">Admin</a>
<tr>
<td colspan=2>
  <%=request.getAttribute("quote")%>
</table>
