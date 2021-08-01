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
public class Lecturer extends Utilisateur{
    
   
    private String departement;
   
    private String num_telephone;
    private String email;
    private Date dateInscription;
    
    public Lecturer (String id,String nm,String prnm,String dep,String sx,String nmtel,String eml,Date date){
        super(nm,prnm,sx,id);
        this.departement = dep;
        this.num_telephone = nmtel;
        this.email = eml;
        this.dateInscription = date;
    }
    
     public static boolean updateLecturer(Lecturer e,Lecturer n){
        if(n==null || e==null){
            return false;
        }
        try{
                  Connection conn = DBConnect.connect();
                  
                  
             String query = "UPDATE `lecturer` SET `nom`= ?,`prenom` = ?,`sexe` = ?,`departement` = ?,`numtel` = ?, `email` = ? WHERE Identifiant = ?";
             PreparedStatement preparedStmt = conn.prepareStatement(query);
            
             preparedStmt.setString(1, n.mNom);
             preparedStmt.setString(2,n.mPrenom);
             preparedStmt.setString(3, n.mSexe);
             preparedStmt.setString(4, n.departement);
             preparedStmt.setString(5, n.num_telephone);
             preparedStmt.setString(6, n.email);
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
   
     public static List<Lecturer> getAllRegisteredLecturers(){
          List<Lecturer> listeLecturers = new ArrayList<>();
            try{
                //se connecter a la bd pour extraire tout les livres enregistrees
                  Connection con = DBConnect.connect();
                  //preparer la requete sql
                   Statement st = con.createStatement();
                   String sql = "select * from lecturer";

                    //executer la requete pour stocker le resultat dans la variable resultat              
                   ResultSet resultat = st.executeQuery(sql);
                                  //une boucle while pour parcourir tout les livres dans resultat                       
                                  while(resultat.next()){
                                        String matr = resultat.getString("Identifiant");
                                        String nom = resultat.getString("nom");
                                        String prnm = resultat.getString("prenom");
                                        String dep = resultat.getString("departement");
                                        String sx = resultat.getString("sexe");
                                        String nmtel = resultat.getString("numtel");
                                        String eml = resultat.getString("email");
                                        java.sql.Date dateSqlInscription = resultat.getDate("date");
                                        java.util.Date dateInscription = new java.util.Date(dateSqlInscription.getTime());

                                        //creer l'objet etudiant
                                         Lecturer l = new Lecturer(matr,nom,prnm,dep,sx,nmtel,eml,dateInscription);

                                        //ajouter cet etudiant a la liste Etudiant
                                        listeLecturers.add(l);
                                  }
                                  //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.

                //fermer la connexion quand je fini de tout extraire
               con.close();                   


            }catch(Exception e){
                System.out.println("erreur connexion a la bd"+e);
            }
        return listeLecturers;
    }
     public static Lecturer getLecturer(String id){
          Lecturer lecturer = null;
            try{
                //se connecter a la bd pour extraire tout les livres enregistrees
                  Connection con = DBConnect.connect();
                  //preparer la requete sql
                  
                   String sql = "select * from lecturer WHERE id_enseignant = ?";
                   
                   PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1,id);

                    //executer la requete pour stocker le resultat dans la variable resultat              
                   ResultSet resultat = st.executeQuery(sql);
                                  //une boucle while pour parcourir tout les livres dans resultat                       
                                  while(resultat.next()){
                                        String matr = resultat.getString("Identifiant");
                                        String nom = resultat.getString("nom");
                                        String prnm = resultat.getString("prenom");
                                        String dep = resultat.getString("departement");
                                        String sx = resultat.getString("sexe");
                                        String nmtel = resultat.getString("numtel");
                                        String eml = resultat.getString("email");
                                        java.sql.Date dateSqlInscription = resultat.getDate("date");
                                        java.util.Date dateInscription = new java.util.Date(dateSqlInscription.getTime());

                                        //creer l'objet etudiant
                                         Lecturer l = new Lecturer(matr,nom,prnm,dep,sx,nmtel,eml,dateInscription);

                                        //ajouter cet etudiant a la liste Etudiant
                                        lecturer = l;
                                  }
                                  //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.

                //fermer la connexion quand je fini de tout extraire
               con.close();                   


            }catch(Exception e){
                System.out.println("erreur connexion a la bd"+e);
            }
        return lecturer;
     }
    public String getNomEtPrenom(){
        return this.mNom+" "+this.mPrenom;
    }
    public String getDepartment(){
        return this.departement;
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
     public String getNumTelephone(){
        return this.num_telephone;
    }
    public static List<Emprunt> getAllLecturerEmprunts(){
        List<Emprunt> listEmprunts = new ArrayList<>();
          try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
            String requeteEmpruntsLivres = "SELECT * FROM empruntslivrelecturerss";
            PreparedStatement stmt = con.prepareStatement(requeteEmpruntsLivres);
           
            ResultSet resultat = stmt.executeQuery();
            while(resultat.next()){
                String idLivre = resultat.getString("id");
                 java.sql.Date dateEmprsql = resultat.getDate("dateEmprunt");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                 int identifiant = resultat.getInt("identifiant");
                 String idEnseignant = resultat.getString("id_enseignant");
                 Livre livre = Livre.getLivreFromId(Integer.parseInt(idLivre));
                 Emprunt emprunt = new Emprunt(livre,dateEmprunt,Lecturer.getLecturer(idEnseignant),"Livre",identifiant);
                 listEmprunts.add(emprunt);
            }
            String requeteEmpruntsCD = "SELECT * FROM empruntetudiantcd";
            PreparedStatement stmtcd = con.prepareStatement(requeteEmpruntsCD);
            ResultSet resultatcd = stmtcd.executeQuery();
            while(resultatcd.next()){
                String idcd = resultatcd.getString("id");
                 java.sql.Date dateEmprsql = resultatcd.getDate("dateEmprunt");
                  int identifiant = resultatcd.getInt("identifiant");
                   String idEnseignant = resultat.getString("id_Enseignant");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                 CD cd = CD.getCdFromId(idcd);
                 Emprunt emprunt = new Emprunt(cd,dateEmprunt,Lecturer.getLecturer(idEnseignant),"cd",identifiant);
                 listEmprunts.add(emprunt);
            }
            String requeteEmpruntsMDR = "SELECT * FROM empruntetudiantmdr";
            PreparedStatement stmtmdr = con.prepareStatement(requeteEmpruntsMDR);
          
            ResultSet resultatmdr = stmtmdr.executeQuery();
            while(resultatmdr.next()){
                String idmdr = resultatmdr.getString("identifiant");
                 java.sql.Date dateEmprsql = resultatmdr.getDate("dateEmprunt");
                  int identifiant = resultatmdr.getInt("id");
                   String idEnseignant = resultat.getString("id_Enseignant");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                 ResearchMaterial rsd = ResearchMaterial.getRSDFromId(idmdr);
                 Emprunt emprunt = new Emprunt(rsd,dateEmprunt,Lecturer.getLecturer(idEnseignant),"rsd",identifiant);
                 listEmprunts.add(emprunt);
            }
         //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.
        // model.addAll(listEmprunts);
        //fermer la connexion quand je fini de tout extraire
       con.close();                   
       
       
    }catch(Exception e){
        System.out.println("erreur connexion a la bd "+e);
    }
       return listEmprunts;   
    }
    
}
