<%@page import="DB.InscricoesDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="util.DataHourFormat"%>
<%@page import="DB.AtividadeDAO"%>
<%@page import="models.Atividade"%>
<%@page import="java.util.List"%>
<%@page import="models.Evento"%>
<%@page import="DB.EventoDAO"%>
<%@page import="models.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EventoSchool</title>
<link href="/EventSchool/css/evento.css" rel="stylesheet" type="text/css" />
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
         	<a id="eventos" class="fontMenu" href="#">Eventos</a>
           	<a id="contato" class="fontMenu" href="#">Contato</a>
         </div>
         <div id="user">
         	<div id="name" class="fontUser">Olá, <%=usuario.getNome() %></div> 
         	<div id="conta" class="fontUser">Conta</div>
         	<div id="sair" class="fontUser">Sair</div>
         </div>
         <div id="corpo">
         	<div id="dadosEvento">
	         	<div class="fontTitulo">Nome do Evento:</div>
	         	<div class="fontValor"><%=evento.getNome() %></div>
	         	
	         	<div class="fontTitulo">Descricão:</div>
	         	<div align="justify" class="fontValor"><%=evento.getDescricao() %></div>
	         	
	         	<div class="fontTitulo">Local:</div>
	         	<div class="fontValor"><%=evento.getLocal() %></div>
	         	
	         	<div class="fontTitulo">Data de Início:</div>
	         	<div class="fontValor"><%=evento.getDataInicioFormatada() %></div>
	         	
	         	<div class="fontTitulo">Data de Término:</div>
	         	<div class="fontValor"><%=evento.getDataFimFormatada() %></div>     	
	         	        	         	                  	
	         	<div class="fontTitulo">Palestras:</div> 
	         	
	         	<%
	         	
         		List<Atividade> listaPalestrasEvento = AtividadeDAO.listaDePalestrasEvento(idEvento);
				if(listaPalestrasEvento != null){ 
				
				%>
				
	         	<div id="tabelaAtividade">
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
	         				
	         				<%if(InscricoesDAO.verificarInscricao(atividade, usuario)){ %>
	         				
	         					<td class="col6">Inscrito <a href="/EventSchool/cancelar?cod=<%=idEvento%>&at=<%=atividade.getIdAtividade()%>">cancelar</a></td>
	         					
	         				<%}else{ %>

								<td class="col6"><a href="/EventSchool/inscricao?cod=<%=idEvento%>&at=<%=atividade.getIdAtividade()%>">inscrever</a></td>
	         					
	         				<%}%>
					    </tr>
						<%}%>
	         		</table>
	         		<%}else{
	         			out.println("Não existe palestra cadastrada");
	         		}%>
	         	</div>
	         	
	         	<div class="fontTitulo">Minicursos:</div>
	         	<%
	         	
         		List<Atividade> listaMinicursoEvento = AtividadeDAO.listaDeMinicursoEvento(idEvento);
				if(listaMinicursoEvento != null){ 
				
				%>
				
	         	<div id="tabelaAtividade">
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
	         				
	         				<%if(InscricoesDAO.verificarInscricao(atividade, usuario)){ %>
	         				
	         					<td class="col6">Inscrito <a href="/EventSchool/cancelar?cod=<%=idEvento%>&at=<%=atividade.getIdAtividade()%>">cancelar</a></td>
	         					
	         				<%}else{ %>

								<td class="col6"><a href="/EventSchool/inscricao?cod=<%=idEvento%>&at=<%=atividade.getIdAtividade()%>">inscrever</a></td>
	         					
	         				<%}%>
					    </tr>
						<%}%>
	         		</table>
	         		<%}else{
	         			out.println("Não existe minicurso cadastrado");
	         		}%>
	         	</div>
	         	
	         	<div class="fontTitulo">Oficinas:</div>
	         	<%
	         	
         		List<Atividade> listaOficinasEvento = AtividadeDAO.listaDeOficinaEvento(idEvento);
				if(listaOficinasEvento != null){ 
				
				%>
				
	         	<div id="tabelaAtividade">
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
	         				
	         				<%if(InscricoesDAO.verificarInscricao(atividade, usuario)){ %>
	         				
	         					<td class="col6">Inscrito <a href="/EventSchool/cancelar?cod=<%=idEvento%>&at=<%=atividade.getIdAtividade()%>">cancelar</a></td>
	         					
	         				<%}else{ %>

								<td class="col6"><a href="/EventSchool/inscricao?cod=<%=idEvento%>&at=<%=atividade.getIdAtividade()%>">inscrever</a></td>
	         					
	         				<%}%>
					    </tr>
						<%}%>
	         		</table>
	         		<%}else{
	         			out.println("Não existe oficina cadastrada");
	         		}%>
	         	</div>
	         </div>
         </div>
	</div>
</body>
</html>