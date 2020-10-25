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
        
        <h1 class="titulo-principal">Lotes inseridos</h1>

        <h3 class="mensagem"><c:out value="${msg}"/></h3>
        <c:remove var="msg" scope="session"/>

        <ifpe:carregaloteentrada/>
         
        <table class="tabela" border='1'>
            <tr><th>Data</th><th>Hora</th><th>Código</th><th>Quant.Total</th><th>Itens</th></tr>
            <c:forEach var="item" items="${lotesEntradaInseridos}">

                <tr>
                    <td><fmt:formatDate dateStyle="short" timeStyle="short" value="${item.data}" type="date"/></td>
                    <td><fmt:formatDate value="${item.data}" type="time"/></td>
                    <td>${item.codigo}</td>
                    <td>${item.quantidadeTotal}</td>
                    <td><a href='#' onclick="carregaItens(${item.codigo})"><i class="fa fa-eye" aria-hidden="true"></i></a></td>
                </tr>

            </c:forEach>
        </table>

        <script>

            var meuDiv;

            function carregaItens(codigo) {

                fetch("LoteEntradaServlet?codigo=" + codigo, {method: "get"}).then(function (response) {
                    response.text().then(function (text) {
                        let objeto = JSON.parse(text);

                        meuDiv = document.createElement("div");
                        meuDiv.setAttribute("class", "modal-css");

                        document.body.appendChild(meuDiv);

//                        meuDiv.innerHTML = objeto.codigo + "<br>" + objeto.descricao + "<br>";
                        meuDiv.innerHTML = "<br><br>";

                        let tabela = document.createElement("table");
                        tabela.setAttribute("border", "1");
                        tabela.setAttribute("class", "tabela-interna");

                        meuDiv.appendChild(tabela);
                        
                        //Criando header da tabela                          
                        let tr = document.createElement("tr");
                        let th1 = document.createElement("th");
                        th1.innerHTML = "Código";
                        let th2 = document.createElement("th");
                        th2.innerHTML = "Item";
                        let th3 = document.createElement("th");
                        th3.innerHTML = "Quant.";
                        
                        tr.appendChild(th1);
                        tr.appendChild(th2);
                        tr.appendChild(th3);
                        
                        tabela.appendChild(tr);
                        //Fim do header da tabela
                        
                        for (let i = 0; i < objeto.itens.length; i++) {
                            let tr = document.createElement("tr");
                            let td1 = document.createElement("td");
                            td1.innerHTML = objeto.itens[i].codigo;
                            let td2 = document.createElement("td");
                            td2.innerHTML = objeto.itens[i].nomeProduto;
                            let td3 = document.createElement("td");
                            td3.innerHTML = objeto.itens[i].quantidade;

                            tr.appendChild(td1);
                            tr.appendChild(td2);
                            tr.appendChild(td3);
                            tabela.appendChild(tr);
                        }

                        let botao = document.createElement("button");
                        botao.setAttribute("class", "btn-close");
                        botao.appendChild(document.createTextNode("X"));

                        meuDiv.appendChild(botao);

                        botao.addEventListener("click", function () {
                            document.body.removeChild(meuDiv);
                            meuDiv = "";
                        });

                    });
                });
            }

        </script>
    </body>
</html>
