<%@ page language="java" import="models.*" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<body>
<%  
	User user = (User)session.getAttribute("user");
	if(user!= null)
		out.println("Usuário: " + user.getName());
%>

<br><br>Produtos Selecionados

<% List<Product> listProduct = (List<Product>)request.getSession().getAttribute("carrinhoDeCompras");
	double totalProdutos = 0;
	
    if(listProduct != null && !listProduct.isEmpty()){
    	out.println("<table border='0 px'>");
		out.println("<tr><td>Descrição</td><td>Valor</td></tr>");
    	
		Iterator<Product> it = listProduct.iterator();
		while(it.hasNext()){
						
			Product product = it.next();			
			out.println("<tr>");
			out.println("<td>"+product.getDescricao()+"</td>");
			//out.println("<td>R$ "+product.getValor()+"</td>");
			out.println("</tr>");
			//totalProdutos += product.getValor();
		}
		
		out.println("</table>");
		out.println("<br>");
		out.println("Total de produtos no carrinho: " + totalProdutos);
    }
		%>
<br><br>Escolha a forma de pagamento:<br>
1 - Cartão<br>
2 - Paypal<br>
3 - Boleto<br>
</body>
</html>