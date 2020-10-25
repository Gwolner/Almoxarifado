<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ifpe" uri="br.recife.edu.ifpe.customtags"%>

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
        
        <h1 class="titulo-principal">Relatório geral de lotes</h1>
	
	<ifpe:carregarelatorio/>

            <!--Exibe os lotes de entrada e de saida em uma tabela peculiar, 
            conforme ordem que foram adicionados ao longo do tempo no sistema -->
            <table class="tabela" border="1">
                <tr>
                    <th>Data</th><th>Hora</th><th>Responsavel</th>
                    <th>Código</th><th>Nome</th><th>Marca</th><th>Categoria</th><th>Quantidade</th>
                </tr>
                <c:forEach var="lote" items="${relatorio.lotes}">
                    <tr>                        
                        <td rowspan="${lote.itens.size()}"><fmt:formatDate dateStyle="short"  value="${lote.data}" type="date"/></td>
                        <td rowspan="${lote.itens.size()}"><fmt:formatDate value="${lote.data}" type="time"/></td>
                        
                        <!--Condicional com dois JSTL IF por não haver ELSE-->
                        <c:if test="${lote.responsavel.nome == null}">
                            <!--Se não ha responsável, só pode ser lote de entrada-->
                            <td rowspan="${lote.itens.size()}"> ~Entrada~ </td>
                        </c:if>
                        <c:if test="${lote.responsavel.nome != null}">
                            <!--Se houver responsável ele é impresso na tela-->
                            <td rowspan="${lote.itens.size()}">${lote.responsavel.nome}</td>
                        </c:if>
<!--                    </tr>
                    <tr>-->
                        <c:forEach var="i" items="${lote.itens}">
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
