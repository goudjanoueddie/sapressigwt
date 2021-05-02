/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Popup;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.Element;
import org.jdeveloper.client.portlet.CommercialNavigationPanel;

/**
 *
 * @author goudjanou
 */
public class SapressiPopup extends Popup{
    
    CommercialNavigationPanel commercialPortlet = new CommercialNavigationPanel();
    
    public SapressiPopup(){
        
        setSize(400,100);
        setBorders(true);
        //setShadow(true);
        setAutoHide(false);
        //add(commercialPortlet);
    
    }
    
    
    @Override
    protected void onRender(Element parent,int pos){
        super.onRender(parent,pos);
        
        final BorderLayoutData centerData = new
        BorderLayoutData(LayoutRegion.CENTER);
        centerData.setMargins(new Margins(2));
        add(commercialPortlet, centerData);
    }
    
    
}
