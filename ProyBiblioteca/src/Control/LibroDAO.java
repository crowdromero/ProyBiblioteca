/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.MySqlConection;
import Modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xen
 */
public class LibroDAO {
    
    public static void RegistrarLibro(String titulo,String autor,String editorial,String fecha,String genero,int paginas,int cantidad,String idioma){
        
		// Establecer conexión con la base de datos
                Connection con=null;
		PreparedStatement pst=null;
				
		try {
                        //call sp_Registrar_Libros('L00002','Nuevo Libro','A00004','E00002','1992/02/10','G00001',100,1,'I00001');
			con = MySqlConection.getConection();
			String sql="{call sp_Registrar_Libros((?),(?),(?),(?),(?),(?),(?),(?),(?))}";
                        pst=con.prepareCall(sql);
                        pst.setString(1, GenerarCodigo());
			pst.setString(2,titulo);
			pst.setString(3,autor);
			pst.setString(4,editorial);
			pst.setString(5, fecha);
                        pst.setString(6, genero);
			pst.setInt(7,paginas);
			pst.setInt(8,cantidad);
			pst.setString(9,idioma);
			
			pst.executeQuery();
			
			System.out.println("Se añadio correctamente el Registro");
			 
		} catch (Exception e) {
			System.out.println("Error al insertar nuevo Libro");
		}
				
	    	
     } 

    private static String GenerarCodigo() {
        String cod="";
        int numero=obtenerLibros("", "", "", "", "").size()+1;
        cod="L"+(10000+numero);        
        System.out.println(cod);
        return cod;        
    }
    
    public static List<Libro> obtenerLibros(String titulo,String autor,String autorape,String editorial,String genero){
		Libro lib=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Libro> listadelibros = new ArrayList<Libro>();
		
		try {			
			con = MySqlConection.getConection();
			
			String sql="{call sp_consultar_Libro(?,?,?,?,?)}";
                        ps=con.prepareCall(sql);
                        ps.setString(1, titulo);
                        ps.setString(2, autor);
                        ps.setString(3, autorape);
                        ps.setString(4, editorial);
                        ps.setString(5, genero);
                        rs=ps.executeQuery();
            
                        while(rs.next()) {
				 lib=new Libro(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4), 
                                               rs.getString(5),rs.getString(6), rs.getString(7),rs.getString(8));
				 listadelibros.add(lib);
			 }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros de Libros");
		}
		return listadelibros;
	}
    
    public static void llenarTablaMedico(JTable tabla,String titulo,String autor,String autorape,String editorial,String genero){
         
         String CabeceraListado[]= new String[]{"Codigo Libro","Titulo","Autor","Editorial","Fecha de Publicacion","Genero","Cantidad"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Libro x:obtenerLibros(titulo, autor, autorape, editorial, genero)) {
               Object fila[] = { x.getIdlibro(),x.getLib_titulo(),x.getAutor_nombre()+" "+x.getAutor_apellido(),x.getEd_nombre(),x.getLib_fecpub(),x.getGenero(),x.getLib_cantidad()}; 
               dtm.addRow(fila);
             
          }
        tabla.setModel(dtm);
     }
    
    public static void ModificarrLibro(String cod,String titulo,String autor,String editorial,String fecha,String genero,int paginas,int cantidad,String idioma){
        
		// Establecer conexión con la base de datos
                Connection con=null;
		PreparedStatement pst=null;
				
		try {
                        //call sp_Modificar_Libros('L00002','Libro modificado','A00002','E00001','1992/02/10','G00001',50,1,'I00001');
			con = MySqlConection.getConection();
			String sql="{call sp_Modificar_Libros((?),(?),(?),(?),(?),(?),(?),(?),(?))}";
                        pst=con.prepareCall(sql);
                        pst.setString(1,cod);
			pst.setString(2,titulo);
			pst.setString(3,autor);
			pst.setString(4,editorial);
			pst.setString(5, fecha);
                        pst.setString(6, genero);
			pst.setInt(7,paginas);
			pst.setInt(8,cantidad);
			pst.setString(9,idioma);
			
			pst.executeQuery();
			
			System.out.println("Se Modifico el Registro");
                        JOptionPane.showMessageDialog(null,"Se modifico correctamente el Libro");
			 
		} catch (Exception e) {
			System.out.println("Error al modificar nuevo Libro");
		}
				
	    	
     } 
}
