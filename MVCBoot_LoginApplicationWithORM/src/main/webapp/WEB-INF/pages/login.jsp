<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <h1 style="color:red;text-align:center">Login Page</h1>
    <br><br>
    
   <form:form modelAttribute="userCmd">
   UserName::<form:input path="user"/><br>
   password::<form:input path="pwd"/><br>
   <input type="submit" value="login"/>
   </form:form>
   <br><br>
   <h1 style="color:red;text-align:center">${rMsg}</h1>