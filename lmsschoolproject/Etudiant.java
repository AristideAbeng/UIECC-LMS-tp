/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import database.DBConnect;
import interface1.FenetreInscrireUtilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author KIBITI Wen Life
 */
public class Etudiant extends Utilisateur{
    private String matricule;
    
    private String filiere;
    private String num_telephone;
    private String email;
    private Date dateInscription;
    
    public Etudiant(String mat,String nm,String prnm,String fil,String sx,String nmtel,String eml,Date date){
        super(nm,prnm,sx,mat);
        this.matricule = mat;
        this.filiere = fil;
        this.num_telephone = nmtel;
        this.email = eml;
        this.dateInscription = date;
    }
    public String getNomEtPrenom(){
        return this.mNom+" "+this.mPrenom;
    }
    public String getFiliere(){
        return this.filiere;
    }
    public String getSexe(){
        return this.mSexe;
    }
    public Date getDateInscription(){
       return this.dateInscription;
    }
    public String getEmail(){
        return this.email;
    }
    public String getNom(){
        return this.mNom;
    }
    public String getPrenom(){
        return this.mPrenom;
    }
    public String getNumTelephone(){
        return this.num_telephone;
    }
    public String getMatricule(){
        return this.matricule;
    }
    public static boolean updateEtudiant(Etudiant e,Etudiant n){
        if(n==null || e==null){
            return false;
        }
        try{
                  Connection conn = DBConnect.connect();
                  
                  
             String query = "UPDATE `etudiant` SET `nom`= ?,`prenom` = ?,`sexe` = ?,`filiere` = ?,`telephone` = ?, `email` = ? WHERE matricule = ?";
             PreparedStatement preparedStmt = conn.prepareStatement(query);
            
             preparedStmt.setString(1, n.mNom);
             preparedStmt.setString(2,n.mPrenom);
             preparedStmt.setString(3, n.mSexe);
             preparedStmt.setString(4, n.filiere);
             preparedStmt.setString(5, n.num_telephone);
             preparedStmt.setString(6, n.email);
             preparedStmt.setString(7, e.matricule);

             // execute the java preparedstatement
             preparedStmt.executeUpdate();

             conn.close();
             }catch(Exception exc){
               System.out.println(exc);
               return false;
           }
        return true;
    }
    public static Etudiant getEtudiant(String matricule){
        Etudiant etudiant = null;
         if(matricule!=null){
             try{
                 Etudiant e = null;
                Connection con = DBConnect.connect();
                
                String requete = "SELECT * FROM etudiant WHERE matricule = ? ";
                
                 PreparedStatement stmt = con.prepareStatement(requete);
                 stmt.setString(1, matricule);
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
                ResultSet resultat = stmt.executeQuery();
                while(resultat.next()){
                    String matr = resultat.getString("matricule");
                    String nom = resultat.getString("nom");
                    String prnm = resultat.getString("prenom");
                    String fil = resultat.getString("Filiere");
                    String sx = resultat.getString("sexe");
                    String nmtel = resultat.getString("telephone");
                    String eml = resultat.getString("email");
                    java.sql.Date dateSqlInscription = resultat.getDate("dateInscription");
                    java.util.Date dateInscription = new java.util.Date(dateSqlInscription.getTime());
                     e = new Etudiant(matr,nom,prnm,fil,sx,nmtel,eml,dateInscription);
                }
                con.close();
                etudiant = e;
               }catch(Exception e){
                       System.out.println("Erreur getting etudiant"+e);
               }
             return etudiant;
        }
        return null;
    } 
    public static boolean validerMatricule(String matricule){
        if(matricule!=null){
             try{
                Connection con = DBConnect.connect();
                
                String requete = "SELECT * FROM etudiant WHERE matricule = ? ";
                
                 PreparedStatement stmt = con.prepareStatement(requete);
                 stmt.setString(1, matricule);
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
                ResultSet resultat = stmt.executeQuery();
                if(resultat.next() == false){
                    return false;
                }
                con.close();
                
               }catch(Exception e){
                       System.out.println(e);
               }
             return true;
        }
        return false;
    }
     public static List<Etudiant> getAllRegisteredUsers(){
          List<Etudiant> listeEtudiants = new ArrayList<>();
            try{
                //se connecter a la bd pour extraire tout les livres enregistrees
                  Connection con = DBConnect.connect();
                  //preparer la requete sql
                   Statement st = con.createStatement();
                   String sql = "select * from etudiant";

                    //executer la requete pour stocker le resultat dans la variable resultat              
                   ResultSet resultat = st.executeQuery(sql);
                                  //une boucle while pour parcourir tout les livres dans resultat                       
                                  while(resultat.next()){
                                        String matr = resultat.getString("matricule");
                                        String nom = resultat.getString("nom");
                                        String prnm = resultat.getString("prenom");
                                        String fil = resultat.getString("Filiere");
                                        String sx = resultat.getString("sexe");
                                        String nmtel = resultat.getString("telephone");
                                        String eml = resultat.getString("email");
                                        java.sql.Date dateSqlInscription = resultat.getDate("dateInscription");
                                        java.util.Date dateInscription = new java.util.Date(dateSqlInscription.getTime());

                                        //creer l'objet etudiant
                                         Etudiant e = new Etudiant(matr,nom,prnm,fil,sx,nmtel,eml,dateInscription);

                                        //ajouter cet etudiant a la liste Etudiant
                                        listeEtudiants.add(e);
                                  }
                                  //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.

                //fermer la connexion quand je fini de tout extraire
               con.close();                   


            }catch(Exception e){
                System.out.println("erreur connexion a la bd"+e);
            }
        return listeEtudiants;
    }
     public static List<Etudiant> getAllStudentsWithNameLike(String name){
          List<Etudiant> listeEtudiants = new ArrayList<>();
            try{
                //se connecter a la bd pour extraire tout les livres enregistrees
                  Connection con = DBConnect.connect();
                  //preparer la requete sql
                   Statement st = con.createStatement();
                   String sql = "select * from etudiant WHERE nom LIKE '%"+name+"%' OR prenom LIKE '%"+name+"%'";

                    //executer la requete pour stocker le resultat dans la variable resultat              
                   ResultSet resultat = st.executeQuery(sql);
                                  //une boucle while pour parcourir tout les livres dans resultat                       
                                  while(resultat.next()){
                                        String matr = resultat.getString("matricule");
                                        String nom = resultat.getString("nom");
                                        String prnm = resultat.getString("prenom");
                                        String fil = resultat.getString("Filiere");
                                        String sx = resultat.getString("sexe");
                                        String nmtel = resultat.getString("telephone");
                                        String eml = resultat.getString("email");
                                        java.sql.Date dateSqlInscription = resultat.getDate("dateInscription");
                                        java.util.Date dateInscription = new java.util.Date(dateSqlInscription.getTime());

                                        //creer l'objet etudiant
                                         Etudiant e = new Etudiant(matr,nom,prnm,fil,sx,nmtel,eml,dateInscription);

                                        //ajouter cet etudiant a la liste Etudiant
                                        listeEtudiants.add(e);
                                  }
                                  //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.

                //fermer la connexion quand je fini de tout extraire
               con.close();                   


            }catch(Exception e){
                System.out.println("erreur connexion a la bd"+e);
            }
        return listeEtudiants;
    }
      public static List<Etudiant> getAllRegisteredUsersInFiliere(String filiere){
          List<Etudiant> listeEtudiants = new ArrayList<>();
            try{
                //se connecter a la bd pour extraire tout les livres enregistrees
                  Connection con = DBConnect.connect();
                  //preparer la requete sql
                   Statement st = con.createStatement();
                   String sql = "select * from etudiant WHERE Filiere = '"+filiere+"'";
                   System.out.println(sql);
                    //executer la requete pour stocker le resultat dans la variable resultat              
                   ResultSet resultat = st.executeQuery(sql);
                                  //une boucle while pour parcourir tout les livres dans resultat                       
                                  while(resultat.next()){
                                        String matr = resultat.getString("matricule");
                                        String nom = resultat.getString("nom");
                                        String prnm = resultat.getString("prenom");
                                        String fil = resultat.getString("Filiere");
                                        String sx = resultat.getString("sexe");
                                        String nmtel = resultat.getString("telephone");
                                        String eml = resultat.getString("email");
                                        java.sql.Date dateSqlInscription = resultat.getDate("dateInscription");
                                        java.util.Date dateInscription = new java.util.Date(dateSqlInscription.getTime());

                                        //creer l'objet etudiant
                                         Etudiant e = new Etudiant(matr,nom,prnm,fil,sx,nmtel,eml,dateInscription);

                                        //ajouter cet etudiant a la liste Etudiant
                                        listeEtudiants.add(e);
                                  }
                                  //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.

                //fermer la connexion quand je fini de tout extraire
               con.close();                   


            }catch(Exception e){
                System.out.println("erreur connexion a la bd"+e);
            }
        return listeEtudiants;
    }
      
