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
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import static java.util.Calendar.DATE;
import java.util.List;
import org.jdeveloper.beans.Clients;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.dto.CommandeDTO;
import org.jdeveloper.client.dto.EmployeDTO;
import org.jdeveloper.client.rpc.GWTService;
import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class CommandeForm extends FormPanel{
    
    DateField  DateCommande=new DateField();
    SimpleComboBox ClientIdentifiant = new SimpleComboBox();
    TextField<String> montant =new TextField<String>();
    
    Button savedButton=new Button("");
    Button cancelButton=new Button("");
    
    
    final GWTServiceAsync SapressiService = Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    public static Integer clientId;
    
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
    
    
    final AsyncCallback<List<String>> callBackClientName = new AsyncCallback<List<String>> (){
        @Override
        public void onFailure(Throwable caught) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onSuccess(List<String> result) {
            ClientIdentifiant.add(result);
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
    
    public CommandeForm(){
        
        setHeaderVisible(false);
        DateCommande.setFieldLabel("Date Commande");
        ClientIdentifiant.setFieldLabel("Client");
        montant.setFieldLabel("Montant");
        
        ToolTipConfig saveButtonToolTipConfig=new ToolTipConfig();
        saveButtonToolTipConfig.setTitle("Enregistrer Valeur");
        saveButtonToolTipConfig.setText("Ce bouton vous permet d'enregistrer les valeurs dans la base de données");
        
        savedButton.setToolTip(saveButtonToolTipConfig);
        savedButton.setIconAlign(Style.IconAlign.TOP);
        savedButton.setIconStyle("manager-entreprise-button");
        savedButton.setScale(Style.ButtonScale.LARGE);
        
        ToolTipConfig cancelButtonToolTipConfig=new ToolTipConfig();
        cancelButtonToolTipConfig.setTitle("Annuler");
        cancelButtonToolTipConfig.setText("Ce bouton vous permet d'effacer les champs du formulaire");
        
        cancelButton.setToolTip(cancelButtonToolTipConfig);
        cancelButton.setIconAlign(Style.IconAlign.TOP);
        cancelButton.setIconStyle("annulerCss");
        cancelButton.setScale(Style.ButtonScale.LARGE);
        
        add(DateCommande);
        add(ClientIdentifiant);
        add(montant);
        addButton(savedButton);
        addButton(cancelButton);
        SapressiService.getAllClientName(callBackClientName);
        handleComboChangeEvent();
        handlesavedButtonClick();
    
    }
    
    private void handleComboChangeEvent(){
    
        ClientIdentifiant.addListener(Events.SelectionChange,new
        Listener<BaseEvent>(){
        @Override
        public void handleEvent(BaseEvent be)
        {
            SapressiService.getIdClient(ClientIdentifiant.getSimpleValue().toString(), callbackIdClient);
        }
        });
    }
    
    private void handlesavedButtonClick(){
        
        savedButton.addSelectionListener(new SelectionListener(){
            
            @Override
            public void componentSelected(ComponentEvent ce) {
                
                CommandeDTO commandeDTO = new CommandeDTO();
                commandeDTO.setDateCommande(DateCommande.getValue());
                commandeDTO.setMontant(Double.valueOf(montant.getValue()));
                commandeDTO.setIdClients(clientId);
                SapressiService.addCommande(commandeDTO, callback);
                clear();
            }
        
        
        });
    }
    
}
