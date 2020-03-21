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
public class Curriculum implements Serializable, PropertyChangeListener{
    private int id_curriculum;
    private String experiencia;
    private boolean permiso_coche;
    private Set<Formacion> formacion;

   
    private boolean jbean;

    public Curriculum(){
    }
    public Curriculum(int id_curriculum,String experiencia, boolean permiso_coche) {
        this.id_curriculum = id_curriculum;
        this.experiencia = experiencia;
        this.permiso_coche = permiso_coche;
        this.formacion = new HashSet<>();
    }

    public int getId_curriculum() {
        return id_curriculum;
    }

    public void setId_curriculum(int id_curriculum) {
        this.id_curriculum = id_curriculum;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public boolean isPermiso_coche() {
        return permiso_coche;
    }

    public void setPermiso_coche(boolean permiso_coche) {
        this.permiso_coche = permiso_coche;
    }

    public Set<Formacion> getFormacion() {
        return formacion;
    }

    public void setFormacion(Set<Formacion> formacion) {
        this.formacion = formacion;
    }


     public boolean isJbean() {
        return jbean;
    }

    public void setJbean(boolean jbean) {
        this.jbean = jbean;
    }

 @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Nombre anterior:"+evt.getOldValue());
        System.out.println("Nombre nuevo:"+evt.getNewValue());
        setJbean(true);
    }

    
    
    
    
}
