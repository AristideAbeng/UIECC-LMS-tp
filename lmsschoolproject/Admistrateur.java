/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import java.util.Date;

/**
 *
 * @author KIBITI Wen Life
 */
public class Admistrateur {
    private String identifiant;
    private String nom;
    private String prenom;
    private String sexe;
    private String num_telephone;
    private String email;
    private String password;
    private Date dateInscription;
    
    public Admistrateur (String id,String nm,String prnm,String sx,String nmtel,String eml,String pas,Date date){
        this.identifiant = id;
        this.nom = nm;
        this.prenom = prnm;
        this.sexe = sx;
        this.num_telephone = nmtel;
        this.email = eml;
        this.password=pas;
        this.dateInscription = date;
    }
    
}
