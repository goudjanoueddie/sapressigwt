
package org.jdeveloper.client.form;


import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import org.jdeveloper.client.MainEntryPoint;
import org.jdeveloper.client.components.SapressiPopup;


public class ManagerEntrepriseForm extends FormPanel{
    
    TextField<Integer> nombreobjectifatteint=new TextField<Integer>();
    TextField<Integer> totalobjectif=new TextField<Integer>();
    
    TextField<Integer> chiffreaffairerealisee=new TextField<Integer>();
    TextField<Integer> charges=new TextField<Integer>();
    
    TextField<Integer> budgetrealise= new TextField<Integer>();
    TextField<Integer> budgetplanifie=new TextField<Integer>();
    
    TextField<Integer> creancerecouvrees=new TextField<Integer>();
    TextField<Integer> montantplanifie=new TextField<Integer>();
    
    
    TextField<Integer> montantfacturepayedansdelai =new TextField<Integer>();
    TextField<Integer> montanttotalfactureechues = new TextField<Integer>();
    
    SimpleComboBox periode=new SimpleComboBox();
    
    TextArea niveauderealisationdesobjectifs = new TextArea();
    
    TextArea tauxderentabilitefinanciere = new TextArea();
    
    TextArea tauxexecutionbudget =new TextArea();
    
    TextArea tauxcreancerecouvree=new TextArea();
    
    TextArea tauxdereglementdescreancesfournisseurs=new TextArea();
    
    
    final SapressiPopup sapressiPopup=new SapressiPopup() ;
    