    public static List<Etudiant> getAllRegisteredUsersWithPendingBorrows(String filiere){
          List<Etudiant> listeEtudiants = new ArrayList<>();
            try{
                //se connecter a la bd pour extraire tout les livres enregistrees
                  Connection con = DBConnect.connect();
                  //preparer la requete sql
                   Statement st = con.createStatement();
                   String sql = "select * from etudiant";
                   if(filiere !=null){
                    sql = "SELECT DISTINCT etudiant.matricule,etudiant.nom,etudiant.prenom,etudiant.filiere,etudiant.sexe,etudiant.telephone,etudiant.email,etudiant.dateInscription"
                            + " FROM etudiant,empruntslivresetudiants,empruntetudiantcd,empruntetudiantmdr"
                            + " WHERE etudiant.matricule = empruntslivresetudiants.matricule "
                            + "AND etudiant.matricule = empruntetudiantcd.matricule "
                            + "AND etudiant.matricule = empruntetudiantmdr.matricule "
                            + "AND etudiant.filiere = '"+filiere+"' "
                            + "AND (empruntslivresetudiants.dateRetour IS NULL "
                            + "OR empruntetudiantcd.dateRetour IS NULL "
                            + "OR empruntetudiantmdr.dateRetour IS NULL)";
                           
                   }else{
                        sql = "SELECT DISTINCT etudiant.matricule,etudiant.nom,etudiant.prenom,etudiant.filiere,etudiant.sexe,etudiant.telephone,etudiant.email,etudiant.dateInscription"
                            + " FROM etudiant,empruntslivresetudiants,empruntetudiantcd,empruntetudiantmdr"
                            + " WHERE etudiant.matricule = empruntslivresetudiants.matricule "
                            + "AND etudiant.matricule = empruntetudiantcd.matricule "
                            + "AND etudiant.matricule = empruntetudiantmdr.matricule "
                            + "AND (empruntslivresetudiants.dateRetour IS NULL "
                            + "OR empruntetudiantcd.dateRetour IS NULL "
                            + "OR empruntetudiantmdr.dateRetour IS NULL)";
                   }

                    //executer la requete pour stocker le resultat dans la variable resultat              
                   ResultSet resultat = st.executeQuery(sql);
                                  //une boucle while pour parcourir tout les livres dans resultat                       
                                  while(resultat.next()){
                                        String matr = resultat.getString("matricule");
                                        String nom = resultat.getString("nom");
                                        String prnm = resultat.getString("prenom");
                                        String fil = resultat.getString("Filiere");
                                        String sx = resultat.getString("sexe");
                                        String nmtel = resultat.getString("telephone");
                                        String eml = resultat.getString("email");
                                        java.sql.Date dateSqlInscription = resultat.getDate("dateInscription");
                                        java.util.Date dateInscription = new java.util.Date(dateSqlInscription.getTime());

                                        //creer l'objet etudiant
                                         Etudiant e = new Etudiant(matr,nom,prnm,fil,sx,nmtel,eml,dateInscription);

                                        //ajouter cet etudiant a la liste Etudiant
                                        listeEtudiants.add(e);
                                  }
                                  //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.

                //fermer la connexion quand je fini de tout extraire
               con.close();                   


            }catch(Exception e){
                System.out.println("erreur connexion a la bd"+e);
            }
        return listeEtudiants;
    }
     public static List<Etudiant> getAllRegisteredUsersWithClearBorrows(String filiere){
          List<Etudiant> listeEtudiants = new ArrayList<>();
            try{
                //se connecter a la bd pour extraire tout les livres enregistrees
                  Connection con = DBConnect.connect();
                  //preparer la requete sql
                   Statement st = con.createStatement();
                   String sql = "select * from etudiant";
                   if(filiere !=null){
                    sql = "SELECT DISTINCT etudiant.matricule,etudiant.nom,etudiant.prenom,etudiant.filiere,etudiant.sexe,etudiant.telephone,etudiant.email,etudiant.dateInscription"
                            + " FROM etudiant "
                            + "WHERE etudiant.matricule NOT IN ("
                            + "SELECT DISTINCT etudiant.matricule,etudiant.nom,etudiant.prenom,etudiant.filiere,etudiant.sexe,etudiant.telephone,etudiant.email,etudiant.dateInscription"
                            + " FROM etudiant,empruntslivresetudiants"
                            + " WHERE etudiant.matricule = empruntslivresetudiants.matricule "
                            + "AND etudiant.filiere = '"+filiere+"' "
                            + "AND "
                            + "NOT EXISTS("
                            + "SELECT * FROM empruntlivresetudiants "
                            + "WHERE etudiant.matricule = empruntslivresetudiants.matricule "
                            + "AND empruntslivresetudiants.dateRetour IS NOT NULL )"
                            +" UNION "
                           + "SELECT DISTINCT etudiant.matricule,etudiant.nom,etudiant.prenom,etudiant.filiere,etudiant.sexe,etudiant.telephone,etudiant.email,etudiant.dateInscription"
                            + " FROM etudiant,empruntetudiantcd"
                            + " WHERE etudiant.matricule = empruntetudiantcd.matricule "
                            + "AND etudiant.filiere = '"+filiere+"' "
                            + "AND "
                            + "NOT EXISTS("
                            + "SELECT * FROM empruntetudiantcd "
                            + "WHERE etudiant.matricule = empruntetudiantcd.matricule "
                            + "AND empruntetudiantcd.dateRetour IS NOT NULL )"
                            +" UNION "
                           + "SELECT DISTINCT etudiant.matricule,etudiant.nom,etudiant.prenom,etudiant.filiere,etudiant.sexe,etudiant.telephone,etudiant.email,etudiant.dateInscription"
                            + " FROM etudiant,empruntetudiantmdr"
                            + " WHERE etudiant.matricule = empruntetudiantmdr.matricule "
                            + "AND etudiant.filiere = '"+filiere+"' "
                            + "AND "
                            + "NOT EXISTS("
                            + "SELECT * FROM empruntetudiantmdr "
                            + "WHERE etudiant.matricule = empruntetudiantmdr.matricule "
                            + "AND empruntetudiantmdr.dateRetour IS NOT NULL ))"
                            + " AND etudiant.matricule IN ("
                            + " SELECT matricule FROM empruntslivresetudiants "
                            + " UNION "
                            + " SELECT matricule FROM empruntetudiantcd "
                            + " UNION "
                            + " SELECT matricule FROM empruntetudiantmdr)"
                            ;
                   }else{
                       sql = "SELECT DISTINCT etudiant.matricule,etudiant.nom,etudiant.prenom,etudiant.filiere,etudiant.sexe,etudiant.telephone,etudiant.email,etudiant.dateInscription"
                            + " FROM etudiant WHERE etudiant.matricule NOT IN("
                            + " SELECT DISTINCT etudiant.matricule,etudiant.nom,etudiant.prenom,etudiant.filiere,etudiant.sexe,etudiant.telephone,etudiant.email,etudiant.dateInscription"
                            + "FROM etudiant,empruntslivresetudiants"
                            + " WHERE etudiant.matricule = empruntslivresetudiants.matricule "
                            + "AND "
                            + "NOT EXISTS("
                            + "SELECT * FROM empruntlivresetudiants "
                            + "WHERE etudiant.matricule = empruntslivresetudiants.matricule "
                            + "AND empruntslivresetudiants.dateRetour IS NOT NULL )"
                            +" UNION "
                           + "SELECT DISTINCT etudiant.matricule,etudiant.nom,etudiant.prenom,etudiant.filiere,etudiant.sexe,etudiant.telephone,etudiant.email,etudiant.dateInscription"
                            + " FROM etudiant,empruntetudiantcd"
                            + " WHERE etudiant.matricule = empruntetudiantcd.matricule "
                            + "AND "
                            + "NOT EXISTS("
                            + "SELECT * FROM empruntetudiantcd "
                            + "WHERE etudiant.matricule = empruntetudiantcd.matricule "
                            + "AND empruntetudiantcd.dateRetour IS NOT NULL )"
                            +" UNION "
                           + "SELECT DISTINCT etudiant.matricule,etudiant.nom,etudiant.prenom,etudiant.filiere,etudiant.sexe,etudiant.telephone,etudiant.email,etudiant.dateInscription"
                            + " FROM etudiant,empruntetudiantmdr"
                            + " WHERE etudiant.matricule = empruntetudiantmdr.matricule "
                            + "AND "
                            + "NOT EXISTS("
                            + "SELECT * FROM empruntetudiantmdr "
                            + "WHERE etudiant.matricule = empruntetudiantmdr.matricule "
                            + "AND empruntetudiantmdr.dateRetour IS NOT NULL ))"
                            + " AND etudiant.matricule IN ("
                            + " SELECT matricule FROM empruntslivresetudiants "
                            + " UNION "
                            + " SELECT matricule FROM empruntetudiantcd "
                            + " UNION "
                            + " SELECT matricule FROM empruntetudiantmdr)"
                            ;
                   }

                    //executer la requete pour stocker le resultat dans la variable resultat              
                   ResultSet resultat = st.executeQuery(sql);
                                  //une boucle while pour parcourir tout les livres dans resultat                       
                                  while(resultat.next()){
                                        String matr = resultat.getString("matricule");
                                        String nom = resultat.getString("nom");
                                        String prnm = resultat.getString("prenom");
                                        String fil = resultat.getString("Filiere");
                                        String sx = resultat.getString("sexe");
                                        String nmtel = resultat.getString("telephone");
                                        String eml = resultat.getString("email");
                                        java.sql.Date dateSqlInscription = resultat.getDate("dateInscription");
                                        java.util.Date dateInscription = new java.util.Date(dateSqlInscription.getTime());

                                        //creer l'objet etudiant
                                         Etudiant e = new Etudiant(matr,nom,prnm,fil,sx,nmtel,eml,dateInscription);

                                        //ajouter cet etudiant a la liste Etudiant
                                        listeEtudiants.add(e);
                                  }
                                  //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.

                //fermer la connexion quand je fini de tout extraire
               con.close();                   


            }catch(Exception e){
                System.out.println("erreur connexion a la bd"+e);
            }
        return listeEtudiants;
    }
    public static boolean Emprunter(LibraryItem item,String type, Etudiant e){
        if(validerPossibiliterNouvelEmpruntApresSelection(e,item,type)){
             try{
                 
                Connection con = DBConnect.connect();
                 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                 Date date = null;
                  java.sql.Date sqldate = null;
                   
                  date = sdf.parse(sdf.format(new Date()));
                  sqldate = new java.sql.Date(date.getTime());
                   
                  System.out.println("type to be borrowed  is "+type);  
                   
                 
                 if(type.equalsIgnoreCase("livre")){
                     Livre livre = (Livre)item;
                     String insertQuery = "INSERT INTO `empruntslivresetudiants`(`matricule`, `id`, `dateEmprunt`) VALUES (?,?,?)";
                
                    PreparedStatement stmt = con.prepareStatement(insertQuery);
                    stmt.setString(1,e.matricule);
                    stmt.setInt(2,livre.id);
                    stmt.setDate(3, sqldate);
                    
                    stmt.execute();
                 }else if(type.equalsIgnoreCase("cd")){
                     System.out.println("inserting to CD table");
                     CD cd = (CD) item;
                     String insertQuery = "INSERT INTO `empruntetudiantcd`(`matricule`, `identifiant`, `dateEmprunt`) VALUES (?,?,?)";
                
                    PreparedStatement stmt = con.prepareStatement(insertQuery);
                    stmt.setString(1,e.matricule);
                    stmt.setInt(2,cd.id);
                    stmt.setDate(3, sqldate);
                    
                    stmt.execute();
                 }else{
                     ResearchMaterial rsd = (ResearchMaterial) item;
                     String insertQuery = "INSERT INTO `empruntetudiantmdr`(`matricule`, `identifiant`, `dateEmprunt`) VALUES (?,?,?)";
                
                    PreparedStatement stmt = con.prepareStatement(insertQuery);
                    stmt.setString(1,e.matricule);
                    stmt.setInt(2,rsd.id);
                    stmt.setDate(3, sqldate);
                    
                    stmt.execute();
                 }
                          
            //executer la requete pour stocker le resultat dans la variable resultat              
                
               
                con.close();
               return true;
                
               }catch(Exception ex){
                       System.out.println("From Etudiant Emprunter Method CD"+ex);
               }
             
        }
        return false;
    }
    public static boolean validerPossibiliterNouvelEmpruntAvantSelection(Etudiant e) {
        List<Emprunt>  emprunts = e.retournerListeEmprunts(e);
        if(emprunts.size() > 3){
            return false;
        }
        for(Emprunt emp : emprunts){
            if(emp.getValuePenalitesAccumules() > 0){
                return false;
            }
        }
        return true;
    }
    public static boolean validerPossibiliterNouvelEmpruntApresSelection(Etudiant e,LibraryItem item,String type){
         List<Emprunt>  emprunts = e.retournerListeEmprunts(e);
        if(type.equals("Livre")){
            for(Emprunt emp : emprunts){
            Livre livreNonRembourse = (Livre) emp.ressource;
            Livre livreEnCoursDemprunt = (Livre) item;
            if(livreNonRembourse.id == livreEnCoursDemprunt.id){
                return false;
            }
        }
        }
        return true;
    }
    public static JList<Emprunt> chercherEmpruntsEtudiant(String matricule){
         // create List model
          DefaultListModel<Emprunt> model = new DefaultListModel<Emprunt>();
       // add item to model
         List<Emprunt> listEmprunts = new ArrayList<>();
         try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
            String requeteEmpruntsLivres = "SELECT * FROM empruntslivresetudiants WHERE matricule = ? AND dateRetour IS NULL  ";
            PreparedStatement stmt = con.prepareStatement(requeteEmpruntsLivres);
            stmt.setString(1, matricule);
            ResultSet resultat = stmt.executeQuery();
            while(resultat.next()){
                String idLivre = resultat.getString("id");
                 java.sql.Date dateEmprsql = resultat.getDate("dateEmprunt");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                 int identifiant = resultat.getInt("identifiant");
                 Livre livre = Livre.getLivreFromId(Integer.parseInt(idLivre));
                 Emprunt emprunt = new Emprunt(livre,dateEmprunt,Etudiant.getEtudiant(matricule),"Livre",identifiant);
                 listEmprunts.add(emprunt);
            }
            String requeteEmpruntsCD = "SELECT * FROM empruntetudiantcd WHERE matricule = ? AND dateRetour IS NULL  ";
            PreparedStatement stmtcd = con.prepareStatement(requeteEmpruntsCD);
            stmtcd.setString(1, matricule);
            ResultSet resultatcd = stmtcd.executeQuery();
            while(resultatcd.next()){
                String idcd = resultatcd.getString("identifiant");
                 java.sql.Date dateEmprsql = resultatcd.getDate("dateEmprunt");
                  int identifiant = resultatcd.getInt("id");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                 CD cd = CD.getCdFromId(idcd);
                 Emprunt emprunt = new Emprunt(cd,dateEmprunt,Etudiant.getEtudiant(matricule),"cd",identifiant);
                 listEmprunts.add(emprunt);
            }
            String requeteEmpruntsMDR = "SELECT * FROM empruntetudiantmdr WHERE matricule = ? AND dateRetour IS NULL  ";
            PreparedStatement stmtmdr = con.prepareStatement(requeteEmpruntsMDR);
            stmtmdr.setString(1, matricule);
            ResultSet resultatmdr = stmtmdr.executeQuery();
            while(resultatmdr.next()){
                String idmdr = resultatmdr.getString("identifiant");
                 java.sql.Date dateEmprsql = resultatmdr.getDate("dateEmprunt");
                  int identifiant = resultatmdr.getInt("id");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                 ResearchMaterial rsd = ResearchMaterial.getRSDFromId(idmdr);
                 Emprunt emprunt = new Emprunt(rsd,dateEmprunt,Etudiant.getEtudiant(matricule),"rsd",identifiant);
                 listEmprunts.add(emprunt);
            }
         //ajouter la liste des livres au model du JList. cet a dire l'objet qui dit au JList quoi afficher.
         model.addAll(listEmprunts);
        //fermer la connexion quand je fini de tout extraire
       con.close();                   
       
       
    }catch(Exception e){
        System.out.println("erreur connexion a la bd "+e);
    }
   
