/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Scalco
 */
public class CadastrarFilme extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarFilme
     */
    public CadastrarFilme() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        linguagem_grupo = new javax.swing.ButtonGroup();
        idade_grupo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        filme_input = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricao_input = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        cadastrar_botao = new javax.swing.JButton();
        voltar_botao = new javax.swing.JButton();
        dublado_radio = new javax.swing.JRadioButton();
        legendado_radio = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        dez_radio = new javax.swing.JRadioButton();
        livre_radio = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        doze_radio = new javax.swing.JRadioButton();
        quatorze_radio = new javax.swing.JRadioButton();
        dezesseis_radio = new javax.swing.JRadioButton();
        dezoito_radio = new javax.swing.JRadioButton();
        image_action = new javax.swing.JButton();
        image_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastrar Filme");

        jLabel2.setText("Nome do filme");

        filme_input.setToolTipText("Nome do filme");

        descricao_input.setColumns(20);
        descricao_input.setRows(5);
        jScrollPane1.setViewportView(descricao_input);

        jLabel3.setText("Descrição");

        cadastrar_botao.setText("Cadastrar");

        voltar_botao.setText("Voltar");

        linguagem_grupo.add(dublado_radio);
        dublado_radio.setSelected(true);
        dublado_radio.setText("Dublado");
        dublado_radio.setToolTipText("Dublado");
        dublado_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dublado_radioActionPerformed(evt);
            }
        });

        linguagem_grupo.add(legendado_radio);
        legendado_radio.setText("Legendado");
        legendado_radio.setToolTipText("Legendado");
        legendado_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                legendado_radioActionPerformed(evt);
            }
        });

        jLabel4.setText("Idioma");

        idade_grupo.add(dez_radio);
        dez_radio.setText("10+");
        dez_radio.setToolTipText("10+");
        dez_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dez_radioActionPerformed(evt);
            }
        });

        idade_grupo.add(livre_radio);
        livre_radio.setSelected(true);
        livre_radio.setText("Livre");
        livre_radio.setToolTipText("Livre");
        livre_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                livre_radioActionPerformed(evt);
            }
        });

        jLabel5.setText("Classificação indicativa");

        idade_grupo.add(doze_radio);
        doze_radio.setText("12+");
        doze_radio.setToolTipText("12+");
        doze_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doze_radioActionPerformed(evt);
            }
        });

        idade_grupo.add(quatorze_radio);
        quatorze_radio.setText("14+");
        quatorze_radio.setToolTipText("14+");
        quatorze_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quatorze_radioActionPerformed(evt);
            }
        });

        idade_grupo.add(dezesseis_radio);
        dezesseis_radio.setText("16+");
        dezesseis_radio.setToolTipText("16+");
        dezesseis_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dezesseis_radioActionPerformed(evt);
            }
        });

        idade_grupo.add(dezoito_radio);
        dezoito_radio.setText("18+");
        dezoito_radio.setToolTipText("18+");
        dezoito_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dezoito_radioActionPerformed(evt);
            }
        });

        image_action.setText("Subir imagem");
        image_action.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image_actionActionPerformed(evt);
            }
        });

        image_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltar_botao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(filme_input)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dublado_radio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(legendado_radio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(livre_radio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dez_radio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(doze_radio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quatorze_radio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dezesseis_radio))
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dezoito_radio)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 83, Short.MAX_VALUE)
                                        .addComponent(image_label, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(image_action, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filme_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(image_label, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(image_action)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dublado_radio)
                    .addComponent(legendado_radio))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livre_radio)
                    .addComponent(dez_radio)
                    .addComponent(doze_radio)
                    .addComponent(quatorze_radio)
                    .addComponent(dezesseis_radio)
                    .addComponent(dezoito_radio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cadastrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltar_botao))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void legendado_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_legendado_radioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_legendado_radioActionPerformed

    private void dublado_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dublado_radioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dublado_radioActionPerformed

    private void dez_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dez_radioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dez_radioActionPerformed

    private void livre_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_livre_radioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_livre_radioActionPerformed

    private void doze_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doze_radioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doze_radioActionPerformed

    private void quatorze_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quatorze_radioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quatorze_radioActionPerformed

    private void dezesseis_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dezesseis_radioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dezesseis_radioActionPerformed

    private void dezoito_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dezoito_radioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dezoito_radioActionPerformed

    private void image_actionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image_actionActionPerformed
        Icon icon = image_label.getIcon();
        if (icon == null) {
            uploadImage();
        } else {
            resetImage();
        }
    }//GEN-LAST:event_image_actionActionPerformed
    
    private void uploadImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(getParent());
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                BufferedImage picture = ImageIO.read(file);

                image_label.setIcon(new ImageIcon(picture));
                image_action.setText("Remover imagem");
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
    }

    private void resetImage() {
        image_label.setIcon(null);
        image_action.setText("Subir imagem");
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
            java.util.logging.Logger.getLogger(CadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarFilme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar_botao;
    private javax.swing.JTextArea descricao_input;
    private javax.swing.JRadioButton dez_radio;
    private javax.swing.JRadioButton dezesseis_radio;
    private javax.swing.JRadioButton dezoito_radio;
    private javax.swing.JRadioButton doze_radio;
    private javax.swing.JRadioButton dublado_radio;
    private javax.swing.JTextField filme_input;
    private javax.swing.ButtonGroup idade_grupo;
    private javax.swing.JButton image_action;
    private javax.swing.JLabel image_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton legendado_radio;
    private javax.swing.ButtonGroup linguagem_grupo;
    private javax.swing.JRadioButton livre_radio;
    private javax.swing.JRadioButton quatorze_radio;
    private javax.swing.JButton voltar_botao;
    // End of variables declaration//GEN-END:variables
}
