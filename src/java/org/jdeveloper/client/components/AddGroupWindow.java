/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import org.jdeveloper.client.form.AddGroupeForm;

/**
 *
 * @author goudjanou
 */
public class AddGroupWindow extends Window{
    
    private final AddGroupeForm addGroupeForm = new AddGroupeForm();
    
    public AddGroupWindow(){
        setHeading("Ajouter Groupe");
        setSize(400,150);
        setBorders(true);
        setResizable(false);
        setLayout(new FitLayout());
    
    }
    
    @Override
    protected void onRender(Element parent, int pos){
        super.onRender(parent, pos);
        add(addGroupeForm);
    }
    
    
    
}
