/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 29/10/2020 16:03:09 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : mbd - Modelagem de banco de dados
 *  Aluno      : Jhonathan dos reis
 *  Projeto    : PROJETO CAMADAS
 *  Exercício  : Cadastro de miniaturas
 *  ---------------------------------------------------------------------------------------------------
 *  Propósito do arquivo (Pregu;á náo deicha preencher).
 *  ---------------------------------------------------------------------------------------------------| 
 */
package br.com.torrentz.app;

import br.com.torrentz.bll.CategoriaBll;
import br.com.torrentz.bll.PlanosBll;
import br.com.torrentz.model.Categorias;
import br.com.torrentz.model.Planos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JHONATHAN
 */
public class Teste extends javax.swing.JFrame {

    private Categorias categoria;
    private CategoriaBll categoriaBll;
    private Planos planos;
    private PlanosBll planosBll;

    public Teste() {
        initComponents();
        try {
            categoria = new Categorias();
            categoriaBll = new CategoriaBll();
            planos = new Planos();
            planosBll = new PlanosBll();
            
            preencherGridCategoria();
            preencherGridPlanos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seu banco está Offline!", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
        

        this.setLocationRelativeTo(null);
    }

    public void preencherGridCategoria() {

        try {
            DefaultTableModel tableCategoria = (DefaultTableModel) jTableTeste.getModel();
            tableCategoria.setRowCount(0);

            Object[] linha = new Object[2];

            ArrayList<Categorias> categorias = new CategoriaBll().getConsulta();

            for (Categorias categoria1 : categorias) {
                linha[0] = categoria1.getCat_iden();
                linha[1] = categoria1.getCat_nome();
                tableCategoria.addRow(linha);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ai adicionar o dado na grid", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void preencherGridPlanos() {
        
        try {
            DefaultTableModel tablePlanos = (DefaultTableModel) jTablePlanos.getModel();
            tablePlanos.setRowCount(0);

            Object[] linha = new Object[4];

            ArrayList<Planos> planoss = new PlanosBll().getConsulta();

            for (Planos planos1 : planoss) {
                linha[0] = planos1.getPla_iden();
                linha[1] = planos1.getPla_acesso_simultaneo();
                linha[2] = planos1.getPla_nome();
                linha[3] = planos1.getPla_preco();
                tablePlanos.addRow(linha);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ai adicionar o dado na grid", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void preencherFormularioCategoris() {
        int id = Integer.parseInt(jTableTeste.getValueAt(jTableTeste.getSelectedRow(), 0).toString());
        String nome = jTableTeste.getValueAt(jTableTeste.getSelectedRow(), 1).toString();

        jTextFieldNome.setText(nome);
        jTextFieldId.setText(id + "");
    }
    
    public void preencherFormularioPlanos() {
        
        int id = Integer.parseInt(jTablePlanos.getValueAt(jTablePlanos.getSelectedRow(), 0).toString());
        int acessoSimultaneo = Integer.parseInt(jTablePlanos.getValueAt(jTablePlanos.getSelectedRow(), 1).toString());
        String nome = jTablePlanos.getValueAt(jTablePlanos.getSelectedRow(), 2).toString();
        float preco = Float.parseFloat(jTablePlanos.getValueAt(jTablePlanos.getSelectedRow(), 3).toString());
        
        jTextFieldAcessos.setText(acessoSimultaneo + "");
        jTextFieldPlanosNome.setText(nome);
        jTextFieldPlanosPrecos.setText(preco + "");
        jTextFieldPlanosID.setText(id + "");
    }

    public void limparCampos() {
        jTextFieldId.setText("");
        jTextFieldNome.setText("");
    }
    
    public void limparCamposPlanos() {
        jTextFieldAcessos.setText("");
        jTextFieldPlanosPrecos.setText("");
        jTextFieldPlanosNome.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTeste = new javax.swing.JTable();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPlanosNome = new javax.swing.JTextField();
        jTextFieldPlanosPrecos = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePlanos = new javax.swing.JTable();
        jButtonAdicionarPlanos = new javax.swing.JButton();
        jButtonAlterarPlanos = new javax.swing.JButton();
        jButtonRemoverPlanos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPesquisarPlanos = new javax.swing.JTextField();
        jTextFieldPlanosID = new javax.swing.JTextField();
        jTextFieldAcessos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableTeste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTeste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTesteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTeste);
        if (jTableTeste.getColumnModel().getColumnCount() > 0) {
            jTableTeste.getColumnModel().getColumn(0).setMinWidth(80);
            jTableTeste.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableTeste.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        jButtonAdicionar.setText("ADICIONAR");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonRemover.setText("REMOVER");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jLabel1.setText("Categoria:");

        jTextFieldId.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAdicionar)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonAlterar)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonRemover)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNome)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdicionar)
                            .addComponent(jButtonAlterar)
                            .addComponent(jButtonRemover))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Categorias", jPanel1);

        jLabel2.setText("Acessos Simultaneo:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Preço:");

