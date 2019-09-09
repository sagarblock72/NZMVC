<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <h1 style='color:blue;text-align:center'>Customer Details List</h1>
    <c:choose>
    <c:when test="${not empty list}">
   <center> <table bgcolor="lightgreen" border="1"></center>
  <tr>
    <th>no</th>
    <th>name</th>
    <th>addr</th>
    <th>salary</th>
    <th>Mobie</th>
    <th>Bill Amount</th>
    <th>Options</th>
  </tr>
  <c:forEach var="ct" items="${list}">
  <tr>
    <td>${ct.cno}</td>
    <td>${ct.cname}</td>
    <td>${ct.addr}</td>
    <td>${ct.sal}</td>
    <td>${ct.mobno}</td>
    <td>${ct.billamt}</td>
    <td><a href="update.htm?id=${ct.cno}"><img src="images/update.jpg" width="30" hight="30"></img></a></td>
    <td><a href="delete.htm?cno=${ct.cno}" onclick="return confirm('Are you sure you want to delete this item?');"><img src="images/delete.jpg" width="30" hight="30"></img></a></td>
  </tr>
  </c:forEach>
</table>

<br><br><br>
<a href="newuser.htm"><img src="images/new.jpg" width="30" hight="30"></img></a>&nbsp;
<a href="welcome.htm"><img src="images/image.jpg" width="30" hight="30"></a>
</c:when>

 <c:otherwise>
    <span>No record found</span><br>
    </c:otherwise>
</c:choose><br>
<p style="color:red;text-align:cebter">${resultmsg}</p>


    