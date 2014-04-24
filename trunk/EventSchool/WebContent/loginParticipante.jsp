<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EventoSchool</title>
<link href="/EventSchool/css/loginParticipante.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="principal">
		 <div id="top"></div>
		 <div id="menuHeader">
         	<a id="eventos" class="fontMenu" href="/EventSchool/participante/home.jsp">Eventos</a>
           	<a id="contato" class="fontMenu" href="#">Contato</a>
         </div>
         <div id="corpo">
         	<form method="POST" action="/EventSchool/acessoParticipante">
	         	<div id="loginUser">
	         		
	         		<div id="acessar" align="center" class="fontTitulo">Acessar o EventSchool</div>
	         		
	         		<%  
					String erro = (String)request.getAttribute("msg");
					if(erro!=null){
					%>
	         		<div id="erro"><%=erro%></div>
	         		<% } %>
		         	<div class="fontTitulo">E-mail:</div>
		         	<input id="caixaEmail" type="text" name="email"/>
		         	
		         	<div class="fontTitulo">Senha:</div>
		         	<input id="caixaSenha" type="password" name="senha"/>
		         	
		         	<div id="login" align="center"><input type="submit" value="Fazer login"/> ou <a href="cadastrar.jsp">Cadastra-se</a></div>
		         </div>
		 	</form>        
         </div>
	</div>
</body>
</html>