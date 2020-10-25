package br.recife.edu.ifpe.model.interfaces;

import br.recife.edu.ifpe.model.classes.Funcionario;
import java.util.Date;

//Usada para permitir tanto lote de entrada quanto de saida no relatório
public interface Lote {

    public int getCodigo();

    public void setCodigo(int codigo);

    public Date getData();

    public void setData(Date data);

    public Funcionario getResponsavel();

    public void setResponsavel(Funcionario responsavel);
}
