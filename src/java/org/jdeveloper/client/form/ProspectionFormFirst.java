/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.Element;

/**
 *
 * @author goudjanou
 */
public class ProspectionFormFirst extends FormPanel{
    
    
    private final DateField dateProspection = new DateField();
    SimpleComboBox type_prospection = new SimpleComboBox();
    TextArea objectifAppelVisite = new TextArea();
    TextArea besoinAttenteClient = new TextArea();
    SimpleComboBox id_commerciaux = new SimpleComboBox();
    SimpleComboBox id_clients = new SimpleComboBox();
    
    public ProspectionFormFirst(){
            setHeaderVisible(false);
    }
    
    @Override
    protected void onRender(Element parent,int  pos){
        
        super.onRender(parent, pos);
        dateProspection.setFieldLabel("Date Prospection");
        objectifAppelVisite.setFieldLabel("Objectif");
        besoinAttenteClient.setFieldLabel("Attente Client ");
        id_commerciaux.setFieldLabel("Nom Commercial");
        id_clients.setFieldLabel("Nom Client");
        
        add(dateProspection);
        add(objectifAppelVisite);
        add(besoinAttenteClient);
        add(id_commerciaux);
        add(id_clients);
    
    }
    
    
}
