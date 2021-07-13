/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;
import org.jdeveloper.client.dto.ClientDTO;
import org.jdeveloper.client.dto.CommandeDTO;
import org.jdeveloper.client.dto.DemandesDTO;
import org.jdeveloper.client.dto.DemandetraitesDTO;
import org.jdeveloper.client.dto.EmployeDTO;
import org.jdeveloper.client.dto.GroupuserDTO;
import org.jdeveloper.client.dto.ParametreentrepriseDTO;
import org.jdeveloper.client.dto.ParametremanagerDTO;
import org.jdeveloper.client.dto.ProspectionDTO;
import org.jdeveloper.client.dto.UserDTO;

/**
 *
 * @author goudjanou
 */
@RemoteServiceRelativePath("rpc/gwtservice")
public interface GWTService extends RemoteService {
    
    public boolean addEmploye(EmployeDTO employeDTO);
    
    public boolean addGroup(GroupuserDTO groupDTO);
    
    public boolean addUser(UserDTO userDTO);
    
    public boolean addProspection(ProspectionDTO prospectionDTO);
    
    public boolean addClient(ClientDTO clientDTO);
    
    public List<String> getAllGroupName();
    
    public Integer getIdGroup(String groupName);
    
    public List<String> getAllUserName();
    
    public Integer getIdUser(String userName);
    
    public boolean deleteUser(Integer userId);
    
    public List<String> getAllClientName();
    
    public Integer getIdClient(String clientName);
    
    public ClientDTO findCLient(int clientId);
    
    public boolean updateClient(ClientDTO clientDTO);
    
    public List<String> getAllCommercialNames();
    
    public List<String> getAllEmployesId();
    
    public String getEmployeName(String employeId);
    
    public boolean login(String userName , String password);
    
    public ParametreentrepriseDTO getParametreEntreprise();
    
    public ParametremanagerDTO getParametreManager();
    
    public boolean addCommande(CommandeDTO commandeDTO);
    
    public boolean addTauxDemandeTraitee(DemandetraitesDTO demandestraitesDTO);
    
    public boolean addDemande(DemandesDTO demandesDTO);
    
}
