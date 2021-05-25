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
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.components.RemoveUserWindow;
import org.jdeveloper.client.rpc.GWTService;
import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class RemoveUserForm extends FormPanel{
    
    private final SimpleComboBox removeUserField = new SimpleComboBox();    
    final GWTServiceAsync SapressiService=Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    
    public static Integer userId;
    
    final AsyncCallback<List<String>> callBackUserName = new AsyncCallback<List<String>>(){
        
        MessageBox messageBox = new MessageBox();
        
        @Override
        public void onFailure(Throwable caught) {
            messageBox.setMessage(caught.getMessage());
        }

        @Override
        public void onSuccess(List<String> result) {
            removeUserField.add(result);
        }
        
    };
    
    AsyncCallback<Integer> callbackIdUser = new AsyncCallback<Integer>(){
        @Override
        public void onFailure(Throwable caught) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onSuccess(Integer result) {
            userId = result;
        }
    
    };
    
    
    
    public RemoveUserForm(){
        setHeaderVisible(false);
        removeUserField.setFieldLabel("Retirer");
        SapressiService.getAllUserName(callBackUserName);
        
        add(removeUserField);
        handleComboChangeEvent();
        
    }
    
    
    
    /*private void handleRemoveUserClick(){
        
        btnRemove.addSelectionListener(new SelectionListener(){
            
            @Override
            public void componentSelected(ComponentEvent ce) {
                SapressiService.deleteUser(userId, asyncCallback);
                clear();
                RemoveUserWindow removeUserWindow = new RemoveUserWindow();
                removeUserWindow.show();
                
            }
        
        });
    
    
    }*/
    
     private void handleComboChangeEvent(){   
      
        removeUserField.addListener(Events.SelectionChange,new
        Listener<BaseEvent>(){
        @Override
        public void handleEvent(BaseEvent be)
        {
            ((GWTServiceAsync)GWT.create(GWTService.class)).getIdUser(removeUserField.getSimpleValue().toString(), callbackIdUser);
        }
        });
    }
    
    @Override
    protected void onRender(Element parent,int pos){
        super.onRender(parent, pos);   
    }
}
