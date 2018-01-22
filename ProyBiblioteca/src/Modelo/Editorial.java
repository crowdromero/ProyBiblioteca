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
public class Editorial {
    
    private String idEditorial;
    private String ed_nombre;
    private String ed_pais;

    public Editorial() {
    }

    public Editorial(String idEditorial, String ed_nombre, String ed_pais) {
        this.idEditorial = idEditorial;
        this.ed_nombre = ed_nombre;
        this.ed_pais = ed_pais;
    }

    public String getEd_pais() {
        return ed_pais;
    }

    public void setEd_pais(String ed_pais) {
        this.ed_pais = ed_pais;
    }

    public String getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(String idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getEd_nombre() {
        return ed_nombre;
    }

    public void setEd_nombre(String ed_nombre) {
        this.ed_nombre = ed_nombre;
    }
    
        
}
