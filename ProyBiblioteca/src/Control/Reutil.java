/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Xen
 */
public class Reutil {
    
    public static String FormatearFecha(JDateChooser dtcFecha_inicio){
        String dm_fechaincio="";
        
        try {
            String formato = dtcFecha_inicio.getDateFormatString();
            Date date = dtcFecha_inicio.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            dm_fechaincio=String.valueOf(sdf.format(date));
            
            System.out.println(dm_fechaincio);
            
        } catch (Exception e) {
            
        }
       return dm_fechaincio;
    }
    
}
