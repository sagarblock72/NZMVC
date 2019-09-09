<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" isErrorPage="false"%>
    
  <%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

  <html>    
<head>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
<div style="bgcolor:red"><title><tiles:insertAttribute name="title" ignore="true" /></title></div>  
</head>    
<body>    
        <div><tiles:insertAttribute name="header" /></div>    
        <div style="float:left;padding:10px;width:15%;"><tiles:insertAttribute name="menu" /></div>    
        <div style="float:left;padding:10px;width:80%;border-left:1px solid pink;">    
        <tiles:insertAttribute name="body" /></div>    
        <div style="clear:both;bachground-color:green"><tiles:insertAttribute name="footer" /></div>    
    
</body>    
</html>    