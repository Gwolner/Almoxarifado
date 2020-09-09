package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.recife.edu.ifpe.model.classes.Produto;
import java.util.List;
import br.recife.edu.ifpe.model.repositorios.RepositorioProdutos;
import br.recife.edu.ifpe.model.classes.Produto;

public final class produto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/cadastroproduto.jsp");
    _jspx_dependants.add("/visualizaproduto.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Produtos cadastrados</h1>\n");
      out.write("        \n");
      out.write("        ");

        String mensagem = (String) session.getAttribute("msg");
        if(mensagem != null){
        
      out.write("\n");
      out.write("        \n");
      out.write("            <h2>");
      out.print( mensagem );
      out.write("</h2>\n");
      out.write("        \n");
      out.write("        ");

            session.removeAttribute("msg");
        }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <button onclick=\"modalopen()\">Novo produto</button>\n");
      out.write("        <div id=\"modal\" style=\"background-color: pink; position: absolute; top: 200px; left: 200px; border: 1px black solid\">\n");
      out.write("            \n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Cadastro de produtos</h1>\n");
      out.write("        \n");
      out.write("        <a href=\"index.html\"> << Voltar</a><br><br>\n");
      out.write("        \n");
      out.write("        <form method=\"post\" action=\"ProdutoServletNovo\">\n");
      out.write("            \n");
      out.write("            Código: <input type=\"text\" name=\"codigo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param.redirect != null && param[\"redirect\"] eq 'atualiza')?produto.codigo:\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br>\n");
      out.write("            Nome: <input type=\"text\" name=\"nome\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param.redirect != null && param[\"redirect\"] eq 'atualiza')?produto.nome:''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br>\n");
      out.write("            Marca: <input type=\"text\" name=\"marca\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param.redirect != null && param[\"redirect\"] eq 'atualiza')?produto.marca:''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br>\n");
      out.write("            Categoria: <input type=\"text\" name=\"categoria\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param.redirect != null && param[\"redirect\"] eq 'atualiza')?produto.categoria:''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br>\n");
      out.write("            Descrição: <textarea name=\"descricao\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param.redirect != null && param[\"redirect\"] eq 'atualiza')?produto.descricao:''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea><br><br>\n");
      out.write("            \n");
      out.write("            <input type=\"hidden\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param.redirect != null && param[\"redirect\"] eq 'atualiza')?'atualizar':'cadastrar'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" value=\"1\">         \n");
      out.write("                    \n");
      out.write("            <input type=\"submit\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param.redirect != null && param[\"redirect\"] eq 'atualiza')?'Atualizar':'Cadastrar'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("        </form> \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            \n");
      out.write("            <br>\n");
      out.write("            <button onclick=\"modalclose()\">Fechar</button>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        <div id=\"modal2\" style=\"background-color: pink; position: absolute; top: 200px; left: 200px; border: 1px black solid\">\n");
      out.write("            \n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Produtos Cadastrados</h1>\n");
      out.write("        \n");
      out.write("        ");

        Produto produto = (Produto) request.getAttribute("produto");
        if(produto != null){
        
      out.write("\n");
      out.write("        \n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Código</th><td>");
      out.print( produto.getCodigo() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>Nome</th><td>");
      out.print( produto.getNome() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>Marca</th><td>");
      out.print( produto.getMarca() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>Categoria</th><td>");
      out.print( produto.getCategoria() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>Descrição</th><td>");
      out.print( produto.getDescricao() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        ");

        }
        
      out.write(" \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            \n");
      out.write("            <br>\n");
      out.write("            <button onclick=\"modal2close()\">Fechar</button>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");

        List<Produto> produtos = RepositorioProdutos.getCurrentInstance().readAll();
        
      out.write("\n");
      out.write("            \n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Código</th><th>Nome</th><th>Marca</th><th>Categoria</th><th>Operações</th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");

            for(Produto p: produtos){
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( p.getCodigo() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getNome());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getMarca());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getCategoria());
      out.write("</td> <!-- Trocar nome visualziar, alterar e deletar por ícones -->\n");
      out.write("                    <td><a href=\"ProdutoServletNovo?codigo=");
      out.print( p.getCodigo() );
      out.write("&redirect=visualiza\">Visualizar </a>\n");
      out.write("                        <a href=\"ProdutoServletNovo?codigo=");
      out.print( p.getCodigo() );
      out.write("&redirect=atualiza\"> Alterar </a>\n");
      out.write("                        <a href=\"#\" onclick=\"deleteProduto(");
      out.print( p.getCodigo() );
      out.write(")\">Deletar</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            ");

            }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("            \n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            var modal = document.getElementById(\"modal\");\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            var modal2 = document.getElementById(\"modal2\");\n");
      out.write("            \n");
      out.write("            ");

            String redirect = request.getParameter("redirect");
            
            if(redirect == null){
            
      out.write("\n");
      out.write("                document.body.removeChild(modal);\n");
      out.write("                document.body.removeChild(modal2);\n");
      out.write("            ");
 }else if(redirect.equals("visualiza")){ 
      out.write("\n");
      out.write("                document.body.removeChild(modal);\n");
      out.write("            ");
 }else{ 
      out.write("\n");
      out.write("                document.body.removeChild(modal2); \n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            \n");
      out.write("            function modalclose(){\n");
      out.write("                document.body.removeChild(modal);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function modal2close(){\n");
      out.write("                document.body.removeChild(modal2);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function modalopen(){\n");
      out.write("                document.body.appendChild(modal);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function deleteProduto(codigo){\n");
      out.write("                fetch(\"ProdutoServletNovo?codigo=\"+codigo,{method:\"delete\"})\n");
      out.write("                        .then(function(response){\n");
      out.write("                            location.reload();\n");
      out.write("                });\n");
      out.write("            };\n");
      out.write("            \n");
      out.write("        </script>       \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
