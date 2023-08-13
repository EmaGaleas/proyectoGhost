/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1_progra2;

import java.util.Date;
import proyecto1_progra2.clases_o.*;



public class datos extends javax.swing.JFrame {
  private String username;

    public datos(String username) {
        
        this.username=username;
        initComponents();
        nameU.setText(username);
        String pass= Player.getInstancia().obtenerContraseña(username);
        contra.setText(pass);
        Date fechaCreacionUsuario = Player.getInstancia().obtenerFechaCreacion(username);
        fechaC.setText(fechaCreacionUsuario.toString());
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_perfil = new javax.swing.JButton();
        fechaC = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        f_datos = new javax.swing.JLabel();
        nameU = new javax.swing.JLabel();
        contra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        btn_perfil.setBackground(new java.awt.Color(229, 139, 6));
        btn_perfil.setFont(new java.awt.Font("Doctor Soos Light", 0, 30)); // NOI18N
        btn_perfil.setForeground(new java.awt.Color(255, 255, 255));
        btn_perfil.setText("MI PERFIL");
        btn_perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_perfilMouseClicked(evt);
            }
        });

        fechaC.setFont(new java.awt.Font("Doctor Soos Bold", 0, 40)); // NOI18N
        fechaC.setForeground(new java.awt.Color(255, 255, 255));
        fechaC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaC.setText("Nombre de Usuario");
        fechaC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Doctor Soos Bold", 0, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nombre de Usuario");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Doctor Soos Bold", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Contraseña");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Doctor Soos Bold", 0, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fecha de creación");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        f_datos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f_datos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo/f_mis_datos.png"))); // NOI18N
        f_datos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nameU.setFont(new java.awt.Font("Doctor Soos Bold", 0, 40)); // NOI18N
        nameU.setForeground(new java.awt.Color(255, 255, 255));
        nameU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameU.setText("Nombre de Usuario");
        nameU.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        contra.setFont(new java.awt.Font("Doctor Soos Bold", 0, 40)); // NOI18N
        contra.setForeground(new java.awt.Color(255, 255, 255));
        contra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contra.setText("Nombre de Usuario");
        contra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(573, Short.MAX_VALUE)
                .addComponent(btn_perfil)
                .addGap(570, 570, 570))
            .addComponent(nameU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fechaC, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(f_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameU, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fechaC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btn_perfil)
                .addGap(45, 45, 45))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(f_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_perfilMouseClicked
        perfil volver=new perfil(username);
        volver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_perfilMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_perfil;
    private javax.swing.JLabel contra;
    private javax.swing.JLabel f_datos;
    private javax.swing.JLabel fechaC;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel nameU;
    // End of variables declaration//GEN-END:variables
}
