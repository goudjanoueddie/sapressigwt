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
public class CibleQualiteForm extends FormPanel{
    
    private final TextField <String> Tauxderealisationdesactivitesplanifiees = new TextField<String>();
    private final TextField <String> Nombredenonconformites = new TextField<String>();
    private final TextField <String> Tauxdecloturedesnonconformites  = new TextField<String>();
    private final TextField <String> Nombredereclamationsetplaintesclients  = new TextField<String>();
    private final TextField <String> Tauxdecloturedesreclamationsetplaintes  = new TextField<String>();
    private final TextField <String> Tauxrealisationdesactionsdamelioration  = new TextField<String>();
    private final TextField <String> Tauxderealisationdesactionsdameliorationdanslesdelais  = new TextField<String>();
    
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
    

    
    
    
    public CibleQualiteForm(){
        
        setHeaderVisible(false);
        
        Tauxderealisationdesactivitesplanifiees.setFieldLabel("TRAP");
        Tauxderealisationdesactivitesplanifiees.setToolTip("Taux de Realisation des Activites Planifiees");
        
        Nombredenonconformites.setFieldLabel("NNC");
        Nombredenonconformites.setToolTip("Nombre de Non Conformites");
        
        Tauxdecloturedesnonconformites.setFieldLabel("TCNC");
        Tauxdecloturedesnonconformites.setToolTip("Taux de cloture des Non conformites");
        
        Nombredereclamationsetplaintesclients.setFieldLabel("NRPC");
        Nombredereclamationsetplaintesclients.setToolTip("Nombre de Reclamations et Plaintes Clients");
        
        Tauxdecloturedesreclamationsetplaintes.setFieldLabel("TCRP");
        Tauxdecloturedesreclamationsetplaintes.setToolTip("Taux de Cloture des Reclamations et Plaintes");
        
        Tauxrealisationdesactionsdamelioration.setFieldLabel("TRAA");
        Tauxrealisationdesactionsdamelioration.setToolTip("Taux de Realisation des Actions d'Amelioration");
        
        Tauxderealisationdesactionsdameliorationdanslesdelais.setFieldLabel("TRAAD");
        Tauxderealisationdesactionsdameliorationdanslesdelais.setToolTip("Taux de Realisation des Actions d'Amelioration dans les Delais");
        
        add(Tauxderealisationdesactivitesplanifiees);
        add(Nombredenonconformites);
        add(Tauxdecloturedesnonconformites);
        add(Nombredereclamationsetplaintesclients);
        add(Tauxdecloturedesreclamationsetplaintes);
        add(Tauxrealisationdesactionsdamelioration);
        add(Tauxderealisationdesactionsdameliorationdanslesdelais);
        
    }
    
    
    
}
