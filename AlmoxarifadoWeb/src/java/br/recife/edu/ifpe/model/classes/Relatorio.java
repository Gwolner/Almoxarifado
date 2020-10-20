package br.recife.edu.ifpe.model.classes;

import br.recife.edu.ifpe.model.interfaces.Lote;
import java.util.ArrayList;
import java.util.List;

//Inspirado na lógica de Estoque
public class Relatorio {   
    
   private int codigo;
   private List<Lote> lotes;
   
   public Relatorio(){
       this.lotes = new ArrayList<>();
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }
    
    public void addLote(Lote lote){
        this.lotes.add(lote);
    }
}
