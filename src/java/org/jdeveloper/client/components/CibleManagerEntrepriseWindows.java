/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.user.client.Element;
import org.jdeveloper.client.form.CibleManagerEntrepriseForm;

/**
 *
 * @author goudjanou
 */
public class CibleManagerEntrepriseWindows extends Window {
    
    private CibleManagerEntrepriseForm cibleManagerEntrepriseForm = new CibleManagerEntrepriseForm();
    Button modifierButton = new Button("");
    
    
    public CibleManagerEntrepriseWindows(){
        
        setHeading("Modifier Indicateurs de Performance Processus Manager L'entreprise");
        setSize(450,300);
        setBorders(true);
        setResizable(false);
        setLayout(new FitLayout());
        
        ToolTipConfig modifierToolTipConfig = new ToolTipConfig();
        modifierToolTipConfig.setTitle("Modifier");
        modifierToolTipConfig.setText("Ce bouton vous permet de modifier les valeurs");
        
        modifierButton.setToolTip(modifierToolTipConfig);
        modifierButton.setIconAlign(Style.IconAlign.TOP);
        modifierButton.setIconStyle("modifierFinalCss");
        modifierButton.setScale(Style.ButtonScale.LARGE);
        
        addButton(modifierButton);
    
    }
    
    public CibleManagerEntrepriseForm getCibleManagerEntrepriseForm(){
            return cibleManagerEntrepriseForm;
    }
    
    @Override
    protected void onRender(Element parent,int pos){
        super.onRender(parent,pos);
        add(cibleManagerEntrepriseForm);
        
    }
    
}
