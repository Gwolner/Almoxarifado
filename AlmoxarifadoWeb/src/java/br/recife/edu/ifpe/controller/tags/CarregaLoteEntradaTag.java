package br.recife.edu.ifpe.controller.tags;

import br.recife.edu.ifpe.model.classes.LoteEntrada;
import br.recife.edu.ifpe.model.repositorios.RepositorioLoteEntrada;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class CarregaLoteEntradaTag extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        
        List<LoteEntrada> lotes = RepositorioLoteEntrada.getCurrentInstance().readAll();
        
        getJspContext().setAttribute("lotesEntradaInseridos", lotes, PageContext.PAGE_SCOPE);
    }   
}
