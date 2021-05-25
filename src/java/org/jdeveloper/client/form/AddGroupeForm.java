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
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.dto.GroupuserDTO;
import org.jdeveloper.client.rpc.GWTService;
import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class AddGroupeForm extends FormPanel{
    
    
    private final TextField<String> addGroupTextField=new TextField<String>();
    private final SimpleComboBox groupeCombo = new SimpleComboBox();
    
    private final Button btnAdd = new Button("");
    private final Button btnRemove = new Button("");
    
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
    
    public AddGroupeForm(){
        
        setHeaderVisible(false);
        addGroupTextField.setFieldLabel("Ajouter");
        groupeCombo.setFieldLabel("Retirer");
        //SapressiService.getAllGroupName(callbackGroupName);
        
        ((GWTServiceAsync)GWT.create(GWTService.class)).getAllGroupName(callbackGroupName);
  
        add(addGroupTextField);
        add(groupeCombo);
        
        btnAdd.setIconStyle("enregistrerGroupeCss");
        btnAdd.setIconAlign(Style.IconAlign.TOP);
        btnAdd.setScale(Style.ButtonScale.LARGE);
        ToolTipConfig btnAddToolTipConfig=new ToolTipConfig();
        btnAddToolTipConfig.setTitle("Ajouter");
        btnAddToolTipConfig.setText("Ce bouton vous permet d'ajouter des groupes");
        btnAdd.setToolTip(btnAddToolTipConfig);
        
        btnRemove.setIconStyle("removeGroupeCss");
        btnRemove.setIconAlign(Style.IconAlign.TOP);
        btnRemove.setScale(Style.ButtonScale.LARGE);
        ToolTipConfig btnRemoveToolTipConfig=new ToolTipConfig();
        btnRemoveToolTipConfig.setTitle("Retirer");
        btnRemoveToolTipConfig.setText("Ce bouton vous permet de retirer des groupes");
        btnRemove.setToolTip(btnRemoveToolTipConfig);
        
        
        handlebtnAddClick();
        
        addButton(btnAdd);
        addButton(btnRemove);
    }
    
    @Override
    protected void onRender(Element parent,int pos){
        super.onRender(parent, pos); 
    }
    
    private void handlebtnAddClick(){
        
        btnAdd.addSelectionListener(new SelectionListener(){
            
            @Override
            public void componentSelected(ComponentEvent ce) {
                GroupuserDTO groupDTO = new GroupuserDTO();
                groupDTO.setName(addGroupTextField.getValue());
                
                ((GWTServiceAsync)GWT.create(GWTService.class)).addGroup(groupDTO,callback);
                cleanField();
            }
        
        
        });
        
    }
    
    private void handleComboChangeEvent(){
        
        groupeCombo.addListener(Events.SelectionChange,new
        Listener<BaseEvent>(){
        @Override
        public void handleEvent(BaseEvent be)
        {
       
        }
        });
    }
    
    private void cleanField(){
    addGroupTextField.setValue(null);
    }
    
}
