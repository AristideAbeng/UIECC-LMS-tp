/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import database.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author PBHev
 */
public class LoginController {
    private static final String ADMIN_TABLE = "administrateur";
    public static boolean loginAdmin(String identifier,String password){
        Connection con = DBConnect.connect();
         try{
                          Statement st = con.createStatement();
                          String sql = "select * from "+ADMIN_TABLE;
                          ResultSet resultat = st.executeQuery(sql);
                          boolean identifiantValide = false;
                        
                          while(resultat.next()){
                                
                              String id = resultat.getString("identifiant");
                              String motdp = resultat.getString("motdepasse");
                              
                              if(identifier.equals(id) && motdp.equals(password)){
                                  return true;
                              }
                             
                          }
                          
                          con.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
         return false;
    }
    
}
