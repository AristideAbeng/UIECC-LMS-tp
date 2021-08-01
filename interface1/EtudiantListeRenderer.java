/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import lmsschoolproject.Etudiant;
import lmsschoolproject.PROJECTCONSTANTS;

/**
 *
 * @author KIBITI Wen Life
 */
public class EtudiantListeRenderer extends JPanel implements ListCellRenderer<Etudiant>{
     // definir les conteneurs des informations de l'etudiant a afficher.
    private JLabel lbl_nomEtPrenom = new JLabel();
    private JLabel lbl_filiere = new JLabel();
    private JLabel lbl_image = new JLabel();
    
    public EtudiantListeRenderer(){
         //definir le gestionnaire d'affichage de chaque cellule de la Jlist des livres
        setLayout(new BorderLayout(5, 5));
        
        
      
        
        //definer le panel qui va abriter les label de text
        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbl_nomEtPrenom);
        panelText.add(lbl_filiere);
      
        
        //ajouter les 2 parties(text et image) a la cellule
        add(lbl_image,BorderLayout.WEST);
        add(panelText,BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Etudiant> list, Etudiant value, int index, boolean isSelected, boolean cellHasFocus) {
       lbl_nomEtPrenom.setText(value.getNomEtPrenom());
       lbl_filiere.setText(value.getFiliere());
      
       String path = PROJECTCONSTANTS.IMAGES_PATH;
       String nomImageMasculin = "avatar_profil_masculin.png";
       String nomImageFeminine = "avatar_profil_feminin.png";
       
       //tout ceci pour redimensioner l'image
       BufferedImage img = null;
        try {
            if(value.getSexe().equalsIgnoreCase("m")){
                 img = ImageIO.read(new File(path+nomImageMasculin));
            }else{
                 img = ImageIO.read(new File(path+nomImageFeminine));
            }
           
            Image dimg = img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            lbl_image.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
         // definir les reglages de selection
           // set Opaque to change background color of JLabel
    lbl_nomEtPrenom.setOpaque(true);
    lbl_filiere.setOpaque(true);
    
    lbl_image.setOpaque(true);
 
    // when select item
    if (isSelected) {
        lbl_nomEtPrenom.setBackground(list.getSelectionBackground());
        lbl_filiere.setBackground(list.getSelectionBackground());
      
        lbl_image.setBackground(list.getSelectionBackground());
        setBackground(list.getSelectionBackground());
    } else { // when don't select
        lbl_nomEtPrenom.setBackground(list.getBackground());
        lbl_filiere.setBackground(list.getBackground());
       
        lbl_image.setBackground(list.getBackground());
        setBackground(list.getBackground());
    }
        //je retourne l'element de la liste.
        return this;
    }
    
    
}