    // creer un objet liste en lui passant en parametre l'objet model qui a recu tout les livres.
    JList<Emprunt> list = new JList<>(model);
    
    // definir comment est ce que les elements de la liste devront etre afficher en passant en parametre un instance de LivreRenderer
    list.setCellRenderer(new EmpruntRenderer());
    //return list;
        return list;
    }
    private List<Emprunt> retournerListeEmprunts(Etudiant e){
          List<Emprunt> listEmprunts = new ArrayList<>();
         try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
            String requeteEmpruntsLivres = "SELECT * FROM empruntslivresetudiants WHERE matricule = ? AND dateRetour IS NULL  ";
            PreparedStatement stmt = con.prepareStatement(requeteEmpruntsLivres);
            stmt.setString(1, e.matricule);
            ResultSet resultat = stmt.executeQuery();
            while(resultat.next()){
                String idLivre = resultat.getString("id");
                 java.sql.Date dateEmprsql = resultat.getDate("dateEmprunt");
                  int identifiant = resultat.getInt("identifiant");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                 Livre livre = Livre.getLivreFromId(Integer.parseInt(idLivre));
                 Emprunt emprunt = new Emprunt(livre,dateEmprunt,Etudiant.getEtudiant(matricule),"Livre",identifiant);
                 listEmprunts.add(emprunt);
            }
            String requeteEmpruntsCD = "SELECT * FROM empruntetudiantcd WHERE matricule = ? AND dateRetour IS NULL  ";
            PreparedStatement stmtcd = con.prepareStatement(requeteEmpruntsCD);
            stmtcd.setString(1, matricule);
            ResultSet resultatcd = stmtcd.executeQuery();
            while(resultatcd.next()){
                String idcd = resultatcd.getString("id");
                 java.sql.Date dateEmprsql = resultatcd.getDate("dateEmprunt");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                  int identifiant = resultatcd.getInt("identifiant");
                 CD cd = CD.getCdFromId(idcd);
                 Emprunt emprunt = new Emprunt(cd,dateEmprunt,Etudiant.getEtudiant(matricule),"CD",identifiant);
                 listEmprunts.add(emprunt);
            }
            
         String requeteEmpruntsMDR = "SELECT * FROM empruntetudiantmdr WHERE matricule = ? AND dateRetour IS NULL  ";
            PreparedStatement stmtmdr = con.prepareStatement(requeteEmpruntsMDR);
            stmtmdr.setString(1, matricule);
            ResultSet resultatmdr = stmtmdr.executeQuery();
            while(resultatmdr.next()){
                String idmdr = resultatmdr.getString("identifiant");
                 java.sql.Date dateEmprsql = resultatmdr.getDate("dateEmprunt");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                  int identifiant = resultatmdr.getInt("id");
                 ResearchMaterial rsd = ResearchMaterial.getRSDFromId(idmdr);
                 Emprunt emprunt = new Emprunt(rsd,dateEmprunt,Etudiant.getEtudiant(matricule),"rsd",identifiant);
                 listEmprunts.add(emprunt);
            }
        //fermer la connexion quand je fini de tout extraire
       con.close();  
    }catch(Exception exc){
        System.out.println(e);
    }
      return listEmprunts;  
    }
    public static List<Emprunt> getAllStudentsTransactions(){
         List<Emprunt> listEmprunts = new ArrayList<>();
          try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
            String requeteEmpruntsLivres = "SELECT * FROM empruntslivresetudiants";
            PreparedStatement stmt = con.prepareStatement(requeteEmpruntsLivres);
           
            ResultSet resultat = stmt.executeQuery();
            while(resultat.next()){
                String idLivre = resultat.getString("id");
                 java.sql.Date dateEmprsql = resultat.getDate("dateEmprunt");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                  java.sql.Date dateRetrsql = resultat.getDate("dateRetour");
                 java.util.Date dateRetour = new Date();
                     if(dateRetrsql == null){
                         dateRetour = null;
                     }else{
                        dateRetour = new java.util.Date(dateRetrsql.getTime());  
                     }
                 int identifiant = resultat.getInt("identifiant");
                 String matricule = resultat.getString("matricule");
                 Livre livre = Livre.getLivreFromId(Integer.parseInt(idLivre));
                 Emprunt emprunt = new Emprunt(livre,dateEmprunt,Etudiant.getEtudiant(matricule),"Livre",identifiant);
                  emprunt.setDateRetour(dateRetour);
                 listEmprunts.add(emprunt);
            }
            String requeteEmpruntsCD = "SELECT * FROM empruntetudiantcd";
            PreparedStatement stmtcd = con.prepareStatement(requeteEmpruntsCD);
            ResultSet resultatcd = stmtcd.executeQuery();
            while(resultatcd.next()){
                String idcd = resultatcd.getString("id");
                
                  int identifiant = resultatcd.getInt("identifiant");
                   String matricule = resultatcd.getString("matricule");
                 java.sql.Date dateEmprsql = resultatcd.getDate("dateEmprunt");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                  java.sql.Date dateRetrsql = resultatcd.getDate("dateRetour");
                java.util.Date dateRetour = new Date();
                     if(dateRetrsql == null){
                         dateRetour = null;
                     }else{
                        dateRetour = new java.util.Date(dateRetrsql.getTime());  
                     }
                 CD cd = CD.getCdFromId(idcd);
                 Emprunt emprunt = new Emprunt(cd,dateEmprunt,Etudiant.getEtudiant(matricule),"cd",identifiant);
                  emprunt.setDateRetour(dateRetour);
                 listEmprunts.add(emprunt);
            }
            String requeteEmpruntsMDR = "SELECT * FROM empruntetudiantmdr";
            PreparedStatement stmtmdr = con.prepareStatement(requeteEmpruntsMDR);
          
            ResultSet resultatmdr = stmtmdr.executeQuery();
            while(resultatmdr.next()){
                String idmdr = resultatmdr.getString("identifiant");
                
                  int identifiant = resultatmdr.getInt("id");
                   String matricule = resultatmdr.getString("matricule");
                    java.sql.Date dateEmprsql = resultatmdr.getDate("dateEmprunt");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                     java.sql.Date dateRetrsql = resultatmdr.getDate("dateRetour");
                      java.util.Date dateRetour = new Date();
                     if(dateRetrsql == null){
                         dateRetour = null;
                     }else{
                        dateRetour = new java.util.Date(dateRetrsql.getTime());  
                     }
                 
                 ResearchMaterial rsd = ResearchMaterial.getRSDFromId(idmdr);
                 Emprunt emprunt = new Emprunt(rsd,dateEmprunt,Etudiant.getEtudiant(matricule),"rsd",identifiant);
                 emprunt.setDateRetour(dateRetour);
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
     public static List<Emprunt> getAllUnReturnedStudentsTransactions(){
         List<Emprunt> listEmprunts = new ArrayList<>();
          try{
        //se connecter a la bd pour extraire tout les livres enregistrees
          Connection con = DBConnect.connect();
          //preparer la requete sql
            String requeteEmpruntsLivres = "SELECT * FROM empruntslivresetudiants WHERE dateRetour IS NULL";
            PreparedStatement stmt = con.prepareStatement(requeteEmpruntsLivres);
           
            ResultSet resultat = stmt.executeQuery();
            while(resultat.next()){
                String idLivre = resultat.getString("id");
                 java.sql.Date dateEmprsql = resultat.getDate("dateEmprunt");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                  java.sql.Date dateRetrsql = resultat.getDate("dateRetour");
                 java.util.Date dateRetour = new Date();
                     if(dateRetrsql == null){
                         dateRetour = null;
                     }else{
                        dateRetour = new java.util.Date(dateRetrsql.getTime());  
                     }
                 int identifiant = resultat.getInt("identifiant");
                 String matricule = resultat.getString("matricule");
                 Livre livre = Livre.getLivreFromId(Integer.parseInt(idLivre));
                 Emprunt emprunt = new Emprunt(livre,dateEmprunt,Etudiant.getEtudiant(matricule),"Livre",identifiant);
                  emprunt.setDateRetour(dateRetour);
                 listEmprunts.add(emprunt);
            }
            String requeteEmpruntsCD = "SELECT * FROM empruntetudiantcd WHERE dateRetour IS NULL";
            PreparedStatement stmtcd = con.prepareStatement(requeteEmpruntsCD);
            ResultSet resultatcd = stmtcd.executeQuery();
            while(resultatcd.next()){
                String idcd = resultatcd.getString("id");
                
                  int identifiant = resultatcd.getInt("identifiant");
                   String matricule = resultatcd.getString("matricule");
                 java.sql.Date dateEmprsql = resultatcd.getDate("dateEmprunt");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                  java.sql.Date dateRetrsql = resultatcd.getDate("dateRetour");
                java.util.Date dateRetour = new Date();
                     if(dateRetrsql == null){
                         dateRetour = null;
                     }else{
                        dateRetour = new java.util.Date(dateRetrsql.getTime());  
                     }
                 CD cd = CD.getCdFromId(idcd);
                 Emprunt emprunt = new Emprunt(cd,dateEmprunt,Etudiant.getEtudiant(matricule),"cd",identifiant);
                  emprunt.setDateRetour(dateRetour);
                 listEmprunts.add(emprunt);
            }
            String requeteEmpruntsMDR = "SELECT * FROM empruntetudiantmdr WHERE dateRetour IS NULL";
            PreparedStatement stmtmdr = con.prepareStatement(requeteEmpruntsMDR);
          
            ResultSet resultatmdr = stmtmdr.executeQuery();
            while(resultatmdr.next()){
                String idmdr = resultatmdr.getString("identifiant");
                
                  int identifiant = resultatmdr.getInt("id");
                   String matricule = resultatmdr.getString("matricule");
                    java.sql.Date dateEmprsql = resultatmdr.getDate("dateEmprunt");
                 java.util.Date dateEmprunt = new java.util.Date(dateEmprsql.getTime());
                     java.sql.Date dateRetrsql = resultatmdr.getDate("dateRetour");
                      java.util.Date dateRetour = new Date();
                     if(dateRetrsql == null){
                         dateRetour = null;
                     }else{
                        dateRetour = new java.util.Date(dateRetrsql.getTime());  
                     }
                 
                 ResearchMaterial rsd = ResearchMaterial.getRSDFromId(idmdr);
                 Emprunt emprunt = new Emprunt(rsd,dateEmprunt,Etudiant.getEtudiant(matricule),"rsd",identifiant);
                 emprunt.setDateRetour(dateRetour);
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
