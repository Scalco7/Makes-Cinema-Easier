package view;

import java.text.NumberFormat;
import java.util.regex.Pattern;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Scalco
 */
public class TelaCadastrarSala extends javax.swing.JFrame {

    private static TelaCadastrarSala unicCadastrarSala;

    private TelaCadastrarSala() {
        initComponents();
    }

    public static TelaCadastrarSala geraCadastrarSala() {
        if (unicCadastrarSala == null) {
            unicCadastrarSala = new TelaCadastrarSala();
        }

        return unicCadastrarSala;
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
        jLabel2 = new javax.swing.JLabel();
        nome_input = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        filme_label = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cadastrar_botao = new javax.swing.JButton();
        voltar_botao = new javax.swing.JButton();
        largura_input = new javax.swing.JFormattedTextField();
        assentos_panel = new javax.swing.JPanel();
        assento_botao_a_6 = new javax.swing.JButton();
        assento_botao_b_1 = new javax.swing.JButton();
        assento_botao_b_4 = new javax.swing.JButton();
        assento_botao_b_2 = new javax.swing.JButton();
        assento_botao_b_5 = new javax.swing.JButton();
        assento_botao_b_3 = new javax.swing.JButton();
        assento_botao_a_1 = new javax.swing.JButton();
        assento_botao_b_6 = new javax.swing.JButton();
        assento_botao_a_2 = new javax.swing.JButton();
        assento_botao_a_3 = new javax.swing.JButton();
        assento_botao_a_4 = new javax.swing.JButton();
        assento_botao_a_5 = new javax.swing.JButton();
        assento_botao_a_7 = new javax.swing.JButton();
        assento_botao_a_8 = new javax.swing.JButton();
        assento_botao_a_9 = new javax.swing.JButton();
        assento_botao_a_10 = new javax.swing.JButton();
        assento_botao_a_11 = new javax.swing.JButton();
        assento_botao_a_12 = new javax.swing.JButton();
        assento_botao_b_7 = new javax.swing.JButton();
        assento_botao_b_8 = new javax.swing.JButton();
        assento_botao_b_9 = new javax.swing.JButton();
        assento_botao_a_13 = new javax.swing.JButton();
        assento_botao_b_10 = new javax.swing.JButton();
        assento_botao_b_11 = new javax.swing.JButton();
        assento_botao_a_14 = new javax.swing.JButton();
        profundidade_input = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastrar Sala");

        jLabel2.setText("Nome da sala");

        nome_input.setToolTipText("Nome da sala");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("X");

        filme_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filme_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filme_label.setText("Filme");

        jLabel4.setText("Dimensões");

        cadastrar_botao.setText("Cadastrar");

        voltar_botao.setText("Voltar");
        voltar_botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar_botaoActionPerformed(evt);
            }
        });

        largura_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        largura_input.setText("2");
        largura_input.setToolTipText("Largura");
        largura_input.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                largura_inputPropertyChange(evt);
            }
        });

        assento_botao_a_6.setIconTextGap(0);
        assento_botao_a_6.setLabel("A6");
        assento_botao_a_6.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_6ActionPerformed(evt);
            }
        });

        assento_botao_b_1.setIconTextGap(0);
        assento_botao_b_1.setLabel("B6");
        assento_botao_b_1.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_1ActionPerformed(evt);
            }
        });

        assento_botao_b_4.setIconTextGap(0);
        assento_botao_b_4.setLabel("B3");
        assento_botao_b_4.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_4ActionPerformed(evt);
            }
        });

        assento_botao_b_2.setIconTextGap(0);
        assento_botao_b_2.setLabel("B1");
        assento_botao_b_2.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_2ActionPerformed(evt);
            }
        });

        assento_botao_b_5.setIconTextGap(0);
        assento_botao_b_5.setLabel("B4");
        assento_botao_b_5.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_5ActionPerformed(evt);
            }
        });

        assento_botao_b_3.setIconTextGap(0);
        assento_botao_b_3.setLabel("B2");
        assento_botao_b_3.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_3ActionPerformed(evt);
            }
        });

        assento_botao_a_1.setText("A1");
        assento_botao_a_1.setIconTextGap(0);
        assento_botao_a_1.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_1ActionPerformed(evt);
            }
        });

        assento_botao_b_6.setIconTextGap(0);
        assento_botao_b_6.setLabel("B5");
        assento_botao_b_6.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_6ActionPerformed(evt);
            }
        });

        assento_botao_a_2.setIconTextGap(0);
        assento_botao_a_2.setLabel("A2");
        assento_botao_a_2.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_2ActionPerformed(evt);
            }
        });

        assento_botao_a_3.setIconTextGap(0);
        assento_botao_a_3.setLabel("A3");
        assento_botao_a_3.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_3ActionPerformed(evt);
            }
        });

        assento_botao_a_4.setIconTextGap(0);
        assento_botao_a_4.setLabel("A4");
        assento_botao_a_4.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_4ActionPerformed(evt);
            }
        });

        assento_botao_a_5.setIconTextGap(0);
        assento_botao_a_5.setLabel("A5");
        assento_botao_a_5.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_5ActionPerformed(evt);
            }
        });

        assento_botao_a_7.setIconTextGap(0);
        assento_botao_a_7.setLabel("A6");
        assento_botao_a_7.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_7ActionPerformed(evt);
            }
        });

        assento_botao_a_8.setText("A1");
        assento_botao_a_8.setIconTextGap(0);
        assento_botao_a_8.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_8ActionPerformed(evt);
            }
        });

        assento_botao_a_9.setIconTextGap(0);
        assento_botao_a_9.setLabel("A2");
        assento_botao_a_9.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_9ActionPerformed(evt);
            }
        });

        assento_botao_a_10.setIconTextGap(0);
        assento_botao_a_10.setLabel("A4");
        assento_botao_a_10.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_10ActionPerformed(evt);
            }
        });

        assento_botao_a_11.setIconTextGap(0);
        assento_botao_a_11.setLabel("A3");
        assento_botao_a_11.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_11ActionPerformed(evt);
            }
        });

        assento_botao_a_12.setIconTextGap(0);
        assento_botao_a_12.setLabel("A5");
        assento_botao_a_12.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_12ActionPerformed(evt);
            }
        });

        assento_botao_b_7.setIconTextGap(0);
        assento_botao_b_7.setLabel("B1");
        assento_botao_b_7.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_7ActionPerformed(evt);
            }
        });

        assento_botao_b_8.setIconTextGap(0);
        assento_botao_b_8.setLabel("B1");
        assento_botao_b_8.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_8ActionPerformed(evt);
            }
        });

        assento_botao_b_9.setIconTextGap(0);
        assento_botao_b_9.setLabel("B1");
        assento_botao_b_9.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_9ActionPerformed(evt);
            }
        });

        assento_botao_a_13.setText("A1");
        assento_botao_a_13.setIconTextGap(0);
        assento_botao_a_13.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_13ActionPerformed(evt);
            }
        });

        assento_botao_b_10.setIconTextGap(0);
        assento_botao_b_10.setLabel("B1");
        assento_botao_b_10.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_10ActionPerformed(evt);
            }
        });

        assento_botao_b_11.setIconTextGap(0);
        assento_botao_b_11.setLabel("B1");
        assento_botao_b_11.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_b_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_b_11ActionPerformed(evt);
            }
        });

        assento_botao_a_14.setText("A1");
        assento_botao_a_14.setIconTextGap(0);
        assento_botao_a_14.setMargin(new java.awt.Insets(3, 5, 3, 5));
        assento_botao_a_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assento_botao_a_14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout assentos_panelLayout = new javax.swing.GroupLayout(assentos_panel);
        assentos_panel.setLayout(assentos_panelLayout);
        assentos_panelLayout.setHorizontalGroup(
            assentos_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assentos_panelLayout.createSequentialGroup()
                .addGroup(assentos_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(assentos_panelLayout.createSequentialGroup()
                        .addGroup(assentos_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(assentos_panelLayout.createSequentialGroup()
                                .addComponent(assento_botao_a_1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assento_botao_a_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assento_botao_a_3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assento_botao_a_4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assento_botao_a_5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assento_botao_a_6))
                            .addGroup(assentos_panelLayout.createSequentialGroup()
                                .addComponent(assento_botao_b_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assento_botao_b_3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assento_botao_b_4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assento_botao_b_5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assento_botao_b_6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assento_botao_b_1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assento_botao_a_8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assento_botao_a_9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assento_botao_a_11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assento_botao_a_10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assento_botao_a_12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assento_botao_a_7))
                    .addComponent(assento_botao_b_7)
                    .addComponent(assento_botao_a_13)
                    .addComponent(assento_botao_b_9)
                    .addComponent(assento_botao_b_8)
                    .addComponent(assento_botao_a_14)
                    .addComponent(assento_botao_b_10)
                    .addComponent(assento_botao_b_11))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        assentos_panelLayout.setVerticalGroup(
            assentos_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assentos_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(assento_botao_b_11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assento_botao_b_10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assento_botao_a_14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assento_botao_b_8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assento_botao_b_9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assento_botao_a_13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assento_botao_b_7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(assentos_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assento_botao_b_2)
                    .addComponent(assento_botao_b_3)
                    .addComponent(assento_botao_b_4)
                    .addComponent(assento_botao_b_5)
                    .addComponent(assento_botao_b_6)
                    .addComponent(assento_botao_b_1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(assentos_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assento_botao_a_1)
                    .addComponent(assento_botao_a_2)
                    .addComponent(assento_botao_a_3)
                    .addComponent(assento_botao_a_4)
                    .addComponent(assento_botao_a_5)
                    .addComponent(assento_botao_a_6)
                    .addComponent(assento_botao_a_8)
                    .addComponent(assento_botao_a_9)
                    .addComponent(assento_botao_a_11)
                    .addComponent(assento_botao_a_10)
                    .addComponent(assento_botao_a_12)
                    .addComponent(assento_botao_a_7))
                .addGap(24, 24, 24))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(voltar_botao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 236, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(filme_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(assentos_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(nome_input, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(largura_input, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profundidade_input, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(profundidade_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(assentos_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filme_label)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastrar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltar_botao))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void assento_botao_b_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_4ActionPerformed

    private void assento_botao_b_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_5ActionPerformed

    private void assento_botao_a_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_1ActionPerformed

    private void assento_botao_b_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_6ActionPerformed

    private void assento_botao_a_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_2ActionPerformed

    private void assento_botao_a_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_3ActionPerformed

    private void assento_botao_a_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_4ActionPerformed

    private void assento_botao_a_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_5ActionPerformed

    private void assento_botao_a_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_6ActionPerformed

    private void assento_botao_b_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_1ActionPerformed

    private void assento_botao_b_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_2ActionPerformed

    private void assento_botao_b_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_3ActionPerformed

    private void voltar_botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar_botaoActionPerformed
        voltar();
    }//GEN-LAST:event_voltar_botaoActionPerformed

    private void assento_botao_a_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_7ActionPerformed

    private void assento_botao_a_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_8ActionPerformed

    private void assento_botao_a_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_9ActionPerformed

    private void assento_botao_a_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_10ActionPerformed

    private void assento_botao_a_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_11ActionPerformed

    private void assento_botao_a_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_12ActionPerformed

    private void assento_botao_b_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_7ActionPerformed

    private void assento_botao_b_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_8ActionPerformed

    private void assento_botao_b_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_9ActionPerformed

    private void assento_botao_a_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_a_13ActionPerformed

    private void assento_botao_b_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_10ActionPerformed

    private void assento_botao_b_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_b_11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assento_botao_b_11ActionPerformed

    private void assento_botao_a_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assento_botao_a_14ActionPerformed

    }//GEN-LAST:event_assento_botao_a_14ActionPerformed

    private void profundidade_inputPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_profundidade_inputPropertyChange
        formatarInputParaNumeroPositivo(profundidade_input, 9);
    }//GEN-LAST:event_profundidade_inputPropertyChange

    private void largura_inputPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_largura_inputPropertyChange
        formatarInputParaNumeroPositivo(largura_input, 12);
    }//GEN-LAST:event_largura_inputPropertyChange

    private void voltar() {
        dispose();
        limparTela();
        TelaGerenciarSala.geraTelaGerenciarSala().abrirTela();
    }

    private void limparTela() {
        nome_input.setText("");
        profundidade_input.setText("2");
        profundidade_input.setText("2");
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

    private void gerarAssentos(){
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assento_botao_a_1;
    private javax.swing.JButton assento_botao_a_10;
    private javax.swing.JButton assento_botao_a_11;
    private javax.swing.JButton assento_botao_a_12;
    private javax.swing.JButton assento_botao_a_13;
    private javax.swing.JButton assento_botao_a_14;
    private javax.swing.JButton assento_botao_a_2;
    private javax.swing.JButton assento_botao_a_3;
    private javax.swing.JButton assento_botao_a_4;
    private javax.swing.JButton assento_botao_a_5;
    private javax.swing.JButton assento_botao_a_6;
    private javax.swing.JButton assento_botao_a_7;
    private javax.swing.JButton assento_botao_a_8;
    private javax.swing.JButton assento_botao_a_9;
    private javax.swing.JButton assento_botao_b_1;
    private javax.swing.JButton assento_botao_b_10;
    private javax.swing.JButton assento_botao_b_11;
    private javax.swing.JButton assento_botao_b_2;
    private javax.swing.JButton assento_botao_b_3;
    private javax.swing.JButton assento_botao_b_4;
    private javax.swing.JButton assento_botao_b_5;
    private javax.swing.JButton assento_botao_b_6;
    private javax.swing.JButton assento_botao_b_7;
    private javax.swing.JButton assento_botao_b_8;
    private javax.swing.JButton assento_botao_b_9;
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
