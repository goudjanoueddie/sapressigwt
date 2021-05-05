/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.jdeveloper.client.dto.EmployeDTO;

/**
 *
 * @author goudjanou
 */
public interface GWTServiceAsync {

    public void myMethod(String s, AsyncCallback<String> callback);

    public void addEmploye(EmployeDTO employeDTO, AsyncCallback<java.lang.Boolean> asyncCallback);
}
