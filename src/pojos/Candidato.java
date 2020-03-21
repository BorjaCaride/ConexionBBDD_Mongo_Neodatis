/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.beans.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 *
 * @author a16borjacr
 */
public class Candidato extends Usuario implements Serializable {
    private String fecha_nac;
    private String sexo;
    private int curriculum;
    private Set<Anuncio> anuncio;
    //private

    public Candidato() {
    }

    public Candidato(String fecha_nac, String sexo, String dni, String nombre, String apellidos, String correo, int telefono) {
        super(dni, nombre, apellidos, correo, telefono);
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
       
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(int curriculum) {
        this.curriculum = curriculum;
    }

    public Set<Anuncio> getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Set<Anuncio> anuncio) {
        this.anuncio = anuncio;
    }
    
   
    
}
