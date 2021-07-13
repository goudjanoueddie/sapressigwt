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

/**
 *
 * @author goudjanou
 */
@Entity
@Table(name = "Parametrequalite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametrequalite.findAll", query = "SELECT p FROM Parametrequalite p")
    , @NamedQuery(name = "Parametrequalite.findById", query = "SELECT p FROM Parametrequalite p WHERE p.id = :id")
    , @NamedQuery(name = "Parametrequalite.findByTrap", query = "SELECT p FROM Parametrequalite p WHERE p.trap = :trap")
    , @NamedQuery(name = "Parametrequalite.findByNnc", query = "SELECT p FROM Parametrequalite p WHERE p.nnc = :nnc")
    , @NamedQuery(name = "Parametrequalite.findByTcnc", query = "SELECT p FROM Parametrequalite p WHERE p.tcnc = :tcnc")
    , @NamedQuery(name = "Parametrequalite.findByNrpc", query = "SELECT p FROM Parametrequalite p WHERE p.nrpc = :nrpc")
    , @NamedQuery(name = "Parametrequalite.findByTcrp", query = "SELECT p FROM Parametrequalite p WHERE p.tcrp = :tcrp")
    , @NamedQuery(name = "Parametrequalite.findByTraa", query = "SELECT p FROM Parametrequalite p WHERE p.traa = :traa")
    , @NamedQuery(name = "Parametrequalite.findByTraad", query = "SELECT p FROM Parametrequalite p WHERE p.traad = :traad")})
public class Parametrequalite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "trap")
    private Integer trap;
    @Column(name = "nnc")
    private Integer nnc;
    @Column(name = "tcnc")
    private Integer tcnc;
    @Column(name = "nrpc")
    private Integer nrpc;
    @Column(name = "tcrp")
    private Integer tcrp;
    @Column(name = "traa")
    private Integer traa;
    @Column(name = "traad")
    private Integer traad;

    public Parametrequalite() {
    }

    public Parametrequalite(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrap() {
        return trap;
    }

    public void setTrap(Integer trap) {
        this.trap = trap;
    }

    public Integer getNnc() {
        return nnc;
    }

    public void setNnc(Integer nnc) {
        this.nnc = nnc;
    }

    public Integer getTcnc() {
        return tcnc;
    }

    public void setTcnc(Integer tcnc) {
        this.tcnc = tcnc;
    }

    public Integer getNrpc() {
        return nrpc;
    }

    public void setNrpc(Integer nrpc) {
        this.nrpc = nrpc;
    }

    public Integer getTcrp() {
        return tcrp;
    }

    public void setTcrp(Integer tcrp) {
        this.tcrp = tcrp;
    }

    public Integer getTraa() {
        return traa;
    }

    public void setTraa(Integer traa) {
        this.traa = traa;
    }

    public Integer getTraad() {
        return traad;
    }

    public void setTraad(Integer traad) {
        this.traad = traad;
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
        if (!(object instanceof Parametrequalite)) {
            return false;
        }
        Parametrequalite other = (Parametrequalite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jdeveloper.beans.Parametrequalite[ id=" + id + " ]";
    }
    
}
