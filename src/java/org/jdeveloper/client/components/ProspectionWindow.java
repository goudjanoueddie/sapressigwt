/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.widget.Popup;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import org.jdeveloper.client.form.ProspectionFormFirst;

/**
 *
 * @author goudjanou
 */
public class ProspectionWindow extends Window{
    
    private final ProspectionFormFirst prospectionForm=new ProspectionFormFirst();
    
    public ProspectionWindow(){
        setHeading("Ajouter Prospection");
        setSize(600,300);
        setBorders(true);
        setResizable(true);
        setLayout(new FitLayout());    
    }
    
    @Override
    protected void onRender(Element parent,int  pos){
        super.onRender(parent, pos);
        add(prospectionForm);
    }
    
}
