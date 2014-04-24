<%@page import="DB.ProductDAO"%>
<%@ page import="java.sql.*"%>
<%@ page import="models.Product"%>
<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produtos - Carrinho de Compras</title>
</head>
<body>
<%  
	List<Product> listProduct = (List<Product>)request.getSession().getAttribute("carrinhoDeCompras");
	double totalProdutos = 0;
	
    if(listProduct != null && !listProduct.isEmpty()){
    	out.println("<table border='0 px'>");
		out.println("<tr><td>Descrição</td><td>Valor</td></tr>");
    	
		Iterator<Product> it = listProduct.iterator();
		while(it.hasNext()){
						
			Product product = it.next();			
			out.println("<tr>");
			//out.println("<td>"+product.getDescricao()+"</td>");
			//out.println("<td>R$ "+product.getValor()+"</td>");
			out.println("</tr>");
			//totalProdutos += product.getValor();
		}
		
		out.println("</table>");
		out.println("<br>");
		out.println("Total de produtos no carrinho: " + totalProdutos);
		out.println("<br><a href='/removeProductsSession'><button>Esvaziar carrinho</button></a>");
    	out.println("<br><a href='listProduct.jsp'><button>Continuar comprando</button></a>");
    	out.println("<br><a href='/user/checkout.jsp'><button>Finalizar compra</button></a>");
		//out.println("<a href='ProductRegisterForm.html'><button>Cadastrar novos Produtos</button></a>");
    }
    else{
    	out.println("Sem produtos na sessão");
    	out.println("<br><a href='listProduct.jsp'><button>Listar produtos</button></a>");
    }


%>
</body>
</html>