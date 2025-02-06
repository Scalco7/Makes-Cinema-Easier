package view;

import controller.UsuarioControl;
import javax.swing.JOptionPane;

/**
 *
 * @author Scalco
 */
public class TelaLogin extends javax.swing.JFrame {

    private static TelaLogin unicLogin;

    private TelaLogin() {
        initComponents();
    }

    public static TelaLogin geraLogin() {
        if (unicLogin == null) {
            unicLogin = new TelaLogin();
        }

        return unicLogin;
    }

    public void abrirTela() {
        setVisible(true);
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
        email_input = new javax.swing.JTextField();
        email_label = new javax.swing.JLabel();
        senha_label = new javax.swing.JLabel();
        senha_input = new javax.swing.JPasswordField();
        voltar_botao = new javax.swing.JButton();
        entrar_botao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        email_input.setToolTipText("Email");

        email_label.setText("Email");

        senha_label.setText("Senha");

        senha_input.setToolTipText("Senha");

        voltar_botao.setText("Voltar");
        voltar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar_botaoActionPerformed(evt);
            }
        });

        entrar_botao.setText("Entrar");
        entrar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrar_botaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(entrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(296, 296, 296)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(email_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email_input)
                                    .addComponent(senha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(senha_input, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))))
                        .addGap(0, 202, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(96, 96, 96)
                .addComponent(email_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(senha_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(361, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(voltar_botao)
                    .addComponent(entrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar_botaoActionPerformed
        voltar();
    }//GEN-LAST:event_voltar_botaoActionPerformed

    private void entrar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrar_botaoActionPerformed
        fazerLogin();
    }//GEN-LAST:event_entrar_botaoActionPerformed

    private void voltar() {
        limparTela();
        dispose();
        TelaCatalogoDeFilmes.geraCatalogoDeFilmes().abrirTela();
    }

    private void vaiParaTelaCentral() {
        limparTela();
        dispose();
        TelaCentralAdministrador.geraTelaCentralAdministrador().abrirTela();
    }

    private void limparTela() {
        email_input.setText("");
        senha_input.setText("");
    }

    private void fazerLogin() {
        String email = email_input.getText();
        String senha = senha_input.getText();
        boolean sucesso;

        try {
            UsuarioControl user = new UsuarioControl();
            sucesso = user.login(email, senha);
            if (sucesso) {
                vaiParaTelaCentral();
            } else {
                JOptionPane.showMessageDialog(null, "Email ou senha incorretos!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email_input;
    private javax.swing.JLabel email_label;
    private javax.swing.JButton entrar_botao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField senha_input;
    private javax.swing.JLabel senha_label;
    private javax.swing.JButton voltar_botao;
    // End of variables declaration//GEN-END:variables
}
