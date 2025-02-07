package view;

import java.awt.Dimension;
import java.util.ArrayList;
import model.entities.Sessao;

/**
 *
 * @author Scalco
 */
public class TelaReservarAssentos extends javax.swing.JFrame {

    private static TelaReservarAssentos unicTelaReservarAssentos;

    private ArrayList<String> assentosReservados = new ArrayList<>();
    private Sessao sessao;

    private ArrayList<javax.swing.JTextField> nomeReservaInputs = new ArrayList<>();

    private TelaReservarAssentos() {
        initComponents();
    }

    public static TelaReservarAssentos geraTelaReservarAssentos() {
        if (unicTelaReservarAssentos == null) {
            unicTelaReservarAssentos = new TelaReservarAssentos();
        }

        return unicTelaReservarAssentos;
    }

    public void abrirTela(Sessao sessao, ArrayList<String> assentosReservados) {
        this.assentosReservados = assentosReservados;
        this.sessao = sessao;
        renderizaTela();
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
        jButton1 = new javax.swing.JButton();
        voltar_botao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservar_pnl = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reservar Assentos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Reservar assentos");

        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        voltar_botao.setText("Voltar");
        voltar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar_botaoActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        reservar_pnl.setPreferredSize(new java.awt.Dimension(600, 300));

        javax.swing.GroupLayout reservar_pnlLayout = new javax.swing.GroupLayout(reservar_pnl);
        reservar_pnl.setLayout(reservar_pnlLayout);
        reservar_pnlLayout.setHorizontalGroup(
            reservar_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        reservar_pnlLayout.setVerticalGroup(
            reservar_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(reservar_pnl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(voltar_botao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltar_botao, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar_botaoActionPerformed
        voltar();
    }//GEN-LAST:event_voltar_botaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void renderizaTela() {
        reservar_pnl.removeAll();
        
        int x = 6;
        int y = 6;
        int space = 18;

        int assentoLabelH = 20;
        int nomeLabelH = 16;
        int nomeInputH = 26;

        for (String assentoReservado : assentosReservados) {
            javax.swing.JLabel assentoLabel = new javax.swing.JLabel();
            javax.swing.JLabel nomeLabel = new javax.swing.JLabel();
            javax.swing.JTextField nomeInput = new javax.swing.JTextField();

            assentoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
            assentoLabel.setText("Assento " + assentoReservado);
            nomeLabel.setText("Nome:");
            nomeInput.setToolTipText("Coloque seu nome");

            assentoLabel.setBounds(x, y, 77, assentoLabelH);
            y = y + 6 + assentoLabelH;

            nomeLabel.setBounds(x, y, 77, nomeLabelH);
            y = y + 4 + assentoLabelH;

            nomeInput.setBounds(x, y, 250, nomeInputH);
            y = y + space + nomeInputH;
            
            reservar_pnl.add(assentoLabel);
            reservar_pnl.add(nomeLabel);
            reservar_pnl.add(nomeInput);
            
            nomeReservaInputs.add(nomeInput);
        }

        reservar_pnl.setPreferredSize(new Dimension(600, y));
        reservar_pnl.revalidate();
        reservar_pnl.repaint();
    }

    private void voltar() {
        dispose();
        TelaEscolherAssento.geraEscolherAssento().abrirTela(sessao);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel reservar_pnl;
    private javax.swing.JButton voltar_botao;
    // End of variables declaration//GEN-END:variables
}
