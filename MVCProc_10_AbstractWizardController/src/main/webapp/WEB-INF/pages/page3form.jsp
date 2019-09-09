<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <h1 style="text-align:center">Adress Page</h1>
    
    <form:form commandName="regCmd">
    City   ::<form:input path="city"/><br>
    Pincode::<form:input path="pincode"/><br>
    <input type="submit" value="previous" name="_target1"/>
    <input type="submit" value="finish" name="_finish"/>
    <input type="submit" value="cancel" name="_cancel"/>
    </form:form>
