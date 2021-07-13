/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class DemandeForm extends FormPanel{
    
    DateField dateDemande =new DateField();
    SimpleComboBox nomClient = new SimpleComboBox();
    TextField<String> objet = new TextField<String>();
    TextField<String> reference = new TextField<String>();
    SimpleComboBox typeDemande=new SimpleComboBox();
    SimpleComboBox Moyen = new SimpleComboBox();
    Button savedButton=new Button("");
    Button cancelButton=new Button("");
    
    final GWTServiceAsync SapressiService=Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    
    final AsyncCallback<List<String>> callBackClientName = new AsyncCallback<List<String>> (){
        
        MessageBox messageBox = new MessageBox();
        
        @Override
        public void onFailure(Throwable caught) {
            messageBox.setMessage(caught.getMessage());
        }

        @Override
        public void onSuccess(List<String> result) {
            nomClient.add(result);
        }
    
    
    };
    
   public DemandeForm(){
        createForm();
    }
   
   private void createForm(){
   
       setFrame(true);
       setHeading("Demandes");
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
       
       dateDemande.setFieldLabel("Date Demande");
       left.add(dateDemande,formData);
       
       nomClient.setFieldLabel("Nom Client");
       left.add(nomClient,formData);
       
       typeDemande.setFieldLabel("Type Demande");
       typeDemande.add("Offre");
       typeDemande.add("Devis");
       typeDemande.add("Proforma");
       left.add(typeDemande,formData);
               
       LayoutContainer right=new LayoutContainer();
       right.setStyleAttribute("paddingLeft", "10px");
       layout=new FormLayout();
       layout.setLabelAlign(LabelAlign.LEFT);
       right.setLayout(layout);

       
       objet.setFieldLabel("Objet/Designation");
       right.add(objet,formData);
       
       reference.setFieldLabel("N/Ref");
       right.add(reference,formData);
       
       Moyen.setFieldLabel("Type Contact");
       Moyen.add("telephone");
       Moyen.add("email");
       Moyen.add("presentiel");
       right.add(Moyen,formData);
       
       main.add(left,new ColumnData(.5));
       main.add(right,new ColumnData(.5));
        
       add(main,new FormData("100%"));
       
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
        
        SapressiService.getAllClientName(callBackClientName);
        
        handlecancelButtonCLick();
        handlesavedButtonClick();
        
        addButton(savedButton);
        addButton(cancelButton);
            
   }

    private void handlecancelButtonCLick() {
        
    }

    private void handlesavedButtonClick() {
        
    }
    
}
