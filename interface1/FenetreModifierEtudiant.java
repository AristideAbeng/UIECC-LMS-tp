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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lmsschoolproject.Etudiant;
import lmsschoolproject.Lecturer;
import lmsschoolproject.PROJECTCONSTANTS;
import lmsschoolproject.Utilisateur;

/**
 *
 * @author KIBITI Wen Life
 */
public class FenetreModifierEtudiant extends javax.swing.JFrame {
    private Etudiant etudiant;
    private Lecturer lecturer;
    private FenetreAcceuil mFenetreAcceuil;
    /**
     * Creates new form FenetreModifierEtudiant
     */
    public FenetreModifierEtudiant(Utilisateur e, FenetreAcceuil acceuil) {
        initComponents();
        this.mFenetreAcceuil = acceuil;
        
        if(e!=null){
                if(e instanceof Etudiant){
                    this.lbl_titre_Fenetre.setText("info Etudiant");
                this.etudiant = (Etudiant)e;
                this.lbl_nom.setText(etudiant.getNom());
                this.lbl_prenom.setText(etudiant.getPrenom());
                if(etudiant.getFiliere().equalsIgnoreCase("ISN")){
                     this.cbbx_filiere.setSelectedIndex(0);
                }else if(etudiant.getFiliere().equalsIgnoreCase("INS")){
                      this.cbbx_filiere.setSelectedIndex(1);
                }else{
                     this.cbbx_filiere.setSelectedIndex(2);
                }
                if(etudiant.getSexe().equalsIgnoreCase("m")){
                    this.cbbx_sexe.setSelectedIndex(0);
                }else{
                    this.cbbx_sexe.setSelectedIndex(1);
                }
                this.lbl_dateInscription.setDate(etudiant.getDateInscription());
                this.lbl_matricule.setText(etudiant.getMatricule());
                this.lbl_email.setText(etudiant.getEmail());
                this.lbl_telephone.setText(etudiant.getNumTelephone());

                String path = PROJECTCONSTANTS.IMAGES_PATH;
               String nomImageMasculin = "avatar_profil_masculin.png";
               String nomImageFeminine = "avatar_profil_feminin.png";

               //tout ceci pour redimensioner l'image
               BufferedImage img = null;
                try {
                    if(etudiant.getSexe().equalsIgnoreCase("m")){
                         img = ImageIO.read(new File(path+nomImageMasculin));
                    }else{
                         img = ImageIO.read(new File(path+nomImageFeminine));
                    }

                    Image dimg = img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(dimg);
                    this.lbl_image.setIcon(imageIcon);
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
        }else {
                     this.lbl_titre_Fenetre.setText("info Lecturer");
                  this.lecturer = (Lecturer)e;
                this.lbl_nom.setText(lecturer.getNom());
                this.lbl_prenom.setText(lecturer.getPrenom());
                if(lecturer.getDepartment().equalsIgnoreCase("ISN")){
                     this.cbbx_filiere.setSelectedIndex(0);
                }else if(lecturer.getDepartment().equalsIgnoreCase("INS")){
                      this.cbbx_filiere.setSelectedIndex(1);
                }else{
                     this.cbbx_filiere.setSelectedIndex(2);
                }
                if(lecturer.getSexe().equalsIgnoreCase("m")){
                    this.cbbx_sexe.setSelectedIndex(0);
                }else{
                    this.cbbx_sexe.setSelectedIndex(1);
                }
                this.lbl_dateInscription.setDate(lecturer.getDateInscription());
                this.lbl_matricule.setText(lecturer.getDepartment());
                this.lbl_email.setText(lecturer.getEmail());
                this.lbl_telephone.setText(lecturer.getNumTelephone());

                String path = PROJECTCONSTANTS.IMAGES_PATH;
               String nomImageMasculin = "avatar_profil_masculin.png";
               String nomImageFeminine = "avatar_profil_feminin.png";

               //tout ceci pour redimensioner l'image
               BufferedImage img = null;
                try {
                    if(lecturer.getSexe().equalsIgnoreCase("m")){
                         img = ImageIO.read(new File(path+nomImageMasculin));
                    }else{
                         img = ImageIO.read(new File(path+nomImageFeminine));
                    }

                    Image dimg = img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(dimg);
                    this.lbl_image.setIcon(imageIcon);
                } catch (IOException exc) {
                    exc.printStackTrace();
                }  
                }
        }
        /* String path = PROJECTCONSTANTS.IMAGES_PATH;
      
       //tout ceci pour redimensioner l'image
       BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
            Image dimg = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            this.btn_retour.setIcon(imageIcon);
        } catch (IOException exc) {
            exc.printStackTrace();
        }*/
       
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
        lbl_image = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_nom = new javax.swing.JLabel();
        lbl_prenom = new javax.swing.JLabel();
        cbbx_filiere = new javax.swing.JComboBox<>();
        cbbx_sexe = new javax.swing.JComboBox<>();
        lbl_dateInscription = new com.toedter.calendar.JDateChooser();
        lbl_matricule = new javax.swing.JLabel();
        lbl_telephone = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        btn_modifierNom = new javax.swing.JButton();
        btn_modifierPrenom = new javax.swing.JButton();
        btn_modifierMatricule = new javax.swing.JButton();
        btn_modifierTelephone = new javax.swing.JButton();
        btn_modifierEmail = new javax.swing.JButton();
        btn_Enregistrer = new javax.swing.JButton();
        btn_retour = new javax.swing.JButton();
        lbl_titre_Fenetre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nom");

        jLabel3.setText("prenom");

        jLabel4.setText("filiere");

        jLabel5.setText("Sexe");

        jLabel6.setText("dateInscription");

        jLabel7.setText("matricule");

        jLabel8.setText("telephone");

        jLabel9.setText("email");

        lbl_nom.setText("jLabel10");

        lbl_prenom.setText("jLabel11");

        cbbx_filiere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISN", "INS", "CDN" }));

        cbbx_sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", " " }));

        lbl_matricule.setText("jLabel12");

        lbl_telephone.setText("jLabel13");

        lbl_email.setText("jLabel14");

        btn_modifierNom.setText("modifier");
        btn_modifierNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierNomActionPerformed(evt);
            }
        });

        btn_modifierPrenom.setText("modifier");
        btn_modifierPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierPrenomActionPerformed(evt);
            }
        });

        btn_modifierMatricule.setText("modifier");
        btn_modifierMatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierMatriculeActionPerformed(evt);
            }
        });

        btn_modifierTelephone.setText("modifier");
        btn_modifierTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierTelephoneActionPerformed(evt);
            }
        });

        btn_modifierEmail.setText("modifier");
        btn_modifierEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierEmailActionPerformed(evt);
            }
        });

        btn_Enregistrer.setText("Enregistrer");
        btn_Enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnregistrerActionPerformed(evt);
            }
        });

        btn_retour.setText("retour");
        btn_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retourActionPerformed(evt);
            }
        });

        lbl_titre_Fenetre.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        lbl_titre_Fenetre.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titre_Fenetre.setText("Info Etudiant");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(240, 240, 240)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(lbl_titre_Fenetre, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_dateInscription, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbx_sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbx_filiere, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_modifierTelephone))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_matricule, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_modifierMatricule))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_modifierPrenom))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_modifierNom)))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_email, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addComponent(btn_modifierEmail)
                        .addGap(33, 33, 33))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Enregistrer)
                .addGap(187, 187, 187))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btn_retour)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_nom)
                    .addComponent(btn_modifierNom)
                    .addComponent(lbl_titre_Fenetre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_retour)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbl_prenom)
                            .addComponent(btn_modifierPrenom))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbx_filiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cbbx_sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lbl_dateInscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_matricule)
                    .addComponent(btn_modifierMatricule))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_telephone)
                    .addComponent(btn_modifierTelephone))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbl_email)
                    .addComponent(btn_modifierEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(btn_Enregistrer)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modifierNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierNomActionPerformed
        // TODO add your handling code here:
        String nouveau_titre = JOptionPane.showInputDialog("Entrez Le nouveau nom de l'Etudiant");
        if(nouveau_titre != null){
            if(nouveau_titre.length() > 0){
                this.lbl_nom.setText(nouveau_titre);
            }
        }
    }//GEN-LAST:event_btn_modifierNomActionPerformed

    private void btn_modifierPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierPrenomActionPerformed
        // TODO add your handling code here:
         String nouveau_titre = JOptionPane.showInputDialog("Entrez Le nouveau Prenom de l'Etudiant");
        if(nouveau_titre != null){
            if(nouveau_titre.length() > 0){
                this.lbl_prenom.setText(nouveau_titre);
            }
        }
    }//GEN-LAST:event_btn_modifierPrenomActionPerformed

    private void btn_modifierMatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierMatriculeActionPerformed
        // TODO add your handling code here:
         String nouveau_titre = JOptionPane.showInputDialog("Entrez Le nouveau Matricule de l'Etudiant");
        if(nouveau_titre != null){
            if(nouveau_titre.length() > 0){
                this.lbl_matricule.setText(nouveau_titre);
            }
        }
    }//GEN-LAST:event_btn_modifierMatriculeActionPerformed

    private void btn_modifierTelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierTelephoneActionPerformed
        // TODO add your handling code here:
         String nouveau_titre = JOptionPane.showInputDialog("Entrez Le nouveau contact de l'Etudiant");
        if(nouveau_titre != null){
            if(nouveau_titre.length() > 0){
                this.lbl_telephone.setText(nouveau_titre);
            }
        }
    }//GEN-LAST:event_btn_modifierTelephoneActionPerformed

    private void btn_modifierEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierEmailActionPerformed
        // TODO add your handling code here:
         String nouveau_titre = JOptionPane.showInputDialog("Entrez Le nouvel email de l'Etudiant");
        if(nouveau_titre != null){
            if(nouveau_titre.length() > 0){
                this.lbl_email.setText(nouveau_titre);
            }
        }
    }//GEN-LAST:event_btn_modifierEmailActionPerformed

    private void btn_EnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnregistrerActionPerformed
        // TODO add your handling code here:
        if(this.lecturer == null){
            Etudiant n;
            String nom = this.lbl_nom.getText();
            String prenom = this.lbl_prenom.getText();
            String sexe = this.cbbx_sexe.getSelectedItem().toString();
            String filiere = this.cbbx_filiere.getSelectedItem().toString();
            String tel = this.lbl_telephone.getText();
            String email = this.lbl_email.getText();

            n = new Etudiant(null,nom,prenom,filiere,sexe,tel,email,null);
        
            if(Etudiant.updateEtudiant(etudiant, n)){
                JOptionPane.showMessageDialog(rootPane, "Modifications  Enregistree avec success");
                this.dispose();
            }else{
                 JOptionPane.showMessageDialog(null, "Erreur d'execution verifier puis reessayer a nouveau ");
            }
        }else{
             Lecturer n;
            String nom = this.lbl_nom.getText();
            String prenom = this.lbl_prenom.getText();
            String sexe = this.cbbx_sexe.getSelectedItem().toString();
            String filiere = this.cbbx_filiere.getSelectedItem().toString();
            String tel = this.lbl_telephone.getText();
            String email = this.lbl_email.getText();

            n = new Lecturer(null,nom,prenom,filiere,sexe,tel,email,null);
        
            if(Lecturer.updateLecturer(lecturer, n)){
                JOptionPane.showMessageDialog(rootPane, "Modifications  Enregistree avec success");
                this.dispose();
            }else{
                 JOptionPane.showMessageDialog(null, "Erreur d'execution verifier puis reessayer a nouveau ");
            }
        }
    }//GEN-LAST:event_btn_EnregistrerActionPerformed

    private void btn_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retourActionPerformed
        // TODO add your handling code here:
        
        this.mFenetreAcceuil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_retourActionPerformed

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
            java.util.logging.Logger.getLogger(FenetreModifierEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreModifierEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreModifierEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreModifierEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreModifierEtudiant(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Enregistrer;
    private javax.swing.JButton btn_modifierEmail;
    private javax.swing.JButton btn_modifierMatricule;
    private javax.swing.JButton btn_modifierNom;
    private javax.swing.JButton btn_modifierPrenom;
    private javax.swing.JButton btn_modifierTelephone;
    private javax.swing.JButton btn_retour;
    private javax.swing.JComboBox<String> cbbx_filiere;
    private javax.swing.JComboBox<String> cbbx_sexe;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser lbl_dateInscription;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_matricule;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_prenom;
    private javax.swing.JLabel lbl_telephone;
    private javax.swing.JLabel lbl_titre_Fenetre;
    // End of variables declaration//GEN-END:variables
}
