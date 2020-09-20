package br.recife.edu.ifpe.controller.servlets.jsp;

import br.recife.edu.ifpe.model.classes.Funcionario;
import br.recife.edu.ifpe.model.repositorios.RepositorioFuncionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ListFuncionarioServlet", urlPatterns = {"/ListFuncionarioServlet"})
public class ListFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Lista funcionários cadastrados e devolve a resposta na sessão
        List<Funcionario> funcionarios = RepositorioFuncionario.getCurrentInstance().readAll();
        
        HttpSession session = request.getSession();
        session.setAttribute("listaDeFuncionarios", funcionarios);
        
        //response.sendRedirect("funcionario.jsp");
        getServletContext().getRequestDispatcher("/funcionario.jsp").forward(request, response);
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       
    }

}
