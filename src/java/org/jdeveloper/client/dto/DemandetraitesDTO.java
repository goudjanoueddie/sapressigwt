/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author goudjanou
 */
public class DemandetraitesDTO implements Serializable{
    
    private Integer id;
    private Date dateDebut;
    private Date dateFin;
    private Integer dr;
    private Integer dtdd;
    private String observations;
    
    
    public DemandetraitesDTO(){
    
    }
    
    

    public DemandetraitesDTO(Integer id, Date dateDebut, Date dateFin, Integer dr, Integer dtdd, String observations) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dr = dr;
        this.dtdd = dtdd;
        this.observations = observations;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public Integer getDtdd() {
        return dtdd;
    }

    public void setDtdd(Integer dtdd) {
        this.dtdd = dtdd;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
    
    
    
}
