<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ifpe" uri="br.recife.edu.ifpe.customtags" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Produtos inseridos no Estoque</h1>
        <a href="index.html">home</a><br/>
        
        <ifpe:carregaestoque/>
        
        <table border="1">
            <tr><td>Código</td><td>nome do produto</td><td>quantidade em estoque</td></tr>
            
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
