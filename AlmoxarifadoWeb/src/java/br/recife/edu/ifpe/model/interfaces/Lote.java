/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.model.interfaces;

import java.util.Date;

/**
 *
 * @author wolner
 */
public interface Lote {
    
    public int getCodigo();
    
    public void setCodigo(int codigo);
    
    public Date getData();
    
    public void setData(Date data);
}
