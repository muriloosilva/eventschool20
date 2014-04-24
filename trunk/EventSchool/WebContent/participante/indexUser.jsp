<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="models.User"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Bem vindo Usuário : <%=((User)session.getAttribute("user")).getName() %><br>Escolha uma tarefa: <br>
Pedidos
<br><a href='ProductRegisterForm.html'><button>Ver ultimos pedidos</button></a>
<br><a href='/user/checkout.jsp'><button>Finalizar Pedido</button></a>
<br>Conta
<br><a href='ProductRegisterForm.html'><button>alterar dados cadastrais</button></a>
--
<br><a href='/listProduct.jsp'><button>Visualizar Produtos</button></a>
</body>
</html>