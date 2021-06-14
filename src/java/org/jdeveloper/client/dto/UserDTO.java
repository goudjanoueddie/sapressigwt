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
public class UserDTO implements Serializable {
    
    private Integer id;
    private String name;
    private String userName;
    private String password;
    private Integer group_id;
    private String employe_id;

    public UserDTO(String name, String userName, String password, Integer group_id,String employe_id) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.group_id = group_id;
        this.employe_id = employe_id;
    }
    
    public UserDTO(){
    
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public String getEmploye_id() {
        return employe_id;
    }

    public void setEmploye_id(String employe_id) {
        this.employe_id = employe_id;
    }
    
    
    
}
