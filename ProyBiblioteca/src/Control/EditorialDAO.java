/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.MySqlConection;
import Modelo.Editorial;
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
public class EditorialDAO {
    
    public static List<Editorial> obtenerEditoriales(String nombre) {
		
		Editorial editorial=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Editorial> listadeautores = new ArrayList<Editorial>();
		
		
        
		try {
			con = MySqlConection.getConection();
                        String sql="{call sp_consultar_Editorial(?)}";
                        ps=con.prepareCall(sql);
                        ps.setString(1, nombre);
                        rs=ps.executeQuery();
                        
                    while(rs.next()) {
			editorial=new Editorial(rs.getString(1), rs.getString(2), rs.getString(3));
                        listadeautores.add(editorial);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros de Editoriales ");
		}
		return listadeautores;
	
		
	}
     
     public static void llenarTablaEditorial(JTable tabla,String nombre){
         
         String CabeceraListado[]= new String[]{"Codigo Editorial", "Nombres Editorial","Pais"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Editorial x:obtenerEditoriales(nombre)) {
            Object fila[] = {x.getIdEditorial(), x.getEd_nombre(),x.getEd_pais()};
            dtm.addRow(fila);
        }
        tabla.setModel(dtm);
     }
    
    
}
