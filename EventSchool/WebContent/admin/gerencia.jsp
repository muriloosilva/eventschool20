<%@page import="util.DataHourFormat"%>
<%@page import="DB.InscricoesDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="DB.AtividadeDAO"%>
<%@page import="models.Atividade"%>
<%@page import="java.util.List"%>
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
<link href="/EventSchool/css/gerencia.css" rel="stylesheet" type="text/css" />
</head>
<body> 

	<% 
	Usuario usuario = (Usuario)session.getAttribute("usuario");
	int idEvento = Integer.parseInt(request.getParameter("cod"));
    Evento evento = EventoDAO.pegarEvento(idEvento);
    
  	%>
	<div id="principal">
		 <div id="top"></div>
		 <div id="menuHeader">
         	<a id="eventos" class="fontMenu" href="/EventSchool/admin/eventos.jsp">Eventos</a>
           	<a id="contato" class="fontMenu" href="#">Contato</a>
         </div>
         <div id="user">
         	<div id="name" class="fontUser">Olá, <%=usuario.getNome() %></div> 
         	<div id="conta" class="fontUser">Conta</div>
         	<div id="sair" class="fontUser"><a class="fontUser" href="/EventSchool/sair">Sair</a></div>
         </div>
         <div id="corpo">
         	<div align="center" id=menuLateral>
         		<div id="atividade"><a  class="fontMenuLateral" href="#">Atividades</a></div><br>
         		<div id="configuracaoEvento"><a  class="fontMenuLateral" href="/EventSchool/admin/configurarEvento.jsp?cod=<%=idEvento%>">Config. Evento</a></div><br>
         		<div id="inscritos"><a  class="fontMenuLateral" href="/EventSchool/admin/inscritos.jsp?cod=<%=idEvento%>">Inscritos</a></div><br>
         	</div>
         	<div id="loginUser">
         		
         		<div id="acessar" align="center" class="fontTitulo"><%=evento.getNome() %></div> 
         		
         		<div id="acessar" align="center" class="fontTitulo">ATIVIDADES</div>
         		
         		<div class="fontTitulo">Palestras:</div> 
	         	<div id="tabelaAtividade">
	         	<%
	         	
         		List<Atividade> listaPalestrasEvento = AtividadeDAO.listaDePalestrasEvento(idEvento);
				if(listaPalestrasEvento != null){ 
				
				%>
				
	         	
	         		<table>
						<tr>
	         				<td class="col1"><div class="fontTituloTabela">Nome</div></td>
	         				<td class="col2"><div class="fontTituloTabela">Data</div></td>
	         				<td class="col3"><div class="fontTituloTabela">Hora Inicio</div></td>
	         				<td class="col4"><div class="fontTituloTabela">Hora Fim</div></td>
	         				<td class="col5"><div class="fontTituloTabela">Vagas</div></td>
	         			</tr>
	         			
	         			<%
 	
						Iterator<Atividade> it = listaPalestrasEvento.iterator();
							while(it.hasNext()){
								Atividade atividade = it.next(); 
						
						%>
	         			
	         			<tr>
	         				<td class="col1"><%=atividade.getNome() %></td>
	         				<td class="col2"><%=DataHourFormat.formatarData(atividade.getData()) %></td>
	         				<td class="col3"><%=atividade.getHoraInicio() %></td>
	         				<td class="col4"><%=atividade.getHoraFim() %></td>
	         				<td class="col5"><%=atividade.getVagas() %></td>
	         				<td class="col6"><a href="/EventSchool/excluirAtividade?cod=<%=idEvento%>&at=<%=atividade.getIdAtividade()%>">excluir</a>
	         				</td>
	         					
					    </tr>
						<%}%>
	         		</table>
	         		<%}else{
	         			out.println("Não existe palestra cadastrada");
	         		}%>
	         	</div>
	         	
	         	<div class="fontTitulo">Minicursos:</div>
	         	<div id="tabelaAtividade">
	         	<%
	         	
         		List<Atividade> listaMinicursoEvento = AtividadeDAO.listaDeMinicursoEvento(idEvento);
				if(listaMinicursoEvento != null){ 
				
				%>
				
	         	
	         		<table>
						<tr>
	         				<td class="col1"><div class="fontTituloTabela">Nome</div></td>
	         				<td class="col2"><div class="fontTituloTabela">Data</div></td>
	         				<td class="col3"><div class="fontTituloTabela">Hora Inicio</div></td>
	         				<td class="col4"><div class="fontTituloTabela">Hora Fim</div></td>
	         				<td class="col5"><div class="fontTituloTabela">Vagas</div></td>
	         			</tr>
	         			
	         			<%
 	
						Iterator<Atividade> it = listaMinicursoEvento.iterator();
							while(it.hasNext()){
								Atividade atividade = it.next(); 
						
						%>
	         			
	         			<tr>
	         				<td class="col1"><%=atividade.getNome() %></td>
	         				<td class="col2"><%=DataHourFormat.formatarData(atividade.getData()) %></td>
	         				<td class="col3"><%=atividade.getHoraInicio() %></td>
	         				<td class="col4"><%=atividade.getHoraFim() %></td>
	         				<td class="col5"><%=atividade.getVagas() %></td>
	         				<td class="col6"><a href="/EventSchool/excluirAtividade?cod=<%=idEvento%>&at=<%=atividade.getIdAtividade()%>">excluir</a>
					    </tr>
						<%}%>
	         		</table>
	         		<%}else{
	         			out.println("Não existe minicurso cadastrado");
	         		}%>
	         	</div>
	         	
	         	<div class="fontTitulo">Oficinas:</div>
	         	<div id="tabelaAtividade">
	         	<%
	         	
         		List<Atividade> listaOficinasEvento = AtividadeDAO.listaDeOficinaEvento(idEvento);
				if(listaOficinasEvento != null){ 
				
				%>
				
	         	
	         		<table>
						<tr>
	         				<td class="col1"><div class="fontTituloTabela">Nome</div></td>
	         				<td class="col2"><div class="fontTituloTabela">Data</div></td>
	         				<td class="col3"><div class="fontTituloTabela">Hora Inicio</div></td>
	         				<td class="col4"><div class="fontTituloTabela">Hora Fim</div></td>
	         				<td class="col5"><div class="fontTituloTabela">Vagas</div></td>
	         			</tr>
	         			
	         			<%
 	
						Iterator<Atividade> it = listaOficinasEvento.iterator();
							while(it.hasNext()){
								Atividade atividade = it.next(); 
						
						%>
	         			
	         			<tr>
	         				<td class="col1"><%=atividade.getNome() %></td>
	         				<td class="col2"><%=DataHourFormat.formatarData(atividade.getData()) %></td>
	         				<td class="col3"><%=atividade.getHoraInicio() %></td>
	         				<td class="col4"><%=atividade.getHoraFim() %></td>
	         				<td class="col5"><%=atividade.getVagas() %></td>
	         				<td class="col6"><a href="/EventSchool/excluirAtividade?cod=<%=idEvento%>&at=<%=atividade.getIdAtividade()%>">excluir</a>
					    </tr>
						<%}%>
	         		</table>
	         		<%}else{
	         			out.println("Não existe oficina cadastrada");
	         		}%>
	         	</div>
	         	<form method="POST" action="/EventSchool/admin/cadastrarAtividade.jsp?cod=<%=idEvento%>">
	         		<div id="login" align="center"><input type="submit" value="Criar nova atividade"/></div>
	         	</form>
	         </div>
         </div>
	</div>
</body>
</html>