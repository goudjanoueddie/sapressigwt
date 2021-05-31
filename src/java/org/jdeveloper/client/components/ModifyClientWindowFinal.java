/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import org.jdeveloper.client.form.ClientForm;
import org.jdeveloper.client.form.ModifyClientFormFinal;

/**
 *
 * @author goudjanou
 */
public class ModifyClientWindowFinal extends Window {
    
    
    ModifyClientFormFinal clientForm = new ModifyClientFormFinal();
    
    public ModifyClientWindowFinal(){
        setSize(500,500);
        setBorders(true);
        setResizable(false);
        setLayout(new FitLayout());
    }
    
    
    protected void onRender(Element parent ,int pos){
        super.onRender(parent, pos);
        add(clientForm);
    }
    
}
