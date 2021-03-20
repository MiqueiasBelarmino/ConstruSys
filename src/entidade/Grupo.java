/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author belarmino
 */
@Entity
@Table(name = "grupo")
public class Grupo implements Serializable {

    @Id
    @Column(name = "id_grupo",nullable = false)
    private int id;
    
    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @OneToMany(mappedBy = "group")
    //@JoinColumn(name = "produto_id")
    private List<Produto> listaProdutos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addProdutos(Produto produto) {
        //this.produtos = produtos;
        this.listaProdutos.add(produto);
    }

    @Override
    public String toString(){
        return String.format(nome);
    }
}
