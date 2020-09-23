<%@page import="br.recife.edu.ifpe.model.classes.Produto"%>
<%@page import="java.util.List"%>
<%@page import="br.recife.edu.ifpe.model.repositorios.RepositorioProdutos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="style/general_style.css">
        <title>1ª entrega</title>
    </head>
    <body>
        <%@include file="template_menu.jsp"%>

        <h1 class="titulo-principal">Produtos cadastrados</h1>

        <%
            String mensagem = (String) session.getAttribute("msg");
            if (mensagem != null) {
                out.println("<h2 class='mensagem'>" + mensagem + "</h2>");
                session.removeAttribute("msg");
            }
        %>

        <button class="btn" onclick="modalopen()">Novo produto</button> 

        <div id="modal" class="modal-css">

            <%@include file="cadastroproduto.jsp"%>

            <!--<br>-->            
        </div>

        <div id="modal2" class="modal-css">

            <%@include file="visualizaproduto.jsp"%>

            <!--<br>-->            
        </div>

        <%  
            List<Produto> produtos = RepositorioProdutos.getCurrentInstance().readAll();
            if (produtos.size() != 0) {
        %>
        
        <table class="tabela" border="1">
            <tr>
                <th>Código</th><th>Nome</th><th>Marca</th><th>Categoria</th><th>Operações</th>
            </tr>

            <%
                for (Produto p : produtos) {
            %>
            <tr>
                <td><%= p.getCodigo()%></td>
                <td><%= p.getNome()%></td>
                <td><%= p.getMarca()%></td>
                <td><%= p.getCategoria()%></td> <!-- Trocar nome visualziar, alterar e deletar por ícones -->
                <td><a href="ProdutoServletNovo?codigo=<%= p.getCodigo()%>&redirect=visualiza"><i class="fa fa-eye icon" aria-hidden="true"></i></a>
                    <a href="ProdutoServletNovo?codigo=<%= p.getCodigo()%>&redirect=atualiza"><i class="fa fa-pencil icon" aria-hidden="true"></i></a>
                    <a href="#" onclick="deleteProduto(<%= p.getCodigo()%>)"><i class="fa fa-trash icon" aria-hidden="true"></i></a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            }else{
                out.println("<h2 class='no-table'> Nenhum cadastro realizado até o momento. </h2>");
            }
        %>
        
        
        <script>

            var modal = document.getElementById("modal");

            var modal2 = document.getElementById("modal2");

            <%
                String redirect = request.getParameter("redirect");

                if (redirect == null) {
            %>
            document.body.removeChild(modal);
            document.body.removeChild(modal2);

            <% } else if (redirect.equals("visualiza")) { %>

            document.body.removeChild(modal);

            <% } else if (redirect.equals("atualiza")) { %>

            document.body.removeChild(modal2);

            <% } else { %>

            document.body.removeChild(modal);
            document.body.removeChild(modal2);

            <% }%>

            function modalclose() {
                document.body.removeChild(modal);
            }

            function modal2close() {
                document.body.removeChild(modal2);
            }

            function modalopen() {
                document.body.appendChild(modal);
            }

            function deleteProduto(codigo) {
                fetch("ProdutoServletNovo?codigo=" + codigo, {method: 'delete'})
                        .then(function (response) {
                            location.reload();
                        });
            }
            ;

        </script>       
    </body>
</html>
