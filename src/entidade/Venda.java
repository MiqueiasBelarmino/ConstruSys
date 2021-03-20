package entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author belarmino
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_venda")
    private int cod_venda;
    @Column(name = "total")
    private double total;
    @Column(name = "dataVenda")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Column(name = "formaPagto", length = 8)
    private String formaPagto;
    @Column(name = "parcelas")
    private int parcelas;
    @Column(name = "status", length = 9)
    private String status;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_client")
    private Cliente client;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_itemVenda")
    private List<ItemVenda> listaItem;

    public Venda() {
    }

    public int getCod_venda() {
        return cod_venda;
    }

    public void setCod_venda(int cod_venda) {
        this.cod_venda = cod_venda;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(String formaPagto) {
        this.formaPagto = formaPagto;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<ItemVenda> getListaItem() {
        return listaItem;
    }

    public void setListaItem(List<ItemVenda> listaItem) {
        this.listaItem = listaItem;
    }

    public void addItem(ItemVenda item) {
        listaItem.add(item);
    }
    
    public String toString(){
        return String.format("%d",cod_venda);
    }
}
