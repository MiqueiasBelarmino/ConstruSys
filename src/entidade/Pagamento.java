package entidade;

import facade.PagamentoFacade;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author belarmino
 */
@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pag_codigo")
    private int pag_codigo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "venda", referencedColumnName = "cod_venda")
    private Venda venda;

    @Column(name = "cliente", nullable = false)
    private String cliente;

    @Column(name = "parcelas", nullable = true, length = 2)
    private int parcelas;
    @Column(name = "valorParcela", nullable = false)
    private double valorParcela;
    @Column(name = "total", nullable = false)
    private double total;
    @Column(name = "pagas", nullable = false, length = 2)
    private int pagas;
    @Column(name = "status")
    private String status;

    public Pagamento(Venda venda, boolean st) {
        if (st) {
            parcelas = venda.getParcelas();
            valorParcela = (venda.getTotal() / venda.getParcelas());
            total = venda.getTotal();
            status = venda.getStatus();
            cliente = venda.getClient().getNome();
            pagas = 0;
            this.venda = venda;
            PagamentoFacade pf = new PagamentoFacade();
            pf.create(this);
        }
    }

    public Pagamento() {
    }
    

    public int getPag_codigo() {
        return pag_codigo;
    }

    public void setPag_codigo(int pag_codigo) {
        this.pag_codigo = pag_codigo;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPagas() {
        return pagas;
    }

    public void setPagas(int pagas) {
        this.pagas = pagas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
