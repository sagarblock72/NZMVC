<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:red;text-align:center">Register Page</h1><br>
<form:form modelAttribute="ctCmd">
cno     :<form:input path="cno" /><br>
cname   :<form:input path="cname"/><br>
addr    :<form:input path="addr"/><br>
sal     :<form:input path="sal"/><br>
mobno   :<form:input path="mobno"/><br>
billamt :<form:input path="billamt"/><br>
<input type="submit" value="register" />

</form:form>
<a href="welcome.htm">home</a>