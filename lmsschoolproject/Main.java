/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;
import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author KIBITI Wen Life
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello world");
        Connection con = DBConnect.connect();
        String utilisateur = "";
        String mdp = "";
       
        
        
    }
    
}
