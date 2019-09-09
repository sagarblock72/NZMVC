<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:red;text-align:center">Register Page</h1><br>
<form:form  commandName="ctCmd">
cno     :<form:input path="cno" /><form:errors path="cno"/><br>
cname   :<form:input path="cname"/><form:errors path="cname"/><br>
addr    :<form:input path="addr"/><form:errors path="addr"/><br>
sal     :<form:input path="sal"/><form:errors path="sal"/><br>
mobno   :<form:input path="mobno"/><form:errors path="mobno"/><br>
billamt :<form:input path="billamt"/><form:errors path="billamt"/><br>
<input type="submit" value="register" />

</form:form>
<a href="welcome.htm">home</a>