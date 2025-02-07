package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.dao.DaoFactory;
import model.dao.FilmeDao;
import model.entities.Filme;

public class TelaCatalogoDeFilmes extends javax.swing.JFrame {

    private static TelaCatalogoDeFilmes unicCatalogoDeFilmes;

    private List<Filme> filmes = new ArrayList<>();

    private TelaCatalogoDeFilmes() {
    }

    public static TelaCatalogoDeFilmes geraCatalogoDeFilmes() {
        if (unicCatalogoDeFilmes == null) {
            unicCatalogoDeFilmes = new TelaCatalogoDeFilmes();
        }

        return unicCatalogoDeFilmes;
    }

    public void abrirTela() {
        buscarFilmes();
        initComponents();
        renderizaFilmes();
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

        BotaoEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        catalogo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catalogo de Filmes");

        BotaoEntrar.setText("Administrador - Entrar");
        BotaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEntrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Makes Cinema Easier");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        catalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catalogoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout catalogoLayout = new javax.swing.GroupLayout(catalogo);
        catalogo.setLayout(catalogoLayout);
        catalogoLayout.setHorizontalGroup(
            catalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
        );
        catalogoLayout.setVerticalGroup(
            catalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(catalogo);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Qual vai ser a aventura de hoje?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoEntrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoEntrar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEntrarActionPerformed
        goToLogin();
    }//GEN-LAST:event_BotaoEntrarActionPerformed

    private void catalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catalogoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_catalogoMouseClicked

    private void goToLogin() {
        dispose();
        TelaLogin.geraLogin().abrirTela();
    }

    private void buscarFilmes() {
        FilmeDao filmeDao = DaoFactory.createFilmeDao();
        filmes = filmeDao.listAvailables();
    }

    private void filmeClicado(java.awt.event.MouseEvent evt, int index) {
        dispose();
        TelaFilme.geraFilme().abrirTela(filmes.get(index));
    }

    private void renderizaFilmes() {
        int largura = 150;
        int altura = 200;
        int x = 45;
        int y = 20;

        for (int i = 0; i < filmes.size(); i++) {
            Filme filme = filmes.get(i);
            javax.swing.JPanel filmePanel = new javax.swing.JPanel();
            javax.swing.JLabel img = new javax.swing.JLabel();

            img.setPreferredSize(new Dimension(142, 160));
            img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            try {
                byte[] bytes = Base64.getDecoder().decode(filme.getBase64Image());
                ImageIcon imageIcon = new ImageIcon(bytes);
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(142, 160, java.awt.Image.SCALE_SMOOTH); 
                imageIcon = new ImageIcon(newimg);
                img.setIcon(imageIcon);
            } catch (Exception exc) {
                img.setText("Erro");
            }

            filmePanel.add(img);
            filmePanel.add(new javax.swing.JLabel(filme.getNome()));
            filmePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            filmePanel.setBounds(x, y, largura, altura);

            final int filmeIndex = i;
            filmePanel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    filmeClicado(evt, filmeIndex);
                }
            });

            catalogo.add(filmePanel);
            catalogo.setPreferredSize(new Dimension(617, y + altura + 30));
            catalogo.revalidate();
            catalogo.repaint();

            x = x + largura + 20;

            if ((i + 1) % 3 == 0) {
                y = y + altura + 20;
                x = 45;
            }
        }
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
            java.util.logging.Logger.getLogger(TelaCatalogoDeFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCatalogoDeFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCatalogoDeFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCatalogoDeFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCatalogoDeFilmes.geraCatalogoDeFilmes().abrirTela();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEntrar;
    private javax.swing.JPanel catalogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
