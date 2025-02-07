package view;

import controller.SalaControl;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import model.entities.Usuario;

/**
 *
 * @author Scalco
 */
public class TelaCadastrarSala extends javax.swing.JFrame {

    private static TelaCadastrarSala unicCadastrarSala;
    private Usuario usuario;

    private TelaCadastrarSala(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
    }

    public static TelaCadastrarSala geraCadastrarSala(Usuario usuario) {
        if (unicCadastrarSala == null) {
            unicCadastrarSala = new TelaCadastrarSala(usuario);
        }

        return unicCadastrarSala;
    }

    public void abrirTela() {
        setVisible(true);
        gerarAssentos();
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
        nome_input = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cadastrar_botao = new javax.swing.JButton();
        voltar_botao = new javax.swing.JButton();
        largura_input = new javax.swing.JFormattedTextField();
        assentos_panel = new javax.swing.JPanel();
        filme_label = new javax.swing.JLabel();
        profundidade_input = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Sala");
        setMinimumSize(new java.awt.Dimension(661, 569));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastrar Sala");

        jLabel2.setText("Nome da sala");

        nome_input.setToolTipText("Nome da sala");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("X");

        jLabel4.setText("Dimensões");

        cadastrar_botao.setText("Cadastrar");
        cadastrar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_botaoActionPerformed(evt);
            }
        });

        voltar_botao.setText("Voltar");
        voltar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar_botaoActionPerformed(evt);
            }
        });

        largura_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        largura_input.setText("2");
        largura_input.setToolTipText("Largura");
        largura_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largura_inputActionPerformed(evt);
            }
        });
        largura_input.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                largura_inputPropertyChange(evt);
            }
        });

        filme_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filme_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filme_label.setText("Filme");

        javax.swing.GroupLayout assentos_panelLayout = new javax.swing.GroupLayout(assentos_panel);
        assentos_panel.setLayout(assentos_panelLayout);
        assentos_panelLayout.setHorizontalGroup(
            assentos_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filme_label, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        assentos_panelLayout.setVerticalGroup(
            assentos_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assentos_panelLayout.createSequentialGroup()
                .addContainerGap(449, Short.MAX_VALUE)
                .addComponent(filme_label)
                .addContainerGap())
        );

        profundidade_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        profundidade_input.setText("2");
        profundidade_input.setToolTipText("Largura");
        profundidade_input.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                profundidade_inputPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(largura_input, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profundidade_input, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(voltar_botao)
                    .addComponent(jLabel1)
                    .addComponent(nome_input, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cadastrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(assentos_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(largura_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profundidade_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assentos_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltar_botao))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar_botaoActionPerformed
        voltar();
    }//GEN-LAST:event_voltar_botaoActionPerformed

    private void profundidade_inputPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_profundidade_inputPropertyChange
        formatarInputParaNumeroPositivo(profundidade_input, 9);
        gerarAssentos();
    }//GEN-LAST:event_profundidade_inputPropertyChange

    private void largura_inputPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_largura_inputPropertyChange
        formatarInputParaNumeroPositivo(largura_input, 7);
        gerarAssentos();
    }//GEN-LAST:event_largura_inputPropertyChange

    private void largura_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largura_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_largura_inputActionPerformed

    private void cadastrar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_botaoActionPerformed
        criarSala();
    }//GEN-LAST:event_cadastrar_botaoActionPerformed

    private void criarSala() {
        String nome = nome_input.getText();
        Integer largura = Integer.parseInt(largura_input.getText());
        Integer profundidade = Integer.parseInt(profundidade_input.getText());

        boolean sucesso;

        try {
            SalaControl sala = new SalaControl();
            sucesso = sala.cadastrarSala(nome, largura, profundidade);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                voltar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro no preenchimento de campos!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }
    
    private void voltar() {
        dispose();
        limparTela();
        TelaGerenciarSala.geraTelaGerenciarSala(usuario).abrirTela();
    }

    private void limparTela() {
        nome_input.setText("");
        profundidade_input.setText("2");
        largura_input.setText("2");
    }

    private void formatarInputParaNumeroPositivo(javax.swing.JFormattedTextField input, int max) {
        String value = input.getText();
        String sanitizedValue = value.replaceAll("[^\\d]", "");
        if (sanitizedValue.isEmpty() || sanitizedValue.isBlank()) {
            input.setText("1");
            return;
        }

        int number = Integer.parseInt(sanitizedValue);

        if (number > max) {
            number = max;
        } else if (number < 1) {
            number = 1;
        }

        input.setText(Integer.toString(number));
    }

    private void gerarAssentos() {
        assentos_panel.removeAll();

        int largura = Integer.parseInt(largura_input.getText());
        int profundidade = Integer.parseInt(profundidade_input.getText());

        int panelHeight = 438;
        int assentoW = 47;
        int assentoH = 30;
        int space = 5;
        int x = 0;
        int y = panelHeight - assentoH - 40;

        for (int letra = 0; letra < profundidade; letra++) {
            x = 0;
            for (int num = 1; num <= largura; num++) {
                String label = String.valueOf((char) (letra + 65)) + Integer.toString(num);
                javax.swing.JButton botao = new javax.swing.JButton();
                botao.setIconTextGap(0);
                botao.setFont(new java.awt.Font("Segoe UI", 0, 10));
                botao.setLabel(label);
                botao.setMargin(new java.awt.Insets(3, 0, 3, 0));
                botao.setBounds(x, y, assentoW, assentoH);

                assentos_panel.add(botao);

                x = x + assentoW + space;
            }
            y = y - assentoH - space;
        }

        filme_label.setBounds(0, panelHeight - 20, x - space, 20);
        assentos_panel.add(filme_label);

        assentos_panel.setPreferredSize(new Dimension(x - space, panelHeight));
        assentos_panel.revalidate();
        assentos_panel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel assentos_panel;
    private javax.swing.JButton cadastrar_botao;
    private javax.swing.JLabel filme_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFormattedTextField largura_input;
    private javax.swing.JTextField nome_input;
    private javax.swing.JFormattedTextField profundidade_input;
    private javax.swing.JButton voltar_botao;
    // End of variables declaration//GEN-END:variables
}
