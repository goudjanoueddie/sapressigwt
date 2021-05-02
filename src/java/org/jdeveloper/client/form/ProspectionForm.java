/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
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
    
    //Button savedButton=new Button("Enregistrer");
    Button savedButton=new Button("");
    Button cancelButton=new Button("");
    
    
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
        
        
        
        addButton(savedButton);
        addButton(cancelButton);
    
    }
    
    public ProspectionForm(){
        createForm();
    }
    
}
