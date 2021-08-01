/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import java.awt.BorderLayout;
import java.awt.Color;
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

/**
 *
 * @author KIBITI Wen Life
 */
public class EmpruntRenderer extends JPanel implements ListCellRenderer<Emprunt>{
    
     // definir les conteneurs des informations du livre a afficher.
    private JLabel lbl_titre = new JLabel();
    private JLabel lbl_auteur = new JLabel();
    private JLabel lbl_image = new JLabel();
    private JLabel lbl_dateEmprunt = new JLabel();
    private JLabel lbl_penalites = new JLabel();
    
    public EmpruntRenderer(){
        //definir le gestionnaire d'affichage de chaque cellule de la Jlist des livres
        setLayout(new BorderLayout(5, 5));
        
        
      
        
        //definer le panel qui va abriter les label de text
        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbl_titre);
        panelText.add(lbl_auteur);
        panelText.add(lbl_dateEmprunt);
        panelText.add(lbl_penalites);
        
        //ajouter les 2 parties(text et image) a la cellule
        add(lbl_image,BorderLayout.WEST);
        add(panelText,BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Emprunt> list, Emprunt value, int index, boolean isSelected, boolean cellHasFocus) {
         LibraryItem item = null;
        System.out.println("res type is "+value.ressourceType);
         System.out.println("res client is "+value.client.toString());
        if(value.ressourceType.equalsIgnoreCase("Livre")){
           
            item = (Livre)value.ressource;
        }
        if(value.ressourceType.equalsIgnoreCase("cd")){
           item = (CD)value.ressource;
        }
        if(value.ressourceType.equalsIgnoreCase("rsd")){
          item = (ResearchMaterial)value.ressource;
        }
        
        
      if(item!=null){
                lbl_titre.setText(item.titre);
                lbl_auteur.setText(item.auteur);
                lbl_dateEmprunt.setText(value.dateEmprunt.toString());
                lbl_penalites.setText(value.getPenalitesAccumulees());
                
                if(value.getValuePenalitesAccumules()>0){
                    lbl_penalites.setForeground(Color.red);
                }

                String path =PROJECTCONSTANTS.IMAGES_PATH;

                //tout ceci pour redimensioner l'image
                BufferedImage img = null;
                try {
                     System.out.println("trying to read "+path+""+item.nomImage);
                     img = ImageIO.read(new File(path+item.nomImage));
                     Image dimg = img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
                     ImageIcon imageIcon = new ImageIcon(dimg);
                     lbl_image.setIcon(imageIcon);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                  // definir les reglages de selection
                    // set Opaque to change background color of JLabel
             lbl_titre.setOpaque(true);
             lbl_auteur.setOpaque(true);
             lbl_dateEmprunt.setOpaque(true);
             lbl_penalites.setOpaque(true);
             lbl_image.setOpaque(true);

             // when select item
             if (isSelected) {
                 lbl_titre.setBackground(list.getSelectionBackground());
                 lbl_auteur.setBackground(list.getSelectionBackground());
                 lbl_dateEmprunt.setBackground(list.getSelectionBackground());
                 lbl_penalites.setBackground(list.getSelectionBackground());
                 lbl_image.setBackground(list.getSelectionBackground());
                 setBackground(list.getSelectionBackground());
             } else { // when don't select
                 lbl_titre.setBackground(list.getBackground());
                 lbl_auteur.setBackground(list.getBackground());
                 lbl_dateEmprunt.setBackground(list.getBackground());
                 lbl_penalites.setBackground(list.getBackground());
                 lbl_image.setBackground(list.getBackground());
                 setBackground(list.getBackground());
             }
      }
        //je retourne l'element de la liste.
        return this;
    }
    
}
