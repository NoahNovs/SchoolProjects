<%
   String me = request.getContextPath();
 %>

<form action="<%=me%>/add/quote">

<table> 
  <tr> <td> Author: <td> <input type=text size=40 name=author> 
  <tr> <td> Quote:  <td> <textarea rows=6 cols=40 name=quote></textarea>

  <tr> <td colspan=2> <input type=submit name=action value=Create>
</table>

</form> 