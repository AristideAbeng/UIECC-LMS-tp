/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmsschoolproject;

import interface1.FenetreInscrireUtilisateur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PBHev
 */
public class PROJECTCONSTANTS {
    
    public static final String IMAGES_PATH = "..\\LMSSchoolProject1\\src\\image\\";
    public static final String IMAGE_ACCEUIL = "imageAcceuil.jpg";
    
    
    public static java.sql.Date getTodaySqlDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
         java.sql.Date sqldate = null;
        try {
            date = sdf.parse(sdf.format(new Date()));
            sqldate = new java.sql.Date(date.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FenetreInscrireUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sqldate;
    }
}
