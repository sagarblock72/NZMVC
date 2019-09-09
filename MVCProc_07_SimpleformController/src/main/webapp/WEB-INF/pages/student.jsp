<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>register student details</h1><br>

<style>
form:errors {background-color: red;}
form:errors {color: blue;}
 form:errors{color: red;}
</style>

<form:form  method="post" commandName="stCmd">
Number::<form:input path="sno"/><br><form:errors path="sno"/><br><br>
Name  ::<form:input path="sname"/><br><form:errors path="sname"/><br>
Adress ::<form:input path="loc"/><br><form:errors path="loc"/><br>
<input type="submit" value="register">

</form:form>
