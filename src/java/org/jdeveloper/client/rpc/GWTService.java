/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;
import org.jdeveloper.client.dto.EmployeDTO;
import org.jdeveloper.client.dto.GroupuserDTO;
import org.jdeveloper.client.dto.ProspectionDTO;
import org.jdeveloper.client.dto.UserDTO;

/**
 *
 * @author goudjanou
 */
@RemoteServiceRelativePath("rpc/gwtservice")
public interface GWTService extends RemoteService {

    public String myMethod(String s);
    
    public boolean addEmploye(EmployeDTO employeDTO);
    
    public boolean addGroup(GroupuserDTO groupDTO);
    
    public boolean addUser(UserDTO userDTO);
    
    public boolean addProspection(ProspectionDTO prospectionDTO);
    
    public List<String> getAllGroupName();
    
    public Integer getIdGroup(String groupName);
    
    public List<String> getAllUserName();
    
    public Integer getIdUser(String userName);
    
    public boolean deleteUser(Integer userId);
  
}
