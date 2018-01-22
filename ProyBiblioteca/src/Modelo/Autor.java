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
public class Autor {
    
    private String idAutor;
    private String autor_nombre;
    private String autor_apellido;
    private String autor_nacionalidad;
    
    
    public Autor() {
    }

    public Autor(String idAutor, String autor_nombre, String autor_apellido, String autor_nacionalidad) {
        this.idAutor = idAutor;
        this.autor_nombre = autor_nombre;
        this.autor_apellido = autor_apellido;
        this.autor_nacionalidad = autor_nacionalidad;
    }

    public String getAutor_nacionalidad() {
        return autor_nacionalidad;
    }

    public void setAutor_nacionalidad(String autor_nacionalidad) {
        this.autor_nacionalidad = autor_nacionalidad;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
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
    
    
}