        jTablePlanos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Acessos Silmultaneo", "Nome", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePlanos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePlanosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePlanos);
        if (jTablePlanos.getColumnModel().getColumnCount() > 0) {
            jTablePlanos.getColumnModel().getColumn(0).setMinWidth(80);
            jTablePlanos.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTablePlanos.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        jButtonAdicionarPlanos.setText("ADICIONAR");
        jButtonAdicionarPlanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarPlanosActionPerformed(evt);
            }
        });

        jButtonAlterarPlanos.setText("ALTERAR");
        jButtonAlterarPlanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarPlanosActionPerformed(evt);
            }
        });

        jButtonRemoverPlanos.setText("REMOVER");
        jButtonRemoverPlanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverPlanosActionPerformed(evt);
            }
        });

        jLabel5.setText("Pesquisar:");

        jTextFieldPlanosID.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldPlanosNome)
                            .addComponent(jTextFieldPlanosPrecos)
                            .addComponent(jTextFieldAcessos, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jButtonAdicionarPlanos)
                                .addGap(50, 50, 50)
                                .addComponent(jButtonAlterarPlanos)
                                .addGap(56, 56, 56)
                                .addComponent(jButtonRemoverPlanos)
                                .addGap(0, 101, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldPlanosID, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPesquisarPlanos)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPlanosID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAcessos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldPlanosNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldPlanosPrecos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdicionarPlanos)
                            .addComponent(jButtonAlterarPlanos)
                            .addComponent(jButtonRemoverPlanos))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisarPlanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Planos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        try {
            categoria.setCat_nome(jTextFieldNome.getText());
            categoriaBll.Adicionar(categoria);
            preencherGridCategoria();
            limparCampos();

            JOptionPane.showMessageDialog(null, "Categoria incluida com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        try {

            categoria.setCat_nome(jTextFieldNome.getText());
            if (categoria.getCat_nome().equals("")) {
                throw new Exception("Digite uma categoria a ser alterada!");
            }
            categoria.setCat_iden(Integer.parseInt(jTextFieldId.getText()));
            categoriaBll.Alterar(categoria);
            preencherGridCategoria();
            limparCampos();

            JOptionPane.showMessageDialog(null, "Categoria alterada!");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        try {
            if (jTextFieldNome.getText().equals("")) {
                throw new Exception("Digite uma categoria a ser removida!");
            }
            categoria.setCat_iden(Integer.parseInt(jTextFieldId.getText()));
            categoriaBll.Remover(categoria);
            preencherGridCategoria();
            limparCampos();

            JOptionPane.showMessageDialog(null, "Categoria removida com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jTableTesteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTesteMouseClicked
        try {
            preencherFormularioCategoris();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTableTesteMouseClicked

    private void jButtonAdicionarPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarPlanosActionPerformed
        try {
            planos.setPla_acesso_simultaneo(Integer.parseInt(jTextFieldAcessos.getText()));
            planos.setPla_nome(jTextFieldPlanosNome.getText());
            planos.setPla_preco(Float.parseFloat(jTextFieldPlanosPrecos.getText()));
            planosBll.Adicionar(planos);
            preencherGridPlanos();
            limparCamposPlanos();

            JOptionPane.showMessageDialog(null, "Plano incluido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAdicionarPlanosActionPerformed

    private void jButtonAlterarPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarPlanosActionPerformed
        
        try {
            if (jTextFieldAcessos.getText().equals("") && jTextFieldNome.getText().equals("") && jTextFieldPlanosPrecos.getText().equals("")) {
                throw new Exception("Digite um plano a ser alterado!");
            }
            planos.setPla_acesso_simultaneo(Integer.parseInt(jTextFieldAcessos.getText()));
            planos.setPla_nome(jTextFieldPlanosNome.getText());
            planos.setPla_preco(Float.parseFloat(jTextFieldPlanosPrecos.getText()));       
            planos.setPla_iden(Integer.parseInt(jTextFieldPlanosID.getText()));
            planosBll.Alterar(planos);
            preencherGridPlanos();
            limparCamposPlanos();

            JOptionPane.showMessageDialog(null, "Plano alterado!");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAlterarPlanosActionPerformed

    private void jButtonRemoverPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverPlanosActionPerformed
        try {
            if (jTextFieldAcessos.getText().equals("") && jTextFieldNome.getText().equals("") && jTextFieldPlanosPrecos.getText().equals("")) {
                throw new Exception("Digite um plano a ser removido!");
            }
            planos.setPla_iden(Integer.parseInt(jTextFieldPlanosID.getText()));
            planosBll.Remover(planos);
            preencherGridPlanos();
            limparCamposPlanos();

            JOptionPane.showMessageDialog(null, "Plano removido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonRemoverPlanosActionPerformed

    private void jTablePlanosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePlanosMouseClicked
        try {
            preencherFormularioPlanos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTablePlanosMouseClicked

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
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAdicionarPlanos;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonAlterarPlanos;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonRemoverPlanos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablePlanos;
    private javax.swing.JTable jTableTeste;
    private javax.swing.JTextField jTextFieldAcessos;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisarPlanos;
    private javax.swing.JTextField jTextFieldPlanosID;
    private javax.swing.JTextField jTextFieldPlanosNome;
    private javax.swing.JTextField jTextFieldPlanosPrecos;
    // End of variables declaration//GEN-END:variables
}
