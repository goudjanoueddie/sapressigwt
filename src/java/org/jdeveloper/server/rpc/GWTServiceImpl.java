/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.server.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdeveloper.beans.Employes;
import org.jdeveloper.client.dto.EmployeDTO;

import org.jdeveloper.client.rpc.GWTService;
import org.jdeveloper.controller.EmployesJpaController;
import org.jdeveloper.controller.exceptions.PreexistingEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class GWTServiceImpl extends RemoteServiceServlet implements GWTService {

    public String myMethod(String s) {
        // Do something interesting with 's' here on the server.
        return "Server says: " + s;
    }

    @Override
    public boolean addEmploye(EmployeDTO employeDTO) {
        
        Employes employe = new Employes();
        employe.setIdEmploye(employeDTO.getIdEmploye());
        employe.setNomEmploye(employeDTO.getNomEmploye());
        employe.setPrenomEmploye(employeDTO.getPrenomEmploye());
        employe.setTelephone(employeDTO.getTelephone());
        employe.setCourriel(employeDTO.getCourriel());
        employe.setDateNaissance(employeDTO.getDateNaissance());
        employe.setGenre(employeDTO.getGenre());
        employe.setDepartement(employeDTO.getDepartement());
        employe.setAdresse(employeDTO.getAdresse());
        
        EmployesJpaController employesJpaController = new EmployesJpaController();
        boolean added = false;
        
        try{
            
            employesJpaController.create(employe);
            added =true;
        
        }catch (RollbackFailureException ex){
            
            Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex)
        {
            Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return added;
    }
}
