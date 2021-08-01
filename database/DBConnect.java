/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author KIBITI Wen Life
 */
public class DBConnect {
    
    public static Connection connect(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
          //  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?","root","");
            System.out.println("you are connected to the db");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
        
    }
    
}
