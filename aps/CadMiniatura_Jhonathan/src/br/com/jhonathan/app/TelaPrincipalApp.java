/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 11/10/2020 13:33:52 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : APS - Arquitetura e Projeto de Software
 *  Aluno      : Jhonathan dos reis
 *  Projeto    : PROJETO CAMADAS
 *  Exercício  : Cadastro de miniaturas
 *  ---------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  ---------------------------------------------------------------------------------------------------| 
 */
package br.com.jhonathan.app;

import br.com.jhonathan.bll.FabricanteBll;
import br.com.jhonathan.bll.MiniaturaBll;
import br.com.jhonathan.bll.TemaBll;
import br.com.jhonathan.bll.TipoMiniaturaBll;
import br.com.jhonathan.model.Fabricante;
import br.com.jhonathan.model.Miniatura;
import br.com.jhonathan.model.Tema;
import br.com.jhonathan.model.TipoMiniatura;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JHONATHAN
 */
public class TelaPrincipalApp extends javax.swing.JFrame {
    private Miniatura miniatura;
    private MiniaturaBll miniaturaBll;
    private TipoMiniatura tipoMiniatura;
    private TipoMiniaturaBll TipoMiniaturaBll;
    private FabricanteBll fabricanteBll;
    private Fabricante fabricante;
    private TemaBll temaBll;
    private Tema tema;

