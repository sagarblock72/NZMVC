<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <h1 style="color:red;text-align:center">Login Page</h1>
    <form:form modelAttribute="userCmd">
    <span style="color:red"><form:errors path="*"/></span><br><br>
    Login UserName::<form:input path="user"/><br>
    Login Password::<form:input path="pwd"/><br>
    Age::<form:input path="age"/><br><br>
    Domain::<form:checkboxes items="${domains}" path="dmn"/><br>
    <input type="submit" value="login"/>
    </form:form>
    <br><br>
    <c:if test="${not empty result }">
    <c:out value="${result}"></c:out>
    </c:if><br>
    <c:if test="${not empty domain }">
    <c:out value="${domain}"></c:out>
    </c:if>