/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.MySqlConection;
import Modelo.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xen
 */
public class AutorDAO {
    
     public static List<Autor> obtenerAutores(String nombre,String apellido) {
		
		Autor autor=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Autor> listadeautores = new ArrayList<Autor>();
		
		
        
		try {
			con = MySqlConection.getConection();
                        String sql="{call sp_consultar_Autor(?,?)}";
                        ps=con.prepareCall(sql);
                        ps.setString(1, nombre);
                        ps.setString(2, apellido);
                        rs=ps.executeQuery();
                        
                    while(rs.next()) {
			autor=new Autor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) );
                        listadeautores.add(autor);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros de Autores ");
		}
		return listadeautores;
	
		
	}
     
     public static void llenarTablaAutor(JTable tabla,String nombre,String apellido){
         
         String CabeceraListado[]= new String[]{"Codigo Autor", "Nombres","Apellidos","Nacionalidad"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Autor x:obtenerAutores(nombre,apellido)) {
            Object fila[] = { x.getIdAutor(), x.getAutor_nombre(),x.getAutor_apellido(), x.getAutor_nacionalidad()};
            dtm.addRow(fila);
        }
        tabla.setModel(dtm);
     }
    
}
