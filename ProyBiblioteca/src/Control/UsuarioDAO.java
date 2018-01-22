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
    
}
