<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ifpe" uri="br.recife.edu.ifpe.customtags"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="style/general_style.css">
        <title>2ª entrega</title>
        <style>
            .plus{
                font-size: 15pt;
                text-decoration: none;
                color: blue;
                font-weight: bold;
            }
        </style>
    </head>
    <body>        
        <%@include file="template_menu.jsp"%>
        
        <h1 class="titulo-principal">Lote de saída</h1>

        <h3 class="mensagem"><c:out value="${msg}"/></h3>

        <c:remove var="msg" scope="session"/>

        <ifpe:carregaprodutos/>        
        <ifpe:carregafuncionarios/>

        <h2>Produtos cadastrados</h2>

        <table class="tabela" border="1">
            <tr><th>Código</th><th>Nome</th><th>Marca</th><th>Categoria</th><th>Inserir</th></tr>
                    <c:forEach var="pAux" items="${produtos}">
                <tr>
                    <td>${pAux.codigo}</td>
                    <td>${pAux.nome}</td>
                    <td>${pAux.marca}</td>
                    <td>${pAux.categoria}</td>
                    <td><a href="#" class="plus" onclick="adiciona(${pAux.codigo})"> +</a></td>
                </tr>
            </c:forEach>                
        </table>
 
        <c:if test="${loteSaida != null}"><br><br>
            <h2>Produtos inseridos no lote de saida</h2>

            <table class="tabela" border="1">
                <tr><th>Código</th><th>Nome</th><th>Marca</th><th>Categoria</th><th>Quantidade</th><th>Inserir</th></tr>
                <c:forEach var="i" items="${loteSaida.itens}">
                    <tr>
                        <td>${i.produto.codigo}</td>
                        <td>${i.produto.nome}</td>
                        <td>${i.produto.marca}</td>
                        <td>${i.produto.categoria}</td>
                        <td>${i.quantidade}</td>
                        <td><a href="#" class="plus" onclick="diminui(${i.produto.codigo})"> -</a> |
                            <a href="#" class="plus" onclick="adiciona(${i.produto.codigo})">+</a></td>
                    </tr>
                </c:forEach>                
            </table><br><br>
            
            <!--Lista os possiveis responsáveis pela retirada do produto do estoque -->
            <h2>Responsável pela retirada</h2>
        
            <table class="tabela" border="1">
                <tr><th>Código</th><th>Nome</th><th>Departamento</th><th>Responsabilizar</th></tr>
                <c:forEach var="f" items="${funcionarios}">
                         <tr>
                            <td>${f.codigo}</td>
                            <td>${f.nome}</td>
                            <td>${f.departamento}</td>
                            <!--Chama método que associa o responsável ao produto-->
                            <td><a href="#" class="job" onclick="associarFuncionario(${f.codigo})"><i class="fa fa-id-card-o" aria-hidden="true"></i></a></td>
                         </tr>
                </c:forEach>            
            </table>
            
            <button class="btn" onclick="cadastrar()">Cadastrar</button>
        </c:if>

        <script>
            function adiciona(codigo) {
                fetch("LoteSaidaServlet?operacao=mais&codigo=" + codigo, {method: "put"})
                        .then(function () {
                            location.reload();
                        });
            }

            function diminui(codigo) {
                fetch("LoteSaidaServlet?operacao=menos&codigo=" + codigo, {method: "put"})
                        .then(function () {
                            location.reload();
                        });
            }

            function cadastrar() {
                fetch("LoteSaidaServlet", {method: "post"})
                        .then(function (response) {

                            if (response.status === 500) {
                                location.reload();
                            } else {
                                location.href = "lotesaidaapresentacao.jsp";
                            }
                        }).catch(function (erro) {
                    location.reload();
                });
            }
            
//            Requisição assincrona para associar o funcionário ao produto
            function associarFuncionario(codigo) {
                fetch("LoteSaidaServlet?operacao=neutra&codigo=" + codigo, {method: "put"})
                        .then(function () {
                            location.reload();
                        });
            }
        </script>
    </body>
</html>
