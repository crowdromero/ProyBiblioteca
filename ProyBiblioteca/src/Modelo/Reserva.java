/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Xen
 */
public class Reserva {
    
    
    private int idRegistro;
    private String idlibro;        
    private String lib_titulo;        
    private String autor_nombre;        
    private String autor_apellido;        
    private String idusuario;        
    private String usu_nombre;        
    private String usu_apellido;    
    private String reg_horareserva;    
    private String reg_horadevolucion;    

    public Reserva() {
    }

    public Reserva(int idRegistro, String idlibro, String lib_titulo, String autor_nombre, String autor_apellido, String idusuario, String usu_nombre, String usu_apellido, String reg_horareserva, String reg_horadevolucion) {
        this.idRegistro = idRegistro;
        this.idlibro = idlibro;
        this.lib_titulo = lib_titulo;
        this.autor_nombre = autor_nombre;
        this.autor_apellido = autor_apellido;
        this.idusuario = idusuario;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.reg_horareserva = reg_horareserva;
        this.reg_horadevolucion = reg_horadevolucion;
    }

    public String getReg_horadevolucion() {
        return reg_horadevolucion;
    }

    public void setReg_horadevolucion(String reg_horadevolucion) {
        this.reg_horadevolucion = reg_horadevolucion;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(String idlibro) {
        this.idlibro = idlibro;
    }

    public String getLib_titulo() {
        return lib_titulo;
    }

    public void setLib_titulo(String lib_titulo) {
        this.lib_titulo = lib_titulo;
    }

    public String getAutor_nombre() {
        return autor_nombre;
    }

    public void setAutor_nombre(String autor_nombre) {
        this.autor_nombre = autor_nombre;
    }

    public String getAutor_apellido() {
        return autor_apellido;
    }

    public void setAutor_apellido(String autor_apellido) {
        this.autor_apellido = autor_apellido;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public String getUsu_apellido() {
        return usu_apellido;
    }

    public void setUsu_apellido(String usu_apellido) {
        this.usu_apellido = usu_apellido;
    }

    public String getReg_horareserva() {
        return reg_horareserva;
    }

    public void setReg_horareserva(String reg_horareserva) {
        this.reg_horareserva = reg_horareserva;
    }
    
    
    
}
