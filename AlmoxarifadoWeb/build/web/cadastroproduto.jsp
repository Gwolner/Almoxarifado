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
            
            Código: <input type="text" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.codigo:""}"><br>
            Nome: <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.nome:''}"><br>
            Marca: <input type="text" name="marca" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.marca:''}"><br>
            Categoria: <input type="text" name="categoria" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.categoria:''}"><br>
            Descrição: <textarea name="descricao">${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.descricao:''}</textarea><br><br>
            
            <input type="hidden" name="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}" value="1">         
                    
            <input type="submit" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}">
        </form> 
    </body>
</html>
