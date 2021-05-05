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
public class EmployeDTO implements Serializable{
    
    private String idEmploye;
    private String nomEmploye;
    private String prenomEmploye;
    private String telephone;
    private String courriel;
    private Date dateNaissance;
    private String genre;
    private String departement;
    private String adresse;

    public EmployeDTO(String idEmploye, String nomEmploye, String prenomEmploye, String telephone, String courriel, Date dateNaissance, String genre, String departement, String adresse) {
        this.idEmploye = idEmploye;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.telephone = telephone;
        this.courriel = courriel;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.departement = departement;
        this.adresse = adresse;
    }

    public EmployeDTO(String idEmploye, String nomEmploye) {
        this.idEmploye = idEmploye;
        this.nomEmploye = nomEmploye;
    }
    
    
    public EmployeDTO(){
    
    }
    

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
    
}
