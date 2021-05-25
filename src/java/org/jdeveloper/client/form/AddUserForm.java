/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import java.util.List;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.components.AddUserWindow;
import org.jdeveloper.client.dto.GroupuserDTO;
import org.jdeveloper.client.dto.UserDTO;
import org.jdeveloper.client.rpc.GWTService;
import org.jdeveloper.client.rpc.GWTServiceAsync;
import org.jdeveloper.controller.UserJpaController;

/**
 *
 * @author goudjanou
 */
public class AddUserForm extends FormPanel{
    
    private final TextField <String> nameTextField = new TextField<String>();
    private final TextField <String> userNameTextField = new TextField<String>();
    private final TextField <String> passwordTextField = new TextField<String>();
    private final SimpleComboBox groupeCombo = new SimpleComboBox();
    
    public Integer groupId;
    UserDTO userDTO = new UserDTO();
    final GWTServiceAsync SapressiService=Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    
    
    final AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
        
        MessageBox messageBox = new MessageBox();
        
        @Override
        public void onFailure(Throwable caught) {
            messageBox.setMessage("Impossible d'effectuer cet enregistrement");
            messageBox.show();
        }

        @Override
        public void onSuccess(Boolean result) {
            
            if(result){
                messageBox.setMessage("Enregistrement effectué avec succès");
            
            }else{
                messageBox.setMessage("Impossible d'effectuer cet enregistrement");
            }
            
            messageBox.show();
        }
    };
    
    
     final AsyncCallback<List<String>> callbackGroupName=new AsyncCallback<List<String>>(){
         
         MessageBox messageBox = new MessageBox();

        @Override
        public void onFailure(Throwable caught) {
            messageBox.setMessage(caught.getMessage());
        }

        @Override
        public void onSuccess(List<String> result) {
            
            groupeCombo.add(result);
        }
    
    
    
    };
     
     MessageBox messageBoxInternal = new MessageBox();
     
       AsyncCallback<Integer> callbackIdGroup =new AsyncCallback<Integer>(){
         
         
        @Override
        public void onFailure(Throwable caught) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onSuccess(Integer result) {
            groupId =result;
        }
     };
     
     
     
    
    public AddUserForm(){
        
        setHeaderVisible(false);
        nameTextField.setFieldLabel("Nom");
        userNameTextField.setFieldLabel("Login");
        passwordTextField.setFieldLabel("Password");
        groupeCombo.setFieldLabel("Groupe");
        
       SapressiService.getAllGroupName(callbackGroupName);
        
        add(nameTextField);
        add(userNameTextField);
        add(passwordTextField);
        add(groupeCombo);
        
        handleComboChangeEvent();
    }
    
    
    public void save(){
                
                
                userDTO.setName(nameTextField.getValue());
                userDTO.setUserName(userNameTextField.getValue());
                userDTO.setPassword(passwordTextField.getValue());
                userDTO.setGroup_id(groupId);
                
                SapressiService.addUser(userDTO, callback);
                
                //SapressiService.getIdGroup(groupeCombo.getSimpleValue().toString(), callbackIdGroup);
                //((GWTServiceAsync)GWT.create(GWTService.class)).getIdGroup(groupeCombo.getSimpleValue().toString(), callbackIdGroup);
                cleanField();
                
    
    
    }
    
    private void handleComboChangeEvent(){   
      
        groupeCombo.addListener(Events.SelectionChange,new
        Listener<BaseEvent>(){
        @Override
        public void handleEvent(BaseEvent be)
        {
            ((GWTServiceAsync)GWT.create(GWTService.class)).getIdGroup(groupeCombo.getSimpleValue().toString(), callbackIdGroup);
        }
        });
    }
    
    private void cleanField(){
        clear();
    }
    
    
    
}
