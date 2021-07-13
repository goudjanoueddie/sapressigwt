/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client;

//import com.extjs.gxt.ui.client.Style.HorizontalAlignment;

import com.extjs.gxt.ui.client.Registry;
import org.jdeveloper.client.components.MainPanel;
import org.jdeveloper.client.components.RightNavigationPanel;
import org.jdeveloper.client.components.LeftNavigationPanel;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
//import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.core.shared.GWT;


import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.rpc.GWTService;


/**
 * Main entry point.
 *
 * @author goudjanou
 */
public class MainEntryPoint implements EntryPoint { 
    
    public MainEntryPoint() {
        
    }
       
    public void onModuleLoad() {
        Registry.register(SapressiConstant.SAPRESSI_SERVICE, GWT.create(GWTService.class));
        LoginDialog loginDialog =new LoginDialog();
        loginDialog.show();
        
    }
    
}
