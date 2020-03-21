/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.beans.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16borjacr
 */
public class Anuncio implements Serializable{
    private int id_anuncio; 
    private String titulo;
    private String descripcion;
    private int vacantes;
    private String localidad;
    private String fecha;
    private float salario;
    private Empresario empresario;
    private Set<Formacion> formacion;
    private Set<Candidato> candidato;

    public Anuncio() {
    }

    public Anuncio(int id_anuncio, String titulo, String descripcion, int vacantes, String localidad, String fecha, float Salario) {
        this.id_anuncio = id_anuncio;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.vacantes = vacantes;
        this.localidad = localidad;
        this.fecha = fecha;
        this.salario = Salario;
        this.formacion = new HashSet<>();
        this.candidato = new HashSet<>();
       
    }

    public int getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(int id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        
        this.vacantes = vacantes;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Empresario getEmpresario() {
        return empresario;
    }

    public void setEmpresario(Empresario empresario) {
        this.empresario = empresario;
    }

    public Set<Formacion> getFormacion() {
        return formacion;
    }

    public void setFormacion(Set<Formacion> formacion) {
        this.formacion = formacion;
    }

    public Set<Candidato> getCandidato() {
        return candidato;
    }

    public void setCandidato(Set<Candidato> candidato) {
        this.candidato = candidato;
    }
    
    
 
}
