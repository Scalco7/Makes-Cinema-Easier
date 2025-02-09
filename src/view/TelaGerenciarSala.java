package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.DaoFactory;
import model.dao.SalaDao;
import model.entities.Sala;
import model.entities.Usuario;

/**
 *
 * @author Scalco
 */
public class TelaGerenciarSala extends javax.swing.JFrame {

    private static TelaGerenciarSala unicTelaGerenciarSala;
    private Usuario usuario;

    private TelaGerenciarSala() {
        initComponents();
    }

    public static TelaGerenciarSala geraTelaGerenciarSala() {
        if (unicTelaGerenciarSala == null) {
            unicTelaGerenciarSala = new TelaGerenciarSala();
        }

        return unicTelaGerenciarSala;
    }

    public void abrirTela(Usuario usuario) {
        this.usuario = usuario;
        atualizarTabela();
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
        nova_botao = new javax.swing.JButton();
        editar_botao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        voltar_botao = new javax.swing.JButton();
        pesquisar_input = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pesquisar_botao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciar Sala");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Salas");

        nova_botao.setText("Nova");
        nova_botao.setToolTipText("");
        nova_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nova_botaoActionPerformed(evt);
            }
        });

        editar_botao.setText("Editar");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Quantidade Assentos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setToolTipText("Tabela de filmes");
        jScrollPane1.setViewportView(tabela);

        voltar_botao.setText("Voltar");
        voltar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar_botaoActionPerformed(evt);
            }
        });

        pesquisar_input.setToolTipText("Barra de pesquisa");
        pesquisar_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisar_inputActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisar");

        pesquisar_botao.setText("Pesquisar");
        pesquisar_botao.setMaximumSize(new java.awt.Dimension(646, 647));
        pesquisar_botao.setMinimumSize(new java.awt.Dimension(646, 647));
        pesquisar_botao.setPreferredSize(new java.awt.Dimension(646, 647));
        pesquisar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisar_botaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltar_botao)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nova_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pesquisar_input)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisar_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nova_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pesquisar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(voltar_botao)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar_botaoActionPerformed
        voltar();
    }//GEN-LAST:event_voltar_botaoActionPerformed

    private void nova_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nova_botaoActionPerformed
        abrirTelaCadastrar();
    }//GEN-LAST:event_nova_botaoActionPerformed

    private void pesquisar_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisar_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisar_inputActionPerformed

    private void pesquisar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisar_botaoActionPerformed
        pesquisarSala();
    }//GEN-LAST:event_pesquisar_botaoActionPerformed

    private void voltar() {
        dispose();
        TelaCentralAdministrador.geraTelaCentralAdministrador().abrirTela(usuario);
    }

    private void abrirTelaCadastrar() {
        dispose();
        TelaCadastrarSala.geraCadastrarSala().abrirTela(usuario);
    }
    
    private void pesquisarSala() {
        String nomeSala = pesquisar_input.getText().trim();
        if (!nomeSala.isEmpty()) {
            SalaDao salaDao = DaoFactory.createSalaDao();
            List<Sala> salas = salaDao.findByName(nomeSala);
            atualizarTabela(salas);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, insira o nome do filme para pesquisa.");
        }
    }

    private void atualizarTabela(List<Sala> salas) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        
        int posLin = 0;
        modelo.setRowCount(posLin);
        for (Sala sala : salas) {
            modelo.insertRow(posLin, new Object[]{
                sala.getId(),
                sala.getNome(),
                sala.getLargura()*sala.getProfundidade()
            });
            posLin++;
        }
    }
    
    public void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        SalaDao salaDao = DaoFactory.createSalaDao();
        List<Sala> salas = salaDao.findByAll();
        int posLin = 0;
        modelo.setRowCount(posLin);

        for (Sala sala : salas) {
            modelo.insertRow(posLin, new Object[]{
                sala.getId(),
                sala.getNome(),
                sala.getLargura()*sala.getProfundidade()
            });
            posLin++;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editar_botao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nova_botao;
    private javax.swing.JButton pesquisar_botao;
    private javax.swing.JTextField pesquisar_input;
    private javax.swing.JTable tabela;
    private javax.swing.JButton voltar_botao;
    // End of variables declaration//GEN-END:variables
}
