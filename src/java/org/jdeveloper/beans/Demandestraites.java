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
@Table(name = "Demandestraites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandestraites.findAll", query = "SELECT d FROM Demandestraites d")
    , @NamedQuery(name = "Demandestraites.findById", query = "SELECT d FROM Demandestraites d WHERE d.id = :id")
    , @NamedQuery(name = "Demandestraites.findByDateDebut", query = "SELECT d FROM Demandestraites d WHERE d.dateDebut = :dateDebut")
    , @NamedQuery(name = "Demandestraites.findByDateFin", query = "SELECT d FROM Demandestraites d WHERE d.dateFin = :dateFin")
    , @NamedQuery(name = "Demandestraites.findByDr", query = "SELECT d FROM Demandestraites d WHERE d.dr = :dr")
    , @NamedQuery(name = "Demandestraites.findByDtdd", query = "SELECT d FROM Demandestraites d WHERE d.dtdd = :dtdd")
    , @NamedQuery(name = "Demandestraites.findByObservations", query = "SELECT d FROM Demandestraites d WHERE d.observations = :observations")})
public class Demandestraites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "dr")
    private Integer dr;
    @Column(name = "dtdd")
    private Integer dtdd;
    @Size(max = 400)
    @Column(name = "observations")
    private String observations;

    public Demandestraites() {
    }

    public Demandestraites(Integer id) {
        this.id = id;
    }

    public Demandestraites(Integer id, Date dateDebut, Date dateFin) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demandestraites)) {
            return false;
        }
        Demandestraites other = (Demandestraites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Demandestraites[ id=" + id + " ]";
    }
    
}
