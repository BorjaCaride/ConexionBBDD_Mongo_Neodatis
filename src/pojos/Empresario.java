/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.beans.*;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author a16borjacr
 */
public class Empresario extends Usuario implements Serializable{
    
    private String nombre_empresa;
    private String sector;
    private String localidad;
    private Set<Anuncio> anuncio;

    public Empresario(){
    }
    
    public Empresario(String nombre_empresa, String sector, String localidad, String dni, String nombre, String apellidos, String correo, int telefono) {
        super(dni, nombre, apellidos, correo, telefono);
        this.nombre_empresa = nombre_empresa;
        this.sector = sector;
        this.localidad = localidad;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Set<Anuncio> getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Set<Anuncio> anuncio) {
        this.anuncio = anuncio;
    }
    
    
    
    
}
