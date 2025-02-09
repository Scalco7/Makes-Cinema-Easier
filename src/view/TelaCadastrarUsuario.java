package view;

import controller.UsuarioControl;
import javax.swing.JOptionPane;
import model.entities.Usuario;

/**
 *
 * @author Scalco
 */
public class TelaCadastrarUsuario extends javax.swing.JFrame {

    private static TelaCadastrarUsuario unicCadastrarUsuario;
    private Usuario usuario;

    private TelaCadastrarUsuario() {
        initComponents();
    }

    public static TelaCadastrarUsuario geraCadastrarUsuario() {
        if (unicCadastrarUsuario == null) {
            unicCadastrarUsuario = new TelaCadastrarUsuario();
        }

        return unicCadastrarUsuario;
    }

    public void abrirTela(Usuario usuario) {
        this.usuario = usuario;
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
        nome_input = new javax.swing.JTextField();
        nome_label = new javax.swing.JLabel();
        senha_label = new javax.swing.JLabel();
        senha_input = new javax.swing.JPasswordField();
        voltar_botao = new javax.swing.JButton();
        entrar_botao = new javax.swing.JButton();
        email_label = new javax.swing.JLabel();
        email_input = new javax.swing.JTextField();
        cpf_label = new javax.swing.JLabel();
        cpf_input = new javax.swing.JTextField();
        telefone_input = new javax.swing.JTextField();
        telefone_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Usuario");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro");

        nome_input.setToolTipText("Nome");

        nome_label.setText("Nome");

        senha_label.setText("Senha");

        senha_input.setToolTipText("Senha");
        senha_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senha_inputActionPerformed(evt);
            }
        });

        voltar_botao.setText("Voltar");
        voltar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar_botaoActionPerformed(evt);
            }
        });

        entrar_botao.setText("Cadastrar");
        entrar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrar_botaoActionPerformed(evt);
            }
        });

        email_label.setText("Email");

        email_input.setToolTipText("Email");

        cpf_label.setText("CPF");

        cpf_input.setToolTipText("CPF");

        telefone_input.setToolTipText("Telefone");

        telefone_label.setText("Telefone");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senha_input, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cpf_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome_input)
                            .addComponent(cpf_input, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefone_label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(telefone_input, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(email_input, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(voltar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(entrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltar_botao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(nome_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nome_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(cpf_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpf_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(telefone_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefone_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(email_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(email_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(senha_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senha_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(entrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar_botaoActionPerformed
        voltar();
    }//GEN-LAST:event_voltar_botaoActionPerformed

    private void entrar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrar_botaoActionPerformed
        criarConta();
    }//GEN-LAST:event_entrar_botaoActionPerformed

    private void senha_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senha_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senha_inputActionPerformed

    private void voltar() {
        limparTela();
        dispose();
        TelaCentralAdministrador.geraTelaCentralAdministrador().abrirTela(usuario);
    }
    
    private void limparTela(){
        cpf_input.setText("");
        nome_input.setText("");
        email_input.setText("");
        senha_input.setText("");
        telefone_input.setText("");
    }

    private void criarConta() {
        String cpf = cpf_input.getText();
        String nome = nome_input.getText();
        String email = email_input.getText();
        String senha = senha_input.getText();
        String telefone = telefone_input.getText();
        boolean sucesso;
        
        try{
            UsuarioControl user = new UsuarioControl(); 
            sucesso = user.cadastrarUsuario(cpf, nome, email, senha, telefone);
            if(sucesso){
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                voltar();
            } else{
                JOptionPane.showMessageDialog(null, "Erro no preenchimento de campos!");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf_input;
    private javax.swing.JLabel cpf_label;
    private javax.swing.JTextField email_input;
    private javax.swing.JLabel email_label;
    private javax.swing.JButton entrar_botao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nome_input;
    private javax.swing.JLabel nome_label;
    private javax.swing.JPasswordField senha_input;
    private javax.swing.JLabel senha_label;
    private javax.swing.JTextField telefone_input;
    private javax.swing.JLabel telefone_label;
    private javax.swing.JButton voltar_botao;
    // End of variables declaration//GEN-END:variables
}
