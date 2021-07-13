
package org.jdeveloper.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
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
public interface GWTServiceAsync {

    public void addEmploye(EmployeDTO employeDTO, AsyncCallback<java.lang.Boolean> asyncCallback);
    
    public void addGroup(GroupuserDTO groupDTO, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void addUser(UserDTO userDTO, AsyncCallback<java.lang.Boolean> asyncCallback);
    
    public void getAllGroupName(AsyncCallback<List<String>> asyncCallback);

    public void getIdGroup(String groupName, AsyncCallback<java.lang.Integer> asyncCallback);

    public void getAllUserName(AsyncCallback<List<String>> asyncCallback);

    public void deleteUser(Integer userId, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void getIdUser(String userName, AsyncCallback<Integer> asyncCallback);

    public void addProspection(ProspectionDTO prospectionDTO, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void addClient(ClientDTO clientDTO, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void getAllClientName(AsyncCallback<List<String>> asyncCallback);

    public void getIdClient(String clientName, AsyncCallback<Integer> asyncCallback);

    public void findCLient(int clientId, AsyncCallback<ClientDTO> asyncCallback);

    public void updateClient(ClientDTO clientDTO, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void getAllCommercialNames(AsyncCallback<List<String>> asyncCallback);

    public void getAllEmployesId(AsyncCallback<List<String>> asyncCallback);

    public void getEmployeName(String employeId, AsyncCallback<String> asyncCallback);

    public void login(String userName, String password, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void getParametreEntreprise(AsyncCallback<ParametreentrepriseDTO> asyncCallback);

    public void getParametreManager(AsyncCallback<ParametremanagerDTO> asyncCallback);

    public void addCommande(CommandeDTO commandeDTO, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void addTauxDemandeTraitee(DemandetraitesDTO demandestraitesDTO,AsyncCallback<java.lang.Boolean> asyncCallback);

    public void addDemande(DemandesDTO demandesDTO, AsyncCallback<java.lang.Boolean> asyncCallback);




    
}
