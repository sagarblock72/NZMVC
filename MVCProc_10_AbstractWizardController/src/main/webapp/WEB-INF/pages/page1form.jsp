<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
 <h1 style="text-align:center">Login page</h1>
    <form:form commandName="regCmd">
    
    username::<form:input path="username"/><br>
    password::<form:input path="password"/><br>
    <input type="submit" value="next" name="_target1"/>
    <input type="submit" value="cancel" name="_cancel"/>
    
    </form:form>