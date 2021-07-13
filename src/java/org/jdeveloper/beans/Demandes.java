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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author goudjanou
 */
@Entity
@Table(name = "Demandes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandes.findAll", query = "SELECT d FROM Demandes d")
    , @NamedQuery(name = "Demandes.findById", query = "SELECT d FROM Demandes d WHERE d.id = :id")
    , @NamedQuery(name = "Demandes.findByDateDemande", query = "SELECT d FROM Demandes d WHERE d.dateDemande = :dateDemande")
    , @NamedQuery(name = "Demandes.findByNomClient", query = "SELECT d FROM Demandes d WHERE d.nomClient = :nomClient")
    , @NamedQuery(name = "Demandes.findByObjet", query = "SELECT d FROM Demandes d WHERE d.objet = :objet")
    , @NamedQuery(name = "Demandes.findByReference", query = "SELECT d FROM Demandes d WHERE d.reference = :reference")
    , @NamedQuery(name = "Demandes.findByType", query = "SELECT d FROM Demandes d WHERE d.type = :type")
    , @NamedQuery(name = "Demandes.findByMoyen", query = "SELECT d FROM Demandes d WHERE d.moyen = :moyen")
    , @NamedQuery(name = "Demandes.findByHeureDemande", query = "SELECT d FROM Demandes d WHERE d.heureDemande = :heureDemande")})
public class Demandes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_demande")
    @Temporal(TemporalType.DATE)
    private Date dateDemande;
    @Size(max = 100)
    @Column(name = "nom_client")
    private String nomClient;
    @Size(max = 100)
    @Column(name = "objet")
    private String objet;
    @Size(max = 100)
    @Column(name = "reference")
    private String reference;
    @Size(max = 100)
    @Column(name = "type")
    private String type;
    @Size(max = 100)
    @Column(name = "moyen")
    private String moyen;
    @Column(name = "heure_demande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDemande;

    public Demandes() {
    }

    public Demandes(Integer id) {
        this.id = id;
    }

    public Demandes(Integer id, Date dateDemande) {
        this.id = id;
        this.dateDemande = dateDemande;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demandes)) {
            return false;
        }
        Demandes other = (Demandes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Demandes[ id=" + id + " ]";
    }
    
}
