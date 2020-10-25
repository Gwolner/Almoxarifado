<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ifpe" uri="br.recife.edu.ifpe.customtags" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="style/general_style.css">
        <title>2ª entrega</title>
    </head>
    <body>
        <%@include file="template_menu.jsp"%>
        
        <h1 class="titulo-principal">Produtos em estoque</h1>

        <ifpe:carregaestoque/>
        
        <table class="tabela" border="1">
            <tr><th>Código do produto</th><th>Nome do produto</th><th>Quant. em estoque</th></tr>
            
            <c:forEach var="item" items="${estoque.itens}">
                <tr>
                    <td><c:out value="${item.codigo}"/></td>
                    <td><c:out value="${item.produto.nome}"/></td>
                    <td><c:out value="${item.quantidade}"/></td>
                </tr>
            </c:forEach>
            
        </table>
       
        
    </body>
</html>
