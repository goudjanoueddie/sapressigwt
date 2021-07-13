/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.components;

import com.extjs.gxt.ui.client.Registry;
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
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.jdeveloper.client.MainScreen;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.dto.ClientDTO;
import org.jdeveloper.client.dto.ParametreentrepriseDTO;
import org.jdeveloper.client.dto.ParametremanagerDTO;
import org.jdeveloper.client.form.EmployeeForm;
import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class RightNavigationPanel extends ContentPanel {
    
    private Button modifierCibleManagerEntreprise=new Button("Manager Entreprise");
    private Button modifierCiblePiloterQualiter = new Button("Qualite");
    private Button modifierCibleCommercial = new Button("Commercial");
    private Button modifierCibleFormation = new Button("Formation");
    private Button modifierCibleControle = new Button("Contrôle");
    private Button modifierEquipement = new Button("Equipement");
    private Button modifierAchatEtInfrastructure = new Button("Achat & Infrastructure");
    private Button modifierGRH =new Button("GRH");
    
    private Button demandeConvertieCommandeButton = new Button("TDCC");
    
    private Button ajouterGroupe=new Button("Ajouter Groupe");
    private Button ajouterUser = new Button("Ajouter Utilisateur");
    private Button ajouterEmployeeButton=new Button("Ajouter Employe");
    private Button chercherButton=new Button("Chercher");
    private Button deleteButton=new Button("Delete");
    
    
    
    GWTServiceAsync SapressiService = Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    
        AsyncCallback<ParametreentrepriseDTO> callBackgetParameter = new AsyncCallback<ParametreentrepriseDTO>(){
            
        @Override
        public void onFailure(Throwable caught) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        

        @Override
        public void onSuccess(ParametreentrepriseDTO result) {
            
            CibleCommercialWindows cibleCommandeWindows = new CibleCommercialWindows();
            cibleCommandeWindows.getCibleCommercialForm().getTauxDeCommandesObtenuesApresProspection().setValue(result.getTcoap().toString());
            cibleCommandeWindows.getCibleCommercialForm().getNombreDeNouveauxClients().setValue(result.getNc().toString());
            cibleCommandeWindows.getCibleCommercialForm().getTauxDeDemandeConvertiesEnCommande().setValue(result.getTdcc().toString());
            cibleCommandeWindows.getCibleCommercialForm().getTauxDeFacturationDesTravauxRealises().setValue(result.getTftr().toString());
            cibleCommandeWindows.getCibleCommercialForm().getTauxDePrevisionChiffreAffaire().setValue(result.getTpca().toString());
            cibleCommandeWindows.getCibleCommercialForm().getTauxDeRealisationDuChiffreAffaireReel().setValue(result.getTrcar().toString());
            cibleCommandeWindows.show();
        }
            
        };
        
        AsyncCallback<ParametremanagerDTO> callBackgetParameterManager = new AsyncCallback<ParametremanagerDTO>(){
            
        @Override
        public void onFailure(Throwable caught) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onSuccess(ParametremanagerDTO result) {
            CibleManagerEntrepriseWindows CibleManagerEntrepriseWindows = new CibleManagerEntrepriseWindows();
            CibleManagerEntrepriseWindows.getCibleManagerEntrepriseForm().getNiveauderealisationdesobjectifsoperationnels().setValue(result.getNrdoo().toString());
            CibleManagerEntrepriseWindows.getCibleManagerEntrepriseForm().getTauxdecreancesrecouvrees().setValue(result.getTcr().toString());
            CibleManagerEntrepriseWindows.getCibleManagerEntrepriseForm().getTauxdereglementcreancesdesfournisseurs().setValue(result.getTrcf().toString());
            CibleManagerEntrepriseWindows.getCibleManagerEntrepriseForm().getTauxderentabilitefinanciere().setValue(result.getTrf().toString());
            CibleManagerEntrepriseWindows.getCibleManagerEntrepriseForm().getTauxdesatisfactiondesclients().setValue(result.getTsdc().toString());
            CibleManagerEntrepriseWindows.getCibleManagerEntrepriseForm().getTauxexecutiondubudget().setValue(result.getTeb().toString());
            CibleManagerEntrepriseWindows.show();
        }
        
        };

    
    
    
    public RightNavigationPanel(){
        setLayout(new FitLayout());
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
                 SapressiService.getParametreManager(callBackgetParameterManager);
            }
        });
       
        setupContentPanel.add(modifierCibleManagerEntreprise,new RowData(1,-1,new Margins(5,5,10,5)));
        
        modifierCiblePiloterQualiter.setIconStyle("seuilPiloterQualiterCss");
        modifierCiblePiloterQualiter.setScale(Style.ButtonScale.LARGE);
        modifierCiblePiloterQualiter.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                 CibleQualiteWindows cibleQualiteWindows = new CibleQualiteWindows();
                 cibleQualiteWindows.show();
            }
        });
        setupContentPanel.add(modifierCiblePiloterQualiter,new RowData(1,-1,new Margins(5,5,10,5)));
        
        
        modifierCibleCommercial.setIconStyle("seuilCommercial");
        modifierCibleCommercial.setScale(Style.ButtonScale.LARGE);
        modifierCibleCommercial.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                 SapressiService.getParametreEntreprise(callBackgetParameter);
            }
        });
        setupContentPanel.add(modifierCibleCommercial,new RowData(1,-1,new Margins(5,5,10,5)));
        
        
        modifierCibleFormation.setIconStyle("seuilFormation");
        modifierCibleFormation.setScale(Style.ButtonScale.LARGE);
        modifierCibleFormation.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                 
            }
        });
        setupContentPanel.add(modifierCibleFormation,new RowData(1,-1,new Margins(5,5,10,5)));
        
        
        modifierCibleControle.setIconStyle("seuilControl");
        modifierCibleControle.setScale(Style.ButtonScale.LARGE);
        modifierCibleControle.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                 
            }
        });
        setupContentPanel.add(modifierCibleControle,new RowData(1,-1,new Margins(5,5,10,5)));
        
        
        modifierEquipement.setIconStyle("seuilEquipement");
        modifierEquipement.setScale(Style.ButtonScale.LARGE);
        modifierEquipement.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                 
            }
        });
        setupContentPanel.add(modifierEquipement,new RowData(1,-1,new Margins(5,5,10,5)));
        
        modifierAchatEtInfrastructure.setIconStyle("seuilAchatEtInfrastructure");
        modifierAchatEtInfrastructure.setScale(Style.ButtonScale.LARGE);
        modifierAchatEtInfrastructure.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                 
            }
        });
        setupContentPanel.add(modifierAchatEtInfrastructure,new RowData(1,-1,new Margins(5,5,10,5)));
        
        modifierGRH.setIconStyle("seuilGRH");
        modifierGRH.setScale(Style.ButtonScale.LARGE);
        modifierGRH.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                 
            }
        });
        setupContentPanel.add(modifierGRH,new RowData(1,-1,new Margins(5,5,10,5)));
        
        
        
        
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
        
        ContentPanel managerEntrepriseContentPanel = new ContentPanel();
        managerEntrepriseContentPanel.setHeading("MANAGER ENTREPRISE");
        managerEntrepriseContentPanel.setIconStyle("iconnavileft1");
        managerEntrepriseContentPanel.setLayout(new RowLayout());
        
        
        
        ContentPanel piloterQualiteContentPanel =new ContentPanel();
        piloterQualiteContentPanel.setHeading("PILOTER QUALITE");
        piloterQualiteContentPanel.setIconStyle("iconpiloterqualite");
        piloterQualiteContentPanel.setLayout(new RowLayout());
        
        ContentPanel commercialContentPanel = new ContentPanel();
        commercialContentPanel.setHeading("COMMERCIAL");
        commercialContentPanel.setIconStyle("iconcommercial");
        commercialContentPanel.setLayout(new RowLayout());
        
        demandeConvertieCommandeButton.setIconStyle("demandeConvertie");
        demandeConvertieCommandeButton.setScale(Style.ButtonScale.LARGE);
        demandeConvertieCommandeButton.setToolTip("Taux de demande converties en commandes");
       
        commercialContentPanel.add(demandeConvertieCommandeButton,new RowData(1,-1,new Margins(5,5,10,5))) ;
      
        rightSideBarPanel.add(setupContentPanel);
        rightSideBarPanel.add(ajoutProfilContentPanel);
        rightSideBarPanel.add(managerEntrepriseContentPanel);
        rightSideBarPanel.add(piloterQualiteContentPanel);
        rightSideBarPanel.add(commercialContentPanel);
        return rightSideBarPanel;
    
    }
    
    
    
}