/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.beans.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16borjacr
 */
public class Formacion implements Serializable{
    private int id_formacion;
    private String nombre;
    private Set<Curriculum> curriculum;
    private Set<Anuncio> anuncio;
    
    public Formacion() {
        
    }
    public Formacion(int id_formacion ,String nombre) {
        this.id_formacion = id_formacion;
        this.nombre = nombre;
        this.curriculum = new HashSet<>();
        this.anuncio = new HashSet<>();
    }

    public int getId_formacion() {
        return id_formacion;
    }

    public void setId_formacion(int id_formacion) {
        this.id_formacion = id_formacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Curriculum> getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Set<Curriculum> curriculum) {
        this.curriculum = curriculum;
    }

    public Set<Anuncio> getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Set<Anuncio> anuncio) {
        this.anuncio = anuncio;
    }
    
    
}
