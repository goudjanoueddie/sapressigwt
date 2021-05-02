/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.portlet;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.ContentPanel;

/**
 *
 * @author goudjanou
 */
//public class CommercialNavigationPanel extends Portlet{
public class CommercialNavigationPanel extends ContentPanel{
    
    ToolBar toolBar=new ToolBar();
    
    ButtonGroup group1= new ButtonGroup(3);
    ButtonGroup group2= new ButtonGroup(3);
    
    ToggleButton btnnewetu= new ToggleButton();
    Button btn2= new Button();
    Button btn3=new Button();
    MenuItem menutodo1= new MenuItem("TO do1");
    MenuItem menutodo2= new MenuItem("TO do2");
    Button btn4=new Button();
    
    
    Button btn5=new Button();
    Button btn6=new Button();
    Button btn7=new Button();
    Button btn8=new Button();
    
    MenuItem menutodo3= new MenuItem("Nouvel emploi du temps");
    MenuItem menutodo4= new MenuItem("TO do4");
    
    public CommercialNavigationPanel(){
        
        setLayout(new FitLayout());
       // setHeight(150);
        firstToolBar();
    
    }

    private void firstToolBar() {
        group1.setHeading("Commercial");
        
        btnnewetu.setIconStyle("foldericon");
        ToolTipConfig toolTipConfigetu = new ToolTipConfig();
        toolTipConfigetu.setTitle("Gestion Commercial");
        toolTipConfigetu.setText("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        btnnewetu.setToolTip(toolTipConfigetu);
        btnnewetu.setScale(Style.ButtonScale.LARGE);
        group1.add(btnnewetu);
        
        toolBar.add(group1);
        add(toolBar);
                
    }
    
}
