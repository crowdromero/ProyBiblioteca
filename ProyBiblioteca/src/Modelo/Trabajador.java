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
public class Trabajador {
    
    private String idTrabajador;
    private String trab_pass;
    private String trab_nombre;
    private String trab_apellido;

    public Trabajador() {
    }

    public Trabajador(String idTrabajador, String trab_pass, String trab_nombre, String trab_apellido) {
        this.idTrabajador = idTrabajador;
        this.trab_pass = trab_pass;
        this.trab_nombre = trab_nombre;
        this.trab_apellido = trab_apellido;
    }

    public String getTrab_apellido() {
        return trab_apellido;
    }

    public void setTrab_apellido(String trab_apellido) {
        this.trab_apellido = trab_apellido;
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getTrab_pass() {
        return trab_pass;
    }

    public void setTrab_pass(String trab_pass) {
        this.trab_pass = trab_pass;
    }

    public String getTrab_nombre() {
        return trab_nombre;
    }

    public void setTrab_nombre(String trab_nombre) {
        this.trab_nombre = trab_nombre;
    }
    
               

    
}
