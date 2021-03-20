/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import entidade.Fornecedor;
import entidade.Grupo;
import entidade.Produto;
import entidade.Unidade;
import facade.FornecedorFacade;
import facade.ProdutoFacade;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author belarmino
 */
public class ProdutosVisao extends javax.swing.JDialog {

    private ProdutoFacade facade;
    private Produto produto;
    private Grupo grupo;
    private FornecedorFacade ff;
    private Fornecedor fornecedor;
    private Unidade unidade;

    /**
     * Creates new form ProdutosVisao
     */
    public ProdutosVisao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        enableComponents(false);
        facade = new ProdutoFacade();
        ff = new FornecedorFacade();
    }

    private void enableComponents(boolean status) {
        for (Component comp : jpDados.getComponents()) {
            comp.setEnabled(status);
        }

        for (Component comp : jpFiltro.getComponents()) {
            comp.setEnabled(!status);
        }

        jtProdutos.setEnabled(!status);
        jbtGravar.setEnabled(status);
        jbtCancelar.setEnabled(status);
        jbtCadastrar.setEnabled(!status);

    }

    public void updateTable() {
        produtosList.clear();
        produtosList.addAll(facade.searchAll());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        produtosEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("db_tcc_miqueiasPU").createEntityManager();
        produtosQuery = java.beans.Beans.isDesignTime() ? null : produtosEntityManager.createQuery("SELECT p FROM Produto p");
        produtosList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(produtosQuery.getResultList());
        jpDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfPrecoUnitario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfEtoqueMinimo = new javax.swing.JTextField();
        jbtBuscaGrupo = new javax.swing.JButton();
        jbtBuscaForne = new javax.swing.JButton();
        jtfGrupo = new javax.swing.JTextField();
        jtfUnidade = new javax.swing.JTextField();
        jtfFornecedor = new javax.swing.JTextField();
        jbtBuscaUnidade = new javax.swing.JButton();
        jpFiltro = new javax.swing.JPanel();
        jcbOpcoes = new javax.swing.JComboBox();
        jtfPesquisa = new javax.swing.JTextField();
        jbtFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbtGravar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jbtFechar = new javax.swing.JButton();
        jbtCadastrar = new javax.swing.JButton();
        jbtAtualizar = new javax.swing.JButton();
        jbtDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção - Produtos");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jpDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Descrição:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtProdutos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.descricao}"), jtfDescricao, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel2.setText("Grupo:");

        jLabel3.setText("Unidade:");

        jLabel4.setText("Preço Unitário:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtProdutos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.precoUnitario}"), jtfPrecoUnitario, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel5.setText("Estoque Mínimo:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtProdutos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.quantidade}"), jtfQuantidade, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel6.setText("Quantidade:");

        jLabel7.setText("Fornecedor:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtProdutos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.estoqueMin}"), jtfEtoqueMinimo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jbtBuscaGrupo.setText("Buscar");
        jbtBuscaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscaGrupoActionPerformed(evt);
            }
        });

        jbtBuscaForne.setText("Buscar");
        jbtBuscaForne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscaForneActionPerformed(evt);
            }
        });

        jbtBuscaUnidade.setText("Buscar");
        jbtBuscaUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscaUnidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDadosLayout = new javax.swing.GroupLayout(jpDados);
        jpDados.setLayout(jpDadosLayout);
        jpDadosLayout.setHorizontalGroup(
            jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosLayout.createSequentialGroup()
                        .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDadosLayout.createSequentialGroup()
                                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(24, 24, 24)
                                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpDadosLayout.createSequentialGroup()
                                        .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpDadosLayout.createSequentialGroup()
                                                .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jpDadosLayout.createSequentialGroup()
                                                .addComponent(jtfUnidade)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtBuscaUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)))
                                        .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(29, 29, 29)
                                        .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfEtoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jtfDescricao, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpDadosLayout.createSequentialGroup()
                                        .addComponent(jtfGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtBuscaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jpDadosLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jpDadosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtBuscaForne, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpDadosLayout.setVerticalGroup(
            jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jbtBuscaGrupo)
                    .addComponent(jtfGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jtfPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBuscaUnidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEtoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jbtBuscaForne)
                    .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpFiltro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jcbOpcoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Descrição", "Grupo" }));

        jbtFiltrar.setText("Filtrar");
        jbtFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFiltrarActionPerformed(evt);
            }
        });

        jtProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtProdutos.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produtosList, jtProdutos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricao}"));
        columnBinding.setColumnName("Descrição");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantidade}"));
        columnBinding.setColumnName("Quantidade");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${unidade}"));
        columnBinding.setColumnName("Unidade");
        columnBinding.setColumnClass(entidade.Unidade.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precoUnitario}"));
        columnBinding.setColumnName("Preco Unitário");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${group}"));
        columnBinding.setColumnName("Grupo");
        columnBinding.setColumnClass(entidade.Grupo.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${provider}"));
        columnBinding.setColumnName("Fornecedor");
        columnBinding.setColumnClass(entidade.Fornecedor.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jtProdutos);
        if (jtProdutos.getColumnModel().getColumnCount() > 0) {
            jtProdutos.getColumnModel().getColumn(0).setResizable(false);
            jtProdutos.getColumnModel().getColumn(1).setResizable(false);
            jtProdutos.getColumnModel().getColumn(2).setResizable(false);
            jtProdutos.getColumnModel().getColumn(2).setPreferredWidth(27);
            jtProdutos.getColumnModel().getColumn(3).setResizable(false);
            jtProdutos.getColumnModel().getColumn(4).setResizable(false);
            jtProdutos.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jpFiltroLayout = new javax.swing.GroupLayout(jpFiltro);
        jpFiltro.setLayout(jpFiltroLayout);
        jpFiltroLayout.setHorizontalGroup(
            jpFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jpFiltroLayout.createSequentialGroup()
                        .addComponent(jcbOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpFiltroLayout.setVerticalGroup(
            jpFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagem/Save.png"))); // NOI18N
        jbtGravar.setText("Gravar");
        jbtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGravarActionPerformed(evt);
            }
        });

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagem/Cancel.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagem/Home.png"))); // NOI18N
        jbtFechar.setText("Fechar");
        jbtFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFecharActionPerformed(evt);
            }
        });

        jbtCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagem/Add.png"))); // NOI18N
        jbtCadastrar.setText("Cadastrar");
        jbtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCadastrarActionPerformed(evt);
            }
        });

        jbtAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagem/Modify.png"))); // NOI18N
        jbtAtualizar.setText("Atualizar");
        jbtAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAtualizarActionPerformed(evt);
            }
        });

        jbtDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagem/Delete.png"))); // NOI18N
        jbtDeletar.setText("Deletar");
        jbtDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtDeletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtFechar)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtGravar)
                    .addComponent(jbtCancelar)
                    .addComponent(jbtFechar)
                    .addComponent(jbtCadastrar)
                    .addComponent(jbtAtualizar)
                    .addComponent(jbtDeletar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGravarActionPerformed
        if (produto == null) {
            produto = produtosList.get(jtProdutos.getSelectedRow());
            enableComponents(false);
            facade.updateData(produto);
            JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso !");
            updateTable();
        } else {
            if (jtfDescricao.getText().isEmpty()
                    || jtfEtoqueMinimo.getText().isEmpty()
                    //|| jtfGrupo.getText().isEmpty()
                    || jtfPrecoUnitario.getText().isEmpty()
                    || jtfQuantidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            } else {
                facade.createData(produto);
                JOptionPane.showMessageDialog(null, "Registro inserido com sucesso !");
                updateTable();
                enableComponents(false);
                if (!jbtAtualizar.isEnabled()) {
                    jbtAtualizar.setEnabled(true);
                }
                if (!jbtDeletar.isEnabled()) {
                    jbtDeletar.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_jbtGravarActionPerformed

    private void jbtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCadastrarActionPerformed
        enableComponents(true);
        jtfQuantidade.setEnabled(true);
        if (jbtDeletar.isEnabled() || jbtAtualizar.isEnabled()) {
            jbtDeletar.setEnabled(false);
            jbtAtualizar.setEnabled(false);
        }
        produto = new Produto();
        produtosList.add(produto);
        int linha = produtosList.size() - 1;
        jtProdutos.setRowSelectionInterval(linha, linha);
        jtfDescricao.requestFocus();
    }//GEN-LAST:event_jbtCadastrarActionPerformed

    private void jbtAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAtualizarActionPerformed
        jtfQuantidade.setEnabled(false);
        if (jtProdutos.isRowSelected(jtProdutos.getSelectedRow())) {
            enableComponents(true);
            if (jbtDeletar.isEnabled()) {
                jbtDeletar.setEnabled(false);
            }
            produto = null;
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!");
        }
    }//GEN-LAST:event_jbtAtualizarActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        enableComponents(false);
        if (!jbtDeletar.isEnabled()) {
            jbtDeletar.setEnabled(true);
        }
        if (!jbtAtualizar.isEnabled()) {
            jbtAtualizar.setEnabled(true);
        }
        updateTable();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeletarActionPerformed
        if (jtProdutos.isRowSelected(jtProdutos.getSelectedRow())) {
            int op = JOptionPane.showConfirmDialog(null, "Deseja Realmente excluír ?");
            if (op == 0) {
                facade.deleteData(produtosList.get(jtProdutos.getSelectedRow()));
                updateTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!");
        }
    }//GEN-LAST:event_jbtDeletarActionPerformed

    private void jbtFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtFecharActionPerformed

    private void jbtBuscaForneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscaForneActionPerformed
        FornecedorBuscaVisao fbv = new FornecedorBuscaVisao(null, true);
        fbv.setVisible(true);
    }//GEN-LAST:event_jbtBuscaForneActionPerformed

    private void jbtBuscaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscaGrupoActionPerformed
        GrupoBuscaVisao gbv = new GrupoBuscaVisao(null, true);
        gbv.setVisible(true);
    }//GEN-LAST:event_jbtBuscaGrupoActionPerformed

    private void jbtBuscaUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscaUnidadeActionPerformed
        UnidadeBuscaVisao ubv = new UnidadeBuscaVisao(null, true);
        ubv.setVisible(true);
    }//GEN-LAST:event_jbtBuscaUnidadeActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        try {
            setGrupo();
        } catch (Exception e) {
        }
        try {
            setUnidade();
        } catch (Exception e) {
        }
        try {
            setFornecedor();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formFocusGained

    private void jbtFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtFiltrarActionPerformed
    private void setGrupo() {
        grupo = GrupoBuscaVisao.grupo;
        jtfGrupo.setText(""+grupo.getNome());
    }

    private void setUnidade() {
        unidade = UnidadeBuscaVisao.unidade;
        jtfUnidade.setText(UnidadeBuscaVisao.unidade.getDescricao());
    }

    private void setFornecedor() {
        fornecedor = FornecedorBuscaVisao.fornecedor;
        jtfFornecedor.setText(FornecedorBuscaVisao.fornecedor.getNomeFantasia());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProdutosVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutosVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutosVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutosVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutosVisao dialog = new ProdutosVisao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAtualizar;
    private javax.swing.JButton jbtBuscaForne;
    private javax.swing.JButton jbtBuscaGrupo;
    private javax.swing.JButton jbtBuscaUnidade;
    private javax.swing.JButton jbtCadastrar;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtDeletar;
    private javax.swing.JButton jbtFechar;
    private javax.swing.JButton jbtFiltrar;
    private javax.swing.JButton jbtGravar;
    private javax.swing.JComboBox jcbOpcoes;
    private javax.swing.JPanel jpDados;
    private javax.swing.JPanel jpFiltro;
    private javax.swing.JTable jtProdutos;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfEtoqueMinimo;
    private javax.swing.JTextField jtfFornecedor;
    private javax.swing.JTextField jtfGrupo;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JTextField jtfPrecoUnitario;
    private javax.swing.JTextField jtfQuantidade;
    private javax.swing.JTextField jtfUnidade;
    private javax.persistence.EntityManager produtosEntityManager;
    private java.util.List<entidade.Produto> produtosList;
    private javax.persistence.Query produtosQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}