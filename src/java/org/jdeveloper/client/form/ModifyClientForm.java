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
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.components.ModifyClientWindowFinal;
import org.jdeveloper.client.dto.ClientDTO;
import org.jdeveloper.client.dto.GroupuserDTO;
import org.jdeveloper.client.rpc.GWTService;

import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class ModifyClientForm extends FormPanel{
    
    private final SimpleComboBox modifyClientField = new SimpleComboBox();
//    private final Button btnModifier = new Button("");
    final GWTServiceAsync SapressiService = Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    public static Integer clientId;
    
    final AsyncCallback<List<String>> callBackClientName = new AsyncCallback<List<String>> (){
        @Override
        public void onFailure(Throwable caught) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onSuccess(List<String> result) {
            modifyClientField.add(result);
        }
    
    };
    
    AsyncCallback<Integer> callbackIdClient = new AsyncCallback<Integer>(){
        @Override
        public void onFailure(Throwable caught) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onSuccess(Integer result) {
            clientId = result;
        }
    
    };
    
   
    
    
    public ModifyClientForm(){
        
        setHeaderVisible(false);
        modifyClientField.setFieldLabel("Client");
        SapressiService.getAllClientName(callBackClientName);
        
        handleComboChangeEvent();
        add(modifyClientField);
        
    }
    
    private void handleComboChangeEvent(){
    
        modifyClientField.addListener(Events.SelectionChange,new
        Listener<BaseEvent>(){
        @Override
        public void handleEvent(BaseEvent be)
        {
           // ((GWTServiceAsync)GWT.create(GWTService.class)).getIdUser(removeUserField.getSimpleValue().toString(), callbackIdUser);
            SapressiService.getIdClient(modifyClientField.getSimpleValue().toString(), callbackIdClient);
        }
        });
    }
    
}
