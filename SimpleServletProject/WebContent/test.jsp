<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Testing JSPs</h3><br>
	
	<%!
	public int add(int a, int b)
	{
		return a + b;
	}
	%>
	
	<%
	int i = 1;
	int j = 2;
	int k;
	
	k = i + j;
	%>
	
	<p>The value of "k" is: <%=k %></p>
	
	<%
	k = add(6548, 6123);
	%>
	
	<p>The value of "k" is: <%=k %></p>

</body>
</html>