/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Status;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author goudjanou
 */
public class LoginDialog extends Dialog{
    
    
    protected TextField<String> userName;
    protected TextField<String> password;
    protected Button reset;
    protected Button login;
    protected Status status;
    
    
    public LoginDialog(){
        
        FormLayout layout = new FormLayout();
        layout.setLabelWidth(90);
        layout.setDefaultWidth(155);
        setLayout(layout);
        
        setButtonAlign(HorizontalAlignment.LEFT);
        setButtons("");
        setIcon(IconHelper.createStyle("user"));
        setHeading("Tableau de Bord Sapressi Login");
        setModal(true);
        setBodyBorder(true);
        setBodyStyle("padding: 8px;background: none");
        setWidth(300);
        setResizable(false);
        
        KeyListener keyListener=new KeyListener(){
          
            public void componentKeyUp(ComponentEvent event){
                validate();
            }
        };
        
        userName =new TextField<String>();
        userName.setMinLength(4);
        userName.setFieldLabel("Login");
        userName.addKeyListener(keyListener);
        add(userName);
        
        password = new TextField<String>();
        password.setMinLength(4);
        password.setPassword(true);
        password.setFieldLabel("Mot de Passe");
        password.addKeyListener(keyListener);
        add(password);
        
        setFocusWidget(userName);
             
    }
    
    
    @Override
    protected void createButtons(){
        super.createButtons();
        status = new Status();
        status.setBusy("Patientez s'il vous plait...");
        status.hide();
        status.setAutoWidth(true);
        getButtonBar().add(status);
        getButtonBar().add(new FillToolItem());
        
        reset=new Button("Annuler");
        reset.setIconStyle("resetCss");
        reset.addSelectionListener(new SelectionListener<ButtonEvent>(){
            
            @Override
            public void componentSelected(ButtonEvent ce) {
                userName.reset();
                password.reset();
                validate();
                userName.focus();
            }
        
        });
        
        login= new Button("Connexion");
        login.setIconStyle("loginCss");
        login.disable();
        login.addSelectionListener(new SelectionListener<ButtonEvent>(){
            
            @Override
            public void componentSelected(ButtonEvent ce) {
                onSubmit();
            }
        
        });
        
        addButton(reset);
        addButton(login);
    
    
    }
    
    
    
    protected void onSubmit(){
        
    status.show();
    getButtonBar().disable();
    Timer t = new Timer() {

      @Override
      public void run() {
        LoginDialog.this.hide();
        MainScreen.getInstance();
      }

    };
    t.schedule(2000);
        
    }
    
    protected boolean hasValue(TextField<String> field){
        return field.getValue() != null && field.getValue().length() > 0;
    }
    protected void validate() {
    
        login.setEnabled(hasValue(userName) && hasValue(password)&& password.getValue().length() > 3);
        
    }
    
}
