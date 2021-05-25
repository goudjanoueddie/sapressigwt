/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import org.jdeveloper.client.MainScreen;
import org.jdeveloper.client.form.EmployeeForm;

/**
 *
 * @author goudjanou
 */
public class RightNavigationPanel extends ContentPanel {
    
    private Button modifierCibleManagerEntreprise=new Button("Seuil Manager Entreprise");
    private Button ajouterGroupe=new Button("Ajouter Groupe");
    private Button ajouterUser = new Button("Ajouter Utilisateur");
    private Button ajouterEmployeeButton=new Button("Ajouter Employe");
    private Button chercherButton=new Button("Chercher");
   // private Button updateButton=new Button("Update");
    private Button deleteButton=new Button("Delete");
    
    //final  AddGroupePopup sapressiPopup=new AddGroupePopup();
    
    
    

    
    
    
    public RightNavigationPanel(){
        setLayout(new FitLayout());
        //sapressiPopup.setConstrainViewport(true);
        add(getRightSideBarPanel());     
    }
    
    
    private ContentPanel getRightSideBarPanel(){
   
        ContentPanel rightSideBarPanel= new ContentPanel();
        rightSideBarPanel.setHeading("Parametrage");
        rightSideBarPanel.setBodyBorder(true);
        rightSideBarPanel.setLayout(new AccordionLayout());
        
        ContentPanel setupContentPanel =new ContentPanel();
        setupContentPanel.setHeading("MODIFIER PARAMETRES");
        setupContentPanel.setIconStyle("iconnaviright1");
        setupContentPanel.setLayout(new RowLayout());
        
        modifierCibleManagerEntreprise.setIconStyle("modifiermanagerentreprise");
        modifierCibleManagerEntreprise.setScale(Style.ButtonScale.LARGE);
        modifierCibleManagerEntreprise.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                 
            }
        });
        
        setupContentPanel.add(modifierCibleManagerEntreprise,new RowData(1,-1,new Margins(5,5,10,5)));
        
        
        
        ContentPanel ajoutProfilContentPanel =new ContentPanel();
        ajoutProfilContentPanel.setHeading("AJOUTER PROFIL");
        ajoutProfilContentPanel.setIconStyle("ajoutProfilCss");
        ajoutProfilContentPanel.setLayout(new RowLayout());
        
        ajouterGroupe.setIconStyle("ajouterGroupeCss");
        ajouterGroupe.setScale(Style.ButtonScale.LARGE);
        ajouterGroupe.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {                           
                AddGroupWindow addGroupeWindow = new AddGroupWindow();
                addGroupeWindow.show();
            }
        });
        
        ajoutProfilContentPanel.add(ajouterGroupe,new RowData(1,-1,new Margins(5,5,10,5)));
        
        ajouterUser.setIconStyle("ajouterUserCss");
        ajouterUser.setScale(Style.ButtonScale.LARGE);
        ajouterUser.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                
                AddUserWindow addUserWindow =new AddUserWindow();           
                addUserWindow.show();
                
                 
            }
        });
        
        ajoutProfilContentPanel.add(ajouterUser,new RowData(1,-1,new Margins(5,5,10,5)));
        
        
        ajouterEmployeeButton.setIconStyle("ajouterCommercialCss");
        ajouterEmployeeButton.setScale(Style.ButtonScale.LARGE);
        ajouterEmployeeButton.addSelectionListener(new SelectionListener(){
            @Override
            public void componentSelected(ComponentEvent ce) {
                EmployeeForm employeeForm=new EmployeeForm();
                MainScreen.addTab("Ajouter Employe", employeeForm);    
            }
        });
        
        
        
        ajoutProfilContentPanel.add(ajouterEmployeeButton,new RowData(1,-1,new Margins(5,5,10,5)));
        
        chercherButton.setIconStyle("searchCss");
        chercherButton.setScale(Style.ButtonScale.LARGE);
        chercherButton.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                           
                //sapressiPopup.show();
                 
            }
        });
        
        ajoutProfilContentPanel.add(chercherButton,new RowData(1,-1,new Margins(5,5,10,5)));
      
        rightSideBarPanel.add(setupContentPanel);
        rightSideBarPanel.add(ajoutProfilContentPanel);
        return rightSideBarPanel;
    
    }
    
    
    
}