    Button calculerButton=new Button("");
    Button saveButton=new Button("");
    Button genererRapportButton=new Button("");
    
    
    private void createForm(){
    
        setFrame(true);
        setHeading("MANAGER L'ENTREPRISE");
        
        setLabelAlign(LabelAlign.TOP);
        setButtonAlign(HorizontalAlignment.CENTER);
        
        LayoutContainer main=new LayoutContainer();
        main.setLayout(new ColumnLayout());
        
        LayoutContainer left=new LayoutContainer();
        left.setStyleAttribute("paddingRight", "10px");
        FormLayout layout=new FormLayout();
        layout.setLabelAlign(LabelAlign.TOP);
        left.setLayout(layout);
        
        LayoutContainer right=new LayoutContainer();
        right.setStyleAttribute("paddingLeft", "10px");
        layout = new FormLayout();
        layout.setLabelAlign(LabelAlign.TOP);
        right.setLayout(layout);
        
        
        FormData formData=new FormData("100%");
        
        nombreobjectifatteint.setFieldLabel("Nombre d'objectifs atteints");
        left.add(nombreobjectifatteint,formData);
        
        totalobjectif.setFieldLabel("Total des objectifs");
        right.add(totalobjectif,formData);
        
        
        
        chiffreaffairerealisee.setFieldLabel("Chiffre d'affaire realisee");
        left.add(chiffreaffairerealisee,formData);
        
        charges.setFieldLabel("Charges");
        right.add(charges,formData);
        
         budgetrealise.setFieldLabel("Budget Realise");
        left.add(budgetrealise,formData);
        
         budgetplanifie.setFieldLabel("budget planifie");
        right.add(budgetplanifie,formData);
        
        creancerecouvrees.setFieldLabel("Creance recouvree");
        left.add(creancerecouvrees,formData);
       
        montantplanifie.setFieldLabel("Montant Planifie");
        right.add(montantplanifie,formData);
        
        montantfacturepayedansdelai.setFieldLabel("Montant Facture Paye dans les delais");
        left.add(montantfacturepayedansdelai,formData);
        
        montanttotalfactureechues.setFieldLabel("Montant total des factures echues");
        right.add(montanttotalfactureechues,formData);
        
        periode.setFieldLabel("Mois");
        
        
        periode.add("JANVIER");
        periode.add("FEVRIER");
        periode.add("MARS");
        periode.add("AVRIL");
        periode.add("MAI");
        periode.add("JUIN");
        periode.add("JUILLET");
        periode.add("AOUT");
        periode.add("SEPTEMBRE");
        periode.add("OCTOBRE");
        periode.add("NOVEMBRE");
        periode.add("DECEMBRE");
        
       add(periode);
       
       niveauderealisationdesobjectifs.setFieldLabel("Niveau de realisation des objectifs");
       
       tauxderentabilitefinanciere.setFieldLabel("Taux de rentabilite financiere");
       
       tauxexecutionbudget.setFieldLabel("Taux d'execution budget");
       
       tauxcreancerecouvree.setFieldLabel("Taux creance recouvree");
       
       tauxdereglementdescreancesfournisseurs.setFieldLabel("Taux de reglement des creances fournisseurs");
       left.add(niveauderealisationdesobjectifs);
       right.add(tauxderentabilitefinanciere);
       
       left.add(tauxexecutionbudget);
       right.add(tauxcreancerecouvree);
       
       left.add(tauxdereglementdescreancesfournisseurs);
               
        
       main.add(left, new ColumnData(.5));
       main.add(right, new ColumnData(.5));
        
        
        add(main, new FormData("100%"));
        
        
        //resultat.add(niveauderealisationdesobjectifs);
        
        
        //resultat.add(tauxderentabilitefinanciere);
        
        ToolTipConfig calculerButtonToolTipConfig=new ToolTipConfig();
        calculerButtonToolTipConfig.setTitle("Calculer");
        calculerButtonToolTipConfig.setText("Ce bouton vous permet d'effectuer les calculs");
        
        calculerButton.setToolTip(calculerButtonToolTipConfig);
        calculerButton.setIconAlign(Style.IconAlign.TOP);
        calculerButton.setIconStyle("calculer-button");
        calculerButton.setScale(Style.ButtonScale.LARGE);
        
        calculerButton.addSelectionListener(new SelectionListener(){

            @Override
            public void componentSelected(ComponentEvent ce) {
                Integer niveaurealisationobjectifoperationnel=0;
                
                niveaurealisationobjectifoperationnel = (nombreobjectifatteint.getValue()/totalobjectif.getValue()) * 100;
                //niveauderealisationdesobjectifs.setValue(Integer.toString(niveaurealisationobjectifoperationnel));
                
                int valeurToshow=Integer.parseInt(niveaurealisationobjectifoperationnel.toString());
                montantfacturepayedansdelai.setValue(valeurToshow);
                
               
            }
        
        
        
        });
        
        ToolTipConfig saveButtonToolTipConfig=new ToolTipConfig();
        saveButtonToolTipConfig.setTitle("Enregistrer Valeur");
        saveButtonToolTipConfig.setText("Ce bouton vous permet d'enregistrer les valeurs dans la base de données");
        
        saveButton.setToolTip(saveButtonToolTipConfig);
        saveButton.setIconAlign(Style.IconAlign.TOP);
        saveButton.setIconStyle("save-button");
        saveButton.setScale(Style.ButtonScale.LARGE);
        
        ToolTipConfig genererRapportQualiteToolTipConfig=new ToolTipConfig();
        genererRapportQualiteToolTipConfig.setTitle("Generer Rapport");
        genererRapportQualiteToolTipConfig.setText("Ce bouton vous permet de generer le rapport Mensuel");
        
        genererRapportButton.setToolTip(genererRapportQualiteToolTipConfig);
        genererRapportButton.setIconAlign(Style.IconAlign.TOP);
        genererRapportButton.setIconStyle("generer-rapport-button");
        genererRapportButton.setScale(Style.ButtonScale.LARGE);
        
       
        
        addButton(calculerButton);
        addButton(saveButton);
        addButton(genererRapportButton);
    
    }
    
    public ManagerEntrepriseForm(){
    
        createForm();
        
        calculerButton.addListener(Events.Select,new Listener<ButtonEvent>(){
            
            @Override
            public void handleEvent(ButtonEvent be) {
                //sapressiPopup.show();
            }
        
        
        });
    }
    
    
    
    
    
}
