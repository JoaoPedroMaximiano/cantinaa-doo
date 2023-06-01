package view.menuPrincipal;

import controller.bairro.ControllerCadastroBairro;
import controller.caixa.ControllerCadastroCaixa;
import controller.carteirinha.ControllerCadastroCarteirinha;
import controller.cidade.ControllerCadastroCidade;
import controller.cliente.ControllerCadastroCliente;
import controller.endereco.ControllerCadastroEndereco;
import controller.fornecedor.ControllerCadastroFornecedor;
import controller.funcionario.ControllerCadastroFuncionario;
import controller.produto.ControllerCadastroProduto;
import view.bairro.TelaCadastroBairro;
import view.caixa.TelaCadastroCaixa;
import view.carteirinha.TelaCadastroCarteirinha;
import view.cidade.TelaCadastroCidade;
import view.cliente.TelaCadastroCliente;
import view.endereco.TelaCadastroEndereco;
import view.fornecedor.TelaCadastroFornecedor;
import view.funcionario.TelaCadastroFuncionario;
import view.produto.TelaCadastroProduto;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        model.dao.Persiste.getInstancia();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemFornecedor = new javax.swing.JMenuItem();
        jMenuItemFuncionario = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemBairro = new javax.swing.JMenuItem();
        jMenuItemCidade = new javax.swing.JMenuItem();
        jMenuItemEndereco = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCarteirinha = new javax.swing.JMenuItem();
        jMenuItemProduto = new javax.swing.JMenuItem();
        jMenuItemCaixa = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuMovimentos = new javax.swing.JMenu();
        jMenuContas = new javax.swing.JMenu();
        jMenuItemPagar = new javax.swing.JMenuItem();
        jMenuItemReceber = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setMinimumSize(new java.awt.Dimension(770, 396));
        setResizable(false);
        setSize(new java.awt.Dimension(770, 396));

        jMenuCadastros.setText("Cadastros");

        jMenuItemCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/People.png"))); // NOI18N
        jMenuItemCliente.setText("Cliente");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCliente);

        jMenuItemFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Boss.png"))); // NOI18N
        jMenuItemFornecedor.setText("Fornecedor");
        jMenuItemFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFornecedorActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemFornecedor);

        jMenuItemFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Female.png"))); // NOI18N
        jMenuItemFuncionario.setText("Funcionário");
        jMenuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionarioActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemFuncionario);
        jMenuCadastros.add(jSeparator3);

        jMenuItemBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ruas.png"))); // NOI18N
        jMenuItemBairro.setText("Bairro");
        jMenuItemBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBairroActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemBairro);

        jMenuItemCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cidade.png"))); // NOI18N
        jMenuItemCidade.setText("Cidade");
        jMenuItemCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCidadeActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCidade);

        jMenuItemEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/endereco.png"))); // NOI18N
        jMenuItemEndereco.setText("Endereço");
        jMenuItemEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEnderecoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemEndereco);
        jMenuCadastros.add(jSeparator4);

        jMenuItemCarteirinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Message.png"))); // NOI18N
        jMenuItemCarteirinha.setText("Carteirinha");
        jMenuItemCarteirinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarteirinhaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCarteirinha);

        jMenuItemProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Buy.png"))); // NOI18N
        jMenuItemProduto.setText("Produto");
        jMenuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemProduto);

        jMenuItemCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Dollar.png"))); // NOI18N
        jMenuItemCaixa.setText("Caixa");
        jMenuItemCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCaixaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCaixa);
        jMenuCadastros.add(jSeparator5);

        jMenuItemSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemSair);

        jMenuBarPrincipal.add(jMenuCadastros);

        jMenuMovimentos.setText("Movimentos");

        jMenuContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Briefcase.png"))); // NOI18N
        jMenuContas.setText("Contas");

        jMenuItemPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fall.png"))); // NOI18N
        jMenuItemPagar.setText("Pagar");
        jMenuItemPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPagarActionPerformed(evt);
            }
        });
        jMenuContas.add(jMenuItemPagar);

        jMenuItemReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Dollar.png"))); // NOI18N
        jMenuItemReceber.setText("Receber");
        jMenuItemReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReceberActionPerformed(evt);
            }
        });
        jMenuContas.add(jMenuItemReceber);

        jMenuMovimentos.add(jMenuContas);

        jMenuBarPrincipal.add(jMenuMovimentos);

        jMenu3.setText("Relatórios ");
        jMenuBarPrincipal.add(jMenu3);

        jMenu4.setText("Ajuda");
        jMenuBarPrincipal.add(jMenu4);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCidadeActionPerformed
        TelaCadastroCidade telaCadastroCidade = new TelaCadastroCidade(null, true);
        ControllerCadastroCidade controllerCadastroCidade = new ControllerCadastroCidade(telaCadastroCidade);
        telaCadastroCidade.setVisible(true);
    }//GEN-LAST:event_jMenuItemCidadeActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPagarActionPerformed
    }//GEN-LAST:event_jMenuItemPagarActionPerformed

    private void jMenuItemReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReceberActionPerformed
    }//GEN-LAST:event_jMenuItemReceberActionPerformed

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente(null, true);
        ControllerCadastroCliente controllerCadastroCliente = new ControllerCadastroCliente(telaCadastroCliente);
        telaCadastroCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItemEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEnderecoActionPerformed
        TelaCadastroEndereco telaCadastroEndereco = new TelaCadastroEndereco(null, true);
        ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(telaCadastroEndereco);
        telaCadastroEndereco.setVisible(true);
    }//GEN-LAST:event_jMenuItemEnderecoActionPerformed

    private void jMenuItemBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBairroActionPerformed
        TelaCadastroBairro telaCadastroBairro = new TelaCadastroBairro(null, true);
        ControllerCadastroBairro controllerCadastroBairro = new ControllerCadastroBairro(telaCadastroBairro);
        telaCadastroBairro.setVisible(true);
    }//GEN-LAST:event_jMenuItemBairroActionPerformed

    private void jMenuItemFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFornecedorActionPerformed
        TelaCadastroFornecedor telaCadastroFornecedor = new TelaCadastroFornecedor(null, true);
        ControllerCadastroFornecedor controllerCadastroFornecedor = new ControllerCadastroFornecedor(telaCadastroFornecedor);
        telaCadastroFornecedor.setVisible(true);
    }//GEN-LAST:event_jMenuItemFornecedorActionPerformed

    private void jMenuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionarioActionPerformed
        TelaCadastroFuncionario telaCadastroFuncionario = new TelaCadastroFuncionario(null, true);
        ControllerCadastroFuncionario controllerCadastroFuncionario = new ControllerCadastroFuncionario(telaCadastroFuncionario);
        telaCadastroFuncionario.setVisible(true);
    }//GEN-LAST:event_jMenuItemFuncionarioActionPerformed

    private void jMenuItemCarteirinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarteirinhaActionPerformed
        TelaCadastroCarteirinha telaCadastroCarteirinha = new TelaCadastroCarteirinha(null, true);
        ControllerCadastroCarteirinha controllerCadastroCarteirinha = new ControllerCadastroCarteirinha(telaCadastroCarteirinha);
        telaCadastroCarteirinha.setVisible(true);
    }//GEN-LAST:event_jMenuItemCarteirinhaActionPerformed

    private void jMenuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdutoActionPerformed
        TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(null, true);
        ControllerCadastroProduto controllerCadastroProduto = new ControllerCadastroProduto(telaCadastroProduto);
        telaCadastroProduto.setVisible(true);
    }//GEN-LAST:event_jMenuItemProdutoActionPerformed

    private void jMenuItemCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCaixaActionPerformed
        TelaCadastroCaixa telaCadastroCaixa = new TelaCadastroCaixa(null, true);
        ControllerCadastroCaixa controllerCadastroCaixa = new ControllerCadastroCaixa(telaCadastroCaixa);
        telaCadastroCaixa.setVisible(true);
    }//GEN-LAST:event_jMenuItemCaixaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenu jMenuContas;
    private javax.swing.JMenuItem jMenuItemBairro;
    private javax.swing.JMenuItem jMenuItemCaixa;
    private javax.swing.JMenuItem jMenuItemCarteirinha;
    private javax.swing.JMenuItem jMenuItemCidade;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemEndereco;
    private javax.swing.JMenuItem jMenuItemFornecedor;
    private javax.swing.JMenuItem jMenuItemFuncionario;
    private javax.swing.JMenuItem jMenuItemPagar;
    private javax.swing.JMenuItem jMenuItemProduto;
    private javax.swing.JMenuItem jMenuItemReceber;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuMovimentos;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
