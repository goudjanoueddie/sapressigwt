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
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import org.jdeveloper.client.SapressiConstant;
import org.jdeveloper.client.form.ModifyClientForm;
import org.jdeveloper.client.rpc.GWTServiceAsync;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.jdeveloper.client.dto.ClientDTO;
import static org.jdeveloper.client.form.ModifyClientForm.clientId;

/**
 *
 * @author goudjanou
 */
public class ModifyClientWindow extends Window{
    
    private ModifyClientForm modifyClientForm = new ModifyClientForm();
    GWTServiceAsync SapressiService = Registry.get(SapressiConstant.SAPRESSI_SERVICE);
    private final Button btnModifier = new Button("");
    
    AsyncCallback<ClientDTO> callBackFind = new AsyncCallback<ClientDTO>(){
        @Override
        public void onFailure(Throwable caught) {
            MessageBox messageBox = new MessageBox();
            messageBox.setMessage("Une erreur est survenue!!!");
            messageBox.show();
        }

        @Override
        public void onSuccess(ClientDTO result) {
            
            ClientDTO clientDTO;
            clientDTO = result;
            MessageBox messageBox = new MessageBox();
            
            if(result !=null){ 
                ModifyClientWindowFinal modifyClientWindowFinal = new ModifyClientWindowFinal();
                modifyClientWindowFinal.getClientForm().getNom().setValue(result.getNomClient());
                modifyClientWindowFinal.getClientForm().getAdresse().setValue(result.getAdresse());
                modifyClientWindowFinal.getClientForm().getTelephone().setValue(result.getTelephone());
                modifyClientWindowFinal.getClientForm().getCourriel().setValue(result.getCourriel());
                modifyClientWindowFinal.getClientForm().getLocalisation().setValue(result.getLocalisation());
                modifyClientWindowFinal.getClientForm().getActivites().setValue(result.getActivites());
                modifyClientWindowFinal.getClientForm().getNom_correspondant().setValue(result.getCorrespondant());
                modifyClientWindowFinal.getClientForm().getFonction_correpondant().setValue(result.getFonctionCorrespondant());
                modifyClientWindowFinal.getClientForm().getContact_correspondant().setValue(result.getContactCorrespondant());
                modifyClientWindowFinal.getClientForm().getCourriel_correspondant().setValue(result.getCourrielCorrespondant());
                modifyClientWindowFinal.show();
                hide();
            }else {
                messageBox.setMessage("Aucun client trouve");
                messageBox.show();
            }
            
        }
    
    };
    
    public ModifyClientWindow(){
        
        setHeading("Chercher Client");
        setSize(400,120);
        setBorders(true);
        setResizable(false);
        //setLayout(new FitLayout());
        ToolTipConfig modifierButtonToolTipConfig=new ToolTipConfig();
        modifierButtonToolTipConfig.setTitle("Chercher");
        modifierButtonToolTipConfig.setText("Ce bouton vous permet de chercher un client");
        
        btnModifier.setToolTip(modifierButtonToolTipConfig);
        btnModifier.setIconAlign(Style.IconAlign.TOP);
        btnModifier.setIconStyle("searchCss");
        btnModifier.setScale(Style.ButtonScale.LARGE);
        
        
        handlebtnModifierButton();
        addButton(btnModifier);
    
    }
    
    protected void onRender(Element parent ,int pos){
        super.onRender(parent, pos);
        add(modifyClientForm);
    }
    
    private void handlebtnModifierButton(){
    
        btnModifier.addSelectionListener(new SelectionListener(){
            
            @Override
            public void componentSelected(ComponentEvent ce) {
                SapressiService.findCLient(clientId, callBackFind);
            }
        
        
        });
    
    }
    
}
