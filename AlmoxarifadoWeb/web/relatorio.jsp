<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ifpe" uri="br.recife.edu.ifpe.customtags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/font-awesome-4.7.0/css/font-awesome.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Relatório geral de lotes</h1>

            <!--Exibe os lotes de entrada e de saida em uma tabela peculiar, 
            conforme ordem que foram adicionados ao longo do tempo no sistema -->
            <table border="1">
                <tr>
                    <tr>
                        <th>Data</th><th>Hora</th><th>Responsavel</th>
                    </tr>
                        <th>Código</th><th>Nome</th><th>Marca</th><th>Categoria</th><th>Quantidade</th>
                </tr>
                <c:forEach var="lote" items="${relatorio.lotes}">
                    <tr>                        
                        <td><fmt:formatDate dateStyle="short" timeStyle="short" value="${lote.data}" type="date"/></td>
                        <td><fmt:formatDate dateStyle="short" timeStyle="short" value="${lote.data}" type="time"/></td>
                        <c:if test="${param.lote.responsavel == null}">
                            <td> Lote de entrada </td>
                        </c:if>
                        <c:if test="${param.lote.responsavel != null}">
                            <td>${lote.responsavel.nome}</td>
                        </c:if>
                    </tr>
                    <c:forEach var="i" items="${lote.itens}">
                        <tr>
                            
                            <td>${i.produto.codigo}</td>
                            <td>${i.produto.nome}</td>
                            <td>${i.produto.marca}</td>
                            <td>${i.produto.categoria}</td>
                            <td>${i.quantidade}</td>                             
                        </tr>
                    </c:forEach> 
                </c:forEach>
            </table>
    </body>
</html>
