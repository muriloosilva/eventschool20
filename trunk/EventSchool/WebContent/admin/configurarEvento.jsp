<%@page import="DB.EventoDAO"%>
<%@page import="models.Evento"%>
<%@page import="models.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EventoSchool</title>
<link href="/EventSchool/css/cadastrarEvento.css" rel="stylesheet" type="text/css" />
</head>
<body> 
	<% 
	Usuario usuario = (Usuario)session.getAttribute("usuario");
    
  	%>
	<div id="principal">
		 <div id="top"></div>
		 <div id="menuHeader">
         	<a id="eventos" class="fontMenu" href="/EventSchool/admin/eventos.jsp">Eventos</a>
           	<a id="contato" class="fontMenu" href="#">Contato</a>
         </div>
         <div id="user">
         	<div id="name" class="fontUser">Olá, <%=usuario.getNome()%></div> 
         	<div id="conta" class="fontUser">Conta</div>
         	<div id="sair" class="fontUser"><a class="fontUser" href="/EventSchool/sair">Sair</a></div>
         </div>
         <div id="corpo">
         	<%
         	
         	int idEvento = Integer.parseInt(request.getParameter("cod"));
			Evento evento = EventoDAO.pegarEvento(idEvento);
         	%>
         
         	<form method="POST" action="/EventSchool/alterarEvento?cod=<%=idEvento %>">
	         	<div id="loginUser">
	         		
	         		<div id="acessar" align="center" class="fontTitulo">ALTERAR EVENTO</div>
	         		<%
	         		String erro = (String)request.getAttribute("msg");
					if(erro!=null){
					%>
	         		<div id="erro"><%=erro%></div>
	         		<% } 
					
					 
					
	         		%>
	         		
	         		<div class="fontTitulo">Nome:</div>
		         	<input class="caixa" type="text" name="nome" value="<%=evento.getNome()%>"/>
		         	
		         	<div class="fontTitulo">Descrição:</div>
		         	<input class="textArea" type="text" name="descricao" value="<%=evento.getDescricao()%>"/>
	         	
		         	<div class="fontTitulo">Local:</div>
		         	<input class="caixa" type="text" name="local" value="<%=evento.getLocal()%>"/>
		         	
		         	<div class="fontTitulo">Data Inicio:</div>
		         	<input class="caixa" type="text" name="inicio" value="<%=evento.getDataInicioFormatada()%>"/>
		         	
		         	<div class="fontTitulo">Data Fim:</div>
		         	<input class="caixa" type="text" name="fim" value="<%=evento.getDataFimFormatada()%>"/>
		         	
		         	<div class="fontTitulo">Data inicio inscrições:</div>
		         	<input class="caixa" type="text" name="inicioInscricoes" value="<%=evento.getDataInicioInscricoesFormatado()%>"/>
		         	
		         	<div class="fontTitulo">Data fim inscrições:</div>
		         	<input class="caixa" type="text" name="fimInscricoes" value="<%=evento.getDataFimInscricoesFormatado()%>"/>
		         	
		         	<div class="fontTitulo">Telefone:</div>
		         	<input class="caixa" type="text" name="telefone" value="<%=evento.getTelefone()%>"/>
		         	
		         	<div class="fontTitulo">E-mail:</div>
		         	<input class="caixa" type="text" name="email" value="<%=evento.getEmail()%>"/>
		         	
		         	<div id="login" align="center"><input type="button" value="Cancelar"/><input type="submit" value="Alterar"/></div>
		         </div>
		 	</form>
         </div>
	</div>
</body>
</html>