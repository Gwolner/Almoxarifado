<%@page import="br.recife.edu.ifpe.model.classes.Produto"%>
<%@page import="java.util.List"%>
<%@page import="br.recife.edu.ifpe.model.repositorios.RepositorioProdutos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Produtos cadastrados</h1>
        
        <%
        String mensagem = (String) session.getAttribute("msg");        
        if(mensagem != null){
            out.println("<h2>"+mensagem+"</h2>");
            //session.removeAttribute("msg");
        }
        %>
        
        <button onclick="modalopen()">Novo produto</button>
        <div id="modal" style="background-color: pink; position: absolute; top: 200px; left: 200px; border: 1px black solid">
            
            <%@include file="cadastroproduto.jsp"%>
            
            <br>
            <button onclick="modalclose()">Fechar</button>
        </div>
            
        <div id="modal2" style="background-color: pink; position: absolute; top: 200px; left: 200px; border: 1px black solid">
            
            <%@include file="visualizaproduto.jsp"%>
            
            <br>
            <button onclick="modal2close()">Fechar</button>
        </div>
        
        <%
        List<Produto> produtos = RepositorioProdutos.getCurrentInstance().readAll();
        %>
            
        <table border="1">
            <tr>
                <th>Código</th><th>Nome</th><th>Marca</th><th>Categoria</th><th>Operações</th>
            </tr>
            
            <%
            for(Produto p: produtos){
            %>
                <tr>
                    <td><%= p.getCodigo() %></td>
                    <td><%= p.getNome()%></td>
                    <td><%= p.getMarca()%></td>
                    <td><%= p.getCategoria()%></td> <!-- Trocar nome visualziar, alterar e deletar por ícones -->
                    <td><a href="ProdutoServletNovo?codigo=<%= p.getCodigo() %>&redirect=visualiza">Visualizar </a>
                        <a href="ProdutoServletNovo?codigo=<%= p.getCodigo() %>&redirect=atualiza"> Alterar </a>
                        <a href="#" onclick="deleteProduto(<%= p.getCodigo() %>)">Deletar</a>
                    </td>
                </tr>
            <%
            }
            %>
        </table>
            
        <script>
            
            var modal = document.getElementById("modal");
            
            
            
            var modal2 = document.getElementById("modal2");
            
            <%
            String redirect = request.getParameter("redirect");
            
            if(redirect == null){
            %>
                document.body.removeChild(modal);
                document.body.removeChild(modal2);
                
            <% }else if(redirect.equals("visualiza")){ %>
                
                document.body.removeChild(modal);
                
            <% }else{ %>
                
                document.body.removeChild(modal2); 
                
            <% } %>
            
            function modalclose(){
                document.body.removeChild(modal);
            }
            
            function modal2close(){
                document.body.removeChild(modal2);
            }
            
            function modalopen(){
                document.body.appendChild(modal);
            }
            
            function deleteProduto(codigo){                
                fetch("ProdutoServletNovo?codigo="+codigo,{method:'delete'})
                        .then(function(response){
                            location.reload();
                });
            };
            
        </script>       
    </body>
</html>
