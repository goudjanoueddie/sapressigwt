/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.user.client.Element;
import org.jdeveloper.client.form.AddUserForm;

/**
 *
 * @author goudjanou
 */
public class AddUserWindow extends Window {
    
    //private final AddUserForm addUserForm = new AddUserForm();
    private  AddUserForm addUserForm = new AddUserForm();
    
    private final Button btnAdd = new Button("");
    private final Button btnRemove = new Button("");
    
    public AddUserWindow(){
        setHeading("Ajouter Utilisateur");
        setSize(450,300);
        setBorders(true);
        setResizable(false);
        setLayout(new FitLayout());
        
        btnAdd.setIconStyle("enregistrerGroupeCss");
        btnAdd.setIconAlign(Style.IconAlign.TOP);
        btnAdd.setScale(Style.ButtonScale.LARGE);
        ToolTipConfig btnAddToolTipConfig=new ToolTipConfig();
        btnAddToolTipConfig.setTitle("Ajouter");
        btnAddToolTipConfig.setText("Ce bouton vous permet d'ajouter des utlisateurs");
        btnAdd.setToolTip(btnAddToolTipConfig);
        
        btnRemove.setIconStyle("removeGroupeCss");
        btnRemove.setIconAlign(Style.IconAlign.TOP);
        btnRemove.setScale(Style.ButtonScale.LARGE);
        ToolTipConfig btnRemoveToolTipConfig=new ToolTipConfig();
        btnRemoveToolTipConfig.setTitle("Retirer");
        btnRemoveToolTipConfig.setText("Ce bouton vous permet de retirer des utilisateurs");
        btnRemove.setToolTip(btnRemoveToolTipConfig);
        
         handlebtnAddClick();
         handlebtnRemoveClick();
        
        addButton(btnAdd);
        addButton(btnRemove);
        
    }
    
    @Override
    protected void onRender(Element parent,int pos){
        super.onRender(parent, pos);
        add(addUserForm);
    }
    
    private void handlebtnAddClick(){
        
        btnAdd.addSelectionListener(new SelectionListener(){
            
            @Override
            public void componentSelected(ComponentEvent ce) {
                
                addUserForm.save();
                hide();
                AddUserWindow addUserWindow =new AddUserWindow();           
                addUserWindow.show();
                
            }
        });    
    }
    
    private void handlebtnRemoveClick(){
    
        btnRemove.addSelectionListener(new SelectionListener(){
            @Override
            public void componentSelected(ComponentEvent ce) {
               /*AddGroupePopup addGroupePopup= new AddGroupePopup();
               addGroupePopup.show(btnRemove.getElement(),"bl- tr?");*/
               hide();
               RemoveUserWindow removeUserWindow = new RemoveUserWindow();
               removeUserWindow.show();
            }
        
        
        });
    }
        
        
        
    }
    

