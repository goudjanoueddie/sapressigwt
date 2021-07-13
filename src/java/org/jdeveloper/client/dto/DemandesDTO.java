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
public class DemandesDTO implements Serializable {
    
    private Integer id;
    private Date dateDemande;
    private String nomClient;
    private String objet;
    private String reference;
    private String type;
    private String moyen;
    private Date heureDemande;
    
    DemandesDTO(Integer id,Date dateDemande,String nomClient,String objet,String reference,String type,String moyen,Date heureDemande){
        
        this.id=id;
        this.dateDemande=dateDemande;
        this.nomClient = nomClient;
        this.objet=objet;
        this.reference=reference;
        this.type=type;
        this.moyen=moyen;
        this.heureDemande=heureDemande;
    
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoyen() {
        return moyen;
    }

    public void setMoyen(String moyen) {
        this.moyen = moyen;
    }

    public Date getHeureDemande() {
        return heureDemande;
    }

    public void setHeureDemande(Date heureDemande) {
        this.heureDemande = heureDemande;
    }
     
}
