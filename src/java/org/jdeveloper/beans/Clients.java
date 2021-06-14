/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.jdeveloper.client.dto.ClientDTO;

/**
 *
 * @author goudjanou
 */
@Entity
@Table(name = "Clients")
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
    , @NamedQuery(name = "Clients.findByCourrielCorrespondant", query = "SELECT c FROM Clients c WHERE c.courrielCorrespondant = :courrielCorrespondant")
    , @NamedQuery(name = "Clients.findByClientNameParameter" , query="SELECT c.idClients FROM Clients c WHERE c.nomClient = :nomClient")})
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clients")
    private Integer idClients;
    @Size(max = 100)
    @Column(name = "nom_client")
    private String nomClient;
    @Size(max = 100)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 100)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 100)
    @Column(name = "courriel")
    private String courriel;
    @Size(max = 100)
    @Column(name = "localisation")
    private String localisation;
    @Size(max = 100)
    @Column(name = "activites")
    private String activites;
    @Size(max = 100)
    @Column(name = "correspondant")
    private String correspondant;
    @Size(max = 100)
    @Column(name = "fonction_correspondant")
    private String fonctionCorrespondant;
    @Size(max = 100)
    @Column(name = "contact_correspondant")
    private String contactCorrespondant;
    @Size(max = 100)
    @Column(name = "courriel_correspondant")
    private String courrielCorrespondant;

    public Clients() {
    }

    public Clients(Integer idClients) {
        this.idClients = idClients;
    }
    
    public Clients(ClientDTO clientDTO){
        
        setIdClients(clientDTO.getIdClients());
        setNomClient(clientDTO.getNomClient());
        setAdresse(clientDTO.getAdresse());
        setTelephone(clientDTO.getTelephone());
        setCourriel(clientDTO.getCourriel());
        setLocalisation(clientDTO.getLocalisation());
        setActivites(clientDTO.getActivites());
        setCorrespondant(clientDTO.getCorrespondant());
        setFonctionCorrespondant(clientDTO.getFonctionCorrespondant());
        setContactCorrespondant(clientDTO.getContactCorrespondant());
        setCourrielCorrespondant(clientDTO.getCourrielCorrespondant());
        
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
