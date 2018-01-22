/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.MySqlConection;
import Modelo.Trabajador;
import Modelo.Usuario;
import Vista.FrmMenuPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Xen
 */
public class TrabajadorDAO {
    
    public static Trabajador obtenerUsuario(Trabajador trab) {
		Trabajador trabajador=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
                    con = MySqlConection.getConection();
                    String sql="{call sp_consultar_Trabajador(?,?)}";
                    pst=con.prepareCall(sql);
                    pst.setString(1,trab.getIdTrabajador());
                    pst.setString(2,trab.getTrab_pass());
                    rs=pst.executeQuery();
                        			
                    while(rs.next()) {
                        trabajador=new Trabajador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    }
		} catch (Exception e) {
			System.out.println("error al obtener Trabajador");
		}
		
		
		return trabajador;
	}
    
    public static void ingresar(String usuario,String contraseña,JFrame vista) {
		
			
		Trabajador trab=new Trabajador();
		trab.setIdTrabajador(usuario);
		trab.setTrab_pass(contraseña);
		
		Trabajador trab1=TrabajadorDAO.obtenerUsuario(trab);
		
		if(trab1!=null) {
			JOptionPane.showMessageDialog(null, "Bienvenido");
			FrmMenuPrincipal frame=new FrmMenuPrincipal();
                        frame.setVisible(true);
                        
                        
                        //Dimension dim = frame.getToolkit().getScreenSize();
                        //frame.setLocationRelativeTo(frame);
                        //frame.setSize(dim);
                        vista.dispose();
                        
		}else {
			JOptionPane.showMessageDialog(null, "Datos Invalidos","Error",JOptionPane.ERROR_MESSAGE);
                        
		}
                
        }
    
}
