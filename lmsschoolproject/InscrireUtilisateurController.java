/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author PBHev
 */
public class InscrireUtilisateurController {
    public static boolean InscrireEnseignant(String identifiant,String nom,String prenom,String sexe,String departement,String numtel,String email){
          //Lecturer lecturerinscris = new Lecturer(identifiant,nom,prenom,sexe,departement,numtel,email,PROJECTCONSTANTS.getTodaySqlDate());
           try{
                 Connection con = DBConnect.connect();
                 String insertQuery = "INSERT INTO `lecturer`(`Identifiant`, `nom`, `prenom`, `sexe`, `departement`, `date`, `numtel`, `email`) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                requeteInsertion.setString(1,identifiant);
                requeteInsertion.setString(2,nom);
                requeteInsertion.setString(3, prenom);
                requeteInsertion.setString(4,sexe);
                requeteInsertion.setString(5,departement);
                requeteInsertion.setDate(6,PROJECTCONSTANTS.getTodaySqlDate());
                requeteInsertion.setString(7,numtel);
                requeteInsertion.setString(8, email);
                      
                requeteInsertion.execute();
               
            
                con.close();
                return true;
            }catch(Exception e){
                 
                System.out.println(e);
            }
        return false;
    }

    public static boolean InscrireEtudiant(String matricule, String nom, String prenom, String sexe, String filiere, String numtel, String email) {
        try{
                 Connection con = DBConnect.connect();
                 String insertQuery = "INSERT INTO `etudiant`(`nom`, `prenom`, `sexe`, `Filiere`, `dateInscription`, `matricule`,`telephone`,`email`) VALUES (?,?,?,?,?,?,?,?)";
                 
                PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                requeteInsertion.setString(1,nom);
                requeteInsertion.setString(2,prenom);
                requeteInsertion.setString(3, sexe);
                requeteInsertion.setString(4,filiere);
                requeteInsertion.setDate(5,PROJECTCONSTANTS.getTodaySqlDate());
                requeteInsertion.setString(6,matricule);
                requeteInsertion.setString(7,numtel);
                requeteInsertion.setString(8, email);
                      
                requeteInsertion.execute();
                JOptionPane.showMessageDialog(null, "Enregistree avec success");
            
                con.close();
                
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Erreur Enregistrement");
                System.out.println(e);
            }
        return false;
    }

    public static boolean VerifierMotDePasse(String motdepasse, String motdepass) {
       if(motdepasse.equals(motdepass)){
           return true;
       }
       return false;
    }

    public static boolean InscrireAdmin(String nom, String prenom, String sexe, String identifiant, String numtel, String email, String motdepasse) {
           try{
                 Connection con = DBConnect.connect();
                 String insertQuery = "INSERT INTO `administrateur`(`nom`, `prenom`, `sexe`, `identifiant`, `date`, `motdepasse`, `numtel`, `email`) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                
                requeteInsertion.setString(1,nom);
                requeteInsertion.setString(2, prenom);
                requeteInsertion.setString(3,sexe);
                requeteInsertion.setString(4,identifiant);
                requeteInsertion.setDate(5,PROJECTCONSTANTS.getTodaySqlDate());
                requeteInsertion.setString(6,motdepasse);
                requeteInsertion.setString(7,numtel);
                requeteInsertion.setString(8, email);
                      
                requeteInsertion.execute();
               
            
                con.close();
                return true;
            }catch(Exception e){
                
                System.out.println(e);
            }
           return false;
    }
}
