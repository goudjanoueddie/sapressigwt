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
public class GroupuserDTO implements Serializable{
    
    private Integer id;
    private String name;
    
    
    public GroupuserDTO(Integer id,String name){
        this.id = id;
        this.name = name;
    }
    
    public GroupuserDTO(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
        
}
