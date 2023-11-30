package view.venda;

import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaVenda extends javax.swing.JDialog {


    public TelaVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanelTitulo = new javax.swing.JPanel();
        labelTitulo = new java.awt.Label();
        jPanelCorpo = new javax.swing.JPanel();
        jLabelCodigoBarraProduto = new javax.swing.JLabel();
        jTextFieldCodigoBarraProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabelCaixa = new javax.swing.JLabel();
        jLabelCodigoBarraCarteirinha = new javax.swing.JLabel();
        jComboBoxCaixa = new javax.swing.JComboBox<>();
        jLabelCodigoBarraProduto3 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jTextFieldCodigoBarraCarteirinha = new javax.swing.JTextField();
        jLabelObs = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObs = new javax.swing.JTextArea();
        jTextFieldQtd = new javax.swing.JTextField();
        jLabelQtd = new javax.swing.JLabel();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonIniciarVenda = new javax.swing.JButton();
        jButtonFinalizarVenda = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setAlignment(java.awt.Label.CENTER);
        labelTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelTitulo.setName(""); // NOI18N
        labelTitulo.setText("Venda");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        labelTitulo.getAccessibleContext().setAccessibleName("");

        jPanelCorpo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelCodigoBarraProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCodigoBarraProduto.setText("Cód. de barra do produto");
        jLabelCodigoBarraProduto.setEnabled(false);

        jTextFieldCodigoBarraProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldCodigoBarraProduto.setEnabled(false);
        jTextFieldCodigoBarraProduto.setFocusCycleRoot(true);
        jTextFieldCodigoBarraProduto.setPreferredSize(new java.awt.Dimension(70, 31));
        jTextFieldCodigoBarraProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoBarraProdutoActionPerformed(evt);
            }
        });

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "Produto", "Valor", "Qtd.", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProdutos.setFocusable(false);
        jTableProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableProdutos);

        jLabelCaixa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCaixa.setText("Caixa");

        jLabelCodigoBarraCarteirinha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCodigoBarraCarteirinha.setText("Cód. de barra da carteirinha");

        jLabelCodigoBarraProduto3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCodigoBarraProduto3.setText("Total");

        jTextFieldTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldTotal.setFocusCycleRoot(true);
        jTextFieldTotal.setFocusTraversalPolicyProvider(true);
        jTextFieldTotal.setFocusable(false);
        jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalActionPerformed(evt);
            }
        });

        jTextFieldCodigoBarraCarteirinha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldCodigoBarraCarteirinha.setFocusCycleRoot(true);
        jTextFieldCodigoBarraCarteirinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoBarraCarteirinhaActionPerformed(evt);
            }
        });
        jTextFieldCodigoBarraCarteirinha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoBarraCarteirinhaKeyPressed(evt);
            }
        });

        jLabelObs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelObs.setText("Observação");

        jTextAreaObs.setColumns(20);
        jTextAreaObs.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObs);

        jTextFieldQtd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldQtd.setEnabled(false);
        jTextFieldQtd.setFocusCycleRoot(true);
        jTextFieldQtd.setPreferredSize(new java.awt.Dimension(70, 31));
        jTextFieldQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdActionPerformed(evt);
            }
        });

        jLabelQtd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelQtd.setText("Qtd.");
        jLabelQtd.setEnabled(false);

        javax.swing.GroupLayout jPanelCorpoLayout = new javax.swing.GroupLayout(jPanelCorpo);
        jPanelCorpo.setLayout(jPanelCorpoLayout);
        jPanelCorpoLayout.setHorizontalGroup(
            jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCorpoLayout.createSequentialGroup()
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelCodigoBarraProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jTextFieldCodigoBarraProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelObs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelCodigoBarraProduto3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldTotal)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodigoBarraCarteirinha)
                            .addComponent(jTextFieldCodigoBarraCarteirinha, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCaixa)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelCorpoLayout.setVerticalGroup(
            jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCaixa)
                            .addComponent(jLabelCodigoBarraCarteirinha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxCaixa)
                            .addComponent(jTextFieldCodigoBarraProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCodigoBarraCarteirinha)))
                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelQtd)
                            .addComponent(jLabelCodigoBarraProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                        .addComponent(jLabelObs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCodigoBarraProduto3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanelBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonIniciarVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonIniciarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jButtonIniciarVenda.setText("(F1) Iniciar venda");
        jButtonIniciarVenda.setActionCommand("0");
        jButtonIniciarVenda.setEnabled(false);
        jButtonIniciarVenda.setFocusable(false);
        jButtonIniciarVenda.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButtonIniciarVenda.setMaximumSize(new java.awt.Dimension(150, 26));
        jButtonIniciarVenda.setMinimumSize(new java.awt.Dimension(150, 26));
        jButtonIniciarVenda.setPreferredSize(new java.awt.Dimension(190, 30));
        jButtonIniciarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarVendaActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonIniciarVenda);

        jButtonFinalizarVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonFinalizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Buy.png"))); // NOI18N
        jButtonFinalizarVenda.setText("(F2) Finalizar venda");
        jButtonFinalizarVenda.setActionCommand("0");
        jButtonFinalizarVenda.setFocusable(false);
        jButtonFinalizarVenda.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButtonFinalizarVenda.setPreferredSize(new java.awt.Dimension(190, 30));
        jButtonFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarVendaActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonFinalizarVenda);

        jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete.png"))); // NOI18N
        jButtonCancelar.setText("(F3) Cancelar");
        jButtonCancelar.setActionCommand("0");
        jButtonCancelar.setFocusable(false);
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(190, 30));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCodigoBarraProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoBarraProdutoActionPerformed
    }//GEN-LAST:event_jTextFieldCodigoBarraProdutoActionPerformed

    private void jButtonIniciarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarVendaActionPerformed
    }//GEN-LAST:event_jButtonIniciarVendaActionPerformed

    private void jButtonFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarVendaActionPerformed
    }//GEN-LAST:event_jButtonFinalizarVendaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed
    }//GEN-LAST:event_jTextFieldTotalActionPerformed

    private void jTextFieldCodigoBarraCarteirinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoBarraCarteirinhaActionPerformed
    }//GEN-LAST:event_jTextFieldCodigoBarraCarteirinhaActionPerformed

    private void jTextFieldQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdActionPerformed
    }//GEN-LAST:event_jTextFieldQtdActionPerformed

    private void jTextFieldCodigoBarraCarteirinhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoBarraCarteirinhaKeyPressed
        if (rootPaneCheckingEnabled) {
        }
    }//GEN-LAST:event_jTextFieldCodigoBarraCarteirinhaKeyPressed

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JButton getjButtonFinalizarVenda() {
        return jButtonFinalizarVenda;
    }

    public void setjButtonFinalizarVenda(JButton jButtonFinalizarVenda) {
        this.jButtonFinalizarVenda = jButtonFinalizarVenda;
    }

    public JButton getjButtonIniciarVenda() {
        return jButtonIniciarVenda;
    }

    public void setjButtonIniciarVenda(JButton jButtonIniciarVenda) {
        this.jButtonIniciarVenda = jButtonIniciarVenda;
    }

    public JComboBox<String> getjComboBoxCaixa() {
        return jComboBoxCaixa;
    }

    public void setjComboBoxCaixa(JComboBox<String> jComboBoxCaixa) {
        this.jComboBoxCaixa = jComboBoxCaixa;
    }

    public JLabel getjLabelCaixa() {
        return jLabelCaixa;
    }

    public void setjLabelCaixa(JLabel jLabelCaixa) {
        this.jLabelCaixa = jLabelCaixa;
    }

    public JLabel getjLabelCodigoBarraCarteirinha() {
        return jLabelCodigoBarraCarteirinha;
    }

    public void setjLabelCodigoBarraCarteirinha(JLabel jLabelCodigoBarraCarteirinha) {
        this.jLabelCodigoBarraCarteirinha = jLabelCodigoBarraCarteirinha;
    }

    public JLabel getjLabelCodigoBarraProduto() {
        return jLabelCodigoBarraProduto;
    }

    public void setjLabelCodigoBarraProduto(JLabel jLabelCodigoBarraProduto) {
        this.jLabelCodigoBarraProduto = jLabelCodigoBarraProduto;
    }

    public JLabel getjLabelCodigoBarraProduto3() {
        return jLabelCodigoBarraProduto3;
    }

    public void setjLabelCodigoBarraProduto3(JLabel jLabelCodigoBarraProduto3) {
        this.jLabelCodigoBarraProduto3 = jLabelCodigoBarraProduto3;
    }

    public JLabel getjLabelObs() {
        return jLabelObs;
    }

    public void setjLabelObs(JLabel jLabelObs) {
        this.jLabelObs = jLabelObs;
    }

    public JLabel getjLabelQtd() {
        return jLabelQtd;
    }

    public void setjLabelQtd(JLabel jLabelQtd) {
        this.jLabelQtd = jLabelQtd;
    }

    public JPanel getjPanelBotoes() {
        return jPanelBotoes;
    }

    public void setjPanelBotoes(JPanel jPanelBotoes) {
        this.jPanelBotoes = jPanelBotoes;
    }

    public JPanel getjPanelCorpo() {
        return jPanelCorpo;
    }

    public void setjPanelCorpo(JPanel jPanelCorpo) {
        this.jPanelCorpo = jPanelCorpo;
    }

    public JPanel getjPanelTitulo() {
        return jPanelTitulo;
    }

    public void setjPanelTitulo(JPanel jPanelTitulo) {
        this.jPanelTitulo = jPanelTitulo;
    }

    public JProgressBar getjProgressBar1() {
        return jProgressBar1;
    }

    public void setjProgressBar1(JProgressBar jProgressBar1) {
        this.jProgressBar1 = jProgressBar1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getjTableProdutos() {
        return jTableProdutos;
    }

    public void setjTableProdutos(JTable jTableProdutos) {
        this.jTableProdutos = jTableProdutos;
    }

    public JTextArea getjTextAreaObs() {
        return jTextAreaObs;
    }

    public void setjTextAreaObs(JTextArea jTextAreaObs) {
        this.jTextAreaObs = jTextAreaObs;
    }

    public JTextField getjTextFieldCodigoBarraCarteirinha() {
        return jTextFieldCodigoBarraCarteirinha;
    }

    public void setjTextFieldCodigoBarraCarteirinha(JTextField jTextFieldCodigoBarraCarteirinha) {
        this.jTextFieldCodigoBarraCarteirinha = jTextFieldCodigoBarraCarteirinha;
    }

    public JTextField getjTextFieldCodigoBarraProduto() {
        return jTextFieldCodigoBarraProduto;
    }

    public void setjTextFieldCodigoBarraProduto(JTextField jTextFieldCodigoBarraProduto) {
        this.jTextFieldCodigoBarraProduto = jTextFieldCodigoBarraProduto;
    }

    public JTextField getjTextFieldQtd() {
        return jTextFieldQtd;
    }

    public void setjTextFieldQtd(JTextField jTextFieldQtd) {
        this.jTextFieldQtd = jTextFieldQtd;
    }

    public JTextField getjTextFieldTotal() {
        return jTextFieldTotal;
    }

    public void setjTextFieldTotal(JTextField jTextFieldTotal) {
        this.jTextFieldTotal = jTextFieldTotal;
    }

    public Label getLabelTitulo() {
        return labelTitulo;
    }

    public void setLabelTitulo(Label labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaVenda dialog = new TelaVenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonFinalizarVenda;
    private javax.swing.JButton jButtonIniciarVenda;
    private javax.swing.JComboBox<String> jComboBoxCaixa;
    private javax.swing.JLabel jLabelCaixa;
    private javax.swing.JLabel jLabelCodigoBarraCarteirinha;
    private javax.swing.JLabel jLabelCodigoBarraProduto;
    private javax.swing.JLabel jLabelCodigoBarraProduto3;
    private javax.swing.JLabel jLabelObs;
    private javax.swing.JLabel jLabelQtd;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelCorpo;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextArea jTextAreaObs;
    private javax.swing.JTextField jTextFieldCodigoBarraCarteirinha;
    private javax.swing.JTextField jTextFieldCodigoBarraProduto;
    private javax.swing.JTextField jTextFieldQtd;
    private javax.swing.JTextField jTextFieldTotal;
    private java.awt.Label labelTitulo;
    // End of variables declaration//GEN-END:variables
}
