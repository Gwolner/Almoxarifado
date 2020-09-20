<%@page import="br.recife.edu.ifpe.model.repositorios.RepositorioFuncionario"%>
<%@page import="br.recife.edu.ifpe.model.classes.Funcionario"%>
<%@page import="java.util.List"%>
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
        <h1>Funcionários cadastrados</h1>
        
        <% //Verifica se há mensagem
        String mensagem = (String) session.getAttribute("msg");        
        if(mensagem != null){
        %>
            <h2> <%= mensagem %> </h2>
        <%    
            session.removeAttribute("msg");
        }
        
        //Verifica se há funciononários listados
        List<Funcionario> listaDeFuncionarios = (List<Funcionario>) session.getAttribute("listaDeFuncionarios");
        if(listaDeFuncionarios == null){
            response.sendRedirect("/AlmoxarifadoWeb/ListFuncionarioServlet");
        }
        %>
        
        <button onclick="modalopen()">Novo funcionário</button>
        <div id="modalFuncionario" class="modal">
            
            <%@include file="cadastrofuncionario.jsp"%>
            
            <br>
            <button onclick="modalclose()">Fechar</button>
        </div>
            
        <div id="modalFuncionario2" class="modal">
            
            <%@include file="visualizafuncionario.jsp"%>
            
            <br>
            <button onclick="modal2close()">Fechar</button>
        </div>
        
        <%--
        List<Funcionario> funcionarios = RepositorioFuncionario.getCurrentInstance().readAll();
        --%>
        
         <table border="1">
            <tr>
                <th>Código</th><th>Nome</th><th>Departamento</th><th>Operações</th>
            </tr>
            
            <%
            if(listaDeFuncionarios != null){
                for(Funcionario f: listaDeFuncionarios){
            %>
                    <tr>
                        <td><%= f.getCodigo() %></td>
                        <td><%= f.getNome()%></td>
                        <td><%= f.getDepartamento()%></td>
                        <td><a href="FuncionarioServlet?codigo=<%= f.getCodigo() %>&redirect=visualiza"><i class="fa fa-eye icon" aria-hidden="true"></i></a>
                            <a href="FuncionarioServlet?codigo=<%= f.getCodigo() %>&redirect=atualiza"><i class="fa fa-pencil icon" aria-hidden="true"></i></a>
                            <a href="#" onclick="deleteFuncionario(<%= f.getCodigo() %>)"><i class="fa fa-trash icon" aria-hidden="true"></i></a>
                        </td>
                    </tr>
            <%
                }
            }
            %>
        </table>
        
        <!--Este include substitui o <script> para que se separem as responsabilidades de frontend.
        Como não foi possivel importar um arquivo .js pois ele não suporta as tags JSP, decidi
        incluir um arquivo jsp eterno contendo código js dentro.--> 
        <%@include file="script/funcionario_script.jsp"%>
        
    </body>
</html>
