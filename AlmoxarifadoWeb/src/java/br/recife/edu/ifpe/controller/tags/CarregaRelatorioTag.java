/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.tags;

import br.recife.edu.ifpe.model.classes.Relatorio;
import br.recife.edu.ifpe.model.repositorios.RepositorioRelatorio;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class CarregaRelatorioTag extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        
        Relatorio r = RepositorioRelatorio.getCurrentInstance().read();
        
        getJspContext().setAttribute("relatorio", r, PageContext.PAGE_SCOPE);
        
    }
    
}
