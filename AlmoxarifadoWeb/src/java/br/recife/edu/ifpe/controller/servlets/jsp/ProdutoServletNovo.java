package br.recife.edu.ifpe.controller.servlets.jsp;

import br.recife.edu.ifpe.model.classes.ItemEstoque;
import br.recife.edu.ifpe.model.classes.Produto;
import br.recife.edu.ifpe.model.repositorios.RepositorioEstoque;
import br.recife.edu.ifpe.model.repositorios.RepositorioProdutos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProdutoServletNovo", urlPatterns = {"/ProdutoServletNovo"})
public class ProdutoServletNovo extends HttpServlet {

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        //String redirect = request.getParameter("redirect"); 
        //Quem vai ler esse redirect é a página de cadastro ou de visualzição!
        
        Produto p = RepositorioProdutos.getCurrentInstance().read(codigo);
        
        request.setAttribute("produto", p);
        
        getServletContext().getRequestDispatcher("/produto.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        
        String a = request.getParameter("atualizar");
        
        Produto p = new Produto();
        
        Produto prodAux = RepositorioProdutos.getCurrentInstance().read(codigo);
                
        p.setCodigo(codigo);
        p.setNome(nome);
        p.setMarca(marca);
        p.setCategoria(categoria);
        p.setDescricao(descricao);
        
        if(a == null && prodAux == null){
            RepositorioProdutos.getCurrentInstance().create(p);

            ItemEstoque item = new ItemEstoque();
            item.setProduto(p);
            item.setQuantidade(0);
            item.setCodigo(p.getCodigo());

            RepositorioEstoque.getCurrentInstance().read().addItem(item);

            session.setAttribute("msg", "Produto " + p.getNome() + " cadastrado com sucesso!");
        }else if(a != null){
            RepositorioProdutos.getCurrentInstance().update(p);
        
            session.setAttribute("msg", "Produto " + p.getNome() + " atualizado com sucesso!");
        }else{
            session.setAttribute("msg", "Código " + p.getCodigo() + " já está cadastrado!");
        }     
        
        response.sendRedirect("produto.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response);        
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        HttpSession session = request.getSession();
        
        Produto p = RepositorioProdutos.getCurrentInstance().read(codigo);
        
        session.setAttribute("msg", "O produto "+p.getNome()+" foi deletado!");
        
        RepositorioProdutos.getCurrentInstance().delete(p);
        
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
