/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client.form;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.rpc.GWTServiceAsync;

/**
 *
 * @author goudjanou
 */
public class CibleCommercialForm extends FormPanel {
    
     TextField <String> TauxDeDemandeConvertiesEnCommande = new TextField<String>();
     TextField <String>  NombreDeNouveauxClients = new TextField<String> ();
     TextField <String> TauxDeCommandesObtenuesApresProspection = new TextField<String>();
     TextField <String> TauxDePrevisionChiffreAffaire = new TextField<String>();
     TextField <String> TauxDeFacturationDesTravauxRealises = new TextField<String>();
     TextField <String> TauxDeRealisationDuChiffreAffaireReel = new TextField<String>();
    
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
    
    public CibleCommercialForm(){
        
        setHeaderVisible(false);
        
        TauxDeDemandeConvertiesEnCommande.setFieldLabel("TDCC");
        TauxDeDemandeConvertiesEnCommande.setToolTip("Taux De Demande Converties En Commande");
        
        NombreDeNouveauxClients.setFieldLabel("NC");
        NombreDeNouveauxClients.setToolTip("Nouveaux Clients");
                
        TauxDeCommandesObtenuesApresProspection.setFieldLabel("TCOAP");
        TauxDeCommandesObtenuesApresProspection.setToolTip("Taux De Commande Obtenues Apres Prospection");
        
        TauxDePrevisionChiffreAffaire.setFieldLabel("TPCA");
        TauxDePrevisionChiffreAffaire.setToolTip("Taux De Prevision Chiffre Affaire");
                
        TauxDeFacturationDesTravauxRealises.setFieldLabel("TFTR");
        TauxDeFacturationDesTravauxRealises.setToolTip("Taux De Facturation Des Travaux Realises");
                
        TauxDeRealisationDuChiffreAffaireReel.setFieldLabel("TRCAR"); 
        TauxDeRealisationDuChiffreAffaireReel.setToolTip("Taux De Realisation Du Chiffre Affaire Reel");
                
        add(TauxDeDemandeConvertiesEnCommande);
        add(NombreDeNouveauxClients);
        add(TauxDeCommandesObtenuesApresProspection);
        add(TauxDePrevisionChiffreAffaire);
        add(TauxDeFacturationDesTravauxRealises);
        add(TauxDeRealisationDuChiffreAffaireReel);
    }

    public TextField<String> getTauxDeDemandeConvertiesEnCommande() {
        return TauxDeDemandeConvertiesEnCommande;
    }

    public void setTauxDeDemandeConvertiesEnCommande(TextField<String> TauxDeDemandeConvertiesEnCommande) {
        this.TauxDeDemandeConvertiesEnCommande = TauxDeDemandeConvertiesEnCommande;
    }

    public TextField<String> getNombreDeNouveauxClients() {
        return NombreDeNouveauxClients;
    }

    public void setNombreDeNouveauxClients(TextField<String> NombreDeNouveauxClients) {
        this.NombreDeNouveauxClients = NombreDeNouveauxClients;
    }

    public TextField<String> getTauxDeCommandesObtenuesApresProspection() {
        return TauxDeCommandesObtenuesApresProspection;
    }

    public void setTauxDeCommandesObtenuesApresProspection(TextField<String> TauxDeCommandesObtenuesApresProspection) {
        this.TauxDeCommandesObtenuesApresProspection = TauxDeCommandesObtenuesApresProspection;
    }

    public TextField<String> getTauxDePrevisionChiffreAffaire() {
        return TauxDePrevisionChiffreAffaire;
    }

    public void setTauxDePrevisionChiffreAffaire(TextField<String> TauxDePrevisionChiffreAffaire) {
        this.TauxDePrevisionChiffreAffaire = TauxDePrevisionChiffreAffaire;
    }

    public TextField<String> getTauxDeFacturationDesTravauxRealises() {
        return TauxDeFacturationDesTravauxRealises;
    }

    public void setTauxDeFacturationDesTravauxRealises(TextField<String> TauxDeFacturationDesTravauxRealises) {
        this.TauxDeFacturationDesTravauxRealises = TauxDeFacturationDesTravauxRealises;
    }

    public TextField<String> getTauxDeRealisationDuChiffreAffaireReel() {
        return TauxDeRealisationDuChiffreAffaireReel;
    }

    public void setTauxDeRealisationDuChiffreAffaireReel(TextField<String> TauxDeRealisationDuChiffreAffaireReel) {
        this.TauxDeRealisationDuChiffreAffaireReel = TauxDeRealisationDuChiffreAffaireReel;
    }
    
    
    
    
    
    
    
}
