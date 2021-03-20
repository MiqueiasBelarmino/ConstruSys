package entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * @author belarmino
 */
@Entity
@Table(name = "despesa_variavel")
public class DespesaVariavel extends Despesa {

    @Column(name = "dataVencimento", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVencimento;

    public DespesaVariavel() {
    }

    public DespesaVariavel(Date dataVencimento, int codigo, String descricao, double valor, Date dataPagamento, String status) {
        super(codigo, descricao, valor, dataPagamento, status);
        this.dataVencimento = dataVencimento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

}
