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
public class CibleCommandeForm extends FormPanel {
    
    private final TextField <String> TauxDeDemandeConvertiesEnCommande = new TextField<String>();
    private final TextField <String>  NombreDeNouveauxClients = new TextField<String> ();
    private final TextField <String> TauxDeCommandesObtenuesApresProspection = new TextField<String>();
    private final TextField <String> TauxDePrevisionChiffreAffaire = new TextField<String>();
    private final TextField <String> TauxDeFacturationDesTravauxRealises = new TextField<String>();
    private final TextField <String> TauxDeRealisationDuChiffreAffaireReel = new TextField<String>();
    
    final GWTServiceAsync SapressiService = Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    
    final AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
        
        MessageBox messageBox = new MessageBox();
        
        @Override
        public void onFailure(Throwable caught) {
            messageBox.setMessage("Impossible d'effectuer cet enregistrement");
            messageBox.show();
        }

        @Override
        public void onSuccess(Boolean result) {
            
            if(result){
                messageBox.setMessage("Enregistrement effectué avec succès");
            
            }else{
                messageBox.setMessage("Impossible d'effectuer cet enregistrement");
            }
            
            messageBox.show();
        }
    };
    
    public CibleCommandeForm(){
        
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
                
        TauxDeRealisationDuChiffreAffaireReel.setFieldLabel("RCAR"); 
        TauxDeRealisationDuChiffreAffaireReel.setToolTip("Realisation Du Chiffre Affaire Reel");
                
        add(TauxDeDemandeConvertiesEnCommande);
        add(NombreDeNouveauxClients);
        add(TauxDeCommandesObtenuesApresProspection);
        add(TauxDePrevisionChiffreAffaire);
        add(TauxDeFacturationDesTravauxRealises);
        add(TauxDeRealisationDuChiffreAffaireReel);
    }
    
}
