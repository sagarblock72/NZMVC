<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:red;text-align:center">Update record</h1><br>
<form:form method="post" modelAttribute="ctCmd">

cno:<form:input path="cno"/><br><form:errors path="cno"/>
cname:<form:input path="cname"/><br><form:errors path="cname"/>
addr:<form:input path="addr"/><br><form:errors path="addr"/>
sal :<form:input path="sal"/><br><form:errors path="sal"/>
MobNo :<form:input path="mobno"/><br><form:errors path="mobno"/>
BillAmt :<form:input path="billamt"/><br><form:errors path="billamt"/><br>
<input type="submit" value="update" />

</form:form>

 