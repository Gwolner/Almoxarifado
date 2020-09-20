<%@page import="br.recife.edu.ifpe.model.classes.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>1ª entrega</title>
    </head>
    <body>
        <h1>Funcionário Cadastrado</h1>
        
        <%
        Funcionario func = (Funcionario) request.getAttribute("funcionario");
        if(func != null){
        %>
        
        <table border="1">
            <tr>
                <th>Código</th><td><%= func.getCodigo() %></td>
            </tr>
            <tr>
                <th>Nome</th><td><%= func.getNome() %></td>
            </tr>
            <tr>
                <th>Departamento</th><td><%= func.getDepartamento()%></td>
            </tr>
        </table>
        <%
        }
        %> 
    </body>
</html>
