<%@page import="java.util.Iterator"%>
<%@page import="models.Category"%>
<%@page import="java.util.List"%>
<%@page import="DB.CategoryDAO"%>
<%@page import="models.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><i>Cadastro de SubCategoria</i></h3>
	<form action="/registerSubCategory" method="POST">
		Selecione uma categoria: <select name="categorias" id="categorias">
									<% 
									
									List<Category> categories = CategoryDAO.getCategories();
									if(categories != null){
										Iterator<Category> it = categories.iterator();
										while(it.hasNext()){
											Category category = it.next();
											out.println("<option value='"+ category.getId() +"'> "+ category.getNome()+"</option>");
										}
									}
									else{
										out.println("<option>Nenhuma categoria cadastrada</option>");
									}
										
									%>
									</select><br>
		Nome da SubCategoria:	<input type="text" name="nomeSubCategoria"><br>		
		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>