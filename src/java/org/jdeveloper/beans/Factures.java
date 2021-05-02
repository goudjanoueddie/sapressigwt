/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author goudjanou
 */
@Entity
@Table(name = "factures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factures.findAll", query = "SELECT f FROM Factures f")
    , @NamedQuery(name = "Factures.findByIdFacture", query = "SELECT f FROM Factures f WHERE f.idFacture = :idFacture")
    , @NamedQuery(name = "Factures.findByDateEdition", query = "SELECT f FROM Factures f WHERE f.dateEdition = :dateEdition")
    , @NamedQuery(name = "Factures.findByMontant", query = "SELECT f FROM Factures f WHERE f.montant = :montant")})
public class Factures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_facture")
    private Integer idFacture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_edition")
    @Temporal(TemporalType.DATE)
    private Date dateEdition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private double montant;
    @JoinColumn(name = "id_commande", referencedColumnName = "id_commande")
    @ManyToOne(optional = false)
    private Commandes idCommande;

    public Factures() {
    }

    public Factures(Integer idFacture) {
        this.idFacture = idFacture;
    }

    public Factures(Integer idFacture, Date dateEdition, double montant) {
        this.idFacture = idFacture;
        this.dateEdition = dateEdition;
        this.montant = montant;
    }

    public Integer getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Integer idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Commandes getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Commandes idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacture != null ? idFacture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factures)) {
            return false;
        }
        Factures other = (Factures) object;
        if ((this.idFacture == null && other.idFacture != null) || (this.idFacture != null && !this.idFacture.equals(other.idFacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Factures[ idFacture=" + idFacture + " ]";
    }
    
}
