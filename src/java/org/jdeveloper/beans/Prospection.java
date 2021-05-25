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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author goudjanou
 */
@Entity
@Table(name = "prospection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prospection.findAll", query = "SELECT p FROM Prospection p")
    , @NamedQuery(name = "Prospection.findByIdProspection", query = "SELECT p FROM Prospection p WHERE p.idProspection = :idProspection")
    , @NamedQuery(name = "Prospection.findByDateProspection", query = "SELECT p FROM Prospection p WHERE p.dateProspection = :dateProspection")
    , @NamedQuery(name = "Prospection.findByObjectifProspection", query = "SELECT p FROM Prospection p WHERE p.objectifProspection = :objectifProspection")
    , @NamedQuery(name = "Prospection.findByBesoinsAttenteClient", query = "SELECT p FROM Prospection p WHERE p.besoinsAttenteClient = :besoinsAttenteClient")
    , @NamedQuery(name = "Prospection.findByType", query = "SELECT p FROM Prospection p WHERE p.type = :type")})
public class Prospection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prospection")
    private Integer idProspection;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_prospection")
    @Temporal(TemporalType.DATE)
    private Date dateProspection;
    @Size(max = 400)
    @Column(name = "objectif_prospection")
    private String objectifProspection;
    @Size(max = 400)
    @Column(name = "besoins_attente_client")
    private String besoinsAttenteClient;
    @Size(max = 100)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "id_clients", referencedColumnName = "id_clients")
    @ManyToOne(optional = false)
    private Clients idClients;
    @JoinColumn(name = "id_employe", referencedColumnName = "id_employe")
    @ManyToOne
    private Employes idEmploye;

    public Prospection() {
    }

    public Prospection(Integer idProspection) {
        this.idProspection = idProspection;
    }

    public Prospection(Integer idProspection, Date dateProspection) {
        this.idProspection = idProspection;
        this.dateProspection = dateProspection;
    }

    public Integer getIdProspection() {
        return idProspection;
    }

    public void setIdProspection(Integer idProspection) {
        this.idProspection = idProspection;
    }

    public Date getDateProspection() {
        return dateProspection;
    }

    public void setDateProspection(Date dateProspection) {
        this.dateProspection = dateProspection;
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

    public Clients getIdClients() {
        return idClients;
    }

    public void setIdClients(Clients idClients) {
        this.idClients = idClients;
    }

    public Employes getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Employes idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProspection != null ? idProspection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prospection)) {
            return false;
        }
        Prospection other = (Prospection) object;
        if ((this.idProspection == null && other.idProspection != null) || (this.idProspection != null && !this.idProspection.equals(other.idProspection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Prospection[ idProspection=" + idProspection + " ]";
    }
    
}
