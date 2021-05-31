/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.form.ModifyClientForm;
import org.jdeveloper.client.rpc.GWTServiceAsync;
import com.google.gwt.user.client.Element;

/**
 *
 * @author goudjanou
 */
public class ModifyClientWindow extends Window{
    
    private ModifyClientForm modifyClientForm = new ModifyClientForm();
    GWTServiceAsync SapressiService = Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    private final Button btnSearch = new Button("");
    
    public ModifyClientWindow(){
        
        setHeading("Chercher Client");
        setSize(400,120);
        setBorders(true);
        setResizable(false);
        setLayout(new FitLayout());
    
    }
    
    protected void onRender(Element parent ,int pos){
        super.onRender(parent, pos);
        add(modifyClientForm);
    }
    
}
