
 
package org.jdeveloper.client;


import org.jdeveloper.client.components.MainPanel;
import org.jdeveloper.client.components.RightNavigationPanel;
import org.jdeveloper.client.components.LeftNavigationPanel;
import org.jdeveloper.client.form.ManagerEntrepriseForm;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
//import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
//import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;


public class HomePageOwn extends ContentPanel{
    
     private final static TabPanel tabPanel = new TabPanel();
     BorderLayoutData mainContentsLayoutData =new BorderLayoutData(Style.LayoutRegion.CENTER);
     Viewport viewport=new Viewport();
     private final static MainEntryPoint INSTANCE=new MainEntryPoint();
    
    public HomePageOwn(){
    
       
        
    }
    
    
    
    public ContentPanel getMainContents(){
        
        MainPanel mainPanel=new MainPanel();
        tabPanel.setMinTabWidth(115);
        tabPanel.setTabScroll(true);
        tabPanel.setCloseContextMenu(true);
        
        BorderLayoutData mainContentsLayoutData=new BorderLayoutData(LayoutRegion.CENTER);
        mainContentsLayoutData.setMargins(new Margins(0));
        mainPanel.add(tabPanel,mainContentsLayoutData);
        return mainPanel;
    }
    
    public ContentPanel getRightSideBar(){
        
        RightNavigationPanel rightSidebarPanel = new RightNavigationPanel();
        return rightSidebarPanel;
        
    }
    
    public ContentPanel getLeftSideBar(){
        
       
       LeftNavigationPanel leftSidebarPanel=new LeftNavigationPanel();
       leftSidebarPanel.setBodyBorder(true);
       leftSidebarPanel.setLayout(new AccordionLayout());
       
       ContentPanel setupContentPanel=new ContentPanel();
       setupContentPanel.setHeading("Manager L'entreprise");
       setupContentPanel.setLayout(new RowLayout());
       
       Button managerEntrepriseButton=new Button("Manager L'entreprise",new SelectionListener<ButtonEvent>() {
           
        @Override
        public void componentSelected(ButtonEvent ce)
        {
        ManagerEntrepriseForm managerEntrepriseForm = new ManagerEntrepriseForm();
        addTab("Manager L'entreprise",managerEntrepriseForm);
        }
        });
       
       setupContentPanel.add(managerEntrepriseButton,new RowData(1,-1,new Margins(5,5,5,5)));
       
       
       
       leftSidebarPanel.add(setupContentPanel);
    
        return leftSidebarPanel;
        
    }
    
    public VerticalPanel getFooter(){
        
      VerticalPanel footerPanel = new VerticalPanel();
       footerPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
       Label label = new Label("Design by JDEVELOPER.Copyright © JDEVELOPER.");
       footerPanel.add(label);
       return footerPanel;
    
    }
    
    private void addTab(String text,ContentPanel contentPanel){
    
        TabItem item=new TabItem();
        item.setText(text);
        item.setClosable(true);
        item.add(contentPanel);
        tabPanel.add(item);
        tabPanel.setSelection(item);
    
    }
    
    
}
