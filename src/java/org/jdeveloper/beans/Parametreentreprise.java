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
import javax.xml.bind.annotation.XmlRootElement;
import org.jdeveloper.client.dto.ParametreentrepriseDTO;

/**
 *
 * @author goudjanou
 */
@Entity
@Table(name = "Parametreentreprise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametreentreprise.findAll", query = "SELECT p FROM Parametreentreprise p")
    , @NamedQuery(name = "Parametreentreprise.findById", query = "SELECT p FROM Parametreentreprise p WHERE p.id = :id")
    , @NamedQuery(name = "Parametreentreprise.findByTdcc", query = "SELECT p FROM Parametreentreprise p WHERE p.tdcc = :tdcc")
    , @NamedQuery(name = "Parametreentreprise.findByNc", query = "SELECT p FROM Parametreentreprise p WHERE p.nc = :nc")
    , @NamedQuery(name = "Parametreentreprise.findByTcoap", query = "SELECT p FROM Parametreentreprise p WHERE p.tcoap = :tcoap")
    , @NamedQuery(name = "Parametreentreprise.findByTpca", query = "SELECT p FROM Parametreentreprise p WHERE p.tpca = :tpca")
    , @NamedQuery(name = "Parametreentreprise.findByTftr", query = "SELECT p FROM Parametreentreprise p WHERE p.tftr = :tftr")
    , @NamedQuery(name = "Parametreentreprise.findByTrcar", query = "SELECT p FROM Parametreentreprise p WHERE p.trcar = :trcar")})
public class Parametreentreprise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tdcc")
    private Integer tdcc;
    @Column(name = "nc")
    private Integer nc;
    @Column(name = "tcoap")
    private Integer tcoap;
    @Column(name = "tpca")
    private Integer tpca;
    @Column(name = "tftr")
    private Integer tftr;
    @Column(name = "trcar")
    private Integer trcar;

    public Parametreentreprise() {
    }

    public Parametreentreprise(Integer id) {
        this.id = id;
    }
    
    public Parametreentreprise(ParametreentrepriseDTO parametreentrepriseDTO){
        
        setId(parametreentrepriseDTO.getId());
        setTdcc(parametreentrepriseDTO.getTdcc());
        setNc(parametreentrepriseDTO.getNc());
        setTcoap(parametreentrepriseDTO.getTcoap());
        setTpca(parametreentrepriseDTO.getTpca());
        setTftr(parametreentrepriseDTO.getTftr());
        setTrcar(parametreentrepriseDTO.getTrcar());
    
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTdcc() {
        return tdcc;
    }

    public void setTdcc(Integer tdcc) {
        this.tdcc = tdcc;
    }

    public Integer getNc() {
        return nc;
    }

    public void setNc(Integer nc) {
        this.nc = nc;
    }

    public Integer getTcoap() {
        return tcoap;
    }

    public void setTcoap(Integer tcoap) {
        this.tcoap = tcoap;
    }

    public Integer getTpca() {
        return tpca;
    }

    public void setTpca(Integer tpca) {
        this.tpca = tpca;
    }

    public Integer getTftr() {
        return tftr;
    }

    public void setTftr(Integer tftr) {
        this.tftr = tftr;
    }

    public Integer getTrcar() {
        return trcar;
    }

    public void setTrcar(Integer trcar) {
        this.trcar = trcar;
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
        if (!(object instanceof Parametreentreprise)) {
            return false;
        }
        Parametreentreprise other = (Parametreentreprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Parametreentreprise[ id=" + id + " ]";
    }
    
}
