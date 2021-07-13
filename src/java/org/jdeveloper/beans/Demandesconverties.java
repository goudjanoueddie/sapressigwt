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
@Table(name = "Demandesconverties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandesconverties.findAll", query = "SELECT d FROM Demandesconverties d")
    , @NamedQuery(name = "Demandesconverties.findById", query = "SELECT d FROM Demandesconverties d WHERE d.id = :id")
    , @NamedQuery(name = "Demandesconverties.findByDateDebut", query = "SELECT d FROM Demandesconverties d WHERE d.dateDebut = :dateDebut")
    , @NamedQuery(name = "Demandesconverties.findByDateFin", query = "SELECT d FROM Demandesconverties d WHERE d.dateFin = :dateFin")
    , @NamedQuery(name = "Demandesconverties.findByDt", query = "SELECT d FROM Demandesconverties d WHERE d.dt = :dt")
    , @NamedQuery(name = "Demandesconverties.findByDcc", query = "SELECT d FROM Demandesconverties d WHERE d.dcc = :dcc")
    , @NamedQuery(name = "Demandesconverties.findByObservations", query = "SELECT d FROM Demandesconverties d WHERE d.observations = :observations")})
public class Demandesconverties implements Serializable {

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
    @Column(name = "dt")
    private Integer dt;
    @Column(name = "dcc")
    private Integer dcc;
    @Size(max = 400)
    @Column(name = "observations")
    private String observations;

    public Demandesconverties() {
    }

    public Demandesconverties(Integer id) {
        this.id = id;
    }

    public Demandesconverties(Integer id, Date dateDebut, Date dateFin) {
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

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Integer getDcc() {
        return dcc;
    }

    public void setDcc(Integer dcc) {
        this.dcc = dcc;
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
        if (!(object instanceof Demandesconverties)) {
            return false;
        }
        Demandesconverties other = (Demandesconverties) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Demandesconverties[ id=" + id + " ]";
    }
    
}
