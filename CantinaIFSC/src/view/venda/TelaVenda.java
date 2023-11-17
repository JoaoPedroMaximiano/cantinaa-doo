package view.venda;

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

        jTextFieldCodigoBarraProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldCodigoBarraProduto.setFocusCycleRoot(true);
        jTextFieldCodigoBarraProduto.setFocusable(false);
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
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        jComboBoxCaixa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
        jTextFieldCodigoBarraCarteirinha.setFocusable(false);
        jTextFieldCodigoBarraCarteirinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoBarraCarteirinhaActionPerformed(evt);
            }
        });

        jLabelObs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelObs.setText("Observação");

        jTextAreaObs.setColumns(20);
        jTextAreaObs.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObs);

        jTextFieldQtd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldQtd.setFocusCycleRoot(true);
        jTextFieldQtd.setFocusable(false);
        jTextFieldQtd.setPreferredSize(new java.awt.Dimension(70, 31));
        jTextFieldQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdActionPerformed(evt);
            }
        });

        jLabelQtd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelQtd.setText("Qtd.");

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
                            .addComponent(jComboBoxCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoBarraProdutoActionPerformed

    private void jButtonIniciarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarVendaActionPerformed

    }//GEN-LAST:event_jButtonIniciarVendaActionPerformed

    private void jButtonFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFinalizarVendaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalActionPerformed

    private void jTextFieldCodigoBarraCarteirinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoBarraCarteirinhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoBarraCarteirinhaActionPerformed

    private void jTextFieldQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQtdActionPerformed

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
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
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
