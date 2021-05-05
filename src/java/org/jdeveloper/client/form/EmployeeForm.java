/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Date;
import org.jdeveloper.client.components.SapressiPopup;
import org.jdeveloper.client.dto.EmployeDTO;
import org.jdeveloper.client.rpc.GWTService;
import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class EmployeeForm extends FormPanel{
//public class EmployeeForm extends Window{
    
    TextField<String> nom=new TextField<String>();
    TextField<String> prenom=new TextField<String>();
    TextField<String> mobile=new TextField<String>();
    TextField<String> email=new TextField<String>();
    TextField<String> IdEmploye=new TextField<String>();
    
    DateField dateNaissance = new DateField();
    
    Radio maleRadio = new Radio();
    Radio femaleRadio = new Radio();
    
    SimpleComboBox departmentCombo = new SimpleComboBox();
    
    TextArea addressField = new TextArea();
    
    Button savedButton=new Button("");
    Button cancelButton=new Button("");
    
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
        setHeading("Employé");
        setLabelAlign(LabelAlign.LEFT);
        setButtonAlign(HorizontalAlignment.CENTER);
        LayoutContainer main=new LayoutContainer();
        main.setLayout(new ColumnLayout());
        
        LayoutContainer left=new LayoutContainer();
        left.setStyleAttribute("paddingRight", "10px");
        FormLayout layout = new FormLayout();
        layout.setLabelAlign(LabelAlign.LEFT);
        left.setLayout(layout);
        
        FormData formData =new FormData("100%");
        
        nom.setFieldLabel("Nom");
        //nom.setAllowBlank(false);
        nom.setSelectOnFocus(true);
        left.add(nom,formData);
        
        mobile.setFieldLabel("Telephone");
        left.add(mobile,formData);
        
        dateNaissance.setFieldLabel("Date de Naissance");
        dateNaissance.setMinValue(new Date(60,1,1));
        dateNaissance.setMaxValue(new Date());
        left.add(dateNaissance,formData);
        
        maleRadio.setBoxLabel("Homme");
        femaleRadio.setBoxLabel("Femme");
        
        
        RadioGroup genderGroup = new RadioGroup();
        genderGroup.setFieldLabel("Genre");
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        left.add(genderGroup,formData);
        
        departmentCombo.setFieldLabel("Departement");
        departmentCombo.add("Commercial");
        departmentCombo.add("Technicien");
        departmentCombo.add("Comptabilite");
        left.add(departmentCombo,formData);
        
        
        LayoutContainer right=new LayoutContainer();
        right.setStyleAttribute("paddingLeft", "10px");
        layout=new FormLayout();
        layout.setLabelAlign(LabelAlign.LEFT);
        right.setLayout(layout);
        
        prenom.setFieldLabel("Prenom");
        right.add(prenom,formData);
        
        email.setFieldLabel("Email");
        right.add(email, formData);
        
        IdEmploye.setFieldLabel("ID Employe");
        right.add(IdEmploye,formData);
              
        main.add(left,new ColumnData(.5));
        main.add(right,new ColumnData(.5));
        
        add(main,new FormData("100%"));
        
        addressField.setFieldLabel("Adresse");
        addressField.setHeight(150);
        add(addressField,new FormData("100%"));
        
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
        handlesavedButtonClick();
        
        addButton(savedButton);
        addButton(cancelButton);
    
    }

    public EmployeeForm() {
        createForm();
    } 
    
    private void handlecancelButtonCLick(){
            
     cancelButton.addSelectionListener(new SelectionListener(){

     @Override
     public void componentSelected(ComponentEvent ce) {
            cleanField();
          }
        });
    
   
    }
    
    private void handlesavedButtonClick(){
        
        savedButton.addSelectionListener(new SelectionListener(){
            
            @Override
            public void componentSelected(ComponentEvent ce) {
                EmployeDTO employeDTO=new EmployeDTO();
                employeDTO.setIdEmploye(IdEmploye.getValue());
                employeDTO.setNomEmploye(nom.getValue());
                employeDTO.setPrenomEmploye(prenom.getValue());
                employeDTO.setTelephone(mobile.getValue());
                employeDTO.setCourriel(email.getValue());
                employeDTO.setDateNaissance(dateNaissance.getValue());
                String value = (maleRadio.getValue()) ? maleRadio.getBoxLabel() : femaleRadio.getBoxLabel(); 
                employeDTO.setGenre(value);
                employeDTO.setDepartement(departmentCombo.getSimpleValue().toString());
                employeDTO.setAdresse(addressField.getValue());
                
                ((GWTServiceAsync) GWT.create(GWTService.class)) .addEmploye(employeDTO, callback);
                cleanField();
            }
        
        
        });
    
    }
    
    private void cleanField(){
            nom.setValue(null);
            prenom.setValue(null);
            mobile.setValue(null);
            email.setValue(null);
            dateNaissance.setValue(null);
            maleRadio.clear();
            femaleRadio.clear();
            departmentCombo.clear();
            addressField.setValue(null);
            IdEmploye.setValue(null);
    }
    
}
