/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
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
import java.util.Date;

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
    
    DateField dateNaissance =new DateField();
    
    Radio maleRadio = new Radio();
    Radio femaleRadio = new Radio();
    
    SimpleComboBox departmentCombo = new SimpleComboBox();
    
    TextArea addressField = new TextArea();
    
    Button savedButton=new Button("Enregistrer");
    Button cancelButton=new Button("Annuler");
    
    
    private void createForm(){
        
        setFrame(true);
        setHeading("Employé");
       // setSize(600,500);
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
        nom.setAllowBlank(false);
        nom.setSelectOnFocus(true);
        left.add(nom,formData);
        
        mobile.setFieldLabel("Telephone");
        left.add(mobile);
        
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
        
        /*addressField.setFieldLabel("Adresse");
        right.add(addressField,formData);*/
        
        main.add(left,new ColumnData(.5));
        main.add(right,new ColumnData(.5));
        
        add(main,new FormData("100%"));
        
        addressField.setFieldLabel("Adresse");
        addressField.setHeight(150);
        add(addressField,new FormData("100%"));
        
        addButton(savedButton);
        addButton(cancelButton);
    
    }

    public EmployeeForm() {
        createForm();
    }   
    
}
