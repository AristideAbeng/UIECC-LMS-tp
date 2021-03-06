/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface1;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author KIBITI Wen Life
 */
public class FenetreTransaction extends javax.swing.JFrame {

    /**
     * Creates new form FenetreTransaction
     */
    public FenetreTransaction() {
        initComponents();
         String path = "C:\\Users\\KIBITI Wen Life\\Documents\\NetBeansProjects\\LMSSchoolProject\\src\\image\\imageAcceuil.jpg";
      
       //tout ceci pour redimensioner l'image
       BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
            Image dimg = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            this.btn_Acceuil.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     protected class GradientJPanel extends JPanel{
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g; 
            int width = getWidth();
            int height = getHeight();
            
            Color color1 = new Color(52,143,80);
            Color color2 = new Color(86,180,211);
            
            GradientPaint gp = new GradientPaint(0,0,color1,180,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0,0,width,height);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new GradientJPanel();
        btn_retournerEmprunt = new javax.swing.JButton();
        btn_emprunter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_Acceuil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_retournerEmprunt.setBackground(new java.awt.Color(102, 153, 0));
        btn_retournerEmprunt.setText("Retourner");
        btn_retournerEmprunt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retournerEmpruntActionPerformed(evt);
            }
        });

        btn_emprunter.setBackground(new java.awt.Color(255, 102, 102));
        btn_emprunter.setText("Emprunter");
        btn_emprunter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_emprunterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Effectuer une Transaction");

        btn_Acceuil.setText("Acceuil");
        btn_Acceuil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AcceuilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_retournerEmprunt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_emprunter, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .addGap(333, 333, 333))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btn_Acceuil)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btn_Acceuil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(btn_emprunter, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(btn_retournerEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_emprunterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_emprunterActionPerformed
        // TODO add your handling code here:
        FenetreEmprunter fen = new FenetreEmprunter();
        fen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_emprunterActionPerformed

    private void btn_retournerEmpruntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retournerEmpruntActionPerformed
        // TODO add your handling code here:
         FenetreRetournerEmprunt fen = new FenetreRetournerEmprunt();
        fen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_retournerEmpruntActionPerformed

    private void btn_AcceuilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AcceuilActionPerformed
        // TODO add your handling code here:
        FenetreAcceuil fenetre = new FenetreAcceuil();
        fenetre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_AcceuilActionPerformed

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
            java.util.logging.Logger.getLogger(FenetreTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreTransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Acceuil;
    private javax.swing.JButton btn_emprunter;
    private javax.swing.JButton btn_retournerEmprunt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
