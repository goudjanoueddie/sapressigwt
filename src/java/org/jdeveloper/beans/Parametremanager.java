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
import org.jdeveloper.client.dto.ParametremanagerDTO;

/**
 *
 * @author goudjanou
 */
@Entity
@Table(name = "Parametremanager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametremanager.findAll", query = "SELECT p FROM Parametremanager p")
    , @NamedQuery(name = "Parametremanager.findById", query = "SELECT p FROM Parametremanager p WHERE p.id = :id")
    , @NamedQuery(name = "Parametremanager.findByNrdoo", query = "SELECT p FROM Parametremanager p WHERE p.nrdoo = :nrdoo")
    , @NamedQuery(name = "Parametremanager.findByTrf", query = "SELECT p FROM Parametremanager p WHERE p.trf = :trf")
    , @NamedQuery(name = "Parametremanager.findByTeb", query = "SELECT p FROM Parametremanager p WHERE p.teb = :teb")
    , @NamedQuery(name = "Parametremanager.findByTcr", query = "SELECT p FROM Parametremanager p WHERE p.tcr = :tcr")
    , @NamedQuery(name = "Parametremanager.findByTrcf", query = "SELECT p FROM Parametremanager p WHERE p.trcf = :trcf")
    , @NamedQuery(name = "Parametremanager.findByTsdc", query = "SELECT p FROM Parametremanager p WHERE p.tsdc = :tsdc")})
public class Parametremanager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nrdoo")
    private Integer nrdoo;
    @Column(name = "trf")
    private Integer trf;
    @Column(name = "teb")
    private Integer teb;
    @Column(name = "tcr")
    private Integer tcr;
    @Column(name = "trcf")
    private Integer trcf;
    @Column(name = "tsdc")
    private Integer tsdc;

    public Parametremanager() {
    
    }
    
    public Parametremanager(ParametremanagerDTO parametremanagerDTO){
        setId(parametremanagerDTO.getId());
        setNrdoo(parametremanagerDTO.getNrdoo());
        setTrf(parametremanagerDTO.getTrf());
        setTeb(parametremanagerDTO.getTeb());
        setTcr(parametremanagerDTO.getTcr());
        setTrcf(parametremanagerDTO.getTrcf());
        setTsdc(parametremanagerDTO.getTsdc());
    }

    public Parametremanager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNrdoo() {
        return nrdoo;
    }

    public void setNrdoo(Integer nrdoo) {
        this.nrdoo = nrdoo;
    }

    public Integer getTrf() {
        return trf;
    }

    public void setTrf(Integer trf) {
        this.trf = trf;
    }

    public Integer getTeb() {
        return teb;
    }

    public void setTeb(Integer teb) {
        this.teb = teb;
    }

    public Integer getTcr() {
        return tcr;
    }

    public void setTcr(Integer tcr) {
        this.tcr = tcr;
    }

    public Integer getTrcf() {
        return trcf;
    }

    public void setTrcf(Integer trcf) {
        this.trcf = trcf;
    }

    public Integer getTsdc() {
        return tsdc;
    }

    public void setTsdc(Integer tsdc) {
        this.tsdc = tsdc;
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
        if (!(object instanceof Parametremanager)) {
            return false;
        }
        Parametremanager other = (Parametremanager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Parametremanager[ id=" + id + " ]";
    }
    
}
