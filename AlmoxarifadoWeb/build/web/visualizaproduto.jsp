<%@page import="br.recife.edu.ifpe.model.classes.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/font-awesome-4.7.0/css/font-awesome.min.css">
        <title>1ª entrega</title>
    </head>
    <body>
        <h1 class="titulo-interno">Detalhes do produto</h1>

        <a href="produto.jsp?redirect=fecha"><button class="btn-close" onclick="modal2close()"><i class="fa fa-times" aria-hidden="true"></i></button></a>

        <%
            Produto produto = (Produto) request.getAttribute("produto");
            if (produto != null) {
        %>
        <div class="div-tabela-interna">
            <table class="tabela-interna" border="1">
                <tr>
                    <th>Código</th><td><%= produto.getCodigo()%></td>
                </tr>
                <tr>
                    <th>Nome</th><td><%= produto.getNome()%></td>
                </tr>
                <tr>
                    <th>Marca</th><td><%= produto.getMarca()%></td>
                </tr>
                <tr>
                    <th>Categoria</th><td><%= produto.getCategoria()%></td>
                </tr>
                <tr>
                    <th>Descrição</th><td><%= produto.getDescricao()%></td>
                </tr>
            </table>
        </div>
        <%
            }
        %> 
    </body>
</html>
