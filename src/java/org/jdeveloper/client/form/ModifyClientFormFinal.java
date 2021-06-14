/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.dto.ClientDTO;
import org.jdeveloper.client.rpc.GWTServiceAsync;

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
    
    ClientDTO clientDTO = new ClientDTO();
    final GWTServiceAsync SapressiService=Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    
    final AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
        
        MessageBox messageBox = new MessageBox();
        
        @Override
        public void onFailure(Throwable caught) {
            messageBox.setMessage(caught.getMessage());
            messageBox.show();
        }

        @Override
        public void onSuccess(Boolean result) {
            
            if(result){
                messageBox.setMessage("Enregistrement effectué avec succès");
            
            }else{
                messageBox.setMessage("Impossible d'effectuer cette modification");
            }
            
            messageBox.show();
        }
    };
    
    
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
        supprimerToolTipConfig.setText("Ce bouton vous permet de quitter le formulaire");
        
        supprimerButton.setToolTip(supprimerToolTipConfig);
        supprimerButton.setIconAlign(Style.IconAlign.TOP);
        supprimerButton.setIconStyle("quitterFinalCss");
        supprimerButton.setScale(Style.ButtonScale.LARGE);
        
        
        handlemodifierButtonClick();
        
        addButton(modifierButton);
        addButton(supprimerButton);
        
    }
    
    
    public ModifyClientFormFinal(){
        createForm();
    }
    
    private void handlemodifierButtonClick(){

        modifierButton.addSelectionListener(new SelectionListener<ButtonEvent>()
        
        {
        @Override
        public void componentSelected(ButtonEvent ce)
        {
            clientDTO.setNomClient(nom.getValue());
            clientDTO.setAdresse(adresse.getValue());
            clientDTO.setTelephone(telephone.getValue());
            clientDTO.setCourriel(courriel.getValue());
            clientDTO.setLocalisation(localisation.getValue());
            clientDTO.setActivites(activites.getValue());
            clientDTO.setCorrespondant(nom_correspondant.getValue());
            clientDTO.setFonctionCorrespondant(fonction_correpondant.getValue());
            clientDTO.setContactCorrespondant(contact_correspondant.getValue());
            clientDTO.setCourrielCorrespondant(courriel_correspondant.getValue());
            
            SapressiService.updateClient(clientDTO, callback);
            clear();
        }
        });
    }

    public TextField<String> getNom() {
        return nom;
    }

    public void setNom(TextField<String> nom) {
        this.nom = nom;
    }

    public TextField<String> getAdresse() {
        return adresse;
    }

    public void setAdresse(TextField<String> adresse) {
        this.adresse = adresse;
    }

    public TextField<String> getTelephone() {
        return telephone;
    }

    public void setTelephone(TextField<String> telephone) {
        this.telephone = telephone;
    }

    public TextField<String> getCourriel() {
        return courriel;
    }

    public void setCourriel(TextField<String> courriel) {
        this.courriel = courriel;
    }

    public TextField<String> getLocalisation() {
        return localisation;
    }

    public void setLocalisation(TextField<String> localisation) {
        this.localisation = localisation;
    }

    public TextField<String> getActivites() {
        return activites;
    }

    public void setActivites(TextField<String> activites) {
        this.activites = activites;
    }

    public TextField<String> getNom_correspondant() {
        return nom_correspondant;
    }

    public void setNom_correspondant(TextField<String> nom_correspondant) {
        this.nom_correspondant = nom_correspondant;
    }

    public TextField<String> getFonction_correpondant() {
        return fonction_correpondant;
    }

    public void setFonction_correpondant(TextField<String> fonction_correpondant) {
        this.fonction_correpondant = fonction_correpondant;
    }

    public TextField<String> getContact_correspondant() {
        return contact_correspondant;
    }

    public void setContact_correspondant(TextField<String> contact_correspondant) {
        this.contact_correspondant = contact_correspondant;
    }

    public TextField<String> getCourriel_correspondant() {
        return courriel_correspondant;
    }

    public void setCourriel_correspondant(TextField<String> courriel_correspondant) {
        this.courriel_correspondant = courriel_correspondant;
    }

}
