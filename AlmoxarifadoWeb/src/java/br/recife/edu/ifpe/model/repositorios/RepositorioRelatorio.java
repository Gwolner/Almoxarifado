package br.recife.edu.ifpe.model.repositorios;

import br.recife.edu.ifpe.model.classes.Relatorio;
import java.util.ArrayList;
import java.util.List;

//Inspirado na lógica de RepositórioEstoque com adaptações
public class RepositorioRelatorio {
    
    private static RepositorioRelatorio myself = null;
    
    private List<Relatorio> relatorio = null;
    
    private RepositorioRelatorio(){
        this.relatorio = new ArrayList<>();
        this.relatorio.add(new Relatorio());
    }
    
    public static RepositorioRelatorio getCurrentInstance(){
        if(myself == null)
            myself = new RepositorioRelatorio();
        
        return myself;
    }
    
    public void create(Relatorio e){
        this.relatorio.add(e);
    }
    
    public Relatorio read(){
        return this.relatorio.get(0);
    }
    
//    Método update sem utilidade no momento
    
//    public void update(int codigoProduto,int quantidade){
//        for(ItemRelatorio i: this.relatorio.get(0).getItens()){
//            if(i.getProduto().getCodigo() == codigoProduto){
//                
//                i.setQuantidade(quantidade);
//                return;
//                
//            }
//        }
//    }
}
