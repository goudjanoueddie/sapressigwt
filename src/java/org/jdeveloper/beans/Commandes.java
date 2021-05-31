/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author goudjanou
 */
@Entity
@Table(name = "Commandes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commandes.findAll", query = "SELECT c FROM Commandes c")
    , @NamedQuery(name = "Commandes.findByIdCommande", query = "SELECT c FROM Commandes c WHERE c.idCommande = :idCommande")
    , @NamedQuery(name = "Commandes.findByDateCommande", query = "SELECT c FROM Commandes c WHERE c.dateCommande = :dateCommande")})
public class Commandes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_commande")
    private Integer idCommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_commande")
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    @JoinColumn(name = "id_clients", referencedColumnName = "id_clients")
    @ManyToOne(optional = false)
    private Clients idClients;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCommande")
    private List<Factures> facturesList;

    public Commandes() {
    }

    public Commandes(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Commandes(Integer idCommande, Date dateCommande) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
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

    public Clients getIdClients() {
        return idClients;
    }

    public void setIdClients(Clients idClients) {
        this.idClients = idClients;
    }

    @XmlTransient
    public List<Factures> getFacturesList() {
        return facturesList;
    }

    public void setFacturesList(List<Factures> facturesList) {
        this.facturesList = facturesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commandes)) {
            return false;
        }
        Commandes other = (Commandes) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Commandes[ idCommande=" + idCommande + " ]";
    }
    
}
