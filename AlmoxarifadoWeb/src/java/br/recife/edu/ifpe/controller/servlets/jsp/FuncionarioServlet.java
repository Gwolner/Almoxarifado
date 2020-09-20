package br.recife.edu.ifpe.controller.servlets.jsp;

import br.recife.edu.ifpe.model.classes.Funcionario;
import br.recife.edu.ifpe.model.classes.ItemEstoque;
import br.recife.edu.ifpe.model.classes.LoteSaida;
import br.recife.edu.ifpe.model.classes.Produto;
import br.recife.edu.ifpe.model.repositorios.RepositorioEstoque;
import br.recife.edu.ifpe.model.repositorios.RepositorioFuncionario;
import br.recife.edu.ifpe.model.repositorios.RepositorioProdutos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        Funcionario f = RepositorioFuncionario.getCurrentInstance().read(codigo);
        
        request.setAttribute("funcionario", f);
        
        getServletContext().getRequestDispatcher("/funcionario.jsp").forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String departamento = request.getParameter("departamento");
        
        String atualizarFuncionario = request.getParameter("atualizar");
        
        Funcionario f = new Funcionario();
        
        f.setCodigo(codigo);
        f.setNome(nome);
        f.setDepartamento(departamento);
        
        HttpSession session = request.getSession();
        
        if(atualizarFuncionario == null){
            RepositorioFuncionario.getCurrentInstance().create(f);

            LoteSaida ls = new LoteSaida();
            ls.setCodigo(f.getCodigo());
            ls.setResponsavel(f);            

            RepositorioFuncionario.getCurrentInstance().create(f);

            session.setAttribute("msg", "Funcionário " + f.getNome() + " cadastrado com sucesso!");
        }else{
            RepositorioFuncionario.getCurrentInstance().update(f);
        
            session.setAttribute("msg", "Funcionário " + f.getNome() + " atualizado com sucesso!");
        }
        response.sendRedirect("funcionario.jsp");
        
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response);        
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        HttpSession session = request.getSession();
        
        Funcionario f = RepositorioFuncionario.getCurrentInstance().read(codigo);
        
        session.setAttribute("msg", "O Funcionário "+f.getNome()+" foi deletado!");
        
        RepositorioFuncionario.getCurrentInstance().delete(f);
    }
    
}
