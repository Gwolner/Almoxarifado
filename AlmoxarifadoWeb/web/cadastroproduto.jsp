<%-- 
    Document   : cadastroproduto
    Created on : 06/09/2020, 19:55:36
    Author     : Wolf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de produtos</h1>
        
        <a href="index.html"> << Voltar</a><br><br>
        
        <form method="post" action="ProdutoServletNovo">
            
            Código: <input type="text" name="codigo"><br>
            Nome: <input type="text" name="nome"><br>
            Marca: <input type="text" name="marca"><br>
            Categoria: <input type="text" name="categoria"><br>
            Descrição: <textarea name="descricao"></textarea><br><br>
            
            <input type="submit" value="Cadastrar">
        </form> 
    </body>
</html>
