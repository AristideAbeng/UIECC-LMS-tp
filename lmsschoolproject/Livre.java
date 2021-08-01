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
public class Livre extends LibraryItem{
  
   public Date datePublication;
   public int nbExemplaires;
   public int nbPages;
   public String maisonEdition;
   public String edition;
   public String positionement;
   public String categorie;
   public int id;
   
   public Livre(String t,String au,Date dt,int ne,int nbp,String me,String ed,String p,String ni,String c,int i){
       super(t,au,ni);
       this.datePublication = dt;
       this.nbExemplaires = ne;
       this.nbPages = nbp;
       this.maisonEdition = me;
       this.edition = ed;
       this.positionement = p;
       this.categorie = c;
       this.id = i;
   }
   public static List<String> getAllAuthors(){
       List<String> allBookAuthors = new ArrayList<>();
       try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
           Statement st = con.createStatement();
           String sql = "SELECT DISTINCT Auteur FROM livre";
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
           ResultSet resultat = st.executeQuery(sql);
                          //une boucle while pour parcourir tout les livres dans resultat                       
                          while(resultat.next()){
                                String auteur = resultat.getString("Auteur");  
                                System.out.println(auteur);
                                //ajouter ce livre a la liste de livres
                                allBookAuthors.add(auteur);
                          }
        //fermer la connexion quand je fini de tout extraire
       con.close();                   
       
       
    }catch(Exception e){
        System.out.println("erreur connexion a la bd");
    }
       return allBookAuthors;
   }
   public static List<String> getAllPublishingCompanies(){
       List<String> allBookPublishingCompanies = new ArrayList<>();
       try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
           Statement st = con.createStatement();
           String sql = "SELECT DISTINCT MaisonEdition FROM livre";
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
           ResultSet resultat = st.executeQuery(sql);
                          //une boucle while pour parcourir tout les livres dans resultat                       
                          while(resultat.next()){
                                String auteur = resultat.getString("MaisonEdition");  
                               
                                //ajouter ce livre a la liste de livres
                                allBookPublishingCompanies.add(auteur);
                          }
        //fermer la connexion quand je fini de tout extraire
       con.close();                   
       
       
    }catch(Exception e){
        System.out.println("erreur connexion a la bd");
    }
       return allBookPublishingCompanies;
   }
   public static Livre getLivreFromId(int idLivre){
       Livre mLivre = null;
        try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
          
           String sql = "SELECT * FROM livre WHERE id = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, idLivre);
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
           ResultSet resultat = stmt.executeQuery();
           while(resultat.next()){
                              String titre = resultat.getString("Titre");  
                                String auteur = resultat.getString("Auteur");  
                                java.sql.Date datePublication = resultat.getDate("DatePublication");
                                java.util.Date utilDate = new java.util.Date(datePublication.getTime());
                                int nbExemplaire = resultat.getInt("NombreDexemplaires");
                                int nbPages = resultat.getInt("nbPage");
                                String maisonEdition = resultat.getString("MaisonEdition");
                                String edition = resultat.getString("edition");
                                String positionement = resultat.getString("Positionement");
                                String nomImage = resultat.getString("nomImage");
                                String categorie = resultat.getString("Stylecategorie");
                                int id = resultat.getInt("id");
                                
                                // creer un objet livre a partir des informations extraites de la variable resultat
                                Livre livre = new Livre(titre,auteur,utilDate,nbExemplaire,
                                nbPages,maisonEdition,edition,positionement,nomImage,categorie,id);
                                mLivre = livre;
           }
           con.close();
        }catch(Exception e){
            System.out.println(e);  
        }
       return mLivre;
   }
    
}
