/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class CibleManagerEntrepriseForm extends FormPanel{
    
    TextField <String> Niveauderealisationdesobjectifsoperationnels = new TextField<String>();
    TextField <String> Tauxderentabilitefinanciere = new TextField<String>();
    TextField <String> Tauxexecutiondubudget = new TextField<String>();
    TextField <String> Tauxdecreancesrecouvrees = new TextField<String>(); 
    TextField <String> Tauxdereglementcreancesdesfournisseurs  = new TextField<String>(); //
    TextField <String> Tauxdesatisfactiondesclients  = new TextField<String>();
    
    final GWTServiceAsync SapressiService = Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    
    final AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
        
        MessageBox messageBox = new MessageBox();
        
        @Override
        public void onFailure(Throwable caught) {
            messageBox.setMessage("Impossible d'effectuer cette modification");
            messageBox.show();
        }

        @Override
        public void onSuccess(Boolean result) {
            
            if(result){
                messageBox.setMessage("Modification effectuée avec succès");
            
            }else{
                messageBox.setMessage("Impossible d'effectuer cette modification");
            }
            
            messageBox.show();
        }
    };
    
    
    public CibleManagerEntrepriseForm(){
        
        setHeaderVisible(false);
        
        Niveauderealisationdesobjectifsoperationnels.setFieldLabel("NRDOO");
        Niveauderealisationdesobjectifsoperationnels.setToolTip("Niveau de Realisation des Objectifs Operationnels");
        
        Tauxderentabilitefinanciere.setFieldLabel("TRF");
        Tauxderentabilitefinanciere.setToolTip("Taux de rentabilite financiere");
        
        Tauxexecutiondubudget.setFieldLabel("TEB");
        Tauxexecutiondubudget.setToolTip("Taux Execution Du Budget");
        
        Tauxdecreancesrecouvrees.setFieldLabel("TCR");
        Tauxdecreancesrecouvrees.setToolTip("Taux de creances recouvrees");
        
        Tauxdereglementcreancesdesfournisseurs.setFieldLabel("TRCF");
        Tauxdereglementcreancesdesfournisseurs.setToolTip("Taux de reglement creances des fournisseurs");
        
        Tauxdesatisfactiondesclients.setFieldLabel("TSDC");
        Tauxdesatisfactiondesclients.setToolTip("Taux de satisfaction des clients");
        
        add(Niveauderealisationdesobjectifsoperationnels);
        add(Tauxderentabilitefinanciere);
        add(Tauxexecutiondubudget);
        add(Tauxdecreancesrecouvrees);
        add(Tauxdereglementcreancesdesfournisseurs);
        add(Tauxdesatisfactiondesclients);
       
    }

    public TextField<String> getNiveauderealisationdesobjectifsoperationnels() {
        return Niveauderealisationdesobjectifsoperationnels;
    }

    public void setNiveauderealisationdesobjectifsoperationnels(TextField<String> Niveauderealisationdesobjectifsoperationnels) {
        this.Niveauderealisationdesobjectifsoperationnels = Niveauderealisationdesobjectifsoperationnels;
    }

    public TextField<String> getTauxderentabilitefinanciere() {
        return Tauxderentabilitefinanciere;
    }

    public void setTauxderentabilitefinanciere(TextField<String> Tauxderentabilitefinanciere) {
        this.Tauxderentabilitefinanciere = Tauxderentabilitefinanciere;
    }

    public TextField<String> getTauxexecutiondubudget() {
        return Tauxexecutiondubudget;
    }

    public void setTauxexecutiondubudget(TextField<String> Tauxexecutiondubudget) {
        this.Tauxexecutiondubudget = Tauxexecutiondubudget;
    }

    public TextField<String> getTauxdecreancesrecouvrees() {
        return Tauxdecreancesrecouvrees;
    }

    public void setTauxdecreancesrecouvrees(TextField<String> Tauxdecreancesrecouvrees) {
        this.Tauxdecreancesrecouvrees = Tauxdecreancesrecouvrees;
    }

    public TextField<String> getTauxdereglementcreancesdesfournisseurs() {
        return Tauxdereglementcreancesdesfournisseurs;
    }

    public void setTauxdereglementcreancesdesfournisseurs(TextField<String> Tauxdereglementcreancesdesfournisseurs) {
        this.Tauxdereglementcreancesdesfournisseurs = Tauxdereglementcreancesdesfournisseurs;
    }

    public TextField<String> getTauxdesatisfactiondesclients() {
        return Tauxdesatisfactiondesclients;
    }

    public void setTauxdesatisfactiondesclients(TextField<String> Tauxdesatisfactiondesclients) {
        this.Tauxdesatisfactiondesclients = Tauxdesatisfactiondesclients;
    }
    
}
