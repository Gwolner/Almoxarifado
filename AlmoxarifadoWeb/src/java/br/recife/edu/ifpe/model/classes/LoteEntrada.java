/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.model.classes;

import br.recife.edu.ifpe.model.interfaces.Lote;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoteEntrada implements Lote{
    
    private int codigo;
    private List<ItemEntrada> itens;
    private Date data;
    
//    Adicionado atributo responsavel no lote de ntrada para permitir a identificação no relatorio
    private Funcionario responsavel; 
    
    /*
    * Neste campo ficarão armazenadas as informações de documentos
    */
    private String descricao;
    
    public LoteEntrada(){
        this.itens = new ArrayList<>();
        this.data = new Date();
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<ItemEntrada> getItens() {
        return itens;
    }

    public void setItens(List<ItemEntrada> itens) {
        this.itens = itens;
    }

    @Override
    public Date getData() {
        return data;
    }

    @Override
    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void addItem(ItemEntrada i){
        this.itens.add(i);
    }
    
    public int getQuantidadeTotal(){
        int quant = 0;
        
        for(ItemEntrada i: itens){
            quant += i.getQuantidade();
        }
        
        return quant;
    }
    
//    Adicionado Get e Set para Funcionário/Responsavel
    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }
    
    
}
