package view.endereco;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCadastroEndereco extends javax.swing.JDialog {

    public TelaCadastroEndereco(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public void setjButtonBuscar(JButton jButtonBuscar) {
        this.jButtonBuscar = jButtonBuscar;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JButton getjButtonGravar() {
        return jButtonGravar;
    }

    public void setjButtonGravar(JButton jButtonGravar) {
        this.jButtonGravar = jButtonGravar;
    }

    public JButton getjButtonNovo() {
        return jButtonNovo;
    }

    public void setjButtonNovo(JButton jButtonNovo) {
        this.jButtonNovo = jButtonNovo;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public void setjButtonSair(JButton jButtonSair) {
        this.jButtonSair = jButtonSair;
    }

    public JComboBox<String> getjComboBoxBairro() {
        return jComboBoxBairro;
    }

    public void setjComboBoxBairro(JComboBox<String> jComboBoxBairro) {
        this.jComboBoxBairro = jComboBoxBairro;
    }

    public JComboBox<String> getjComboBoxCidade() {
        return jComboBoxCidade;
    }

    public void setjComboBoxCidade(JComboBox<String> jComboBoxCidade) {
        this.jComboBoxCidade = jComboBoxCidade;
    }

    public JComboBox<String> getjComboBoxStatus() {
        return jComboBoxStatus;
    }

    public void setjComboBoxStatus(JComboBox<String> jComboBoxStatus) {
        this.jComboBoxStatus = jComboBoxStatus;
    }

    public JFormattedTextField getjFormattedTextFieldCEP() {
        return jFormattedTextFieldCEP;
    }

    public void setjFormattedTextFieldCEP(JFormattedTextField jFormattedTextFieldCEP) {
        this.jFormattedTextFieldCEP = jFormattedTextFieldCEP;
    }

    public JFormattedTextField getjFormattedTextFieldLogradouro() {
        return jFormattedTextFieldLogradouro;
    }

    public void setjFormattedTextFieldLogradouro(JFormattedTextField jFormattedTextFieldLogradouro) {
        this.jFormattedTextFieldLogradouro = jFormattedTextFieldLogradouro;
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

    public JTextField getjTextFieldID() {
        return jTextFieldID;
    }

    public void setjTextFieldID(JTextField jTextFieldID) {
        this.jTextFieldID = jTextFieldID;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        labelTitulo = new java.awt.Label();
        jPanelCorpo = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelCEP = new javax.swing.JLabel();
        jFormattedTextFieldCEP = new javax.swing.JFormattedTextField();
        jLabelLogradouro = new javax.swing.JLabel();
        jFormattedTextFieldLogradouro = new javax.swing.JFormattedTextField();
        jLabelStatus = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jLabelBairro = new javax.swing.JLabel();
        jComboBoxCidade = new javax.swing.JComboBox<>();
        jLabelCidade = new javax.swing.JLabel();
        jComboBoxBairro = new javax.swing.JComboBox<>();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Endereço");
        setResizable(false);

        jPanelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setAlignment(java.awt.Label.CENTER);
        labelTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelTitulo.setName(""); // NOI18N
        labelTitulo.setText("Cadastro de Endereço");

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

        jLabelID.setText("ID");

        jTextFieldID.setEnabled(false);
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jLabelCEP.setText("CEP");

        try {
            jFormattedTextFieldCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCEP.setPreferredSize(new java.awt.Dimension(104, 22));

        jLabelLogradouro.setText("Logradouro");

        jFormattedTextFieldLogradouro.setPreferredSize(new java.awt.Dimension(104, 22));

        jLabelStatus.setText("Status");

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Desativado", "Pendente" }));

        jLabelBairro.setText("Bairro");

        jLabelCidade.setText("Cidade");

        jComboBoxBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBairroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCorpoLayout = new javax.swing.GroupLayout(jPanelCorpo);
        jPanelCorpo.setLayout(jPanelCorpoLayout);
        jPanelCorpoLayout.setHorizontalGroup(
            jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCEP)
                            .addComponent(jLabelID)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCorpoLayout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jLabelLogradouro)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelCorpoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                                        .addComponent(jLabelStatus)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jComboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelCorpoLayout.createSequentialGroup()
                                .addComponent(jLabelBairro)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxBairro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelCidade))
                            .addComponent(jFormattedTextFieldLogradouro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelCorpoLayout.setVerticalGroup(
            jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelID)
                            .addComponent(jLabelStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldID))
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLogradouro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCEP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFormattedTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCorpoLayout.createSequentialGroup()
                        .addGroup(jPanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBairro)
                            .addComponent(jLabelCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonNovo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.setActionCommand("0");
        jButtonNovo.setPreferredSize(new java.awt.Dimension(120, 40));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonNovo);

        jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancel.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setActionCommand("1");
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(120, 40));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonCancelar);

        jButtonGravar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/OK.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.setActionCommand("1");
        jButtonGravar.setPreferredSize(new java.awt.Dimension(120, 40));
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonGravar);

        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setActionCommand("0");
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(120, 40));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonBuscar);

        jButtonSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setActionCommand("0");
        jButtonSair.setPreferredSize(new java.awt.Dimension(120, 40));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonSair);

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
                .addComponent(jPanelCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jComboBoxBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBairroActionPerformed
    }//GEN-LAST:event_jComboBoxBairroActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
    }//GEN-LAST:event_jButtonSairActionPerformed

    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroEndereco dialog = new TelaCadastroEndereco(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxBairro;
    private javax.swing.JComboBox<String> jComboBoxCidade;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JFormattedTextField jFormattedTextFieldCEP;
    private javax.swing.JFormattedTextField jFormattedTextFieldLogradouro;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelCorpo;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JTextField jTextFieldID;
    private java.awt.Label labelTitulo;
    // End of variables declaration//GEN-END:variables
}
