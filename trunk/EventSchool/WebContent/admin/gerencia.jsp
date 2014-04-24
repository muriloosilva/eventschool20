<%@page import="models.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EventoSchool</title>
<link href="css/gerencia.css" rel="stylesheet" type="text/css" />
</head>
<body> 

	<% 
	Usuario usuario = (Usuario)session.getAttribute("usuario");
    
  	%>
	<div id="principal">
		 <div id="top"></div>
		 <div id="menuHeader">
         	<a id="eventos" class="fontMenu" href="#">Eventos</a>
           	<a id="contato" class="fontMenu" href="#">Contato</a>
         </div>
         <div id="user">
         	<div id="name" class="fontUser">Olá, Admin</div> 
         	<div id="conta" class="fontUser">Conta</div>
         	<div id="sair" class="fontUser">Sair</div>
         </div>
         <div id="corpo">
         	<div align="center" id=menuLateral>
         		<div id="atividade" class="fontMenuLateral">Atividades</div>
         		<div id="configuracaoEvento" class="fontMenuLateral">Config. Evento</div>
         		<div id="inscritos" class="fontMenuLateral">Inscritos</div>
         	</div>
         	<div id="loginUser">
         		
         		<div id="acessar" align="center" class="fontTitulo">SECITEC 2014</div> 
         		
         		<div id="acessar" align="center" class="fontTitulo">ATIVIDADES</div>
         		
         		<div class="fontTitulo">Palestras:</div> 
	         	<div id="tabelaAtividade">
	         		<table>
	         			<tr><td class="col1"><div class="fontTituloTabela">Nome</div></td><td class="col2"><div class="fontTituloTabela">Local</div></td><td class="col3"><div class="fontTituloTabela">Data Início</div></td><td class="col4"><div class="fontTituloTabela">Opções</div></td></tr>
	         			<tr><td class="col1">a</td> <td class="col2">b</td> <td class="col3">c</td> <td class="col4"><a href="#">editar</a> <a href="#">excluir</a></td></tr>
	         			<tr><td class="col1">a</td> <td class="col2">b</td> <td class="col3" >c</td> <td class="col4"><a href="#">editar</a> <a href="#">excluir</a></td></tr>
	         		</table>
	         	</div>
	         	
	         	<div class="fontTitulo">Minicursos:</div>
	         	<div id="tabelaAtividade">
	         		<table>
	         			<tr><td class="col1"><div class="fontTituloTabela">Nome</div></td><td class="col2"><div class="fontTituloTabela">Local</div></td><td class="col3"><div class="fontTituloTabela">Data Início</div></td><td class="col4"><div class="fontTituloTabela">Opções</div></td></tr>
	         			<tr><td class="col1">a</td> <td class="col2">b</td> <td class="col3">c</td> <td class="col4"><a href="#">editar</a> <a href="#">excluir</a></td></tr>
	         			<tr><td class="col1">a</td> <td class="col2">b</td> <td class="col3" >c</td> <td class="col4"><a href="#">editar</a> <a href="#">excluir</a></td></tr>
	         		</table>
	         	</div>
	         	
	         	<div class="fontTitulo">Oficinas:</div>
	         	<div id="tabelaAtividade">
	         		<table>
	         			<tr><td class="col1"><div class="fontTituloTabela">Nome</div></td><td class="col2"><div class="fontTituloTabela">Local</div></td><td class="col3"><div class="fontTituloTabela">Data Início</div></td><td class="col4"><div class="fontTituloTabela">Opções</div></td></tr>
	         			<tr><td class="col1">a</td> <td class="col2">b</td> <td class="col3">c</td> <td class="col4"><a href="#">editar</a> <a href="#">excluir</a></td></tr>
	         			<tr><td class="col1">a</td> <td class="col2">b</td> <td class="col3" >c</td> <td class="col4"><a href="#">editar</a> <a href="#">excluir</a></td></tr>
	         		</table>
	         	</div>
	         	
	         	<div id="login" align="center"><input type="button" value="Criar nova atividade"/></div>
	         </div>
         </div>
	</div>
</body>
</html>