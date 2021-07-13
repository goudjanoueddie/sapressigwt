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
public class ParametreentrepriseDTO implements Serializable {
    
    private Integer id;
    private Integer tdcc;
    private Integer nc;
    private Integer tcoap;
    private Integer tpca;
    private Integer tftr;
    private Integer trcar;

    public ParametreentrepriseDTO(Integer id, Integer tdcc, Integer nc, Integer tcoap, Integer tpca, Integer tftr, Integer trcar) {
        this.id = id;
        this.tdcc = tdcc;
        this.nc = nc;
        this.tcoap = tcoap;
        this.tpca = tpca;
        this.tftr = tftr;
        this.trcar = trcar;
    }
    
    public ParametreentrepriseDTO(){
    
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
    
    
    
}
