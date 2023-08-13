/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1_progra2;

import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import proyecto1_progra2.clases_j.GhostGame;
import proyecto1_progra2.clases_o.*;


public class oponente extends javax.swing.JFrame {
    private String username;
    
    public oponente(String username) {
        initComponents();
        this.username=username;
        inicializarComboBox(username);
    }
    
    private void inicializarComboBox(String username) {
        info[] arregloPersonas = Player.getInstancia().getArregloPersonas();
        String[] nombresOponentes = Arrays.stream(arregloPersonas)
                                          .filter(p->p != null && !p.getUsername().equals(username))
                                          .map(info::getUsername)
                                          .toArray(String[]::new);

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(nombresOponentes);
        comboOponente.setModel(comboBoxModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        continuar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboOponente = new javax.swing.JComboBox<>();
        btn_menu = new javax.swing.JButton();
        sel = new javax.swing.JLabel();
        f_menu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        continuar.setBackground(new java.awt.Color(18, 29, 35));
        continuar.setFont(new java.awt.Font("Doctor Soos Light", 0, 32)); // NOI18N
        continuar.setForeground(new java.awt.Color(255, 255, 255));
        continuar.setText("CONTINUAR");
        continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                continuarMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Doctor Soos Light", 0, 54)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SELECCIONA UN OPONENTE");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        comboOponente.setFont(new java.awt.Font("Doctor Soos Light", 0, 20)); // NOI18N
        comboOponente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_menu.setBackground(new java.awt.Color(18, 29, 35));
        btn_menu.setFont(new java.awt.Font("Doctor Soos Light", 0, 32)); // NOI18N
        btn_menu.setForeground(new java.awt.Color(255, 255, 255));
        btn_menu.setText("REGRESAR");
        btn_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_menuMouseClicked(evt);
            }
        });

        sel.setText("jLabel2");

        f_menu.setBackground(new java.awt.Color(0, 0, 0));
        f_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo/f_menu.png"))); // NOI18N
        f_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(692, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(comboOponente, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(f_menu)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(comboOponente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(sel)
                .addGap(68, 68, 68)
                .addComponent(continuar)
                .addGap(36, 36, 36)
                .addComponent(btn_menu)
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(f_menu)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseClicked
        menu_principal volver=new menu_principal(username);
        volver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_menuMouseClicked

    private void continuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseClicked
         String oponenteSeleccionado = (String) comboOponente.getSelectedItem();
    
    if (oponenteSeleccionado != null) {
        GhostGame ghostGame = new GhostGame(); 
        ghostGame.setOponente(oponenteSeleccionado); 
        sel.setText(oponenteSeleccionado);
//        tablero tb=new tablero(username);
//        tb.setVisible(true);
//        this.setVisible(false);
    } else {
        JOptionPane.showMessageDialog(null, "Debes seleccionar un oponente antes de continuar.");
    }
    }//GEN-LAST:event_continuarMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_menu;
    private javax.swing.JComboBox<String> comboOponente;
    private javax.swing.JButton continuar;
    private javax.swing.JLabel f_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel sel;
    // End of variables declaration//GEN-END:variables
}
