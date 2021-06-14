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
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.components.AddUserWindow;
import org.jdeveloper.client.dto.ProspectionDTO;
import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class ProspectionForm extends FormPanel{
    
    DateField dateProspection = new DateField();
    SimpleComboBox type_prospection = new SimpleComboBox();
    TextArea objectifAppelVisite = new TextArea();
    TextArea besoinAttenteClient = new TextArea();
    SimpleComboBox id_commerciaux = new SimpleComboBox();
    SimpleComboBox id_clients = new SimpleComboBox();
    
    ProspectionDTO prospectionDTO = new ProspectionDTO();
    
    //Button savedButton=new Button("Enregistrer");
    Button savedButton=new Button("");
    Button cancelButton=new Button("");
    
    final GWTServiceAsync SapressiService=Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    
    private Integer clientId;
    
    final AsyncCallback<List<String>> callbackIdCommercial = new AsyncCallback<List<String>>(){
        
        MessageBox messageBox = new MessageBox();
      
        @Override
        public void onFailure(Throwable caught) {
            messageBox.setMessage(caught.getMessage());
        }

        @Override
        public void onSuccess(List<String> result) {
            id_commerciaux.add(result);
        }
    
    
    };
    
    final AsyncCallback<List<String>> callBackClientName = new AsyncCallback<List<String>> (){
        
        MessageBox messageBox = new MessageBox();
        
        @Override
        public void onFailure(Throwable caught) {
            messageBox.setMessage(caught.getMessage());
        }

        @Override
        public void onSuccess(List<String> result) {
            id_clients.add(result);
        }
    
    
    };
    
    AsyncCallback<Integer> callbackIdClient = new AsyncCallback<Integer>(){
        
        MessageBox messageBox = new MessageBox();
        
        @Override
        public void onFailure(Throwable caught) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onSuccess(Integer result) {
            
            clientId = result;
            
            /*messageBox.setMessage(clientId.toString());
            messageBox.show();*/
        }
    
    };
    
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
     
     
    
    
    private void createForm(){
        
        setFrame(true);
        setHeading("Prospection");
        setLabelAlign(LabelAlign.LEFT);
        setButtonAlign(Style.HorizontalAlignment.CENTER);
        LayoutContainer main=new LayoutContainer();
        main.setLayout(new ColumnLayout());
        
        LayoutContainer left=new LayoutContainer();
        left.setStyleAttribute("paddingRight", "10px");
        FormLayout layout = new FormLayout();
        layout.setLabelAlign(LabelAlign.LEFT);
        left.setLayout(layout);
        
        FormData formData =new FormData("100%");
        
        dateProspection.setFieldLabel("Date Prospection");
        left.add(dateProspection,formData);
        
        type_prospection.setFieldLabel("Type Prospection");
        type_prospection.add("telephone");
        type_prospection.add("courriel");
        type_prospection.add("presentiel");
        left.add(type_prospection,formData);
        
        LayoutContainer right=new LayoutContainer();
        right.setStyleAttribute("paddingLeft", "10px");
        layout = new FormLayout();
        layout.setLabelAlign(LabelAlign.LEFT);
        right.setLayout(layout);
        
        id_commerciaux.setFieldLabel("Identite Commercial");
        right.add(id_commerciaux,formData);
        
        id_clients.setFieldLabel("Identite CLient");
        right.add(id_clients,formData);
        
        main.add(left,new ColumnData(.5));
        main.add(right,new ColumnData(.5));
        
        add(main,new FormData("100%"));
        
        objectifAppelVisite.setFieldLabel("Objectif Appel/Visite");
        objectifAppelVisite.setHeight(150);
        add(objectifAppelVisite,new FormData("100%"));
        
        besoinAttenteClient.setFieldLabel("Besoins / Attente Client ");
        besoinAttenteClient.setHeight(150);
        add(besoinAttenteClient,new FormData("100%"));
        
        
        
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
        
        SapressiService.getAllCommercialNames(callbackIdCommercial);
        SapressiService.getAllClientName(callBackClientName);
        
        handleComboChangeEvent();
        handlesavedButtonClick();
        addButton(savedButton);
        addButton(cancelButton);
    
    }
    
    public ProspectionForm(){
        createForm();
    }
    
    private void handleComboChangeEvent(){
        
        id_clients.addListener(Events.SelectionChange,new
        Listener<BaseEvent>(){
        @Override
        public void handleEvent(BaseEvent be)
        {
            SapressiService.getIdClient(id_clients.getSimpleValue().toString(), callbackIdClient);
        }
        });
    
    }
    
    private void handlesavedButtonClick(){
    
        savedButton.addSelectionListener(new SelectionListener(){
            
            @Override
            public void componentSelected(ComponentEvent ce) {
                
                prospectionDTO.setDateProspetion(dateProspection.getValue());
                prospectionDTO.setType(type_prospection.getSimpleValue().toString());
                prospectionDTO.setId_employe(id_commerciaux.getSimpleValue().toString());
                prospectionDTO.setId_clients(clientId);
                prospectionDTO.setObjectifProspection(objectifAppelVisite.getValue());
                prospectionDTO.setBesoinsAttenteClient(besoinAttenteClient.getValue());
                SapressiService.addProspection(prospectionDTO, callback);
                clear();
               
                
            }
        });  
    
    }
    
}
