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
public class Libro {
    
    private String idlibro;
    private String lib_titulo;
    private String autor_nombre;
    private String autor_apellido;
    private String ed_nombre;
    private String lib_fecpub;
    private String genero;
    private String lib_cantidad;

    public Libro() {
    }

    public Libro(String idlibro, String lib_titulo, String autor_nombre, String autor_apellido, String ed_nombre, String lib_fecpub, String genero, String lib_cantidad) {
        this.idlibro = idlibro;
        this.lib_titulo = lib_titulo;
        this.autor_nombre = autor_nombre;
        this.autor_apellido = autor_apellido;
        this.ed_nombre = ed_nombre;
        this.lib_fecpub = lib_fecpub;
        this.genero = genero;
        this.lib_cantidad = lib_cantidad;
    }

    public String getLib_cantidad() {
        return lib_cantidad;
    }

    public void setLib_cantidad(String lib_cantidad) {
        this.lib_cantidad = lib_cantidad;
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

    public String getEd_nombre() {
        return ed_nombre;
    }

    public void setEd_nombre(String ed_nombre) {
        this.ed_nombre = ed_nombre;
    }

    public String getLib_fecpub() {
        return lib_fecpub;
    }

    public void setLib_fecpub(String lib_fecpub) {
        this.lib_fecpub = lib_fecpub;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
            
            
}
