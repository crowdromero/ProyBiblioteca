/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.MySqlConection;
import static Control.LibroDAO.obtenerLibros;
import Modelo.Libro;
import Modelo.Reserva;
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
public class ReservaDAO {
    
    public static void RegistrarReserva(String codlibro,String codusuario){
        
		// Establecer conexión con la base de datos
                Connection con=null;
		PreparedStatement pst=null;
				
		try {
                        //call sp_Registrar_Registro('76346254','L00002');
			con = MySqlConection.getConection();
			String sql="{call sp_Registrar_Registro((?),(?))}";
                        pst=con.prepareCall(sql);
                        pst.setString(1, codusuario);
			pst.setString(2,codlibro);
			
			pst.executeQuery();
			
			System.out.println("Se añadio correctamente el Registro");
			 
		} catch (Exception e) {
			System.out.println("Error al insertar nuevo registro");
		}
				
	    	
     }
    
    public static List<Reserva> obtenerReservas(String titulo,String usuario){
		Reserva reserva=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Reserva> listadereservas = new ArrayList<Reserva>();
		
		try {			
			con = MySqlConection.getConection();
			
                        //call sp_Consultar_Registro('libro','76346254');
			String sql="{call sp_Consultar_Registro(?,?)}";
                        ps=con.prepareCall(sql);
                        ps.setString(1, titulo);
                        ps.setString(2, usuario);
                        
                        rs=ps.executeQuery();
            
                        while(rs.next()) {
				 reserva=new Reserva(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				 listadereservas.add(reserva);
			 }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros de Reservas");
		}
		return listadereservas;
	}
    
    public static void llenarTablaReserva(JTable tabla,String titulo,String usuario){
         
         String CabeceraListado[]= new String[]{"Nro","Codigo Libro","Titulo","Autor","id Usuario","Usuario","Hora de Reserva","Hora Devolucion"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Reserva x:obtenerReservas(titulo, usuario)) {
               Object fila[] = {x.getIdRegistro(),x.getIdlibro(),x.getLib_titulo(),x.getAutor_nombre()+" "+x.getAutor_apellido(),x.getIdusuario(),x.getUsu_nombre()+" "+x.getUsu_apellido(),x.getReg_horareserva(),x.getReg_horadevolucion()}; 
               dtm.addRow(fila);
             
          }
        tabla.setModel(dtm);
     }
    //sp_Modificar_Registro
    
    public static void devolverReserva(int codlibro){
        
		// Establecer conexión con la base de datos
                Connection con=null;
		PreparedStatement pst=null;
				
		try {
                        
			con = MySqlConection.getConection();
			String sql="{call sp_Modificar_Registro((?))}";
                        pst=con.prepareCall(sql);
                        pst.setInt(1, codlibro);
			
			
			pst.executeQuery();
			
			System.out.println("Se añadio modifico el Registro");
			 
		} catch (Exception e) {
			System.out.println("Error al modificar nuevo registro");
		}
				
	    	
     }
    
}
