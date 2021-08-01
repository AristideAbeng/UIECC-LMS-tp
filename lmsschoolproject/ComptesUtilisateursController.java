/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import database.DBConnect;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import interface1.AdministrateurCellRenderer;
import interface1.LecturerCellRenderer;
import interface1.EtudiantListeRenderer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author PBHev
 */
public class ComptesUtilisateursController {

    public static String ALL = "ALL";
    public static String BORROWED_AND_RETURNED = "Borrowed and Returned";
    
    public static JList<Etudiant> getStudentsList(boolean noSearch,String mCurrentFiliereConstraint,String mCurrentTransactionStatusConstraint,String mSearchCriteria){
        
            // create List model
    DefaultListModel<Etudiant> model = new DefaultListModel<Etudiant>();
    // add item to model
    List<Etudiant> listeEtudiants = new ArrayList<>();
    listeEtudiants = Etudiant.getAllRegisteredUsers();
    if(noSearch){
        if(!mCurrentFiliereConstraint.equalsIgnoreCase(ALL)){
            System.out.println(mCurrentFiliereConstraint);
            listeEtudiants = Etudiant.getAllRegisteredUsersInFiliere(mCurrentFiliereConstraint);
            if(!mCurrentTransactionStatusConstraint.equalsIgnoreCase(ALL)){
                if(mCurrentTransactionStatusConstraint.equalsIgnoreCase(BORROWED_AND_RETURNED)){
                     listeEtudiants = Etudiant.getAllRegisteredUsersWithClearBorrows(mCurrentFiliereConstraint);
                }else{
                     listeEtudiants = Etudiant.getAllRegisteredUsersWithPendingBorrows(mCurrentFiliereConstraint);
                }
               
                 System.out.println(mCurrentTransactionStatusConstraint);
            }
        }else  if(!mCurrentTransactionStatusConstraint.equalsIgnoreCase(ALL)){
             System.out.println(mCurrentTransactionStatusConstraint);
             listeEtudiants = Etudiant.getAllRegisteredUsersWithPendingBorrows(null);
        }
    }else{
         System.out.println("searching");
       listeEtudiants = Etudiant.getAllStudentsWithNameLike(mSearchCriteria);
    }
   
    
    model.addAll(listeEtudiants);
    // creer un objet liste en lui passant en parametre l'objet model qui a recu tout les livres.
    JList<Etudiant> list = new JList<Etudiant>(model);
    
    // definir comment est ce que les elements de la liste devront etre afficher en passant en parametre un instance de LivreRenderer
    list.setCellRenderer(new EtudiantListeRenderer());
    return list;
    }
    
    public static JList<Lecturer> getLecturerList(){
        DefaultListModel<Lecturer> model = new DefaultListModel<Lecturer>();
    // add item to model
    List<Lecturer>  listeLecturer = new ArrayList<>();
    listeLecturer = Lecturer.getAllRegisteredLecturers();
    
   
    
    model.addAll(listeLecturer);
    // creer un objet liste en lui passant en parametre l'objet model qui a recu tout les livres.
    JList<Lecturer> list = new JList<Lecturer>(model);
    
    // definir comment est ce que les elements de la liste devront etre afficher en passant en parametre un instance de LivreRenderer
    list.setCellRenderer(new LecturerCellRenderer());
    return list;
    }
    
    public static JList<Administrateur> getAdminList(){
            // create List model
    DefaultListModel<Administrateur> model = new DefaultListModel<Administrateur>();
    // add item to model
    List<Administrateur>  listeAdministrateur = new ArrayList<>();
    listeAdministrateur = Administrateur.getAllRegisteredAdministrateurs();
    
   
    
    model.addAll(listeAdministrateur);
    // creer un objet liste en lui passant en parametre l'objet model qui a recu tout les livres.
    JList<Administrateur> list = new JList<Administrateur>(model);
    
    // definir comment est ce que les elements de la liste devront etre afficher en passant en parametre un instance de LivreRenderer
    list.setCellRenderer(new AdministrateurCellRenderer());
    return list;
    }
    
    public static boolean deleteEtudiant(Etudiant etudiant){
         try{

                                    Connection con = DBConnect.connect();
                                    String insertQuery = "DELETE FROM  etudiant WHERE matricule = ?";

                                     PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                                     
                                      requeteInsertion.setString(0,etudiant.getMatricule());


                                      requeteInsertion.execute();
                                      

                                      con.close();
                                      return true;
                              }catch(Exception exc){
                                  System.out.println(exc);
                                   
                              }
        return false;
    }
    public static boolean deleteLecturer(Lecturer lecturer){
         try{

                                    Connection con = DBConnect.connect();
                                      String insertQuery = "DELETE FROM  lecturer WHERE Identifiant = ?";

                                     PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                                     
                                      requeteInsertion.setString(0,lecturer.getIdentifiant());


                                      requeteInsertion.execute();
                                      

                                      con.close();
                                      return true;
                              }catch(Exception exc){
                                  System.out.println(exc);
                                   
                              }
        return false;
    }
    public static boolean deleteAdmin(Administrateur admin){
        try{

                                    Connection con = DBConnect.connect();
                                     String insertQuery = "DELETE FROM  administrateur WHERE Identifiant = ?";

                                     PreparedStatement requeteInsertion = con.prepareStatement(insertQuery);
                                     
                                      requeteInsertion.setString(0,admin.getIdentifiant());


                                      requeteInsertion.execute();
                                      

                                      con.close();
                                      return true;
                              }catch(Exception exc){
                                  System.out.println(exc);
                                   
                              }
        return false;
    }
}
