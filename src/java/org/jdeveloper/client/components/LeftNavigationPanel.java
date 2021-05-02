/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import org.jdeveloper.client.form.ManagerEntrepriseForm;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import org.jdeveloper.client.MainEntryPoint;
import org.jdeveloper.client.MainScreen;
import org.jdeveloper.client.form.ClientForm;
import org.jdeveloper.client.form.PiloterQualiteForm;
import org.jdeveloper.client.form.ProspectionForm;
import  org.jdeveloper.client.portlet.CommercialNavigationPanel;

/**
 *
 * @author goudjanou
 */
public class LeftNavigationPanel extends ContentPanel{
    
    
    private Button managerEntrepriseButton= new Button("Manager L'entreprise");
    private Button genererRapportManager= new Button("Voir Rapport");
    
    private Button piloterQualiteButton=new Button("Piloter la Qualite");
    private Button genererRapportPiloterQualiter=new Button("Rapport Qualite");
    private Button genererRapportPiloterQualiterGeneral=new Button("Rapport Qualite General");
    
    private Button prospectionButton = new Button("Prospection");
    private Button clientsButton = new Button("Clients");
    private Button commandesButton = new Button("Commandes");
    private Button commerciauxButton = new Button("Commerciaux");
    private Button factureButton = new Button("Facture");
    private Button recapButton=new Button("ShortCut");
    
    
    public LeftNavigationPanel(){ 
        setLayout(new FitLayout());
        add(getLeftSidebar());
    
    }
    
    private ContentPanel getLeftSidebar(){
        
        ContentPanel leftSideBarPanel = new ContentPanel();
        leftSideBarPanel.setHeading("Navigation");
        leftSideBarPanel.setBodyBorder(true);
        leftSideBarPanel.setLayout(new AccordionLayout());
        
        ContentPanel setupContentPanel=new ContentPanel();
        setupContentPanel.setHeading("MANAGER ENTREPRISE");
        setupContentPanel.setIconStyle("iconnavileft1");
        setupContentPanel.setLayout(new RowLayout());
        
        
         managerEntrepriseButton.setIconStyle("manager-entreprise-button");
         managerEntrepriseButton.setScale(Style.ButtonScale.LARGE);
         managerEntrepriseButton.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                /*Info.display("test","click on ajouteretu");
                EtudiantForm etudiantForm=new EtudiantForm();
                universiteEntryPoint.getInstance().addTab("Ajout Etudiant", etudiantForm);*/
                
                ManagerEntrepriseForm managerEntrepriseForm=new ManagerEntrepriseForm();
                MainScreen.addTab("Manager L'entreprise", managerEntrepriseForm);
            }
        
        
        
        });
         
         genererRapportManager.setIconStyle("generer-rapport-manager");
         genererRapportManager.setScale(Style.ButtonScale.LARGE);
                 
         
         
         
          setupContentPanel.add(managerEntrepriseButton,new RowData(1,-1,new Margins(5,5,10,5)));
          setupContentPanel.add(genererRapportManager,new RowData(1,-1,new Margins(5,5,10,5)));
          
          ContentPanel piloterQualiteContentPanel =new ContentPanel();
          piloterQualiteContentPanel.setHeading("PILOTER QUALITE");
          piloterQualiteContentPanel.setIconStyle("iconpiloterqualite");
          piloterQualiteContentPanel.setLayout(new RowLayout());
          
          
      
          piloterQualiteButton.setIconStyle("piloterqualitebutton");
          piloterQualiteButton.setScale(Style.ButtonScale.LARGE);
          
          piloterQualiteButton.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                PiloterQualiteForm  piloterQualiteForm=new PiloterQualiteForm();
                MainScreen.addTab("Piloter la qualite", piloterQualiteForm);
            }
        
        
        
        });
         
          
          genererRapportPiloterQualiter.setIconStyle("rapportqualitebutton");
          genererRapportPiloterQualiter.setScale(Style.ButtonScale.LARGE);
          
          genererRapportPiloterQualiterGeneral.setIconStyle("rapportqualitebuttongeneral");
          genererRapportPiloterQualiterGeneral.setScale(Style.ButtonScale.LARGE);
          
          piloterQualiteContentPanel.add(piloterQualiteButton,new RowData(1,-1,new Margins(5,5,10,5)));
          piloterQualiteContentPanel.add(genererRapportPiloterQualiter,new RowData(1,-1,new Margins(5,5,10,5)));
          piloterQualiteContentPanel.add(genererRapportPiloterQualiterGeneral,new RowData(1,-1,new Margins(5,5,10,5)));
          
          
          ContentPanel commercialContentPanel = new ContentPanel();
          commercialContentPanel.setHeading("COMMERCIAL");
          commercialContentPanel.setIconStyle("iconcommercial");
          commercialContentPanel.setLayout(new RowLayout());
          
          prospectionButton.setIconStyle("prospection-button");
          prospectionButton.setScale(Style.ButtonScale.LARGE);
          
           prospectionButton.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                /*ProspectionWindow prospection=new ProspectionWindow();
                prospection.show();*/
                
                ProspectionForm prospectionForm=new ProspectionForm();
                MainScreen.addTab("Prospection", prospectionForm);
            }
        
        
        
        });
          
          
          clientsButton.setIconStyle("clients-button");
          clientsButton.setScale(Style.ButtonScale.LARGE);
          clientsButton.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                ClientForm  clientForm=new ClientForm();
                MainScreen.addTab("Client", clientForm);
            }
        
        
        
        });
          
          
          commandesButton.setIconStyle("commandes-button");
          commandesButton.setScale(Style.ButtonScale.LARGE);
          
          
          factureButton.setIconStyle("factures-button");
          factureButton.setScale(Style.ButtonScale.LARGE);
          
          /*recapButton.setScale(Style.ButtonScale.LARGE);
          recapButton.addSelectionListener(new SelectionListener(){
            @Override
            public void componentSelected(ComponentEvent ce) {
                
                SapressiPopup  sapressiPopup =new SapressiPopup();
                sapressiPopup.show();
                
            }
        });*/

          
          commercialContentPanel.add(prospectionButton,new RowData(1,-1,new Margins(5,5,10,5)));
          commercialContentPanel.add(clientsButton,new RowData(1,-1,new Margins(5,5,10,5)));
          commercialContentPanel.add(commandesButton,new RowData(1,-1,new Margins(5,5,10,5)));
          commercialContentPanel.add(factureButton,new RowData(1,-1,new Margins(5,5,10,5)));
          //commercialContentPanel.add(recapButton,new RowData(1,-1,new Margins(5,5,10,5)));
          
          
          
          
        
          leftSideBarPanel.add(setupContentPanel);
          leftSideBarPanel.add(piloterQualiteContentPanel);
          leftSideBarPanel.add(commercialContentPanel);
         
         return leftSideBarPanel;
    }
    
}
