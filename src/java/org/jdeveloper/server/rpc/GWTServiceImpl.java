
package org.jdeveloper.server.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdeveloper.beans.Employes;
import org.jdeveloper.beans.Groupuser;
import org.jdeveloper.beans.User;
import org.jdeveloper.client.dto.EmployeDTO;
import org.jdeveloper.client.dto.GroupuserDTO;
import org.jdeveloper.client.dto.ProspectionDTO;
import org.jdeveloper.client.dto.UserDTO;

import org.jdeveloper.client.rpc.GWTService;
import org.jdeveloper.controller.EmployesJpaController;
import org.jdeveloper.controller.GroupuserJpaController;
import org.jdeveloper.controller.UserJpaController;
import org.jdeveloper.controller.exceptions.IllegalOrphanException;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
