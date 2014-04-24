<%@page import="models.SubCategory"%>
<%@page import="DB.SubCategoryDAO"%>
<%@page import="models.Category"%>
<%@page import="DB.CategoryDAO"%>
<%@page import="DB.ProductDAO"%>
<%@ page import="java.sql.*"%>
<%@ page import="models.Product"%>
<%@ page import="java.util.*" import="models.User" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>EasyBuy</title>
        <link href="headerStyle.css" rel="stylesheet" type="text/css" />
        <link href="bodyStyle.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="main">
            <div id="top">
                <div id="logo"></div>
                    <div id="busca">
                        <div id="busca_esquerda"></div>
                        <div id="busca_centro">
                            <div id="labelBuscar">Buscar</div>
                            <div id="caixaDeTextoEsquerda"></div>
                            <div id="caixaDeTextoCentro">
                                <input id="caixaDeTexto" type="text" />
                            </div>
                            <div id="caixaDeTextoDireita"></div>
                            <div id="botaoBuscar"></div>
                        </div>
                        <div id="busca_direita"></div>
                    </div>
                    <div id="botaoCarrinho"></div>
                    <div id="menuHeader">
                        <a id="loginCadastraSe" class="fontMenu" href="#">Login ou Cadastrar-se</a>
                        <a id="meusPedidos" class="fontMenu" href="#">Meus Pedidos</a>
                        <a id="atendimento" class="fontMenu" href="#">Atendimento</a>
                    </div>
            </div>
            <div id="corpo">
                <div id="bannerPrincipal"></div>
                <div id="menuBody">
                  <div id="categoriaLeft"></div>
                  <div id="categoriaCenter">
                      <div id="labelCategoria" class="fontMenu">Categorias</div>
                  </div>
                  <div id="categoriaRight"></div>
                  <div id="categorias">
                      <ul id="ulCategoria">
                      <% 
                      
                      List<Category> listCategory = CategoryDAO.getCategories();
                      if(listCategory != null){
                    	  Iterator<Category> ic = listCategory.iterator();
                    	  while(ic.hasNext()){
                    		  Category c = ic.next();
                      
                      %>
                          <li class="liCategoria"><a class="fontMenu" href="/listaProdutos.jsp?codCategory=<%=c.getId()%>&indexPage=1"><%= c.getNome()%></a>
                          	 <ul id="ulItensCategoria">
                          	 <% 
                          	 
                          	List<SubCategory> ls = SubCategoryDAO.getSubCategories(c.getId());
                   		  	if(ls!=null){
                   		  		Iterator<SubCategory> is = ls.iterator();                   		  	
                   		  		while(is.hasNext()){                   		  	
                   			 		SubCategory s = is.next();

                          	 %>
                                  <li class="liCategoria"><a class="fontItemMenu" href="/listaProdutos.jsp?codCategory=<%= c.getId() %>&codSubCategory=<%=s.getId()%>&indexPage=1"><%= s.getNome()%></a></li>
                              <%} }%>
                              </ul>       
                          </li>
                          <% }}%>
                             
                          
                      </ul>
                  </div>
                </div>
                <!-- Inicio da lista de produtos -->
                <!-- Inserir código JSP a partir daqui -->
                
                <%  
				User user = (User)session.getAttribute("user");
				if(user!= null)
					out.println("Usuário: " + user.getName());
	
				List<Product> listProduct = ProductDAO.getProducts();
   				if(listProduct != null){
					Iterator<Product> it = listProduct.iterator(); %>
                
                <div id="listaProdutos">
                    <div id="produtosEmDestaque">
                    	<div class="produtosEmDestaqueHeader">
                              <div class="produtosDestaqueLeft"></div>
                              <div class="produtosDestaqueCenter">
                                  <div id="labelCategoria" class="fontMenu">Produtos em Destaque</div>
                              </div>
                              <div class="produtosDestaqueRight"></div>
                    	</div>
                         
                         <div id="produtosEmDestaqueBody">
                         
                         <%
                         int j = 0;
                         while(it.hasNext() && j<2){
                         	j++;
                         %>
                         
                         	<ul class="ulListaProdutos">
                         	
                         		<% for(int i = 0; (i <3&&it.hasNext());i++){
                         		        Product product = it.next();
                         		%>
                            	<li class="liListaProdutos">
                                	<div class="produto">
                                    	<input name="produtoID" type="hidden" value"<%= product.getCod()%>"/>
                                        <div class="produtoImagem">
                                        	<a href="#" title="<%= product.getDescricao()%>">
                                            	<img class="produtoIMG" src="/carregaFoto?codProduto=<%= product.getCod()%>"/>
                                            </a>
                                        </div>
                                        <div class="produtoInfo">
                                        	<a href="produto.html?cod=<%= product.getCod()%>" title="<%= product.getDescricao()%>">
                                        		<span class="produtoMaisDetalhes"></span>
                                            </a>
                                            <div class="produtoDescricao">
                                                <a href="#" class="fontItemMenu" title="<%= product.getDescricao()%>">
                                                    <span itemprop="name"><%= product.getDescricao()%></span>
                                                </a>
                                            </div>
                                            <div class="produtoPreco">
                                            	<span class="produtoPrecoDesconto">desconto de  R$ 200,00</span><br>
                                                <del class="produtoPrecoAnterior">R$ <%= product.getValorAnterior()%></del><br>
                                                <span class="produtoPrecoAtual">R$ <%= product.getValorAtual()%></span><br>
                                                <span class="produtoPrecoParcelado">12x de R$ 49,92</span>
                                                <span class="produtoPrecoDesconto">CartÃ£o Easybuy R$ 580,00</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <% }%>  
                            </ul>
                            <%} %>
                         </div>
                    </div>
                    <div id="produtosRecomendados">
                    	<div class="produtosEmDestaqueHeader">
                              <div class="produtosDestaqueLeft"></div>
                              <div class="produtosDestaqueCenter">
                                  <div id="labelCategoria" class="fontMenu">Produtos Recomendados</div>
                              </div>
                              <div class="produtosDestaqueRight"></div>
                    	</div>
                        <div id="listaProdutosRecomendados">
                            <ul class="ulListaProdutos">
                                    <li class="liListaProdutos">
                                        <div class="produto">
                                            <input name="produtoID" type="hidden" value"#"/>
                                            <div class="produtoImagem">
                                                <a href="#" title="Camera ...">
                                                    <img class="produtoIMG" src="http://img.submarino.com.br/produtos/01/03/item/111259/0/111259015P1.jpg" />
                                                </a>
                                            </div>
                                            <div class="produtoInfo">
                                                <a href="produto.html?cod=#" title="Camera ...">
                                                    <span class="produtoMaisDetalhes"></span>
                                                </a>
                                                <div class="produtoDescricao">
                                                    <a href="#" class="fontItemMenu" title="Camera ...">
                                                        <span itemprop="name">CÃ¢mera Digital 3D Sony Cyber-shot DSC-WX100 18.2MP c/ 10x Zoom Ãptico CartÃ£o 8GB Preta</span>
                                                    </a>
                                                </div>
                                                <div class="produtoPreco">
                                                    <span class="produtoPrecoDesconto">desconto de  R$ 200,00</span><br>
                                                    <del class="produtoPrecoAnterior">R$ 799,00</del><br>
                                                    <span class="produtoPrecoAtual">R$ 599,00</span><br>
                                                    <span class="produtoPrecoParcelado">12x de R$ 49,92</span>
                                                    <span class="produtoPrecoDesconto">CartÃ£o Easybuy R$ 580,00</span>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="liListaProdutos">
                                        <div class="produto">
                                            <input name="produtoID" type="hidden" value"#"/>
                                            <div class="produtoImagem">
                                                <a href="#" title="Camera ...">
                                                    <img class="produtoIMG" src="http://img.submarino.com.br/produtos/01/03/item/111259/0/111259015P1.jpg" />
                                                </a>
                                            </div>
                                            <div class="produtoInfo">
                                                <a href="produto.html?cod=#" title="Camera ...">
                                                    <span class="produtoMaisDetalhes"></span>
                                                </a>
                                                <div class="produtoDescricao">
                                                    <a href="#" class="fontItemMenu" title="Camera ...">
                                                        <span itemprop="name">CÃ¢mera Digital 3D Sony Cyber-shot DSC-WX100 18.2MP c/ 10x Zoom Ãptico CartÃ£o 8GB Preta</span>
                                                    </a>
                                                </div>
                                                <div class="produtoPreco">
                                                    <span class="produtoPrecoDesconto">desconto de  R$ 200,00</span><br>
                                                    <del class="produtoPrecoAnterior">R$ 799,00</del><br>
                                                    <span class="produtoPrecoAtual">R$ 599,00</span><br>
                                                    <span class="produtoPrecoParcelado">12x de R$ 49,92</span>
                                                    <span class="produtoPrecoDesconto">CartÃ£o Easybuy R$ 580,00</span>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="liListaProdutos">
                                        <div class="produto">
                                            <input name="produtoID" type="hidden" value"#"/>
                                            <div class="produtoImagem">
                                                <a href="#" title="Camera ...">
                                                    <img class="produtoIMG" src="http://img.submarino.com.br/produtos/01/03/item/111259/0/111259015P1.jpg" />
                                                </a>
                                            </div>
                                            <div class="produtoInfo">
                                                <a href="produto.html?cod=#" title="Camera ...">
                                                    <span class="produtoMaisDetalhes"></span>
                                                </a>
                                                <div class="produtoDescricao">
                                                    <a href="#" class="fontItemMenu" title="Camera ...">
                                                        <span itemprop="name">CÃ¢mera Digital 3D Sony Cyber-shot DSC-WX100 18.2MP c/ 10x Zoom Ãptico CartÃ£o 8GB Preta</span>
                                                    </a>
                                                </div>
                                                <div class="produtoPreco">
                                                    <span class="produtoPrecoDesconto">desconto de  R$ 200,00</span><br>
                                                    <del class="produtoPrecoAnterior">R$ 799,00</del><br>
                                                    <span class="produtoPrecoAtual">R$ 599,00</span><br>
                                                    <span class="produtoPrecoParcelado">12x de R$ 49,92</span>
                                                    <span class="produtoPrecoDesconto">CartÃ£o Easybuy R$ 580,00</span>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                           </div>
                    </div>
                </div>
                <% }%>
            </div>
        </div>
      </div>
    </body>
</html>
