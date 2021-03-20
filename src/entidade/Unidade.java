package entidade;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author belarmino
 */
@Entity
@Table(name = "unidade")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "decricao",length = 50)
    private String descricao;
    @OneToMany(mappedBy = "unidade")
    //@JoinColumn(name = "produto_id")
    private List<Produto> listaProdutos;

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
    
    
}
