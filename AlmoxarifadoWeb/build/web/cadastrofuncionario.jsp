<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>1ª entrega</title>
    </head>
    <body>
        <h1>Cadastro de funcionários</h1>
        
        <a href="index.html"> << Voltar</a><br><br>
        
        <form method="post" action="FuncionarioServlet">
            
            Código: <input type="text" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?funcionario.codigo:""}"><br>
            Nome: <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?funcionario.nome:''}"><br>
            Departamento <input type="text" name="departamento" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?funcionario.departamento:''}"><br>
           
            <input type="hidden" name="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}" value="1">         
                    
            <input type="submit" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}">
        </form> 
    </body>
</html>
