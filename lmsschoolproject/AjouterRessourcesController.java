/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author PBHev
 */
public class AjouterRessourcesController {
    
    public static boolean AjouterLivre(String titre,String auteur,java.util.Date date,int nbExemplaire,String position,String maison_edition,String categorie,int nbPages,String edition,String nomImage){
       
         try{
            java.sql.Date sqldate = null;
            if (date == null) {
                System.out.println("No date specified!");
                return false;
            } else {
                sqldate = new java.sql.Date(date.getTime());
                // Do something with sqldate
            }
                  Connection con = DBConnect.connect();
                 String insertQuery = "INSERT INTO `livre`(`Titre`, `Auteur`, `DatePublication`, `NombreDexemplaires`, `Positionement`, `MaisonEdition`, `Stylecategorie`, `nbPage`, `edition`,`nomImage`) VALUES (?,?,?,?,?,?,?,?,?,?)";
                 
                PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                requeteInsertion.setString(1,titre);
                 requeteInsertion.setString(2,auteur);
                  requeteInsertion.setDate(3, sqldate);
                  requeteInsertion.setInt(4, nbExemplaire);
                   requeteInsertion.setString(5,position);
                    requeteInsertion.setString(6,maison_edition);
                     requeteInsertion.setString(7,categorie);
                      requeteInsertion.setInt(8,nbPages);
                      requeteInsertion.setString(9,edition);
                      requeteInsertion.setString(10,nomImage);
                      
                requeteInsertion.execute();
               // JOptionPane.showMessageDialog(null, "Enregistree avec success");
            
                con.close();
                return true;
                
        }catch(Exception e){ 
            System.out.println(e);
        }
        return false;
    }
    public static boolean AjouterMDR(String titre,String auteur,java.util.Date date,int nbExemplaire,String position,String maisonEdition, String nomImage){
        try{
            java.sql.Date sqldate = null;
            if (date == null) {
                System.out.println("No date specified!");
                return false;
            } else {
                sqldate = new java.sql.Date(date.getTime());
                // Do something with sqldate
            }
             Connection con = DBConnect.connect();
                 String insertQuery = "INSERT INTO `rsd`(`Titre`, `Auteur`, `DatePublication`, `NombreDexemplaires`, `Positionement`, `MaisonEdition`,`nomImage`) VALUES (?,?,?,?,?,?,?)";
                 
                PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                requeteInsertion.setString(1,titre);
                 requeteInsertion.setString(2,auteur);
                  requeteInsertion.setDate(3, sqldate);
                  requeteInsertion.setInt(4, nbExemplaire);
                   requeteInsertion.setString(5,position);
                    requeteInsertion.setString(6,maisonEdition);

                      requeteInsertion.setString(7,nomImage);
                      
                requeteInsertion.execute();
                JOptionPane.showMessageDialog(null, "Enregistree avec success");
            
                con.close();
                
        }catch(Exception e){ 
            System.out.println(e);
        }
        
        return false;
    
}

    public static boolean AjouterCD(String titre, String auteur, Date date, int nbExemplaire, String position, String maison_edition, String duree, int taille, String nomImage) {
         try{
            java.sql.Date sqldate = null;
            if (date == null) {
                System.out.println("No date specified!");
                return false;
            } else {
                sqldate = new java.sql.Date(date.getTime());
                // Do something with sqldate
            }
             Connection con = DBConnect.connect();
                 String insertQuery = "INSERT INTO `CD`(`Titre`, `Auteur`, `DatePublication`, `NombreDexemplaires`, `Positionement`, `MaisonEdition`, `duree`, `taille`,`nomImage`) VALUES (?,?,?,?,?,?,?,?,?)";
                 
                PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                requeteInsertion.setString(1,titre);
                 requeteInsertion.setString(2,auteur);
                  requeteInsertion.setDate(3, sqldate);
                  requeteInsertion.setInt(4, nbExemplaire);
                   requeteInsertion.setString(5,position);
                    requeteInsertion.setString(6,maison_edition);
                      requeteInsertion.setString(7,duree);
                       requeteInsertion.setInt(8,taille);
                      requeteInsertion.setString(9,nomImage);
                      
                requeteInsertion.execute();
                JOptionPane.showMessageDialog(null, "Enregistree avec success");
            
                con.close();
        }catch(Exception e){
            System.out.println(e);
        }
     return false;
    }
}
