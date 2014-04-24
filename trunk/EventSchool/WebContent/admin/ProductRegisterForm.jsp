<%@page import="java.util.Iterator"%>
<%@page import="DB.CategoryDAO"%>
<%@page import="models.Category"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produtos</title>
<script src="/CarrinhoDeCompras/js/jquery-1.3.2.min.js" type="text/javascript"></script>

<script type="text/javascript">
        $(document).ready(function(){
        	$('#caixaSubCategoria').load('/CarrinhoDeCompras/subCategoryList?idCategoria='+$('#categorias').val() );
            $('#categorias').change(function(){
                $('#caixaSubCategoria').load('/CarrinhoDeCompras/subCategoryList?idCategoria='+$('#categorias').val() );

            });
        });

    </script>


</head>
<body>
	<h3><i>Cadastro de Produtos</i></h3>
	<form enctype="multipart/form-data" action="/registerProduct" method="POST">
		Descrição: <input type="text" name="descricao"/><br>
		Valor Atual: <input type="text" name="valorAtual"/><br>
		Valor Anterior: <input type="text" name="valorAnterior"/><br>
		Quantidade em Estoque: <input type="text" name="quantidadeEstoque"/><br>
		Categoria: <select name="categorias" id="categorias">
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
		SubCategoria: <select name="caixaSubCategoria" id="caixaSubCategoria"></select><br>
		Em destaque: <input name= "emDestaque" type="checkbox"/><br>
		Selecionar Foto: <input type="file" name="foto"/><br> 
				
		<input type="submit" value="Registrar" />
	</form>
</body>
</html>