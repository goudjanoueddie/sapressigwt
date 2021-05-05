/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.jdeveloper.client.dto.EmployeDTO;

/**
 *
 * @author goudjanou
 */
@RemoteServiceRelativePath("rpc/gwtservice")
public interface GWTService extends RemoteService {

    public String myMethod(String s);
    
    public boolean addEmploye(EmployeDTO employeDTO);
}
