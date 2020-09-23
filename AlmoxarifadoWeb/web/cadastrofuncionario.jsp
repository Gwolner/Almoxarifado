<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/font-awesome-4.7.0/css/font-awesome.min.css">
        <title>1ª entrega</title>
    </head>
    <body>
        <h1 class="titulo-interno">${(param.redirect != null && param["redirect"] eq 'atualiza')?'Atualização':'Cadastro'} de funcionário</h1>        

        <a href="funcionario.jsp?redirect=fecha"><button class="btn-close" onclick="modalclose()"><i class="fa fa-times" aria-hidden="true"></i></button></a><br><br>

        <form class="form-entrada" method="post" action="FuncionarioServlet">

            <!--Aceita apenas números e também se torna apenas de leitura (readonly) durante edição de campos-->
            <label>Código: </label><br>
            <input required type="number" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?funcionario.codigo:""}" ${(param.redirect != null && param["redirect"] eq 'atualiza')?'readonly':''}><br>
            
            <label>Nome: </label><br>
            <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?funcionario.nome:''}"><br>
            <label>Departamento: </label><br>
            <input type="text" name="departamento" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?funcionario.departamento:''}"><br>

            <input type="hidden" name="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}" value="1">         
            
            <!--Só da submit se o campo Código for preenchido-->
            <input class="btn-ok" type="submit" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?'Atualizar':'Cadastrar'}">

        </form> 
    </body>
</html>
