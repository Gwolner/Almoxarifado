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
        <%@include file="template_menu.jsp"%>

        <h1 class="titulo-principal">Funcionários cadastrados</h1>

        <% //Verifica se há mensagem
            String mensagem = (String) session.getAttribute("msg");
            if (mensagem != null) {
        %>

        <h2 class="mensagem"> <%= mensagem%> </h2>

        <%
                session.removeAttribute("msg");
            }

            //Verifica se há funciononários listados
            List<Funcionario> listaDeFuncionarios = (List<Funcionario>) session.getAttribute("listaDeFuncionarios");
            if (listaDeFuncionarios == null) {
                response.sendRedirect("/AlmoxarifadoWeb/ListFuncionarioServlet");
            }
        %>

        <button class="btn" onclick="modalopen()">Novo funcionário</button>

        <div id="modal" class="modal-css">
            <%@include file="cadastrofuncionario.jsp"%>
        </div>

        <div id="modal2" class="modal-css">
            <%@include file="visualizafuncionario.jsp"%>
        </div>

        <%  //Esta abaixo responsabilidade passou a ser do servlet e não mais do front.
            //List<Funcionario> funcionarios = RepositorioFuncionario.getCurrentInstance().readAll();
            
            //Apenas exibe a tabela se houver funcionário cadastrado
            if(listaDeFuncionarios!= null && listaDeFuncionarios.size() != 0) {
        %>

        <table class="tabela" border="1">
            <tr>
                <th>Código</th><th>Nome</th><th>Departamento</th><th>Operações</th>
            </tr>

            <%
                for (Funcionario f : listaDeFuncionarios) {
            %>
            <tr>
                <td><%= f.getCodigo()%></td>
                <td><%= f.getNome()%></td>
                <td><%= f.getDepartamento()%></td>
                <td><a href="FuncionarioServlet?codigo=<%= f.getCodigo()%>&redirect=visualiza"><i class="fa fa-eye icon" aria-hidden="true"></i></a>
                    <a href="FuncionarioServlet?codigo=<%= f.getCodigo()%>&redirect=atualiza"><i class="fa fa-pencil icon" aria-hidden="true"></i></a>
                    <a href="#" onclick="deleteFuncionario(<%= f.getCodigo()%>)"><i class="fa fa-trash icon" aria-hidden="true"></i></a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            //Exibe mensagem caso não haja itens cadastrados
            } else {
                out.println("<h2 class='no-table'> Nenhum cadastro realizado até o momento. </h2>");
            }
        %>

        <!--Este include substitui o <script> para que se separem as responsabilidades de frontend.
        Como não foi possivel importar um arquivo .js pois ele não suporta as tags JSP, decidi
        incluir um arquivo jsp contendo código js dentro.--> 
        <%@include file="script/funcionario_script.jsp"%>

    </body>
</html>
