/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Popup;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.user.client.Element;
import org.jdeveloper.client.portlet.CommercialNavigationPanel;

/**
 *
 * @author goudjanou
 */
public class AddGroupePopup extends Popup{
    
    
    private final TextField<String> addGroupTextField=new TextField<String>();
    private final Text txtExplaination = new Text("Supprimer utilisateur");
    private final SimpleComboBox groupeCombo = new SimpleComboBox();
    private final Button btnAdd = new Button("");
    private final Button btnRemove = new Button("");
    
    public AddGroupePopup(){
        
        setSize(400,60);
        //setSize(400,170);
        setBorders(true);
        setShadow(true);
        setAutoHide(false);
        
    
    }
    
    
    @Override
    protected void onRender(Element parent,int pos){
        super.onRender(parent,pos);
        
        
        btnAdd.setIconStyle("enregistrerGroupeCss");
        ToolTipConfig btnAddToolTipConfig=new ToolTipConfig();
        btnAddToolTipConfig.setTitle("Enregistrer Valeur");
        btnAddToolTipConfig.setText("Ce bouton vous permet d'enregistrer les valeurs dans la base de données");
        btnAdd.setToolTip(btnAddToolTipConfig);
        btnAdd.addSelectionListener(new SelectionListener<ButtonEvent>() {
            
        public void componentSelected(ButtonEvent ce) {
        
        }
        
        });
        
        final BorderLayout layout=new BorderLayout();
        setLayout(layout);
        
        final BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH,20);
        northData.setMargins(new Margins(2));
        add(txtExplaination,northData);
        
        final BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
        centerData.setMargins(new Margins(2));
        //add(addGroupTextField, centerData);
        add(groupeCombo,centerData);
        
        final BorderLayoutData eastData = new
        BorderLayoutData(LayoutRegion.EAST, 60);
        eastData.setMargins(new Margins(2));
        add(btnAdd, eastData);
        //add(btnRemove,eastData);
        
    }
    
    
}
