/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controlador.LivroDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.ModelTable;
import modelo.Livro;

/**
 *
 * @author Jackson Meires
 */
public class LivroGUI extends javax.swing.JFrame {

    private Livro objLivro;
    private LivroDAO objDAO;
    private boolean buscar = false;

    /**
     * Creates new form UsuarioGUI
     */
    public LivroGUI() {

        initComponents();

        //Centralizando a janela
        this.setLocationRelativeTo(null);
        // Impede que a janela seja redimencionada 
        this.setResizable(true);
        // Trocando cursor para HAND CURSOR(Maozinha)
        // jButtonRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        // Variavel con recebendo a conexao
        carregarTable(null);
    }

    // Metodo que realiza conexao com o banco, faz uma instrucao Query(select)
    // para jogar na JTable atraves do modelo de tabela (ModelTabel.java)
    public void carregarTable(Livro objLivro) {

        objDAO = new LivroDAO();
        ArrayList dados = new ArrayList();
        if (buscar) {
            dados = objDAO.buscar(objLivro);
        } else {
            objLivro = new Livro();
            dados = objDAO.listarTodos();
        }
        String[] colunas = objLivro.getColunas();

        ModelTable modelo = new ModelTable(dados, colunas);

        tbListagemLivros.setModel(modelo);
        tbListagemLivros.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbListagemLivros.getColumnModel().getColumn(0).setResizable(false);
        tbListagemLivros.getColumnModel().getColumn(1).setPreferredWidth(250);
        tbListagemLivros.getColumnModel().getColumn(1).setResizable(false);
        tbListagemLivros.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbListagemLivros.getColumnModel().getColumn(2).setResizable(false);
        tbListagemLivros.getTableHeader().setReorderingAllowed(false);
        //  tbListagemUsuario.setAutoResizeMode(tbListagemUsuario.AUTO_RESIZE_ALL_COLUMNS);
        // tbListagemUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Metodo responsavel por selecionar um registro ao clicar ou seguir com as setas do teclado
    // na JTable, e realizar a vinculacao do mesmo nos TextFields
    public void selectRegistryTable() {

        txtID_Livro.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 0).toString());
        txtTitulo.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 1).toString());
        txtAutor.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 2).toString());
        txtCategoria.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 3).toString());
        txtEditora.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 4).toString());
        txtEdicao.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 5).toString());
        txtIsbn.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 6).toString());
        txtQuantidade.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 7).toString());
        txtStatus.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 8).toString());
        txtCorredor.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 9).toString());        
        txtPrateleira.setText(tbListagemLivros.getValueAt(tbListagemLivros.getSelectedRow(), 10).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEditora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tbnLimpar = new javax.swing.JButton();
        tbnSalvar = new javax.swing.JButton();
        tbnExit = new javax.swing.JButton();
        tbnExit1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListagemLivros = new javax.swing.JTable();
        txtID_Livro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtEdicao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCorredor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPrateleira = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("LIVROS");

        jLabel2.setText("Titulo");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });

        jLabel3.setText("Autor");

        jLabel4.setText("Editora");

        jLabel5.setText("Categoria");

        tbnLimpar.setText("Limpar");
        tbnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnLimparActionPerformed(evt);
            }
        });

        tbnSalvar.setText("Adicionar / Atualizar");
        tbnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSalvarActionPerformed(evt);
            }
        });

        tbnExit.setText("Sair");
        tbnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExitActionPerformed(evt);
            }
        });

        tbnExit1.setText("Testar Conex�o");
        tbnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExit1ActionPerformed(evt);
            }
        });

        tbListagemLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Email", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListagemLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListagemLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListagemLivros);

        txtID_Livro.setEditable(false);

        jLabel6.setText("ID");

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel7.setText("Edi��o");

        txtEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdicaoActionPerformed(evt);
            }
        });

        jLabel8.setText("ISBN");

        txtIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIsbnActionPerformed(evt);
            }
        });

        jLabel9.setText("Quantidade");

        jLabel10.setText("status");

        jLabel11.setText("Corredor");

        txtCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorredorActionPerformed(evt);
            }
        });

        jLabel12.setText("Prateleira");

        txtPrateleira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrateleiraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtID_Livro, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 920, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tbnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tbnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeletar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(txtTitulo)
                                            .addComponent(txtCategoria)
                                            .addComponent(txtEditora, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                            .addComponent(txtAutor))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9)
                                            .addComponent(txtEdicao)
                                            .addComponent(txtQuantidade)
                                            .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                            .addComponent(txtIsbn)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addGap(51, 51, 51)))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(txtCorredor)
                                    .addComponent(txtPrateleira, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbnExit1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(tbnExit)))
                        .addGap(298, 298, 298))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jLabel6)
                .addGap(14, 14, 14)
                .addComponent(txtID_Livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrateleira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbnLimpar)
                            .addComponent(tbnSalvar)
                            .addComponent(btnDeletar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tbnExit1)
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbnExit)
                            .addComponent(btnBuscar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void tbnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSalvarActionPerformed

        objLivro = new Livro();
        objLivro.setId_Livro(txtID_Livro.getText());
        objLivro.setTitulo(txtTitulo.getText());
        objLivro.setAutor(txtAutor.getText());
        objLivro.setCategoria(txtCategoria.getText());
        objLivro.setEditora(txtEditora.getText());
        objLivro.setEdicao(txtEdicao.getText());
        objLivro.setIsbn(txtIsbn.getText());
        objLivro.setQuantidade(txtQuantidade.getText());
        objLivro.setStatus(txtStatus.getText());
        objLivro.setCorredor(txtCorredor.getText());
        objLivro.setPrateleira(txtPrateleira.getText());

        // fazendo a valida��o dos dados
        if ((txtTitulo.getText().isEmpty()) || (txtAutor.getText().isEmpty()) || (txtCategoria.getText().isEmpty()) || (txtEditora.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new LivroDAO();
            objDAO.salvar(objLivro);
            JOptionPane.showMessageDialog(null, "Livro " + txtTitulo.getText() + " inserido com sucesso! ");
        }

        carregarTable(null);

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_tbnSalvarActionPerformed

    private void tbnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnLimparActionPerformed
        setClear();
        carregarTable(null);
    }//GEN-LAST:event_tbnLimparActionPerformed

    private void tbnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_tbnExitActionPerformed

    private void tbnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExit1ActionPerformed
        try {
            LivroDAO.testarConexao();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_tbnExit1ActionPerformed

    private void tbListagemLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListagemLivrosMouseClicked
        // TODO add your handling code here:
        selectRegistryTable();
    }//GEN-LAST:event_tbListagemLivrosMouseClicked

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        objLivro.setId_Livro(txtID_Livro.getText());

        // fazendo a valida��o dos dados
        if ((txtID_Livro.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new LivroDAO();
            objDAO.deletar(objLivro);
            JOptionPane.showMessageDialog(null, "Livro Removido com Sucesso! ");
        }

        carregarTable(null);

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        objLivro = new Livro();
        objLivro.setTitulo(txtTitulo.getText());
        objLivro.setAutor(txtAutor.getText());
        objLivro.setEdicao(txtEdicao.getText());

        // fazendo a valida��o dos dados
        if ((!txtTitulo.getText().isEmpty()) || (!txtAutor.getText().isEmpty()) || (!txtEdicao.getText().isEmpty())) {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new LivroDAO();
            buscar = true;
            carregarTable(objLivro);
        }else{
            buscar = false;
            carregarTable(null);
        }

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdicaoActionPerformed

    private void txtIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIsbnActionPerformed

    private void txtCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorredorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorredorActionPerformed

    private void txtPrateleiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrateleiraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrateleiraActionPerformed

    public void setClear() {
        txtID_Livro.setText(null);
        txtTitulo.setText(null);
        txtAutor.setText(null);
        txtCategoria.setText(null);
        txtEditora.setText(null);
        txtEdicao.setText(null);
        txtIsbn.setText(null);
        txtQuantidade.setText(null);
        txtStatus.setText(null);
        txtCorredor.setText(null);
        txtPrateleira.setText(null);
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
            java.util.logging.Logger.getLogger(LivroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LivroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LivroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LivroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LivroGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListagemLivros;
    private javax.swing.JButton tbnExit;
    private javax.swing.JButton tbnExit1;
    private javax.swing.JButton tbnLimpar;
    private javax.swing.JButton tbnSalvar;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCorredor;
    private javax.swing.JTextField txtEdicao;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtID_Livro;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtPrateleira;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
