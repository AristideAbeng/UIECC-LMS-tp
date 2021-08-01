/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KIBITI Wen Life
 */
public class Administrateur extends Utilisateur {
   
    private String num_telephone;
    private String email;
    private String password;
    private Date dateInscription;
    
    public Administrateur (String id,String nm,String prnm,String sx,String nmtel,String eml,String pas,Date date){
        super(nm,prnm,sx,id);
        this.num_telephone = nmtel;
        this.email = eml;
        this.password=pas;
        this.dateInscription = date;
    }
     public static boolean updateAdmin(Administrateur e,Administrateur n){
        if(n==null || e==null){
            return false;
        }
        try{
                  Connection conn = DBConnect.connect();
                  
                  
             String query = "UPDATE `administrateur` SET `nom`= ?,`prenom` = ?,`sexe` = ?,`numtel` = ?, `email` = ?,motdepasse = ? WHERE Identifiant = ?";
             PreparedStatement preparedStmt = conn.prepareStatement(query);
            
             preparedStmt.setString(1, n.mNom);
             preparedStmt.setString(2,n.mPrenom);
             preparedStmt.setString(3, n.mSexe);
             
             preparedStmt.setString(4, n.num_telephone);
             preparedStmt.setString(5, n.email);
              preparedStmt.setString(6, n.password);
             preparedStmt.setString(7, e.getIdentifiant());

             // execute the java preparedstatement
             preparedStmt.executeUpdate();

             conn.close();
             }catch(Exception exc){
               System.out.println(exc);
               return false;
           }
        return true;
    }
     public static List<Administrateur> getAllRegisteredAdministrateurs(){
          List<Administrateur> listeAdministrateur = new ArrayList<>();
            try{
                //se connecter a la bd pour extraire tout les livres enregistrees
                  Connection con = DBConnect.connect();
                  //preparer la requete sql
                   Statement st = con.createStatement();
                   String sql = "select * from administrateur";

                    //executer la requete pour stocker le resultat dans la variable resultat              
                   ResultSet resultat = st.executeQuery(sql);
                                  //une boucle while pour parcourir tout les livres dans resultat                       
                                  while(resultat.next()){
                                        String matr = resultat.getString("Identifiant");
                                        String nom = resultat.getString("nom");
                                        String prnm = resultat.getString("prenom");
                                        String sx = resultat.getString("sexe");
                                        String nmtel = resultat.getString("numtel");
                                        String motDePasse = resultat.getString("motdepasse");
                                        String eml = resultat.getString("email");
                                        java.sql.Date dateSqlInscription = resultat.getDate("date");
                                        java.util.Date dateInscription = new java.util.Date(dateSqlInscription.getTime());

                                        //creer l'objet etudiant
                                         Administrateur ad = new Administrateur(matr,nom,prnm,sx,nmtel,eml,motDePasse,dateInscription);

                                        //ajouter cet etudiant a la liste Etudiant
                                        listeAdministrateur.add(ad);
                                  }
                                  System.out.println("the number of admins is "+listeAdministrateur.size());
                                  //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.

                //fermer la connexion quand je fini de tout extraire
               con.close();                   


            }catch(Exception e){
                System.out.println("erreur connexion a la bd"+e);
            }
        return listeAdministrateur;
    }
    public String getNomEtPrenom(){
        return this.mNom+" "+this.mPrenom;
    }
    public String getSexe(){
        return this.mSexe;
    }
    public String getIdentifiant(){
        return this.mIdentifiant;
    }
    public String getNom(){
        return this.mNom;
    }
    public String getPrenom(){
        return this.mPrenom;
    }
    public Date getDateInscription(){
       return this.dateInscription;
    }
    public String getEmail(){
        return this.email;
    }
     public String getPassword(){
        return this.password;
    }
     public String getNumTelephone(){
        return this.num_telephone;
    }
    
}
