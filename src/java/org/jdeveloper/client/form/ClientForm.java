/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;

/**
 *
 * @author goudjanou
 */
public class ClientForm extends FormPanel{
    
    TextField<String> nom=new TextField<String>();
    TextField<String> telephone=new TextField<String>();
    TextField<String> courriel=new TextField<String>();
    TextField<String> localisation =new TextField<String>();
    TextField<String> activites = new TextField<String> ();
    
    TextField<String> nom_correspondant=new TextField<String>();
    TextField<String> fonction_correpondant=new TextField<String>();
    TextField<String> contact_correspondant = new TextField<String>();
    TextField<String> courriel_correspondant = new TextField<String>();
    
    Button savedButton=new Button("");
    Button cancelButton=new Button("");
    
    
    
    private void createForm(){
    
        setFrame(true);
        setHeading("Client");
        setLabelAlign(LabelAlign.TOP);
        setButtonAlign(HorizontalAlignment.CENTER);
        LayoutContainer main=new LayoutContainer();
        main.setLayout(new ColumnLayout());
        
        LayoutContainer left=new LayoutContainer();
        left.setStyleAttribute("paddingRight", "10px");
        FormLayout layout = new FormLayout();
        layout.setLabelAlign(LabelAlign.TOP);
        left.setLayout(layout);
        
        FormData formData =new FormData("100%");
        
        nom.setFieldLabel("Nom");
        nom.setAllowBlank(false);
        nom.setSelectOnFocus(true);
        left.add(nom,formData);
        
        telephone.setFieldLabel("Telephone");
        left.add(telephone,formData);
        
        courriel.setFieldLabel("Email");
        left.add(courriel,formData);
        
        localisation.setFieldLabel("Localisation");
        left.add(localisation,formData);
        
        activites.setFieldLabel("Activite(s)");
        left.add(activites,formData);
        
        LayoutContainer right=new LayoutContainer();
        right.setStyleAttribute("paddingLeft", "10px");
        layout=new FormLayout();
        layout.setLabelAlign(LabelAlign.TOP);
        right.setLayout(layout);
        
        nom_correspondant.setFieldLabel("Nom Correspondant");
        right.add(nom_correspondant,formData);
        
        fonction_correpondant.setFieldLabel("Fonction Correspondant");
        right.add(fonction_correpondant,formData);
        
        contact_correspondant.setFieldLabel("Contact Correspondant");
        right.add(contact_correspondant,formData);
        
        courriel_correspondant.setFieldLabel("Courriel Correspondant");
        right.add(courriel_correspondant,formData);
        
        
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
        
         handlecancelButtonCLick();
        
        addButton(savedButton);
        addButton(cancelButton);
        
    }
    
    private void handlecancelButtonCLick(){
            
     cancelButton.addSelectionListener(new SelectionListener(){

     @Override
     public void componentSelected(ComponentEvent ce) {
            nom.setValue(null);
            telephone.setValue(null);
            courriel.setValue(null);
            localisation.setValue(null);
            activites.setValue(null);
            nom_correspondant.setValue(null);
            fonction_correpondant.setValue(null);
            contact_correspondant.setValue(null);
            courriel_correspondant.setValue(null);
          }
        });
    
   
    }
    
    public ClientForm(){
        createForm();
    }
    
    
}
