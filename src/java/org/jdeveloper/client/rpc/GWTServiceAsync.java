
package org.jdeveloper.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import org.jdeveloper.client.dto.EmployeDTO;
import org.jdeveloper.client.dto.GroupuserDTO;
import org.jdeveloper.client.dto.ProspectionDTO;
import org.jdeveloper.client.dto.UserDTO;

/**
 *
 * @author goudjanou
 */
public interface GWTServiceAsync {

    public void myMethod(String s, AsyncCallback<String> callback);

    public void addEmploye(EmployeDTO employeDTO, AsyncCallback<java.lang.Boolean> asyncCallback);
    
    public void addGroup(GroupuserDTO groupDTO, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void addUser(UserDTO userDTO, AsyncCallback<java.lang.Boolean> asyncCallback);
    
    public void getAllGroupName(AsyncCallback<List<String>> asyncCallback);

    public void getIdGroup(String groupName, AsyncCallback<java.lang.Integer> asyncCallback);

    public void getAllUserName(AsyncCallback<List<String>> asyncCallback);

    public void deleteUser(Integer userId, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void getIdUser(String userName, AsyncCallback<Integer> asyncCallback);

    public void addProspection(ProspectionDTO prospectionDTO, AsyncCallback<java.lang.Boolean> asyncCallback);




    
}
