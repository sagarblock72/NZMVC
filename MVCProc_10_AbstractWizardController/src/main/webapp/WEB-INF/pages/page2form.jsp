<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   
   <h1 style="text-align:center">Contact Page</h1> 
   
    <form:form commandName="regCmd">
    Email::<form:input path="email"/><br>
    mobno::<form:input path="mobno"/><br>
    <input type="submit" value="next" name="_target2"/>
    <input type="submit" value="previous" name="_target0"/>
    <input type="submit" value="cancel" name="_cancel"/>
    </form:form>
