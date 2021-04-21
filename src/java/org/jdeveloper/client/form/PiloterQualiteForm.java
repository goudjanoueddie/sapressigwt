/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;

/**
 *
 * @author goudjanou
 */
public class PiloterQualiteForm extends FormPanel {
    
    TextField<Integer> nombreactivitesrealisees=new TextField<Integer>();
    TextField<Integer> totaldesactivites=new TextField<Integer>();
    
    TextField<Integer> nombredenonconformite=new TextField<Integer>();
    TextField<Integer> nombrereclamationclient=new TextField<Integer>();
    
    TextField<Integer> nombrenccloturees=new TextField<Integer>();
    TextField<Integer> total=new TextField<Integer>();
    
    TextField<Integer> nombrereclamationetplaintescloturees = new  TextField<Integer>();
    TextField<Integer> totalreclamationetplaintescloturees = new TextField<Integer>();
    
    TextField<Integer> nombreactionsrealisees=new TextField<Integer>();
    TextField<Integer> totaldesactionsarealiser=new TextField<Integer>();
    
    TextField<Integer> nombreactionsrealiseesdansdelais=new TextField<Integer>();
    TextField<Integer> totalactionsrealisees=new TextField<Integer>();
    
    SimpleComboBox periode=new SimpleComboBox();
    
    TextArea tauxrealisationactivitesplanifiees=new TextArea();
    TextArea tauxcloturenonconformites=new TextArea();
    TextArea tauxcloturereclamationetplaintes=new TextArea();
    TextArea tauxrealisationactionsamelioration=new TextArea();
    TextArea tauxrealisationactionsameliorationdansdelais=new TextArea();
    
    Button enregistrerButton=new Button("");
    Button genererRapportQualite=new Button("") ;
    Button calculerButton=new Button("");
    
    
    
    
    
    private void createForm(){
        
        setFrame(true);
        setHeading("PILOTER LA QUALITE");
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
        
        nombreactivitesrealisees.setFieldLabel("Nombre d'activités réalisées");
        left.add(nombreactivitesrealisees,formData);
        
        totaldesactivites.setFieldLabel("Total des activités");
        right.add(totaldesactivites,formData);
        
        nombredenonconformite.setFieldLabel("Nombre de non conformité");
        left.add(nombredenonconformite,formData);
        
        nombrereclamationclient.setFieldLabel("Nombre de réclamations clients");
        right.add(nombrereclamationclient,formData);
        
        nombrenccloturees.setFieldLabel("Nombre NC cloturées");
        left.add(nombrenccloturees,formData);
        
        total.setFieldLabel("Total");
        right.add(total,formData);
        
        nombrereclamationetplaintescloturees.setFieldLabel("Nombre réclamations et plaintes cloturées");
        left.add(nombrereclamationetplaintescloturees,formData);
        
        totalreclamationetplaintescloturees.setFieldLabel("Total réclamations et plaintes cloturées");
        right.add(totalreclamationetplaintescloturees,formData);
        
        nombreactionsrealisees.setFieldLabel("Nombre actions réalisées");
        left.add(nombreactionsrealisees,formData);
        
        totaldesactionsarealiser.setFieldLabel("Total des actions a réaliser");
        right.add(totaldesactionsarealiser,formData);
        
        nombreactionsrealiseesdansdelais.setFieldLabel("Nombre actions réalisées dans délais");
        left.add(nombreactionsrealiseesdansdelais,formData);
        
        totalactionsrealisees.setFieldLabel("Total actions realisées");
        right.add(totalactionsrealisees,formData);
        
         
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
        
        tauxrealisationactivitesplanifiees.setFieldLabel("taux de réalisation des activités planifiées");
        left.add(tauxrealisationactivitesplanifiees);
        
        tauxcloturenonconformites.setFieldLabel("taux de cloture de non conformités");
        right.add(tauxcloturenonconformites);
        
        tauxcloturereclamationetplaintes.setFieldLabel("taux de cloture reclamation et plaintes");
        left.add(tauxcloturereclamationetplaintes);
        
        tauxrealisationactionsamelioration.setFieldLabel("taux de realisation actions amelioration");
        right.add(tauxrealisationactionsamelioration);
        
        tauxrealisationactionsameliorationdansdelais.setFieldLabel("taux realisation actions amelioration dans delais");
        left.add(tauxrealisationactionsameliorationdansdelais);
        
        main.add(left, new ColumnData(.5));
        main.add(right, new ColumnData(.5));
        
        
        add(main, new FormData("100%"));
        
        ToolTipConfig calculerButtonToolTipConfig=new ToolTipConfig();
        
        calculerButtonToolTipConfig.setTitle("Enregistrer Valeur");
        calculerButtonToolTipConfig.setText("Ce bouton vous permet d'enregistrer les valeurs dans la base de données");
        
        enregistrerButton.setToolTip(calculerButtonToolTipConfig);
        enregistrerButton.setIconAlign(Style.IconAlign.TOP);
        enregistrerButton.setIconStyle("enregistrer-button-qualite");
        enregistrerButton.setScale(Style.ButtonScale.LARGE);
        
        ToolTipConfig genererRapportQualiteToolTipConfig=new ToolTipConfig();
        genererRapportQualiteToolTipConfig.setTitle("Generer Rapport");
        genererRapportQualiteToolTipConfig.setText("Ce bouton vous permet de generer le rapport Mensuel");
        
        genererRapportQualite.setToolTip(genererRapportQualiteToolTipConfig);
        genererRapportQualite.setIconAlign(Style.IconAlign.TOP);
        genererRapportQualite.setIconStyle("generer-rapport-qualite");
        genererRapportQualite.setScale(Style.ButtonScale.LARGE);
        
        ToolTipConfig calculerButtonQualiteToolTipConfig=new ToolTipConfig();
        calculerButtonQualiteToolTipConfig.setTitle("Calculer");
        calculerButtonQualiteToolTipConfig.setText("Ce bouton vous permet d'effectuer les calculs");
        
        calculerButton.setToolTip(calculerButtonQualiteToolTipConfig);
        calculerButton.setIconAlign(Style.IconAlign.TOP);
        calculerButton.setIconStyle("calculer-button-qualite");
        calculerButton.setScale(Style.ButtonScale.LARGE);
        
        addButton(calculerButton);
        addButton(enregistrerButton);
        addButton(genererRapportQualite);
                
    
    }
    
    
    public PiloterQualiteForm(){
    
        createForm();
    
    }
    
}
