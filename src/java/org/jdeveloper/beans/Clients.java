/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.beans;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author goudjanou
 */
@Entity
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c")
    , @NamedQuery(name = "Clients.findByIdClients", query = "SELECT c FROM Clients c WHERE c.idClients = :idClients")
    , @NamedQuery(name = "Clients.findByNomClient", query = "SELECT c FROM Clients c WHERE c.nomClient = :nomClient")
    , @NamedQuery(name = "Clients.findByAdresse", query = "SELECT c FROM Clients c WHERE c.adresse = :adresse")
    , @NamedQuery(name = "Clients.findByTelephone", query = "SELECT c FROM Clients c WHERE c.telephone = :telephone")
    , @NamedQuery(name = "Clients.findByCourriel", query = "SELECT c FROM Clients c WHERE c.courriel = :courriel")
    , @NamedQuery(name = "Clients.findByLocalisation", query = "SELECT c FROM Clients c WHERE c.localisation = :localisation")
    , @NamedQuery(name = "Clients.findByActivites", query = "SELECT c FROM Clients c WHERE c.activites = :activites")
    , @NamedQuery(name = "Clients.findByCorrespondant", query = "SELECT c FROM Clients c WHERE c.correspondant = :correspondant")
    , @NamedQuery(name = "Clients.findByFonctionCorrespondant", query = "SELECT c FROM Clients c WHERE c.fonctionCorrespondant = :fonctionCorrespondant")
    , @NamedQuery(name = "Clients.findByContactCorrespondant", query = "SELECT c FROM Clients c WHERE c.contactCorrespondant = :contactCorrespondant")
    , @NamedQuery(name = "Clients.findByCourrielCorrespondant", query = "SELECT c FROM Clients c WHERE c.courrielCorrespondant = :courrielCorrespondant")})
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clients")
    private Integer idClients;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_client")
    private String nomClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adresse")
    private String adresse;
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
    @Size(min = 1, max = 100)
    @Column(name = "localisation")
    private String localisation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "activites")
    private String activites;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correspondant")
    private String correspondant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fonction_correspondant")
    private String fonctionCorrespondant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contact_correspondant")
    private String contactCorrespondant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "courriel_correspondant")
    private String courrielCorrespondant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClients")
    private List<Commandes> commandesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClients")
    private List<Prospection> prospectionList;

    public Clients() {
    }

    public Clients(Integer idClients) {
        this.idClients = idClients;
    }

    public Clients(Integer idClients, String nomClient, String adresse, String telephone, String courriel, String localisation, String activites, String correspondant, String fonctionCorrespondant, String contactCorrespondant, String courrielCorrespondant) {
        this.idClients = idClients;
        this.nomClient = nomClient;
        this.adresse = adresse;
        this.telephone = telephone;
        this.courriel = courriel;
        this.localisation = localisation;
        this.activites = activites;
        this.correspondant = correspondant;
        this.fonctionCorrespondant = fonctionCorrespondant;
        this.contactCorrespondant = contactCorrespondant;
        this.courrielCorrespondant = courrielCorrespondant;
    }

    public Integer getIdClients() {
        return idClients;
    }

    public void setIdClients(Integer idClients) {
        this.idClients = idClients;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getActivites() {
        return activites;
    }

    public void setActivites(String activites) {
        this.activites = activites;
    }

    public String getCorrespondant() {
        return correspondant;
    }

    public void setCorrespondant(String correspondant) {
        this.correspondant = correspondant;
    }

    public String getFonctionCorrespondant() {
        return fonctionCorrespondant;
    }

    public void setFonctionCorrespondant(String fonctionCorrespondant) {
        this.fonctionCorrespondant = fonctionCorrespondant;
    }

    public String getContactCorrespondant() {
        return contactCorrespondant;
    }

    public void setContactCorrespondant(String contactCorrespondant) {
        this.contactCorrespondant = contactCorrespondant;
    }

    public String getCourrielCorrespondant() {
        return courrielCorrespondant;
    }

    public void setCourrielCorrespondant(String courrielCorrespondant) {
        this.courrielCorrespondant = courrielCorrespondant;
    }

    @XmlTransient
    public List<Commandes> getCommandesList() {
        return commandesList;
    }

    public void setCommandesList(List<Commandes> commandesList) {
        this.commandesList = commandesList;
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
        hash += (idClients != null ? idClients.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.idClients == null && other.idClients != null) || (this.idClients != null && !this.idClients.equals(other.idClients))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Clients[ idClients=" + idClients + " ]";
    }
    
}
