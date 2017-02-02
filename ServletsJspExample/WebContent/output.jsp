<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Your name is: </h1>
	
	<%
		String firstName = (String) request.getAttribute("firstname");
		String lastName = (String) request.getAttribute("lastname");
		
		out.print(firstName + " " + lastName);
	%>

</body>
</html>