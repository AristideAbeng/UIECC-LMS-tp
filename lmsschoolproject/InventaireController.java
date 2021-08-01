/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import database.DBConnect;
import interface1.CDRenderer;
import interface1.LivreRenderer;
import interface1.RSDRenderer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author PBHev
 */

public class InventaireController {
  public static final String ALL = "All";  
    public static JList<Livre> creerListeLivres(boolean noSearch,String mCurrentAuthorConstraint,String mCurrentPubCompanyConstraint,String mSearchCriteria){
       System.out.println(mCurrentAuthorConstraint+" "+mCurrentPubCompanyConstraint+" "+mSearchCriteria); 
    // create List model
    DefaultListModel<Livre> model = new DefaultListModel<Livre>();
    // add item to model
    List<Livre> listeLivres = new ArrayList<>();
    try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
           Statement st = con.createStatement();
           String sql = "select * from livre";
           if(noSearch){
           if(!mCurrentAuthorConstraint.equalsIgnoreCase(ALL)){
               sql = "SELECT * FROM livre WHERE Auteur = '"+mCurrentAuthorConstraint+"'";
               if(!mCurrentPubCompanyConstraint.equalsIgnoreCase(ALL)){
                    sql = "SELECT * FROM livre WHERE Auteur = '"+mCurrentAuthorConstraint+"' AND MaisonEdition = '"+mCurrentPubCompanyConstraint+"'";
               }
           }else if(!mCurrentPubCompanyConstraint.equalsIgnoreCase(ALL)){
               
                sql = "SELECT * FROM livre WHERE MaisonEdition = '"+mCurrentPubCompanyConstraint+"'";
           }
           }else{
               sql = "SELECT * FROM livre WHERE Titre LIKE '%"+mSearchCriteria+"%'";
           }
           System.out.println(sql);           
            //executer la requete pour stocker le resultat dans la variable resultat              
           ResultSet resultat = st.executeQuery(sql);
                          //une boucle while pour parcourir tout les livres dans resultat                       
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
                                
                                //ajouter ce livre a la liste de livres
                                listeLivres.add(livre);
                          }
                          //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.
                          model.addAll(listeLivres);
        //fermer la connexion quand je fini de tout extraire
       con.close();                   
       
       
    }catch(Exception e){
        System.out.println("erreur connexion a la bd"+e);
    }
   
    // creer un objet liste en lui passant en parametre l'objet model qui a recu tout les livres.
    JList<Livre> list = new JList<Livre>(model);
    
    // definir comment est ce que les elements de la liste devront etre afficher en passant en parametre un instance de LivreRenderer
    list.setCellRenderer(new LivreRenderer());
    return list;
   }
   
  public static boolean deleteBook(Livre livre){
       try{
                 Connection con = DBConnect.connect();
                 String insertQuery = "DELETE FROM  livre WHERE Id = ?";

                 PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                  requeteInsertion.setInt(1,livre.id);
           
                 requeteInsertion.execute();
                                    

                 con.close();
                 return true;
             }catch(Exception exc){
                   System.out.println(exc);
            }
       return false;
  }
  
   public static boolean deleteCD(CD cd){
       try{
                 Connection con = DBConnect.connect();
                 String insertQuery = "DELETE FROM  cd WHERE Id = ?";

                 PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                  requeteInsertion.setInt(1,cd.id);
           
                 requeteInsertion.execute();
                                    

                 con.close();
                 return true;
             }catch(Exception exc){
                   System.out.println(exc);
            }
       return false;
  }
     public static boolean deleteMR(ResearchMaterial rm){
       try{
                 Connection con = DBConnect.connect();
                 String insertQuery = "DELETE FROM  rsd WHERE Id = ?";

                 PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                  requeteInsertion.setInt(1,rm.id);
           
                 requeteInsertion.execute();
                                    

                 con.close();
                 return true;
             }catch(Exception exc){
                   System.out.println(exc);
            }
       return false;
  }
  
   public static JList<CD> creerListeCD(boolean noSearch,String mCurrentAuthorConstraint,String mCurrentPubCompanyConstraint,String mSearchCriteria) {
    // create List model
    DefaultListModel<CD> model = new DefaultListModel<CD>();
    // add item to model
    List<CD> listeCD = new ArrayList<>();
    try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
           Statement st = con.createStatement();
           String sql = "select * from cd";
           if(noSearch){
           if(!mCurrentAuthorConstraint.equalsIgnoreCase(ALL)){
               sql = "SELECT * FROM cd WHERE Auteur = '"+mCurrentAuthorConstraint+"'";
               if(!mCurrentPubCompanyConstraint.equalsIgnoreCase(ALL)){
                    sql = "SELECT * FROM cd WHERE Auteur = '"+mCurrentAuthorConstraint+"' AND MaisonEdition = '"+mCurrentPubCompanyConstraint+"'";
               }
           }else if(!mCurrentPubCompanyConstraint.equalsIgnoreCase(ALL)){
               
                sql = "SELECT * FROM cd WHERE MaisonEdition = '"+mCurrentPubCompanyConstraint+"'";
           }
           }else{
                sql = "SELECT * FROM cd WHERE Titre LIKE '%"+mSearchCriteria+"%'";
           }
           System.out.println(sql);  
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
           ResultSet resultat = st.executeQuery(sql);
                          //une boucle while pour parcourir tout les livres dans resultat                       
                          while(resultat.next()){
                                String titre = resultat.getString("Titre");  
                                String auteur = resultat.getString("Auteur");  
                                java.sql.Date datePublication = resultat.getDate("DatePublication");
                                java.util.Date utilDate = new java.util.Date(datePublication.getTime());
                                int nbExemplaire = resultat.getInt("NombreDexemplaires");
                                java.sql.Time duree = resultat.getTime("duree");
                                String maisonEdition = resultat.getString("MaisonEdition");
                                String positionement = resultat.getString("Positionement");
                                int taille=resultat.getInt("taille");
                                String nomImage = resultat.getString("nomImage");
                                int id = resultat.getInt("identifiant");
                                
                                // creer un objet livre a partir des informations extraites de la variable resultat
                                CD cd = new CD(titre,auteur,utilDate,nbExemplaire,duree,maisonEdition,positionement,taille,nomImage,id);
                                
                                //ajouter ce livre a la liste de livres
                                listeCD.add(cd);
                          }
                          //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.
                          model.addAll(listeCD);
        //fermer la connexion quand je fini de tout extraire
       con.close();                   
       
       
    }catch(Exception e){
        System.out.println("erreur connexion a la bd"+e);
    }
   
    // creer un objet liste en lui passant en parametre l'objet model qui a recu tout les livres.
    JList<CD> list = new JList<CD>(model);
    
    // definir comment est ce que les elements de la liste devront etre afficher en passant en parametre un instance de LivreRenderer
    list.setCellRenderer(new CDRenderer());
    return list;
 }
    public static JList<ResearchMaterial> creerListeRSD(boolean noSearch,String mCurrentAuthorConstraint,String mCurrentPubCompanyConstraint,String mSearchCriteria) {
    // create List model
    DefaultListModel<ResearchMaterial> model = new DefaultListModel<ResearchMaterial>();
    // add item to model
    List<ResearchMaterial> listeRSD = new ArrayList<>();
    try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
           Statement st = con.createStatement();
           
           String sql = "select * from rsd";
           if(noSearch){
           if(!mCurrentAuthorConstraint.equalsIgnoreCase(ALL)){
               sql = "SELECT * FROM rsd WHERE Auteur = '"+mCurrentAuthorConstraint+"'";
               if(!mCurrentPubCompanyConstraint.equalsIgnoreCase(ALL)){
                    sql = "SELECT * FROM rsd WHERE Auteur = '"+mCurrentAuthorConstraint+"' AND MaisonEdition = '"+mCurrentPubCompanyConstraint+"'";
               }
           }else if(!mCurrentPubCompanyConstraint.equalsIgnoreCase(ALL)){
               
                sql = "SELECT * FROM rsd WHERE MaisonEdition = '"+mCurrentPubCompanyConstraint+"'";
           }
           }else{
                sql = "SELECT * FROM rsd WHERE Titre LIKE '%"+mSearchCriteria+"%'";
           }
           System.out.println(sql);  
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
           ResultSet resultat = st.executeQuery(sql);
                          //une boucle while pour parcourir tout les materiels de recherche dans resultat                       
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
                                ResearchMaterial rsd = new ResearchMaterial(titre,auteur,utilDate,nbExemplaire,maisonEdition,positionement,nomImage,id);
                                
                                //ajouter ce livre a la liste de livres
                                listeRSD.add(rsd);
                          }
                          //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.
                          model.addAll(listeRSD);
        //fermer la connexion quand je fini de tout extraire
       con.close();                   
       
       
    }catch(Exception e){
        System.out.println("erreur connexion a la bd");
    }
   
    // creer un objet liste en lui passant en parametre l'objet model qui a recu tout les livres.
    JList<ResearchMaterial> list = new JList<ResearchMaterial>(model);
    
    // definir comment est ce que les elements de la liste devront etre afficher en passant en parametre un instance de LivreRenderer
    list.setCellRenderer(new RSDRenderer());
    return list;
}
}
