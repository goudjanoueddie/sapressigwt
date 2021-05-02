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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author goudjanou
 */
@Entity
@Table(name = "commerciaux")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commerciaux.findAll", query = "SELECT c FROM Commerciaux c")
    , @NamedQuery(name = "Commerciaux.findByIdCommerciaux", query = "SELECT c FROM Commerciaux c WHERE c.idCommerciaux = :idCommerciaux")
    , @NamedQuery(name = "Commerciaux.findByNom", query = "SELECT c FROM Commerciaux c WHERE c.nom = :nom")
    , @NamedQuery(name = "Commerciaux.findByPrenom", query = "SELECT c FROM Commerciaux c WHERE c.prenom = :prenom")
    , @NamedQuery(name = "Commerciaux.findByContacts", query = "SELECT c FROM Commerciaux c WHERE c.contacts = :contacts")
    , @NamedQuery(name = "Commerciaux.findByCourriel", query = "SELECT c FROM Commerciaux c WHERE c.courriel = :courriel")
    , @NamedQuery(name = "Commerciaux.findByDateNaissance", query = "SELECT c FROM Commerciaux c WHERE c.dateNaissance = :dateNaissance")})
public class Commerciaux implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_commerciaux")
    private Integer idCommerciaux;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 100)
    @Column(name = "contacts")
    private String contacts;
    @Size(max = 100)
    @Column(name = "courriel")
    private String courriel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCommerciaux")
    private List<Prospection> prospectionList;

    public Commerciaux() {
    }

    public Commerciaux(Integer idCommerciaux) {
        this.idCommerciaux = idCommerciaux;
    }

    public Commerciaux(Integer idCommerciaux, String nom, String prenom, Date dateNaissance) {
        this.idCommerciaux = idCommerciaux;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public Integer getIdCommerciaux() {
        return idCommerciaux;
    }

    public void setIdCommerciaux(Integer idCommerciaux) {
        this.idCommerciaux = idCommerciaux;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
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

    @XmlTransient
    public List<Prospection> getProspectionList() {
        return prospectionList;
    }

    public void setProspectionList(List<Prospection> prospectionList) {
        this.prospectionList = prospectionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommerciaux != null ? idCommerciaux.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commerciaux)) {
            return false;
        }
        Commerciaux other = (Commerciaux) object;
        if ((this.idCommerciaux == null && other.idCommerciaux != null) || (this.idCommerciaux != null && !this.idCommerciaux.equals(other.idCommerciaux))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Commerciaux[ idCommerciaux=" + idCommerciaux + " ]";
    }
    
}
