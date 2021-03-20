package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author belarmino
 */
@Entity
@Table(name = "despesa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Despesa implements Serializable {

    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(name = "decricao", nullable = false, length = 80)
    private String descricao;
    
    @Column(name = "valor", nullable = false)
    private double valor;
    
    @Column(name = "dataPagamento", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPagamento;
    
    @Column(name = "status", nullable = false)
    private String status;

    public Despesa() {
    }

    public Despesa(int codigo, String descricao, double valor, Date dataPagamento, String status) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.status = status;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
