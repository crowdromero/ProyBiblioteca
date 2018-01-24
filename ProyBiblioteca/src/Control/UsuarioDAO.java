/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.MySqlConection;
import Modelo.Usuario;
import Vista.FrmMenuPrincipal;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Xen
 */
public class UsuarioDAO {
    
    public static Usuario obtenerUsuario(Usuario usu) {
		Usuario usuario=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
                    con = MySqlConection.getConection();
                    String sql="{call sp_consultar_Usuario(?,?)}";
                    pst=con.prepareCall(sql);
                    pst.setString(1,usu.getId());
                    pst.setString(2,usu.getContraseña());
                    rs=pst.executeQuery();
                        			
                    while(rs.next()) {
                        usuario=new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                    }
		} catch (Exception e) {
			System.out.println("error al obtener usuario");
		}
		
		
		return usuario;
	}
    
    public static void ingresar(String usuario,String contraseña,JFrame vista) {
		
			
		Usuario usu=new Usuario();
		usu.setId(usuario);
		usu.setContraseña(contraseña);
		
		Usuario usu1=UsuarioDAO.obtenerUsuario(usu);
		
		if(usu1!=null) {
			JOptionPane.showMessageDialog(null, "Bienvenido");
			FrmMenuPrincipal frame=new FrmMenuPrincipal();
                        frame.setVisible(true);
                        frame.btnnuevousuario.setVisible(false);
                        frame.btnRegistrarLibro.setVisible(false);
                        frame.btnConsultareservas.setVisible(false);
                        //Dimension dim = frame.getToolkit().getScreenSize();
                        //frame.setLocationRelativeTo(frame);
                        //frame.setSize(dim);
                        vista.dispose();
                        
		}else {
			JOptionPane.showMessageDialog(null, "Datos Invalidos","Error",JOptionPane.ERROR_MESSAGE);
                        
		}
                
        }
    
    
     public static void RegistrarUsuario(String codigo,String nombre,String apellido,String direccion,String telefono){
        
		// Establecer conexión con la base de datos
                Connection con=null;
		PreparedStatement pst=null;
                
                String contraseña=codigo+nombre.substring(0,1)+apellido.substring(0,1);
				
		try {
                        //call sp_Registrar_Usuario('76346254','Juan','Perez','Calle Juanito Alimaña 123','995524566','123456');
			con = MySqlConection.getConection();
			String sql="{call sp_Registrar_Usuario((?),(?),(?),(?),(?),(?))}";
                        pst=con.prepareCall(sql);
                        pst.setString(1,codigo);
			pst.setString(2,nombre);
			pst.setString(3,apellido);
			pst.setString(4,direccion);
			pst.setString(5,telefono);
                        pst.setString(6, contraseña);
									
			pst.executeQuery();
			
			System.out.println("Se añadio correctamente el Usuario");
                        
                        JOptionPane.showMessageDialog(null,"Se añadio correctamente el nuevo usuario");
			 
		} catch (Exception e) {
			System.out.println("Error al insertar nuevo Usuario");
		}
				
	    	
     } 
     
     public static void ConfirmarUsuario(String usuario,String contraseña,String Libro,JFrame frame) {
			
		Usuario usu=new Usuario();
		usu.setId(usuario);
		usu.setContraseña(contraseña);
		
		Usuario usu1=UsuarioDAO.obtenerUsuario(usu);
		
		if(usu1!=null) {
			ReservaDAO.RegistrarReserva(Libro, usuario);
                        JOptionPane.showMessageDialog(null, "Se registro la reserva");
                        frame.dispose();
                        
		}else {
			JOptionPane.showMessageDialog(null, "Datos Invalidos","Error",JOptionPane.ERROR_MESSAGE);
                        
		}
                
        }
     
     
}
