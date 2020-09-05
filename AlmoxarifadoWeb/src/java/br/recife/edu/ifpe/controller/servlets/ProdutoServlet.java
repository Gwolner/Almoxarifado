/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.servlets;

import br.recife.edu.ifpe.model.classes.ItemEstoque;
import br.recife.edu.ifpe.model.classes.Produto;
import br.recife.edu.ifpe.model.repositorios.RepositorioEstoque;
import br.recife.edu.ifpe.model.repositorios.RepositorioProdutos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wolf
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String atualizar = request.getParameter("atualizar");
        String deletar = request.getParameter("deletar");
        String codeAux = request.getParameter("codigo");

        if(deletar != null){
            
            int codigo = Integer.parseInt(codeAux);
            
            Produto p = RepositorioProdutos.getCurrentInstance().read(codigo);
            
            RepositorioProdutos.getCurrentInstance().delete(p);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");
                out.println("</head>");
                out.println("<body>");               
                out.println("<h1>O produto " + p.getNome() + " foi deletado com sucesso!</h1>");              
                out.println("<a href=\"ProdutoServlet\">Produtos</a><br>");
                out.println("<a href=\"cadastroproduto.html\">Novo produto</a><br>");
                out.println("<a href=\"index.html\">Home</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        
        
        if (atualizar != null) {

            int codigo = Integer.parseInt(codeAux);

            Produto p = RepositorioProdutos.getCurrentInstance().read(codigo);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Servlet NewServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Produto Recuperado</h1>");
                out.println("<a href=\"ProdutoServlet\"> << Voltar</a>");

                out.println("<form method=\"post\" action=\"ProdutoServlet\">\n"
                        + "            \n"
                        + "            Código: "+p.getCodigo()+"<br>\n"
                        + "            <input type=\"hidden\" name=\"codigo\" value=\""+p.getCodigo()+"\">\n"
                        + "            Nome: <input type=\"text\" name=\"nome\" value=\""+p.getNome()+"\"><br>\n"
                        + "            Marca: <input type=\"text\" name=\"marca\" value=\""+p.getMarca()+"\"><br>\n"
                        + "            Categoria: <input type=\"text\" name=\"categoria\" value=\""+p.getCategoria()+"\"><br>\n"
                        + "            Descrição: <textarea name=\"descricao\">"+p.getDescricao()+"</textarea><br><br>\n"
                        + "            <input type=\"hidden\" name=\"atualizar\" value=\"1\">"
                        + "            \n"
                        + "            <input type=\"submit\" value=\"Atualizar\">\n"
                        + "        </form> ");

                out.println("</body>");
                out.println("</html>");
            }
        }

        if (codeAux == null && atualizar == null && deletar == null) {

            List<Produto> produtos = RepositorioProdutos.getCurrentInstance().readAll();

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Produto Cadastrados</h1>");
                out.println("<a href=\"index.html\">Home</a>");
                out.println("<a href=\"cadastroproduto.html\">Novo produto</a><br><br>");
                out.println("<table border=\"1\">");
                out.println("<tr><th>Código</th><th>Nome</th><th>Marca</th><th>Categoria</th><th>Operações</th></tr>");
                for (Produto p : produtos) {
                    out.println("<tr>");
                    out.println("<td>" + p.getCodigo() + "</td>");
                    out.println("<td>" + p.getNome() + "</td>");
                    out.println("<td>" + p.getMarca() + "</td>");
                    out.println("<td>" + p.getCategoria() + "</td>");
                    out.println("<td><a href=\"ProdutoServlet?codigo=" + p.getCodigo() + "\">Visualizar </a>"
                            + "<a href=\"ProdutoServlet?codigo=" + p.getCodigo() + "&atualizar=1\">Atualizar <a>"
                            + "<a href=\"ProdutoServlet?codigo=" + p.getCodigo() + "&deletar=1\">Deletar<a></td>");
                    out.println("</tr>");
                }
                out.println("</table><br>");
                out.println("<a href=\"index.html\">Home</a>");
                out.println("</body>");
                out.println("</html>");
            }

        } else {

            int codigo = Integer.parseInt(codeAux);

            Produto p = RepositorioProdutos.getCurrentInstance().read(codigo);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Servlet NewServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Produto Recuperado</h1>");
                out.println("<a href=\"ProdutoServlet\"> << Voltar</a><br><br>");
                out.println("<a href=\"index.html\">Home</a>");
                out.println("Código: " + p.getCodigo() + "<br>");
                out.println("Nome: " + p.getNome() + "<br>");
                out.println("Marca: " + p.getMarca() + "<br>");
                out.println("Categoria: " + p.getCategoria() + "<br>");
                out.println("Descrição: " + p.getDescricao() + "<br>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       

        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        
        String atualizar = request.getParameter("atualizar");
        
        Produto p = new Produto();

        p.setCodigo(codigo);
        p.setNome(nome);
        p.setMarca(marca);
        p.setCategoria(categoria);
        p.setDescricao(descricao);

        if(atualizar != null){
            
            RepositorioProdutos.getCurrentInstance().update(p);
        
        }else{
        
            RepositorioProdutos.getCurrentInstance().create(p);

            ItemEstoque item = new ItemEstoque();
            item.setProduto(p);
            item.setQuantidade(0);
            item.setCodigo(p.getCodigo());

            RepositorioEstoque.getCurrentInstance().read().addItem(item);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if(atualizar != null){
                out.println("<h1>O produto " + p.getNome() + " foi atualizado com sucesso!</h1>");
            }else{
                out.println("<h1>O produto " + p.getNome() + " foi cadastrado com sucesso!</h1>");
            }
            out.println("<a href=\"ProdutoServlet\">Produtos</a><br>");
            out.println("<a href=\"cadastroproduto.html\">Novo produto</a><br>");
            out.println("<a href=\"index.html\">Home</a>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
