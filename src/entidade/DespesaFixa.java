package entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author belarmino
 */
@Entity
@Table(name = "despesa_fixa")
public class DespesaFixa extends Despesa {

    @Column(name = "diaVencimento", nullable = true)
    private int diaVencimento;

    public DespesaFixa() {
    }

    public DespesaFixa(int diaVencimento, int codigo, String descricao, double valor, Date dataPagamento, String status) {
        super(codigo, descricao, valor, dataPagamento, status);
        this.diaVencimento = diaVencimento;
    }

    public int getDataVencimento() {
        return diaVencimento;
    }

    public void setDataVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    
}
