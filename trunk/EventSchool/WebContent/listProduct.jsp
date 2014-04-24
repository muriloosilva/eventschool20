<%@page import="DB.ProductDAO"%>
<%@ page import="java.sql.*"%>
<%@ page import="models.Product"%>
<%@ page import="java.util.*" import="models.User" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produtos</title>
</head>
<body>
<%  
	User user = (User)session.getAttribute("user");
	if(user!= null)
		out.println("Usuário: " + user.getName());
	
	List<Product> listProduct = ProductDAO.getProducts();
    if(listProduct != null){
    	out.println("<table border='0 px'> <tr><td>");
		out.println("<tr><td>Descrição</td><td>Valor</td><td></td></tr>");
    	
		Iterator<Product> it = listProduct.iterator();
		while(it.hasNext()){
			
			
			Product product = it.next();			
			out.println("<tr>");
			out.println("<td>"+product.getDescricao()+"</td>");
			out.println("<td>R$ "+product.getValorAtual()+"</td>");
			out.println("<td><a href=adicionarCarrinho?cod="+product.getCod()+"><button>Adicionar ao carrinho</button></td>");
			out.println("</tr>");
			
			/* out.println("Cod: </td><td>" + product.getCod() + "</td></tr><tr><td>");
			out.println("Descrição: </td><td>" + product.getDescricao() + "</td></tr><tr><td>");
			
			out.println("Valor: </td><td>" + product.getValor() + "</td></tr></html>");
			out.println("<a href = 'changeProduct.jsp?cod="+ product.getCod()+"'><button> Alterar </button></a>");
			out.println("<a href = 'removeProduct?cod="+ product.getCod()+"'><button> Deletar </button></a>");
			out.println("<br><br><br>"); */
		}
		
		out.println("</table>");
		
		out.println("<br>");
    	out.println("<br><a href='listaProdutosCarrinho.jsp'><button>Ver produtos no carrinho.</button></a>");
    }
    else{
    	out.println("Sem produtos cadastrados");
    	out.println("<a href='ProductRegisterForm.html'><button>Cadastrar Produtos</button></a>");
    }
    if(user== null)
    	out.println("<br><a href='loginUser.jsp'><button>Logar.</button></a>");
%>
</body>
</html>