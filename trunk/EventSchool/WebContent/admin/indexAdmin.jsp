<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="models.User"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Bem vindo administrador : <%=((User)session.getAttribute("user")).getName() %> - Escolha uma tarefa: <br>
Páginas
<br><a href='ProductRegisterForm.html'><button>Criar página</button></a>
<br><a href='ProductRegisterForm.html'><button>Alterar página</button></a>
<br><a href='ProductRegisterForm.html'><button>Excluir página</button></a>
<br>Categorias
<br><a href='/admin/CategoryRegisterForm.html'><button>Cadastrar Categorias</button></a>
<br><a href='/admin/CategoryRegisterForm.html'><button>Alterar Categorias</button></a>
<br><a href='/admin/CategoryRegisterForm.html'><button>Excluir Categorias</button></a>
<br>SubCategorias
<br><a href='/admin/SubCategoryRegisterForm.jsp'><button>Cadastrar SubCategorias</button></a>
<br><a href='/admin/SubCategoryRegisterForm.jsp'><button>Alterar SubCategorias</button></a>
<br><a href='/admin/SubCategoryRegisterForm.jsp'><button>Excluir SubCategorias</button></a>
<br>Produtos
<br><a href='/admin/ProductRegisterForm.jsp'><button>Cadastrar produtos</button></a>
<br><a href='ProductRegisterForm.jsp'><button>Alterar produtos</button></a>
<br><a href='ProductRegisterForm.jsp'><button>Excluir produtos</button></a>
<br>Usuários
<br><a href='ProductRegisterForm.html'><button>Cadastrar usuário</button></a>
<br><a href='ProductRegisterForm.html'><button>Alterar usuário</button></a>
<br><a href='ProductRegisterForm.html'><button>Excluir usuário</button></a>
</body>
</html>