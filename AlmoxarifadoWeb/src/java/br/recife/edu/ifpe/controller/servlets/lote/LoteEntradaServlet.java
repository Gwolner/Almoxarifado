package br.recife.edu.ifpe.controller.servlets.lote;

import br.recife.edu.ifpe.model.classes.Estoque;
import br.recife.edu.ifpe.model.classes.ItemEntrada;
import br.recife.edu.ifpe.model.classes.ItemEstoque;
import br.recife.edu.ifpe.model.classes.LoteEntrada;
import br.recife.edu.ifpe.model.classes.Produto;
import br.recife.edu.ifpe.model.repositorios.RepositorioEstoque;
import br.recife.edu.ifpe.model.repositorios.RepositorioLoteEntrada;
import br.recife.edu.ifpe.model.repositorios.RepositorioProdutos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoteEntradaServlet", urlPatterns = {"/LoteEntradaServlet"})
public class LoteEntradaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codigo = Integer.parseInt(request.getParameter("codigo"));

        LoteEntrada loteEntrada = RepositorioLoteEntrada.getCurrentInstance().read(codigo);

        String responseJSON = "{\"codigo\":" + loteEntrada.getCodigo() + ","
                + "\"descricao\":\"" + loteEntrada.getDescricao() + "\",\"itens\":[";
        for (ItemEntrada item : loteEntrada.getItens()) {
            responseJSON += "{\"codigo\":" + item.getCodigo() + ",\"nomeProduto\":\"" + item.getProduto().getNome() + "\""
                    + ",\"quantidade\":" + item.getQuantidade() + "}";
            if (loteEntrada.getItens().indexOf(item) != loteEntrada.getItens().size() - 1) {
                responseJSON += ",";
            }
        }
        responseJSON += "]}";

        response.setContentType("text/plain");

        try (PrintWriter out = response.getWriter()) {
            out.println(responseJSON);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        LoteEntrada le = (LoteEntrada) session.getAttribute("loteEntrada");

        for (ItemEntrada i : le.getItens()) {
            if (i.getQuantidade() > 10) {
                session.setAttribute("msg", "VocÊ está tentando inserir mais de 10 itens no produto " + i.getProduto().getNome() + " no seu lote.");

                response.sendError(500);

                return;
            }
        }

        Estoque estoque = RepositorioEstoque.getCurrentInstance().read();

        for (ItemEntrada i : le.getItens()) {
            for (ItemEstoque ie : estoque.getItens()) {
                if (i.getProduto().getCodigo() == ie.getProduto().getCodigo()) {
                    ie.adiciona(i.getQuantidade());
                    break;
                }
            }
        }

        RepositorioLoteEntrada.getCurrentInstance().create(le);

        session.removeAttribute("loteEntrada");

        session.setAttribute("msg", "O lote de entrada foi inserido com sucesso.");

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPut(request, response);

        String operacao = request.getParameter("operacao");

        int codigo = Integer.parseInt(request.getParameter("codigo"));
        int quantidade = 1; //(int) (Math.random()*10000);
        boolean controle = false;
        HttpSession session = request.getSession();
        LoteEntrada le = (LoteEntrada) session.getAttribute("loteEntrada");

        if (le == null) {
            le = new LoteEntrada();

            session.setAttribute("loteEntrada", le);
        }

        if (operacao.equals("mais")) {

            
            for (ItemEntrada i : le.getItens()) {
                if (i.getProduto().getCodigo() == codigo) {
                    i.setQuantidade(i.getQuantidade() + quantidade);
                    controle = true;
                    session.setAttribute("msg", "O produto foi incrementado no lote.");
                    break;
                }
            }

            if (!controle) {
                ItemEntrada item = new ItemEntrada();

                Produto p = RepositorioProdutos.getCurrentInstance().read(codigo);

                item.setProduto(p);
                item.setCodigo(p.getCodigo());
                item.setQuantidade(1);

                le.addItem(item);

                session.setAttribute("msg", "O produto " + p.getNome() + " foi inserido no lote.");
            }
        } else if (operacao.equals("menos")) {

            for (ItemEntrada i : le.getItens()) {
                if (i.getProduto().getCodigo() == codigo) {
                    if (i.getQuantidade() == 1) {
                        le.getItens().remove(i);
                        if (le.getItens().size() == 0) {
                            session.removeAttribute("loteEntrada");
                        }
                        session.setAttribute("msg", "O produto " + i.getProduto().getNome() + " foi removido do lote.");
                        break;
                    }

                    i.setQuantidade(i.getQuantidade() - 1);
                    break;
                }
            }
        }
    }

}
