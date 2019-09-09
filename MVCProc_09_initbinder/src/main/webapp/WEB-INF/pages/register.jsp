<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
    <form:form commandName="rgCmd">
    
    <form:errors path="*"></form:errors>
    
    sno::<form:input path="sno"/><br>
    sname::<form:input path="sname"/><br>
    dob::<form:input path="dob"/><br>
    doj::<form:input path="doj"/><br>
    dom::<form:input path="dom"/><br>
    <input type="submit" value="register"/>
    
    
    </form:form>
     <c:if test="${!empty rgCmd }">
    the given sites are::${rgCmd}
    </c:if>
    
   