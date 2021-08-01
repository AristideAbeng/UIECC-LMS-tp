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
public class ResearchMaterial extends LibraryItem{
    
    
  
   public Date datePublication;
   public int nbExemplaires;
   public String maisonEdition;
   public String positionement;
   public int id;
   
   public ResearchMaterial(String t,String au,Date dt,int ne,String me,String p,String ni,int i){
      super(t,au,ni);
       this.datePublication = dt;
       this.nbExemplaires = ne;
       this.maisonEdition = me;
       this.positionement = p;
       this.id = i;
   }
    public static List<String> getAllAuthors(){
       List<String> allMRAuthors = new ArrayList<>();
       try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
           Statement st = con.createStatement();
           String sql = "SELECT DISTINCT Auteur FROM rsd";
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
           ResultSet resultat = st.executeQuery(sql);
                          //une boucle while pour parcourir tout les livres dans resultat                       
                          while(resultat.next()){
                                String auteur = resultat.getString("Auteur");  
                               
                                //ajouter ce livre a la liste de livres
                                allMRAuthors.add(auteur);
                          }
        //fermer la connexion quand je fini de tout extraire
       con.close();                   
       
       
    }catch(Exception e){
        System.out.println("erreur connexion a la bd");
    }
       return allMRAuthors;
   }
      public static List<String> getAllPublishingCompanies(){
       List<String> allMRPB = new ArrayList<>();
       try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
           Statement st = con.createStatement();
           String sql = "SELECT DISTINCT MaisonEdition FROM rsd";
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
           ResultSet resultat = st.executeQuery(sql);
                          //une boucle while pour parcourir tout les livres dans resultat                       
                          while(resultat.next()){
                                String auteur = resultat.getString("MaisonEdition");  
                               
                                //ajouter ce livre a la liste de livres
                                allMRPB.add(auteur);
                          }
        //fermer la connexion quand je fini de tout extraire
       con.close();                   
       
       
    }catch(Exception e){
        System.out.println("erreur connexion a la bd");
    }
       return allMRPB;
   }
     public static ResearchMaterial getRSDFromId(String idCd){
       ResearchMaterial mRSD = null;
        try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
          
           String sql = "SELECT * FROM rsd WHERE identifiant = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, Integer.parseInt(idCd));
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
           ResultSet resultat = stmt.executeQuery();
           while(resultat.next()){
                            
                                String titre = resultat.getString("Titre");  
                                String auteur = resultat.getString("Auteur");  
                                java.sql.Date datePublication = resultat.getDate("DatePublication");
                                java.util.Date utilDate = new java.util.Date(datePublication.getTime());
                                int nbExemplaire = resultat.getInt("NombreDexemplaires");
                                String maisonEdition = resultat.getString("MaisonEdition");
                                String positionement = resultat.getString("Positionement");
                                String nomImage = resultat.getString("nomImage");
                                int id = resultat.getInt("identifiant");
                                
                                // creer un objet livre a partir des informations extraites de la variable resultat
                                mRSD = new ResearchMaterial(titre,auteur,utilDate,nbExemplaire,maisonEdition,positionement,nomImage,id);                                
           }
           con.close();
        }catch(Exception e){
            System.out.println(e);  
        }
       return mRSD;
   } 
}
