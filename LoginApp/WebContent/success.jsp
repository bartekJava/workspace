<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.koushik.javabrains.dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>
	<h3>Login Successful!</h3>
	
	<jsp:useBean id="user" class="org.koushik.javabrains.dto.User" scope="request">
	</jsp:useBean>
	
	Hello <jsp:getProperty property="userName" name="user"/>

</body>
</html>