/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.dto;

import java.io.Serializable;

/**
 *
 * @author goudjanou
 */
public class ParametremanagerDTO implements Serializable {
    
    private Integer id;
    private Integer nrdoo;
    private Integer trf;
    private Integer teb;
    private Integer tcr;
    private Integer trcf;
    private Integer tsdc;

    public ParametremanagerDTO(Integer id, Integer nrdoo, Integer trf, Integer teb, Integer tcr, Integer trcf, Integer tsdc) {
        this.id = id;
        this.nrdoo = nrdoo;
        this.trf = trf;
        this.teb = teb;
        this.tcr = tcr;
        this.trcf = trcf;
        this.tsdc = tsdc;
    }
    
    public ParametremanagerDTO(){
    
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
    
}
