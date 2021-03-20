package entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author belarmino
 */
@Entity
@Table(name = "item_venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_itemVenda")
    private int cod_itemVenda;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "precoUnitario", nullable = false)
    private double subtotal;
    
    @Column(name = "status",nullable = false,length = 7)
    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto",referencedColumnName = "codigo")
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_venda", referencedColumnName = "cod_venda")
    private Venda sale;

    public ItemVenda() {
    }

    public int getCod_itemVenda() {
        return cod_itemVenda;
    }

    public void setCod_itemVenda(int cod_itemVenda) {
        this.cod_itemVenda = cod_itemVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getSale() {
        return sale;
    }

    public void setSale(Venda sale) {
        this.sale = sale;
    }

}
