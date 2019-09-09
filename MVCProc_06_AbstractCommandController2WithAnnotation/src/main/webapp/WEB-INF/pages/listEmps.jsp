<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <h1 style='color:blue;text-align:center;'>Searched Details</h1><br>
    
     <c:choose>
    <c:when test="${not empty searchresult}">
    <table border="1" style='color:red;text-align:center;bgcolor:green'>
    <tr>
    <th>Empno</th><th>Empname</th><th>Empjob</th><th>Empsal</th><th>Empmgr</th><th>Empdept</th>
    </tr>
   
    <c:forEach var="result" items="${searchresult}">
    <tr>
    <td><c:out value="${result.empno}"/></td>
    <td><c:out value="${result.ename}"/></td>
    <td><c:out value="${result.job}"/></td>
    <td><c:out value="${result.sal}"/></td>
    <td><c:out value="${result.mgrno}"/></td>
    <td><c:out value="${result.deptno}"/></td>
    </tr>
    
    </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
    <span>No record found</span><br>
    </c:otherwise>
    </c:choose>
    
    <a href="search.htm">search page</a>
    