    public TelaPrincipalApp() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
        miniatura = new Miniatura();
        miniaturaBll = new MiniaturaBll();
        TipoMiniaturaBll = new TipoMiniaturaBll();
        tipoMiniatura = new TipoMiniatura();
        fabricanteBll = new FabricanteBll();
        fabricante = new Fabricante();
        temaBll = new TemaBll();
        tema = new Tema();
        preencherGridTema();
        preencherGridFabricante();
        preencherGridTipoMiniatura();
        preencherGridMiniatura();
        preencherComboboxFabricante();
        popularComboboxTema();
        preencherComboboxTipo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
        
    }

    private void preencherGridTema() {

        try {

            DefaultTableModel tabelaTema = (DefaultTableModel) jTableTemas.getModel();
            tabelaTema.setRowCount(0);
            
            for (Tema tema : new TemaBll().getConsulta()) {
                tabelaTema.addRow(new Object[]{tema.getTem_iden(), tema.getTem_nome()});
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void preencherGridFabricante() {
        try {

            DefaultTableModel tabelaFabricante = (DefaultTableModel) jTableTemasFabricante.getModel();
            tabelaFabricante.setRowCount(0);

            //
            Object[] linha = new Object[2];
            
            ArrayList<Fabricante> fabricantes = new FabricanteBll().getConsulta();
                                
            for (Fabricante fabricante : fabricantes) {
                linha[0] = fabricante.getFab_iden();
                linha[1] = fabricante.getFab_nome();
                tabelaFabricante.addRow(linha);
            }
//            //
//            for (Tema tema : new TemaBll().getConsulta()) {
//                tabelaTema.addRow(new Object[]{tema.getTem_iden(), tema.getTem_nome()});
//            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void preencherGridTipoMiniatura() {
        
        try {

            DefaultTableModel tabelaMiniatura = (DefaultTableModel) jTableTipoMiniatura.getModel();
            tabelaMiniatura.setRowCount(0);

            //
            Object[] linha = new Object[2];
            
            ArrayList<TipoMiniatura> miniaturas = new TipoMiniaturaBll().getConsulta();
                                
            for (TipoMiniatura miniatura : miniaturas) {
                linha[0] = miniatura.getTmi_iden();
                linha[1] = miniatura.getTmi_tipo();
                tabelaMiniatura.addRow(linha);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void preencherGridMiniatura(){
        try {

            DefaultTableModel tabelaMiniatura = (DefaultTableModel) jTableMiniatura.getModel();
            tabelaMiniatura.setRowCount(0);

            //
            Object[] linha = new Object[7];
            
            ArrayList<Miniatura> miniaturas = new MiniaturaBll().getConsulta();
                                
            for (Miniatura miniatura : miniaturas) {
                linha[0] = "" + miniatura.getMin_iden();
                linha[1] = miniatura.getMin_modelo();
                linha[2] = miniatura.getMin_ano();
                linha[3] = miniatura.getMin_observacoes();
                linha[4] = miniatura.getMin_edicao();
                linha[5] = miniatura.getMin_escala();
                linha[6] = "" + miniatura.getMin_valor();
                tabelaMiniatura.addRow(linha);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    public void preencherFormulario() {

        int id = Integer.parseInt(jTableTemas.getValueAt(jTableTemas.getSelectedRow(), 0).toString());
        String nome = jTableTemas.getValueAt(jTableTemas.getSelectedRow(), 1).toString();

        jTextFieldNome.setText(nome);
        jTextFieldId.setText(id + "");

    }
    
    public void preencherFormularioFabricante() {

        int id = Integer.parseInt(jTableTemasFabricante.getValueAt(jTableTemasFabricante.getSelectedRow(), 0).toString());
        String nome = jTableTemasFabricante.getValueAt(jTableTemasFabricante.getSelectedRow(), 1).toString();

        jTextFieldNomeFabricante.setText(nome);
        jTextFieldIdFabricante.setText(id + "");

    }
    
    public void preencherFormularioTipoMiniatura() {
        
        int id = Integer.parseInt(jTableTipoMiniatura.getValueAt(jTableTipoMiniatura.getSelectedRow(), 0).toString());
        String tipo = jTableTipoMiniatura.getValueAt(jTableTipoMiniatura.getSelectedRow(), 1).toString();

        jTextFieldTipoMiniatura.setText(tipo);
        jTextFieldIdTipoMiniatura.setText(id + "");
    }
    
    public void preencherFormularioMiniatura() {
        
        int id = Integer.parseInt(jTableMiniatura.getValueAt(jTableMiniatura.getSelectedRow(), 0).toString());
        String modelo = jTableMiniatura.getValueAt(jTableMiniatura.getSelectedRow(), 1).toString();
        String ano = jTableMiniatura.getValueAt(jTableMiniatura.getSelectedRow(), 2).toString();
        String observacoes = jTableMiniatura.getValueAt(jTableMiniatura.getSelectedRow(), 3).toString();
        String edicao = jTableMiniatura.getValueAt(jTableMiniatura.getSelectedRow(), 4).toString();
        String escala = jTableMiniatura.getValueAt(jTableMiniatura.getSelectedRow(), 5).toString();
        String valor = jTableMiniatura.getValueAt(jTableMiniatura.getSelectedRow(), 6).toString();

        jTextFieldIdMiniatura.setText(id + "");
        jTextFieldModeloMiniatura.setText(modelo);
        jTextFieldAnoMiniatura.setText(ano);
        jTextFieldObservacoesMiniatura.setText(observacoes);
        jTextFieldEdicaoMiniatura.setText(edicao);
        jTextFieldEscalaMiniatura.setText(escala);
        jTextFieldValorMiniatura.setText(valor);
        
    }
    
    private void preencherComboboxFabricante() throws Exception {
        
        ArrayList<Fabricante> lista = fabricanteBll.getConsulta();
        jComboBoxFabricantes.removeAllItems();
        jComboBoxFabricantes.addItem("<SELECIONE>");
        
        for (Fabricante fabricante : lista) {
            jComboBoxFabricantes.addItem(fabricante.getFab_nome());
        }

    }

    private void popularComboboxTema() throws Exception {
        ArrayList<Tema> lista = temaBll.getConsulta();

        jComboBoxTemas.removeAllItems();
        jComboBoxTemas.addItem("<SELECIONE>");

        for (Tema tema : lista) {
            jComboBoxTemas.addItem(tema.getTem_nome());
        }
    }

    private void preencherComboboxTipo() throws Exception {
        ArrayList<TipoMiniatura> Lista = TipoMiniaturaBll.getConsulta();
        jComboBoxTipoMiniatura.removeAllItems();
        jComboBoxTipoMiniatura.addItem("<SELECIONE>");

        for (TipoMiniatura tipoMiniatura : Lista) {
            jComboBoxTipoMiniatura.addItem(tipoMiniatura.getTmi_tipo());
        }
    }

    private void limparCampos() {
        jTextFieldNome.setText("");
        jTextFieldId.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTemas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTemasFabricante = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomeFabricante = new javax.swing.JTextField();
        jTextFieldIdFabricante = new javax.swing.JTextField();
        jButtonCadastrarFabricante = new javax.swing.JButton();
        jButtonAlterarFabricante = new javax.swing.JButton();
        jButtonExcluirFabricante = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTipoMiniatura = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTipoMiniatura = new javax.swing.JTextField();
        jTextFieldIdTipoMiniatura = new javax.swing.JTextField();
        jButtonCadastrarTipoMiniatura = new javax.swing.JButton();
        jButtonAlterarTipoMiniatura = new javax.swing.JButton();
        jButtonExcluirTipoMiniatura = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableMiniatura = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldModeloMiniatura = new javax.swing.JTextField();
        jTextFieldIdMiniatura = new javax.swing.JTextField();
        jButtonCadastrarMiniatura = new javax.swing.JButton();
        jButtonAlterarMiniatura = new javax.swing.JButton();
        jButtonExcluirMiniatura = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldObservacoesMiniatura = new javax.swing.JTextField();
        jTextFieldEdicaoMiniatura = new javax.swing.JTextField();
        jTextFieldAnoMiniatura = new javax.swing.JTextField();
        jTextFieldEscalaMiniatura = new javax.swing.JTextField();
        jTextFieldValorMiniatura = new javax.swing.JTextField();
        jComboBoxFabricantes = new javax.swing.JComboBox<>();
        jComboBoxTipoMiniatura = new javax.swing.JComboBox<>();
        jComboBoxTemas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        jTableTemas.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableTemas.getTableHeader().setReorderingAllowed(false);
        jTableTemas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTemasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTemas);
        if (jTableTemas.getColumnModel().getColumnCount() > 0) {
            jTableTemas.getColumnModel().getColumn(0).setMinWidth(80);
            jTableTemas.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableTemas.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        jLabel1.setText("ID:");

        jLabel2.setText("NOME:");

        jTextFieldId.setEditable(false);
        jTextFieldId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonCadastrar.setText("CADASTRAR");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonExcluir))
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 281, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCadastrar)
                        .addComponent(jButtonAlterar)
                        .addComponent(jButtonExcluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Temas", jPanel1);

        jTableTemasFabricante.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableTemasFabricante.getTableHeader().setReorderingAllowed(false);
        jTableTemasFabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTemasFabricanteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableTemasFabricante);
        if (jTableTemasFabricante.getColumnModel().getColumnCount() > 0) {
            jTableTemasFabricante.getColumnModel().getColumn(0).setMinWidth(80);
            jTableTemasFabricante.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableTemasFabricante.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        jLabel3.setText("ID:");

        jLabel4.setText("NOME:");

        jTextFieldIdFabricante.setEditable(false);
        jTextFieldIdFabricante.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonCadastrarFabricante.setText("CADASTRAR");
        jButtonCadastrarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarFabricanteActionPerformed(evt);
            }
        });

        jButtonAlterarFabricante.setText("ALTERAR");
        jButtonAlterarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarFabricanteActionPerformed(evt);
            }
        });

        jButtonExcluirFabricante.setText("EXCLUIR");
        jButtonExcluirFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirFabricanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextFieldNomeFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCadastrarFabricante)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAlterarFabricante)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluirFabricante))
                    .addComponent(jTextFieldIdFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(275, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldIdFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNomeFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrarFabricante)
                    .addComponent(jButtonAlterarFabricante)
                    .addComponent(jButtonExcluirFabricante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Fabricante", jPanel2);

        jTableTipoMiniatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTipoMiniatura.getTableHeader().setReorderingAllowed(false);
        jTableTipoMiniatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTipoMiniaturaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableTipoMiniatura);
        if (jTableTipoMiniatura.getColumnModel().getColumnCount() > 0) {
            jTableTipoMiniatura.getColumnModel().getColumn(0).setMinWidth(80);
            jTableTipoMiniatura.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableTipoMiniatura.getColumnModel().getColumn(0).setMaxWidth(80);
            jTableTipoMiniatura.getColumnModel().getColumn(1).setHeaderValue("MODELO");
        }

        jLabel5.setText("ID:");

        jLabel6.setText("NOME:");

        jTextFieldIdTipoMiniatura.setEditable(false);
        jTextFieldIdTipoMiniatura.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonCadastrarTipoMiniatura.setText("CADASTRAR");
        jButtonCadastrarTipoMiniatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarTipoMiniaturaActionPerformed(evt);
            }
        });

        jButtonAlterarTipoMiniatura.setText("ALTERAR");
        jButtonAlterarTipoMiniatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarTipoMiniaturaActionPerformed(evt);
            }
        });

        jButtonExcluirTipoMiniatura.setText("EXCLUIR");
        jButtonExcluirTipoMiniatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirTipoMiniaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextFieldTipoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCadastrarTipoMiniatura)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAlterarTipoMiniatura)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluirTipoMiniatura))
                    .addComponent(jTextFieldIdTipoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(275, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldIdTipoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTipoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrarTipoMiniatura)
                    .addComponent(jButtonAlterarTipoMiniatura)
                    .addComponent(jButtonExcluirTipoMiniatura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Tipo Miniatura", jPanel4);

        jTableMiniatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MODELO", "ANO", "OBSERVAÇÕES", "ESCALA", "EDICAO", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMiniatura.getTableHeader().setReorderingAllowed(false);
        jTableMiniatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMiniaturaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableMiniatura);
        if (jTableMiniatura.getColumnModel().getColumnCount() > 0) {
            jTableMiniatura.getColumnModel().getColumn(0).setMinWidth(80);
            jTableMiniatura.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableMiniatura.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        jLabel7.setText("ID:");

        jLabel8.setText("MODELO:");

        jTextFieldIdMiniatura.setEditable(false);
        jTextFieldIdMiniatura.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonCadastrarMiniatura.setText("CADASTRAR");
        jButtonCadastrarMiniatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarMiniaturaActionPerformed(evt);
            }
        });

        jButtonAlterarMiniatura.setText("ALTERAR");
        jButtonAlterarMiniatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarMiniaturaActionPerformed(evt);
            }
        });

        jButtonExcluirMiniatura.setText("EXCLUIR");
        jButtonExcluirMiniatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirMiniaturaActionPerformed(evt);
            }
        });

        jLabel9.setText("OBSERVACOES:");

        jLabel10.setText("EDICAO:");

        jLabel11.setText("ANO:");

        jLabel12.setText("ESCALA:");

        jLabel13.setText("VALOR:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(81, 81, 81)
                                .addComponent(jTextFieldAnoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(66, 66, 66)
                                            .addComponent(jTextFieldValorMiniatura))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel9))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldObservacoesMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldEdicaoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldModeloMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldIdMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(60, 60, 60)
                                            .addComponent(jTextFieldEscalaMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel8))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonCadastrarMiniatura)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonAlterarMiniatura))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxTemas, 0, 166, Short.MAX_VALUE)
                                            .addComponent(jComboBoxTipoMiniatura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxFabricantes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addComponent(jButtonExcluirMiniatura)))
                        .addGap(0, 469, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldIdMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldModeloMiniatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jComboBoxFabricantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldObservacoesMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldEdicaoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldAnoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEscalaMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldValorMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrarMiniatura)
                    .addComponent(jButtonAlterarMiniatura)
                    .addComponent(jButtonExcluirMiniatura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Miniatura", jPanel6);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirFabricanteActionPerformed
        try {
            fabricante.setFab_iden(Integer.parseInt(jTextFieldIdFabricante.getText()));
            fabricanteBll.Remover(fabricante);
            preencherGridFabricante();

            JOptionPane.showMessageDialog(this, "Fabricante excluido!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonExcluirFabricanteActionPerformed

    private void jButtonAlterarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarFabricanteActionPerformed
        try {
            fabricante.setFab_iden(Integer.parseInt(jTextFieldIdFabricante.getText()));
            fabricante.setFab_nome(jTextFieldNomeFabricante.getText());
            fabricanteBll.Alterar(fabricante);
            preencherGridFabricante();
            limparCampos();

            JOptionPane.showMessageDialog(this, "Fabricante alterado!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonAlterarFabricanteActionPerformed

    private void jButtonCadastrarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarFabricanteActionPerformed
        try {
            fabricante.setFab_nome(jTextFieldNomeFabricante.getText());
            fabricanteBll.Adicionar(fabricante);
            preencherGridFabricante();
            limparCampos();

            JOptionPane.showMessageDialog(this, "Fabricante cadastrado!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonCadastrarFabricanteActionPerformed

    private void jTableTemasFabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTemasFabricanteMouseClicked
        try {
            preencherFormularioFabricante();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jTableTemasFabricanteMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

        try {

            tema.setTem_iden(Integer.parseInt(jTextFieldId.getText()));
            temaBll.Remover(tema);
            preencherGridTema();
            limparCampos();

            JOptionPane.showMessageDialog(this, "Tema excluido!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        try {
            tema.setTem_iden(Integer.parseInt(jTextFieldId.getText()));
            tema.setTem_nome(jTextFieldNome.getText());
            temaBll.Alterar(tema);
            preencherGridTema();
            limparCampos();

            JOptionPane.showMessageDialog(this, "Tema alterado!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        try {
            tema.setTem_nome(jTextFieldNome.getText());
            temaBll.Adicionar(tema);
            preencherGridTema();
            limparCampos();

            JOptionPane.showMessageDialog(this, "Tema cadastrado!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jTableTemasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTemasMouseClicked
        try {
            preencherFormulario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jTableTemasMouseClicked

    private void jTableTipoMiniaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTipoMiniaturaMouseClicked
        try {
            preencherFormularioTipoMiniatura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jTableTipoMiniaturaMouseClicked

    private void jButtonCadastrarTipoMiniaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarTipoMiniaturaActionPerformed
        try {
            tipoMiniatura.setTmi_tipo(jTextFieldTipoMiniatura.getText());
            TipoMiniaturaBll.Adicionar(tipoMiniatura);
            preencherGridTipoMiniatura();

            JOptionPane.showMessageDialog(this, "Tipo de Miniatura cadastrado!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonCadastrarTipoMiniaturaActionPerformed

    private void jButtonAlterarTipoMiniaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarTipoMiniaturaActionPerformed
        try {
            tipoMiniatura.setTmi_iden(Integer.parseInt(jTextFieldIdTipoMiniatura.getText()));
            tipoMiniatura.setTmi_tipo(jTextFieldTipoMiniatura.getText());
            TipoMiniaturaBll.Alterar(tipoMiniatura);
            preencherGridTipoMiniatura();
            
            JOptionPane.showMessageDialog(this, "Tipo de Miniatura alterado!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonAlterarTipoMiniaturaActionPerformed

    private void jButtonExcluirTipoMiniaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirTipoMiniaturaActionPerformed
        try {

            tipoMiniatura.setTmi_iden(Integer.parseInt(jTextFieldIdTipoMiniatura.getText()));
            TipoMiniaturaBll.Remover(tipoMiniatura);
            preencherGridTipoMiniatura();

            JOptionPane.showMessageDialog(this, "Tipo de Miniatura excluido!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonExcluirTipoMiniaturaActionPerformed

    private void jTableMiniaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMiniaturaMouseClicked
         try {
            preencherFormularioMiniatura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jTableMiniaturaMouseClicked

    private void jButtonCadastrarMiniaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarMiniaturaActionPerformed
        try {
            miniatura.setMin_modelo(jTextFieldModeloMiniatura.getText());
            miniatura.setMin_ano(Integer.parseInt(jTextFieldAnoMiniatura.getText()));
            miniatura.setMin_observacoes(jTextFieldObservacoesMiniatura.getText());
            miniatura.setMin_edicao(jTextFieldEdicaoMiniatura.getText());
            miniatura.setMin_escala(jTextFieldEscalaMiniatura.getText());
            miniatura.setMin_valor(Integer.parseInt(jTextFieldValorMiniatura.getText()));
            
            String nome = jComboBoxFabricantes.getSelectedItem().toString();
            fabricante = fabricanteBll.getFabricanteNome(nome);
            miniatura.setFabricante(fabricante);
            
            String nomeTipo = jComboBoxTipoMiniatura.getSelectedItem().toString();
            tipoMiniatura = TipoMiniaturaBll.getTipoMiniaturaNome(nomeTipo);
            miniatura.setTipoDeMiniatura(tipoMiniatura);
            
            String nomeTema = jComboBoxTemas.getSelectedItem().toString();
            tema = temaBll.getTemaNome(nomeTema);
            miniatura.setTema(tema);
            miniaturaBll.Adicionar(miniatura);
            preencherGridMiniatura();
            
            JOptionPane.showMessageDialog(this, "Miniatura cadastrada!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonCadastrarMiniaturaActionPerformed

    private void jButtonAlterarMiniaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarMiniaturaActionPerformed
        try {
            miniatura.setMin_modelo(jTextFieldModeloMiniatura.getText());
            miniatura.setMin_ano(Integer.parseInt(jTextFieldAnoMiniatura.getText()));
            miniatura.setMin_observacoes(jTextFieldObservacoesMiniatura.getText());
            miniatura.setMin_edicao(jTextFieldEdicaoMiniatura.getText());
            miniatura.setMin_escala(jTextFieldEscalaMiniatura.getText());
            miniatura.setMin_valor(Integer.parseInt(jTextFieldValorMiniatura.getText()));
            miniaturaBll.Adicionar(miniatura);
            preencherGridMiniatura();

            JOptionPane.showMessageDialog(this, "Miniatura alterada!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonAlterarMiniaturaActionPerformed

    private void jButtonExcluirMiniaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirMiniaturaActionPerformed
        try {

            miniatura.setMin_iden(Integer.parseInt(jTextFieldIdMiniatura.getText()));
            miniaturaBll.Remover(miniatura);
            preencherFormularioMiniatura();

            JOptionPane.showMessageDialog(this, "Miniatura excluida!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonExcluirMiniaturaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonAlterarFabricante;
    private javax.swing.JButton jButtonAlterarMiniatura;
    private javax.swing.JButton jButtonAlterarTipoMiniatura;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCadastrarFabricante;
    private javax.swing.JButton jButtonCadastrarMiniatura;
    private javax.swing.JButton jButtonCadastrarTipoMiniatura;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonExcluirFabricante;
    private javax.swing.JButton jButtonExcluirMiniatura;
    private javax.swing.JButton jButtonExcluirTipoMiniatura;
    private javax.swing.JComboBox<String> jComboBoxFabricantes;
    private javax.swing.JComboBox<String> jComboBoxTemas;
    private javax.swing.JComboBox<String> jComboBoxTipoMiniatura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableMiniatura;
    private javax.swing.JTable jTableTemas;
    private javax.swing.JTable jTableTemasFabricante;
    private javax.swing.JTable jTableTipoMiniatura;
    private javax.swing.JTextField jTextFieldAnoMiniatura;
    private javax.swing.JTextField jTextFieldEdicaoMiniatura;
    private javax.swing.JTextField jTextFieldEscalaMiniatura;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldIdFabricante;
    private javax.swing.JTextField jTextFieldIdMiniatura;
    private javax.swing.JTextField jTextFieldIdTipoMiniatura;
    private javax.swing.JTextField jTextFieldModeloMiniatura;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNomeFabricante;
    private javax.swing.JTextField jTextFieldObservacoesMiniatura;
    private javax.swing.JTextField jTextFieldTipoMiniatura;
    private javax.swing.JTextField jTextFieldValorMiniatura;
    // End of variables declaration//GEN-END:variables
}
