<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EventoSchool</title>
<link href="css/cadastrar.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="principal">
		 <div id="top"></div>
		 <div id="menuHeader">
         	<a id="eventos" class="fontMenu" href="#">Eventos</a>
           	<a id="contato" class="fontMenu" href="#">Contato</a>
         </div>
         <div id="corpo">
         
         	<form method="POST" action="/EventSchool/cadastrar">
	         	<div id="loginUser">
	         		
	         		<div id="acessar" align="center" class="fontTitulo">Cadastrar no EventSchool</div>
	         		<%
	         		String erro = (String)request.getAttribute("msg");
					if(erro!=null){
					%>
	         		<div id="erro"><%=erro%></div>
	         		<% } %>
	         		
	         		<div class="fontTitulo">Nome:</div>
		         	<input id="caixaEmail" type="text" name="nome"/>
		         	
		         	<div class="fontTitulo">CPF:</div>
		         	<input id="caixaEmail" type="text" name="cpf"/>
		         	
		         	<div class="fontTitulo">Data de Nascimento</div>
		         	<input id="caixaEmail" type="text" name="nascimento"/>
	         	
		         	<div class="fontTitulo">E-mail:</div>
		         	<input id="caixaEmail" type="text" name="e-mail"/>
		         	
		         	<div class="fontTitulo">Senha:</div>
		         	<input id="caixaSenha" type="password" name="senha"/>
		         	
		         	<div class="fontTitulo">Repita a senha:</div>
		         	<input id="caixaSenha" type="password" name="senha2"/>
		         	
		         	<div id="login" align="center"><input type="submit" value="Cancelar"/><input type="submit" value="Cadastrar"/></div>
		         </div>
	         </form>
         </div>
         
	</div>
</body>
</html>