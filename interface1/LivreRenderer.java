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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import javax.swing.ListCellRenderer;
import lmsschoolproject.Livre;

/**
 *
 * @author KIBITI Wen Life
 */
public class LivreRenderer extends JPanel implements ListCellRenderer<Livre> {
    // definir les conteneurs des informations du livre a afficher.
    private JLabel lbl_titre = new JLabel();
    private JLabel lbl_auteur = new JLabel();
    private JLabel lbl_edition = new JLabel();
    private JLabel lbl_image = new JLabel();
   

    public LivreRenderer(){
        //definir le gestionnaire d'affichage de chaque cellule de la Jlist des livres
        setLayout(new BorderLayout(5, 5));
        
        
      
        
        //definer le panel qui va abriter les label de text
        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbl_titre);
        panelText.add(lbl_auteur);
        panelText.add(lbl_edition);
        
        //ajouter les 2 parties(text et image) a la cellule
        add(lbl_image,BorderLayout.WEST);
        add(panelText,BorderLayout.CENTER);
    }
    
    
    //methode qui sera invoque pour dessiner un element de la liste de Livres.
    @Override
    public Component getListCellRendererComponent(JList<? extends Livre> list, Livre value, int index, boolean isSelected, boolean cellHasFocus) {
       
       lbl_titre.setText(value.titre);
       lbl_auteur.setText(value.auteur);
       lbl_edition.setText(value.edition);
       String path = "..\\LMSSchoolProject1\\src\\image\\";
       
       //tout ceci pour redimensioner l'image
       BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path+value.nomImage));
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
    lbl_edition.setOpaque(true);
    lbl_image.setOpaque(true);
 
    // when select item
    if (isSelected) {
        lbl_titre.setBackground(list.getSelectionBackground());
        lbl_auteur.setBackground(list.getSelectionBackground());
        lbl_edition.setBackground(list.getSelectionBackground());
        lbl_image.setBackground(list.getSelectionBackground());
        setBackground(list.getSelectionBackground());
    } else { // when don't select
        lbl_titre.setBackground(list.getBackground());
        lbl_auteur.setBackground(list.getBackground());
        lbl_edition.setBackground(list.getBackground());
        lbl_image.setBackground(list.getBackground());
        setBackground(list.getBackground());
    }
        //je retourne l'element de la liste.
        return this;
    }
    
}
