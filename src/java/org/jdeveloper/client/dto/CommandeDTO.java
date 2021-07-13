/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.dto;

import java.io.Serializable;
import java.util.Date;
import org.jdeveloper.beans.Clients;

/**
 *
 * @author goudjanou
 */
public class CommandeDTO implements Serializable {
    
    private Integer idCommande;
    private Date dateCommande;
    private double montant;
    private Integer idClients;
   
    public CommandeDTO(){
        
    }

    public CommandeDTO(Integer idCommande, Date dateCommande, Integer idClients,double montant) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.idClients = idClients;
        this.montant = montant;
    }
    
    

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Integer getIdClients() {
        return idClients;
    }

    public void setIdClients(Integer idClients) {
        this.idClients = idClients;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    
    
}
