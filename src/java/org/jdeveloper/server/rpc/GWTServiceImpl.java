
package org.jdeveloper.server.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdeveloper.beans.Clients;
import org.jdeveloper.beans.Commandes;
import org.jdeveloper.beans.Demandes;
import org.jdeveloper.beans.Demandestraites;
import org.jdeveloper.beans.Employes;
import org.jdeveloper.beans.Groupuser;
import org.jdeveloper.beans.Parametreentreprise;
import org.jdeveloper.beans.Parametremanager;
import org.jdeveloper.beans.Prospection;
import org.jdeveloper.beans.User;
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

import org.jdeveloper.client.rpc.GWTService;
import org.jdeveloper.controller.ClientsJpaController;
import org.jdeveloper.controller.CommandesJpaController;
import org.jdeveloper.controller.DemandesJpaController;
import org.jdeveloper.controller.DemandestraitesJpaController;
import org.jdeveloper.controller.EmployesJpaController;
import org.jdeveloper.controller.GroupuserJpaController;
import org.jdeveloper.controller.ParametreentrepriseJpaController;
import org.jdeveloper.controller.ParametremanagerJpaController;
import org.jdeveloper.controller.ProspectionJpaController;
import org.jdeveloper.controller.UserJpaController;
import org.jdeveloper.controller.exceptions.IllegalOrphanException;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
import org.jdeveloper.controller.exceptions.PreexistingEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class GWTServiceImpl extends RemoteServiceServlet implements GWTService {


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
    
    
    

    @Override
    public boolean addGroup(GroupuserDTO groupDTO) {
        
        Groupuser groupUser = new Groupuser();
        groupUser.setName(groupDTO.getName());
        GroupuserJpaController groupuserJpaController = new GroupuserJpaController();
        boolean added = false;
        
        try{
            groupuserJpaController.create(groupUser);
            added=true;
        }catch(RollbackFailureException ex){
        Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
        Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return added;
    }

    @Override
    public boolean addUser(UserDTO userDTO) {
        
        User user = new User();
        user.setName(userDTO.getName());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setGroupid(new Groupuser(userDTO.getGroup_id()));
        user.setIdEmploye(new Employes(userDTO.getEmploye_id()));
        UserJpaController userJpaController=new UserJpaController();
        boolean added = false;
        
         try{
            userJpaController.create(user);
            added=true;
        }catch(RollbackFailureException ex){
        Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
        Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return added;
    }

    @Override
    public List<String> getAllGroupName() {
        List<String> resultatQuery;
        GroupuserJpaController groupuserJpaController = new GroupuserJpaController();
        resultatQuery = groupuserJpaController.getAllGroupes();
        return resultatQuery;
    }

    @Override
    public Integer getIdGroup(String groupName) {
        Integer groupId;
        GroupuserJpaController groupuserJpaController = new GroupuserJpaController();
        groupId = groupuserJpaController.getIdGroup(groupName);
        //groupId = groupuserJpaController.getIdGroupInt(groupName);
        return groupId;
    }

    @Override
    public List<String> getAllUserName() {
        List<String> resultatQuery;
        UserJpaController userJpaController = new UserJpaController();
        resultatQuery = userJpaController.getAllNames();
        return resultatQuery;
    }

    @Override
    public boolean deleteUser(Integer userId) {
        
        boolean deleted =false;
        UserJpaController userJpaController = new UserJpaController();
        try{
        
            userJpaController.destroy(userId);
            deleted =true;
        }catch(IllegalOrphanException ex)
        {
        
        }catch(Exception ex){
        
        }
        
        return deleted;
    }

    @Override
    public Integer getIdUser(String userName) {
        Integer userId;
        UserJpaController userJpaController = new UserJpaController();
        userId = userJpaController.getIdUser(userName);
        return userId;
    }

    @Override
    public boolean addProspection(ProspectionDTO prospectionDTO) {
        ProspectionJpaController prospectinonJpaController = new ProspectionJpaController();
        Prospection prospection = new Prospection();
        prospection.setDateProspection(prospectionDTO.getDateProspetion());
        prospection.setObjectifProspection(prospectionDTO.getObjectifProspection());
        prospection.setBesoinsAttenteClient(prospectionDTO.getBesoinsAttenteClient());
        prospection.setType(prospectionDTO.getType());
        prospection.setIdClients(new Clients(prospectionDTO.getId_clients()));
        prospection.setIdEmploye(new Employes(prospectionDTO.getId_employe()));
        boolean added =false;
        
        try{
            prospectinonJpaController.create(prospection);
            added = true;
        }catch(RollbackFailureException ex){
        Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
        Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }         
       return added;
    }

    @Override
    public boolean addClient(ClientDTO clientDTO) {
        
        ClientsJpaController clientsJpaController = new ClientsJpaController();
        Clients clients = new Clients();
        clients.setNomClient(clientDTO.getNomClient());
        clients.setAdresse(clientDTO.getAdresse());
        clients.setTelephone(clientDTO.getTelephone());
        clients.setCourriel(clientDTO.getCourriel());
        clients.setLocalisation(clientDTO.getLocalisation());
        clients.setActivites(clientDTO.getActivites());
        clients.setCorrespondant(clientDTO.getCorrespondant());
        clients.setFonctionCorrespondant(clientDTO.getFonctionCorrespondant());
        clients.setContactCorrespondant(clientDTO.getContactCorrespondant());
        clients.setCourrielCorrespondant(clientDTO.getCourrielCorrespondant());
        boolean added = false;
        
        try{
        
            clientsJpaController.create(clients);
            added = true;
            
        }catch(RollbackFailureException ex){
        Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
        Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }         
       return added;
    }

    @Override
    public List<String> getAllClientName() {
        List<String> resultatQuery;
        ClientsJpaController clientsJpaController = new ClientsJpaController();
        resultatQuery = clientsJpaController.getAllClientsNames();
        return resultatQuery;
    }

    @Override
    public Integer getIdClient(String clientName) {
        Integer userId;
        ClientsJpaController clientsJpaController = new ClientsJpaController();
        userId = clientsJpaController.getIdClient(clientName);
        return userId;
    }

    @Override
    public ClientDTO findCLient(int clientId) {
        
        ClientsJpaController clientsJpaController = new ClientsJpaController();
        Clients client = clientsJpaController.findClients(clientId);
        ClientDTO clientsDTO = null;
        
        if(client != null){
            clientsDTO = new ClientDTO();
            clientsDTO.setIdClients(client.getIdClients());
            clientsDTO.setNomClient(client.getNomClient());
            clientsDTO.setAdresse(client.getAdresse());
            clientsDTO.setTelephone(client.getTelephone());
            clientsDTO.setCourriel(client.getCourriel());
            clientsDTO.setLocalisation(client.getLocalisation());
            clientsDTO.setActivites(client.getActivites());
            clientsDTO.setCorrespondant(client.getCorrespondant());
            clientsDTO.setFonctionCorrespondant(client.getFonctionCorrespondant());
            clientsDTO.setContactCorrespondant(client.getContactCorrespondant());
            clientsDTO.setCourrielCorrespondant(client.getCourrielCorrespondant());
        }
        
        return clientsDTO;
    }

    @Override
    public boolean updateClient(ClientDTO clientDTO) {
        
        ClientsJpaController clientsJpaController = new ClientsJpaController();
        boolean updated = false;
        try{
            clientsJpaController.edit(new Clients(clientDTO));
            updated = true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updated;
    }

    @Override
    public List<String> getAllCommercialNames() {
        List<String> resultatQuery;
        ProspectionJpaController  prospectionJpaController  = new ProspectionJpaController();
        resultatQuery = prospectionJpaController.getAllCommercial();
        return resultatQuery; 
    }

    @Override
    public List<String> getAllEmployesId() {
        List<String> resultatQuery;
        EmployesJpaController employeJpaController = new EmployesJpaController();
        resultatQuery = employeJpaController.getAllEmployesId();
        return resultatQuery;
    }

    @Override
    public String getEmployeName(String employeId) {
        String employeName;
        EmployesJpaController employeJpaController = new EmployesJpaController();
        employeName = employeJpaController.getNameEmploye(employeId);
        return employeName;
    }

    @Override
    public boolean login(String userName, String password) {
        
        boolean isPresent = false;
        UserJpaController userJpaController = new UserJpaController();
        try {
            isPresent = userJpaController.findByUSerNameAndPassword(userName, password);
        } catch (Exception ex) {
            //Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isPresent;     
    }

    @Override
    public ParametreentrepriseDTO getParametreEntreprise() {
        ParametreentrepriseJpaController parametreentrepriseJpaController = new ParametreentrepriseJpaController();
        Parametreentreprise parametreentreprise = parametreentrepriseJpaController.findParametreentreprise(1);
        ParametreentrepriseDTO parametreentrepriseDTO = null;
    
        if(parametreentreprise != null){
            parametreentrepriseDTO = new ParametreentrepriseDTO();
            parametreentrepriseDTO.setId(parametreentreprise.getId());
            parametreentrepriseDTO.setTdcc(parametreentreprise.getTdcc());
            parametreentrepriseDTO.setNc(parametreentreprise.getNc());
            parametreentrepriseDTO.setTcoap(parametreentreprise.getTcoap());
            parametreentrepriseDTO.setTpca(parametreentreprise.getTpca());
            parametreentrepriseDTO.setTftr(parametreentreprise.getTftr());
            parametreentrepriseDTO.setTrcar(parametreentreprise.getTrcar());
        }
        
        return parametreentrepriseDTO;
    }

    @Override
    public ParametremanagerDTO getParametreManager() {
        
        ParametremanagerJpaController parametremanagerJpaController = new ParametremanagerJpaController();
        Parametremanager parametremanager = parametremanagerJpaController.findParametremanager(1);
        ParametremanagerDTO parametremanagerDTO = null;
        
        if(parametremanager != null){
            parametremanagerDTO = new ParametremanagerDTO();
            parametremanagerDTO.setId(parametremanager.getId());
            parametremanagerDTO.setNrdoo(parametremanager.getNrdoo());
            parametremanagerDTO.setTrf(parametremanager.getTrf());
            parametremanagerDTO.setTeb(parametremanager.getTeb());
            parametremanagerDTO.setTcr(parametremanager.getTcr());
            parametremanagerDTO.setTrcf(parametremanager.getTrcf());
            parametremanagerDTO.setTsdc(parametremanager.getTsdc());
        }
        return parametremanagerDTO;            
    }

    @Override
    public boolean addCommande(CommandeDTO commandeDTO) {
        Commandes commandes =new Commandes();
        commandes.setIdCommande(commandeDTO.getIdCommande());
        commandes.setDateCommande(commandeDTO.getDateCommande());
        commandes.setIdClients(new Clients(commandeDTO.getIdClients()));
        commandes.setMontant(commandeDTO.getMontant());
        
        CommandesJpaController commandeJpaController = new CommandesJpaController();
        boolean added = false;
        
        try{
            commandeJpaController.create(commandes);
            added =true;
        }catch (RollbackFailureException ex){
            Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex)
        {
            Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return added;
    }

    @Override
    public boolean addTauxDemandeTraitee(DemandetraitesDTO demandetraitesDTO) {
        Demandestraites demandestraites    = new Demandestraites();
        demandestraites.setId(demandetraitesDTO.getId());
        demandestraites.setDateDebut(demandetraitesDTO.getDateDebut());
        demandestraites.setDateFin(demandetraitesDTO.getDateFin());
        demandestraites.setDr(demandetraitesDTO.getDr());
        demandestraites.setDtdd(demandetraitesDTO.getDtdd());
        demandestraites.setObservations(demandetraitesDTO.getObservations());
        
        DemandestraitesJpaController demandestraitesJpaController = new DemandestraitesJpaController();
        boolean added =false;
        
        try{
            demandestraitesJpaController.create(demandestraites);
            added =true;
        }catch (RollbackFailureException ex){
            Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex)
        {
            Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return added;
        
        
    }

    @Override
    public boolean addDemande(DemandesDTO demandesDTO) {
        
        Demandes demandes = new Demandes();
        demandes.setId(demandesDTO.getId());
        demandes.setDateDemande(demandesDTO.getDateDemande());
        demandes.setNomClient(demandesDTO.getNomClient());
        demandes.setObjet(demandesDTO.getObjet());
        demandes.setReference(demandesDTO.getReference());
        demandes.setType(demandesDTO.getType());
        demandes.setMoyen(demandesDTO.getMoyen());
        boolean added = false;
        
        DemandesJpaController demandesJpaController = new DemandesJpaController();
        
        try{
            demandesJpaController.create(demandes);
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


