/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.MySqlConection;
import Modelo.Genero;
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
public class GeneroDAO {
    
    public static List<Genero> obtenerGeneros() {
		
		Genero idioma=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Genero> listadegeneros = new ArrayList<Genero>();
		
		
        
		try {
			con = MySqlConection.getConection();
                        String sql="{call sp_Consultar_Genero()}";
                        ps=con.prepareCall(sql);
                        rs=ps.executeQuery();
                        
                    while(rs.next()) {
			idioma=new Genero(rs.getString(1), rs.getString(2) );
                        listadegeneros.add(idioma);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros de Generos ");
		}
		return listadegeneros;
	
		
	}
     
     public static void llenarComboGenero(JComboBox combo){
         
         combo.removeAllItems();
         for (Genero x:obtenerGeneros()) {
            combo.addItem(x.getGenero());
        }
        
     }
     
     public static String obtenercodigo(String texto){
         String id="";
         for (Genero x:obtenerGeneros()) {
            if(x.getGenero().equals(texto)){
                id=x.getIdGenero();
            }
         }
         return id;
     }
    
}
