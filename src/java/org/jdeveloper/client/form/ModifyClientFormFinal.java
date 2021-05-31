/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Style;
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
public class ModifyClientFormFinal extends FormPanel{
    
    
    TextField<String> nom=new TextField<String>();
    TextField<String> adresse = new TextField<String>();
    TextField<String> telephone=new TextField<String>();
    TextField<String> courriel=new TextField<String>();
    TextField<String> localisation =new TextField<String>();
    TextField<String> activites = new TextField<String> ();
    
    TextField<String> nom_correspondant=new TextField<String>();
    TextField<String> fonction_correpondant=new TextField<String>();
    TextField<String> contact_correspondant = new TextField<String>();
    TextField<String> courriel_correspondant = new TextField<String>();
    
    Button modifierButton = new Button("");
    Button supprimerButton = new Button("");
    
    private void createForm(){
    
        setFrame(true);
        setHeading("Modifier Client");
        setLabelAlign(LabelAlign.TOP);
        setButtonAlign(Style.HorizontalAlignment.CENTER);
        LayoutContainer main=new LayoutContainer();
        main.setLayout(new ColumnLayout());
        
        LayoutContainer left=new LayoutContainer();
        left.setStyleAttribute("paddingRight", "10px");
        FormLayout layout = new FormLayout();
        layout.setLabelAlign(LabelAlign.TOP);
        left.setLayout(layout);
        
        FormData formData =new FormData("100%");
        
        nom.setFieldLabel("Nom");
        nom.setSelectOnFocus(true);
        left.add(nom,formData);
        
        adresse.setFieldLabel("Adresse");
        left.add(adresse, formData);
        
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
        
        ToolTipConfig modifierToolTipConfig = new ToolTipConfig();
        modifierToolTipConfig.setTitle("Modifier");
        modifierToolTipConfig.setText("Ce bouton vous permet de modifier les valeurs");
        
        modifierButton.setToolTip(modifierToolTipConfig);
        modifierButton.setIconAlign(Style.IconAlign.TOP);
        modifierButton.setIconStyle("modifierFinalCss");
        modifierButton.setScale(Style.ButtonScale.LARGE);
        
        ToolTipConfig supprimerToolTipConfig = new ToolTipConfig();
        supprimerToolTipConfig.setTitle("Quitter");
        supprimerToolTipConfig.setText("Ce bouton vous permetde quitter le formulaire");
        
        supprimerButton.setToolTip(supprimerToolTipConfig);
        supprimerButton.setIconAlign(Style.IconAlign.TOP);
        supprimerButton.setIconStyle("quitterFinalCss");
        supprimerButton.setScale(Style.ButtonScale.LARGE);
        
        addButton(modifierButton);
        addButton(supprimerButton);
        
    }
    
    
    public ModifyClientFormFinal(){
        createForm();
    }
    
}
