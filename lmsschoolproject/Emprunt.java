/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import database.DBConnect;
import java.sql.Connection;
import java.util.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author KIBITI Wen Life
 */
public class Emprunt {
    int id;
    LibraryItem ressource;
    Date dateEmprunt;
    Date dateRetour;
    Utilisateur client;
    String ressourceType;
    
    public Emprunt(LibraryItem item,Date demprunt,Utilisateur client,String rt,int id){
        this.ressource = item;
        this.dateEmprunt = demprunt;
        this.dateRetour = null;
        this.client = client;
        this.ressourceType = rt;
        this.id = id;
    }
    public LibraryItem getLibraryItem(){
        return ressource;
    }
    public Utilisateur getClient(){
        return this.client;
    }
    public Date getDateRetour(){
        return this.dateRetour;
    }
    public Date getDateEmprunt(){
        return this.dateEmprunt;
    }
    public void setDateRetour(Date date){
        this.dateRetour = date;
    }
    public static JList<Emprunt> getAllTransactionsList(boolean pendingOnly,boolean withPenalties,Date dateFrom,Date dateUpTill){
       
      List<Emprunt> emprunts = new ArrayList<>();
      
      emprunts.addAll(Etudiant.getAllStudentsTransactions());
      //emprunts.addAll(Lecturer.getAllLecturerEmprunts());
      
       DefaultListModel<Emprunt> model = new DefaultListModel<Emprunt>();
       model.addAll(emprunts);
    // creer un objet liste en lui passant en parametre l'objet model qui a recu tout les livres.
    JList<Emprunt> list = new JList<>(model);
    
    // definir comment est ce que les elements de la liste devront etre afficher en passant en parametre un instance de LivreRenderer
    list.setCellRenderer(new EmpruntRenderer());
    //return list;
        return list;
    }
    public String getRessourceType(){return this.ressourceType;}
    public boolean rembourserEmprunt(String RessourceType){
       
             
             try{
                  Connection conn = DBConnect.connect();
                  
                   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                 Date date = null;
                  java.sql.Date sqldate = null;
                   
                  date = sdf.parse(sdf.format(new Date()));
                  sqldate = new java.sql.Date(date.getTime());
                  String query = "";
                  if(RessourceType.equalsIgnoreCase("livre")){
                          query = "UPDATE `empruntslivresetudiants` SET `dateRetour`= ? WHERE identifiant = ?";
                  }else if(RessourceType.equalsIgnoreCase("cd")){
                            query = "UPDATE `empruntetudiantcd` SET `dateRetour`= ? WHERE id = ?";
                  }else{
                       query = "UPDATE `empruntetudiantmdr` SET `dateRetour`= ? WHERE id = ?";
                  }
                   PreparedStatement preparedStmt = conn.prepareStatement(query);
            
             preparedStmt.setDate(1, sqldate);
             preparedStmt.setInt(2,this.id);

             // execute the java preparedstatement
             preparedStmt.executeUpdate();

              conn.close();
             }catch(Exception e){
                
               System.out.println(e);
                return false;
           }
             return true;
    }
    public long getDureeEnJours(){
        if(this.dateRetour ==null){
                Date date = new Date();
                LocalDateTime today = LocalDateTime.now();
                LocalDateTime dateEmpruntTime = LocalDateTime.ofInstant(this.dateEmprunt.toInstant(),ZoneId.systemDefault());
                long numDays = Duration.between(today, dateEmpruntTime).toDays();
                return -1*numDays;
        }else{
              LocalDateTime dateEmpruntTime = LocalDateTime.ofInstant(this.dateEmprunt.toInstant(),ZoneId.systemDefault());
                LocalDateTime dateRetourTime = LocalDateTime.ofInstant(this.dateRetour.toInstant(),ZoneId.systemDefault());
             long numDays = Duration.between(dateRetourTime, dateEmpruntTime).toDays();
             return -1*numDays;
        }
       
        
    }
    public String getPenalitesAccumulees(){
         String devise = " FCFA";
        return getValuePenalitesAccumules()+devise;
    }
    public long getValuePenalitesAccumules(){
         long duree = getDureeEnJours();
      
        return (500 * Math.max(0,duree-14l));
    }
    
    
    
}
