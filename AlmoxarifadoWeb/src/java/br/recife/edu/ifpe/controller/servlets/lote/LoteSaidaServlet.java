package br.recife.edu.ifpe.controller.servlets.lote;

import br.recife.edu.ifpe.model.classes.Estoque;
import br.recife.edu.ifpe.model.classes.Funcionario;
import br.recife.edu.ifpe.model.classes.ItemEstoque;
import br.recife.edu.ifpe.model.classes.ItemSaida;
import br.recife.edu.ifpe.model.classes.LoteSaida;
import br.recife.edu.ifpe.model.classes.Produto;
import br.recife.edu.ifpe.model.repositorios.RepositorioEstoque;
import br.recife.edu.ifpe.model.repositorios.RepositorioLoteSaida;
import br.recife.edu.ifpe.model.repositorios.RepositorioProdutos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoteSaidaServlet", urlPatterns = {"/LoteSaidaServlet"})
public class LoteSaidaServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codigo = Integer.parseInt(request.getParameter("codigo"));

        LoteSaida loteSaida = RepositorioLoteSaida.getCurrentInstance().read(codigo);

        String responseJSON = "{\"codigo\":" + loteSaida.getCodigo() + ","
                + "\"descricao\":\"" + loteSaida.getDescricao() + "\",\"itens\":[";
        for (ItemSaida item : loteSaida.getItens()) {
            responseJSON += "{\"codigo\":" + item.getCodigo() + ",\"nomeProduto\":\"" + item.getProduto().getNome() + "\""
                    + ",\"quantidade\":" + item.getQuantidade() + "}";
            if (loteSaida.getItens().indexOf(item) != loteSaida.getItens().size() - 1) {
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

        LoteSaida ls = (LoteSaida) session.getAttribute("loteSaida");

        for (ItemSaida i : ls.getItens()) {
            if (i.getQuantidade() > 10) {
                session.setAttribute("msg", "VocÊ está tentando inserir mais de 10 itens no produto " + i.getProduto().getNome() + " no seu lote.");

                response.sendError(500);

                return;
            }
        }

        Estoque estoque = RepositorioEstoque.getCurrentInstance().read();

        for (ItemSaida i : ls.getItens()) {
            for (ItemEstoque ie : estoque.getItens()) {
                if (i.getProduto().getCodigo() == ie.getProduto().getCodigo()) {
                    ie.subtrai(i.getQuantidade());
                    break;
                }
            }
        }

        RepositorioLoteSaida.getCurrentInstance().create(ls);

        session.removeAttribute("loteSaida");

        session.setAttribute("msg", "O lote de saida foi inserido com sucesso.");

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPut(request, response);

        String operacao = request.getParameter("operacao");

        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        int quantidade = 1; //(int) (Math.random()*10000);
        
        boolean controle = false;
        
        HttpSession session = request.getSession();
        
        LoteSaida ls = (LoteSaida) session.getAttribute("loteSaida");

        if (ls == null) {
            ls = new LoteSaida();

            session.setAttribute("loteSaida", ls);
        }

        if (operacao.equals("mais")) {

            
            for (ItemSaida i : ls.getItens()) {
                if (i.getProduto().getCodigo() == codigo) {
                    i.setQuantidade(i.getQuantidade() + quantidade);
                    controle = true;
                    session.setAttribute("msg", "O produto foi incrementado no lote.");
                    break;
                }
            }

            if (!controle) {
                ItemSaida item = new ItemSaida();

                Produto p = RepositorioProdutos.getCurrentInstance().read(codigo);

                item.setProduto(p);
                item.setCodigo(p.getCodigo());
                item.setQuantidade(1);

                ls.addItem(item);

                session.setAttribute("msg", "O produto " + p.getNome() + " foi inserido no lote.");
            }
        } else if (operacao.equals("menos")) {

            for (ItemSaida i : ls.getItens()) {
                if (i.getProduto().getCodigo() == codigo) {
                    if (i.getQuantidade() == 1) {
                        ls.getItens().remove(i);
                        if (ls.getItens().size() == 0) {
                            session.removeAttribute("loteSaida");
                        }
                        session.setAttribute("msg", "O produto " + i.getProduto().getNome() + " foi removido do lote.");
                        break;
                    }

                    i.setQuantidade(i.getQuantidade() - 1);
                    break;
                }
            }
        }
        else if (operacao.equals("neutra")) {
            
            List<Funcionario> listaDeFuncionarios = (List<Funcionario>) session.getAttribute("listaDeFuncionarios");
            
            for (Funcionario f : listaDeFuncionarios) {
                if (f.getCodigo() == codigo) {
                    ls.setResponsavel(f);                    
                    break;
                }
            }
        }
    }
    
}
