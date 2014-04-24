<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Admin</title>
</head>
<body>
<form method="POST" action="/loginAdmin">
		<table>
			<tr>
				<th colspan="2">Login Administrador</th>
			</tr>
			<tr>
				<td>Login:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<%  
			String erro = (String)request.getAttribute("msg");
			if(erro!=null){
			%>
			<tr>
				<td style="color: #FF0000" colspan="2"><%=erro%></td>
			</tr>
			<% } %>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Entrar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>