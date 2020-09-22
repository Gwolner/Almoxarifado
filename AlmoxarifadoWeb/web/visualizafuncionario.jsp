<%@page import="br.recife.edu.ifpe.model.classes.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/font-awesome-4.7.0/css/font-awesome.min.css">
        <title>1ª entrega</title>
    </head>
    <body>
        <h1 class="titulo-interno">Detalhes do funcionário</h1>

        <a href="funcionario.jsp?redirect=fecha"><button class="btn-close" onclick="modal2close()"><i class="fa fa-times" aria-hidden="true"></i></button></a>

        <%
            Funcionario func = (Funcionario) request.getAttribute("funcionario");
            if (func != null) {
        %>
        <div class="div-tabela-interna">
            <table class="tabela-interna" border="1">
                <tr>
                    <th>Código</th><td><%= func.getCodigo()%></td>
                </tr>
                <tr>
                    <th>Nome</th><td><%= func.getNome()%></td>
                </tr>
                <tr>
                    <th>Departamento</th><td><%= func.getDepartamento()%></td>
                </tr>
            </table>
        </div>    
        <%
            }
        %> 
    </body>
</html>
