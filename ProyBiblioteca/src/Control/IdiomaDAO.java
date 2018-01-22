/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.MySqlConection;
import Modelo.Idioma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;


/**
 *
 * @author Xen
 */
public class IdiomaDAO {
    public static List<Idioma> obtenerIdiomas() {
		
		Idioma idioma=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Idioma> listadeautores = new ArrayList<Idioma>();
		
		
        
		try {
			con = MySqlConection.getConection();
                        String sql="{call sp_Consultar_Idioma()}";
                        ps=con.prepareCall(sql);
                        rs=ps.executeQuery();
                        
                    while(rs.next()) {
			idioma=new Idioma(rs.getString(1), rs.getString(2) );
                        listadeautores.add(idioma);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros de Idiomas ");
		}
		return listadeautores;
	
		
	}
     
     public static void llenarComboIdioma(JComboBox combo){
         
         combo.removeAllItems();
         for (Idioma x:obtenerIdiomas()) {
            combo.addItem(x.getIdioma());
        }
        
     }
     
     
     public static String obtenercodigo(String texto){
         String id="";
         for (Idioma x:obtenerIdiomas()) {
            if(x.getIdioma().equals(texto)){
                id=x.getIdIdioma();
            }
         }
         return id;
     }
}
