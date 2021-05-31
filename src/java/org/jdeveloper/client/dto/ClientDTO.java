/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.dto;

import java.io.Serializable;

/**
 *
 * @author goudjanou
 */
public class ClientDTO implements Serializable{
    
    private Integer idClients;
    private String nomClient;
    private String adresse;
    private String telephone;
    private String courriel;
    private String localisation;
    private String activites;
    private String correspondant;
    private String fonctionCorrespondant;
    private String contactCorrespondant;
    private String courrielCorrespondant;
    
    
    public ClientDTO(){
    }

    public ClientDTO(String nomClient, String adresse, String telephone, String courriel, String localisation, String activites, String correspondant, String fonctionCorrespondant, String contactCorrespondant, String courrielCorrespondant) {
        this.nomClient = nomClient;
        this.adresse = adresse;
        this.telephone = telephone;
        this.courriel = courriel;
        this.localisation = localisation;
        this.activites = activites;
        this.correspondant = correspondant;
        this.fonctionCorrespondant = fonctionCorrespondant;
        this.contactCorrespondant = contactCorrespondant;
        this.courrielCorrespondant = courrielCorrespondant;
    }

    public Integer getIdClients() {
        return idClients;
    }

    public void setIdClients(Integer idClients) {
        this.idClients = idClients;
    }

    
    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getActivites() {
        return activites;
    }

    public void setActivites(String activites) {
        this.activites = activites;
    }

    public String getCorrespondant() {
        return correspondant;
    }

    public void setCorrespondant(String correspondant) {
        this.correspondant = correspondant;
    }

    public String getFonctionCorrespondant() {
        return fonctionCorrespondant;
    }

    public void setFonctionCorrespondant(String fonctionCorrespondant) {
        this.fonctionCorrespondant = fonctionCorrespondant;
    }

    public String getContactCorrespondant() {
        return contactCorrespondant;
    }

    public void setContactCorrespondant(String contactCorrespondant) {
        this.contactCorrespondant = contactCorrespondant;
    }

    public String getCourrielCorrespondant() {
        return courrielCorrespondant;
    }

    public void setCourrielCorrespondant(String courrielCorrespondant) {
        this.courrielCorrespondant = courrielCorrespondant;
    }
    
    
}
