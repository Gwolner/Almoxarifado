<%@page import="br.recife.edu.ifpe.model.repositorios.RepositorioFuncionario"%>
<%@page import="br.recife.edu.ifpe.model.classes.Funcionario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>1ª entrega</title>
    </head>
    <body>
        <h1>Funcionários cadastrados</h1>
        
        <%
        String mensagem = (String) session.getAttribute("msg");        
        if(mensagem != null){
            out.println("<h2>"+mensagem+"</h2>");
        }
        %>
        
        <button onclick="modalopen()">Novo funcionário</button>
        <div id="modalFuncionario" style="background-color: pink; position: absolute; top: 200px; left: 200px; border: 1px black solid">
            
            <%@include file="cadastrofuncionario.jsp"%>
            
            <br>
            <button onclick="modalFuncionarioClose()">Fechar</button>
        </div>
            
        <div id="modalFuncionario2" style="background-color: pink; position: absolute; top: 200px; left: 200px; border: 1px black solid">
            
            <%@include file="visualizafuncionario.jsp"%>
            
            <br>
            <button onclick="modalFuncionario2Close()">Fechar</button>
        </div>
        
        <%
        List<Funcionario> funcionarios = RepositorioFuncionario.getCurrentInstance().readAll();
        %>
        
         <table border="1">
            <tr>
                <th>Código</th><th>Nome</th><th>Departamento</th><th>Operações</th>
            </tr>
            
            <%
            for(Funcionario f: funcionarios){
            %>
                <tr>
                    <td><%= f.getCodigo() %></td>
                    <td><%= f.getNome()%></td>
                    <td><%= f.getDepartamento()%></td><!-- Trocar nome visualziar, alterar e deletar por ícones -->
                    <td><a href="FuncionarioServlet?codigo=<%= f.getCodigo() %>&redirect=visualiza">Visualizar </a>
                        <a href="FuncionarioServlet?codigo=<%= f.getCodigo() %>&redirect=atualiza"> Alterar </a>
                        <a href="#" onclick="deleteFuncionario(<%= f.getCodigo() %>)">Deletar</a>
                    </td>
                </tr>
            <%
            }
            %>
        </table>
        
        <script>
            
            var modalFuncionario = document.getElementById("modalFuncionario");
            
            
            
            var modalFuncionario2 = document.getElementById("modalFuncionario2");
            
            <%
            String redirect = request.getParameter("redirect");
            
            if(redirect == null){
            %>
                document.body.removeChild(modalFuncionario);
                document.body.removeChild(modalFuncionario2);
                
            <% }else if(redirect.equals("visualiza")){ %>
                
                document.body.removeChild(modalFuncionario);
                
            <% }else{ %>
                
                document.body.removeChild(modalFuncionario2); 
                
            <% } %>
            
            function modalclose(){
                document.body.removeChild(modalFuncionario);
            }
            
            function modal2close(){
                document.body.removeChild(modalFuncionario2);
            }
            
            function modalopen(){
                document.body.appendChild(modalFuncionario);
            }
            
            function deleteFuncionario(codigo){                
                fetch("FuncionarioServlet?codigo="+codigo,{method:'delete'})
                        .then(function(response){
                            location.reload();
                });
            };
            
        </script>
        
    </body>
</html>
