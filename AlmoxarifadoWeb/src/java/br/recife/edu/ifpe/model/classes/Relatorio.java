package br.recife.edu.ifpe.model.classes;

import br.recife.edu.ifpe.model.interfaces.Lote;
import java.util.ArrayList;
import java.util.List;

//Inspirado na lógica de Estoque
public class Relatorio {   
    
   private int codigo;
   
   //Faz uso da interface Lote para que a lista possa receber tanto os lotes de entrada quanto os de saída
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

    //Métodos adaptados para interface Lote
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
