<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/font-awesome-4.7.0/css/font-awesome.min.css">
        <title>1ª entrega</title>
    </head>
    <body>
        <h1 class="titulo-interno">Cadastro de produtos</h1>

        <a href="produto.jsp?redirect=fecha"><button class="btn-close" onclick="modalclose()"><i class="fa fa-times" aria-hidden="true"></i></button></a><br><br>

        <form class="form-entrada" method="post" action="ProdutoServletNovo">

            <label>Código: </label><br>
            <input type="text" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.codigo:""}"><br>
            <label>Nome: </label><br>
            <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.nome:''}"><br>
            <label>Marca: </label><br>
            <input type="text" name="marca" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.marca:''}"><br>
            <label>Categoria: </label><br>
            <input type="text" name="categoria" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.categoria:''}"><br>
            <label>Descrição: </label><br>
            <textarea name="descricao">${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.descricao:''}</textarea><br><br>

            <input type="hidden" name="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}" value="1">         

            <input  class="btn-ok" type="submit" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}">
        </form> 
    </body>
</html>
