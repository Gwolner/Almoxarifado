package br.recife.edu.ifpe.model.classes;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    
   private int codigo;
   private List<ItemEstoque> itens;
   
   public Estoque(){
       this.itens = new ArrayList<>();
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<ItemEstoque> getItens() {
        return itens;
    }

    public void setItens(List<ItemEstoque> itens) {
        this.itens = itens;
    }
    
    public void addItem(ItemEstoque i){
        this.itens.add(i);
    }
}
