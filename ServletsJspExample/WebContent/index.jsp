<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="servletexample" method="post">
		<table>
		<tr>
			<td>First name: </td><td><input type="text" name="firstname"></td>
		</tr>
		<tr>
			<td>Last name: </td><td><input type="text" name="lastname"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="Submit"></td>
		</tr>
		</table>
	</form>
</body>
</html>