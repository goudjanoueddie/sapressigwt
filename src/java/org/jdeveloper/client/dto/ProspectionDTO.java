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
public class ProspectionDTO implements Serializable{
    
    private Date dateProspetion;
    private String objectifProspection;
    private String besoinsAttenteClient;
    private String type;
    private Integer id_clients;
    private String  id_employe;
    
    public ProspectionDTO(){
    
    }

    public ProspectionDTO(Date dateProspetion, String objectifProspection, String besoinsAttenteClient, String type, Integer id_clients, String id_employe) {
        this.dateProspetion = dateProspetion;
        this.objectifProspection = objectifProspection;
        this.besoinsAttenteClient = besoinsAttenteClient;
        this.type = type;
        this.id_clients = id_clients;
        this.id_employe = id_employe;
    }
    
    
    

    public Date getDateProspetion() {
        return dateProspetion;
    }

    public void setDateProspetion(Date dateProspetion) {
        this.dateProspetion = dateProspetion;
    }

    public String getObjectifProspection() {
        return objectifProspection;
    }

    public void setObjectifProspection(String objectifProspection) {
        this.objectifProspection = objectifProspection;
    }

    public String getBesoinsAttenteClient() {
        return besoinsAttenteClient;
    }

    public void setBesoinsAttenteClient(String besoinsAttenteClient) {
        this.besoinsAttenteClient = besoinsAttenteClient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId_clients() {
        return id_clients;
    }

    public void setId_clients(Integer id_clients) {
        this.id_clients = id_clients;
    }

    public String getId_employe() {
        return id_employe;
    }

    public void setId_employe(String id_employe) {
        this.id_employe = id_employe;
    }
    
    
    
    
}
