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
@Table(name = "employes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employes.findAll", query = "SELECT e FROM Employes e")
    , @NamedQuery(name = "Employes.findByIdEmploye", query = "SELECT e FROM Employes e WHERE e.idEmploye = :idEmploye")
    , @NamedQuery(name = "Employes.findByNomEmploye", query = "SELECT e FROM Employes e WHERE e.nomEmploye = :nomEmploye")
    , @NamedQuery(name = "Employes.findByPrenomEmploye", query = "SELECT e FROM Employes e WHERE e.prenomEmploye = :prenomEmploye")
    , @NamedQuery(name = "Employes.findByTelephone", query = "SELECT e FROM Employes e WHERE e.telephone = :telephone")
    , @NamedQuery(name = "Employes.findByCourriel", query = "SELECT e FROM Employes e WHERE e.courriel = :courriel")
    , @NamedQuery(name = "Employes.findByDateNaissance", query = "SELECT e FROM Employes e WHERE e.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "Employes.findByGenre", query = "SELECT e FROM Employes e WHERE e.genre = :genre")
    , @NamedQuery(name = "Employes.findByDepartement", query = "SELECT e FROM Employes e WHERE e.departement = :departement")
    , @NamedQuery(name = "Employes.findByAdresse", query = "SELECT e FROM Employes e WHERE e.adresse = :adresse")})
public class Employes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_employe")
    private Integer idEmploye;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_employe")
    private String nomEmploye;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prenom_employe")
    private String prenomEmploye;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "courriel")
    private String courriel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Size(max = 6)
    @Column(name = "genre")
    private String genre;
    @Size(max = 12)
    @Column(name = "departement")
    private String departement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adresse")
    private String adresse;

    public Employes() {
    }

    public Employes(Integer idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Employes(Integer idEmploye, String nomEmploye, String prenomEmploye, String telephone, String courriel, Date dateNaissance, String adresse) {
        this.idEmploye = idEmploye;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.telephone = telephone;
        this.courriel = courriel;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    public Integer getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Integer idEmploye) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmploye != null ? idEmploye.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employes)) {
            return false;
        }
        Employes other = (Employes) object;
        if ((this.idEmploye == null && other.idEmploye != null) || (this.idEmploye != null && !this.idEmploye.equals(other.idEmploye))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Employes[ idEmploye=" + idEmploye + " ]";
    }
    
}
