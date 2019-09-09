<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color:red;align:center">Load Documents</h1>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <form:form method="POST" modelAttribute="upCmd" enctype="multipart/form-data">
    upload resume::<input type="file" name="resume"/><br>
    upload photo ::<input type="file" name="photo"/><br>
    <input type="submit" value="upload"/>
    </form:form>
