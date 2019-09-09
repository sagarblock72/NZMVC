<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<table border="1" backgroundcolor="red">
  <tr bgcolor="blue"><th>eno</th><th>ename</th><th>job</th><th>Salary</th></tr>
  <c:forEach var="emp" items="${empList}">
  <tr bgcolor="cyan">
  <td><c:value="${emp.eno }"/></td>
  <td><c:value="${emp.ename }"/></td>
  <td><c:value="${emp.job }"/></td>
  <td><c:value="${emp.salary}"/></td>
  
  </tr>
  </c:forEach>
  
</table>

