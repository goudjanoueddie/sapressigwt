/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import org.jdeveloper.client.form.RemoveUserForm;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class RemoveUserWindow extends Window{
    
    private RemoveUserForm removeUserForm = new RemoveUserForm();
    
    GWTServiceAsync SapressiService = Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    
    
    private final Button btnRemove = new Button("");
    
    
    final AsyncCallback<Boolean> asyncCallback = new AsyncCallback<Boolean>() {
        
        MessageBox messageBox = new MessageBox();
        
        @Override
        public void onFailure(Throwable caught) {
            messageBox.setMessage(caught.getMessage());
            messageBox.show();
        }

        @Override
        public void onSuccess(Boolean result) {
            
            if(result){
                
                messageBox.setMessage("Suppression effectué... Cet utilisateur n'aura plus accès a l'application");
                //removeUserField.remove(removeUserField.getSimpleValue().toString());
            
            }else{
                messageBox.setMessage("Impossible de supprimer cet enregistrement");
            }
            
            messageBox.show();
        }
    };
    
    
    public RemoveUserWindow(){
        setHeading("Supprimer utilisateur");
        setSize(400,120);
        setBorders(true);
        setResizable(false);
        setLayout(new FitLayout());
        
        btnRemove.setIconStyle("removeGroupeCss");
        btnRemove.setIconAlign(Style.IconAlign.TOP);
        btnRemove.setScale(Style.ButtonScale.LARGE);
        
        ToolTipConfig btnRemoveToolTipConfig=new ToolTipConfig();
        btnRemoveToolTipConfig.setTitle("Retirer");
        btnRemoveToolTipConfig.setText("Ce bouton vous permet de retirer des utilisateurs");
        btnRemove.setToolTip(btnRemoveToolTipConfig);
        handleRemoveUserClick();
        addButton(btnRemove);
    }
    
    protected void onRender(Element parent, int pos){
        super.onRender(parent, pos);
        add(removeUserForm);
    }
    
    private void handleRemoveUserClick(){
        
        btnRemove.addSelectionListener(new SelectionListener(){
            
            @Override
            public void componentSelected(ComponentEvent ce) {
                SapressiService.deleteUser(RemoveUserForm.userId, asyncCallback);
                hide();
                /*RemoveUserWindow removeUserWindow = new RemoveUserWindow();
                removeUserWindow.show();*/
                
            }
        
        });
    
    
    }
}
