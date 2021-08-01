/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

/**
 *
 * @author KIBITI Wen Life
 */
public class Utilisateur {
    protected String mNom;
    protected String mPrenom;
    protected String mIdentifiant;
    protected String mSexe;
    
    public Utilisateur(String n,String p,String sexe,String id){
        this.mNom = n;
        this.mPrenom = p;
        this.mIdentifiant = id;
        this.mSexe = sexe;
    }
    
    public String getFullName(){
        return this.mNom+" "+this.mPrenom;
    }
    public boolean isMale(){
        if(mSexe.equalsIgnoreCase("M")){
            return true;
        }
        return false;
    }
    public String getAccountId(){
         return this.mIdentifiant;
    }
    
}
