/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.menu.MenuBarItem;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.jdeveloper.client.components.LeftNavigationPanel;
import org.jdeveloper.client.components.MainPanel;
import org.jdeveloper.client.components.NavigationToolBar;
import org.jdeveloper.client.components.RightNavigationPanel;
import org.jdeveloper.client.portlet.CommercialNavigationPanel;
import com.google.gwt.user.client.ui.Image;


/**
 *
 * @author goudjanou
 */
public class MainScreen extends ContentPanel {
    
     private final static TabPanel tabPanel = new TabPanel();
     BorderLayoutData mainContentsLayoutData =new BorderLayoutData(Style.LayoutRegion.CENTER);
     Viewport viewport=new Viewport();
     private final static MainScreen INSTANCE=new MainScreen();
    
    
    public MainScreen(){
          
          //setTopComponent(getBanner());
          viewport.add(tabPanel,mainContentsLayoutData);
          BorderLayout layout = new BorderLayout() ; 
          viewport.setLayout(layout);
          BorderLayoutData menuBarToolBarLayoutData=new BorderLayoutData(Style.LayoutRegion.NORTH,130); 
          menuBarToolBarLayoutData.setSplit(false);
          menuBarToolBarLayoutData.setCollapsible(true);
          menuBarToolBarLayoutData.setMargins(new Margins(0,5,5,5));
          BorderLayoutData leftSidebarLayoutData=new BorderLayoutData(Style.LayoutRegion.WEST,200); 
          leftSidebarLayoutData.setSplit(false); 
          leftSidebarLayoutData.setCollapsible(true); 
          leftSidebarLayoutData.setMargins(new Margins(0,5,0,5));
          mainContentsLayoutData.setMargins(new Margins(0));
          BorderLayoutData rightSidebarLayoutData=new BorderLayoutData(Style.LayoutRegion.EAST,200);
          rightSidebarLayoutData.setSplit(false);
          rightSidebarLayoutData.setCollapsible(true);
          rightSidebarLayoutData.setMargins(new Margins(0,5,0,5));
          BorderLayoutData footerLayoutData=new BorderLayoutData(Style.LayoutRegion.SOUTH,20);
          //BorderLayoutData footerLayoutData=new BorderLayoutData(Style.LayoutRegion.SOUTH,130);
          footerLayoutData.setMargins(new Margins(5));
          footerLayoutData.setCollapsible(true);
          tabPanel.setMinTabWidth(115);
          tabPanel.setTabScroll(true);
          tabPanel.setCloseContextMenu(true);
          //viewport.add(getMenuAndToolBar(), menuBarToolBarLayoutData);
          
         
          viewport.add(getBanner(), menuBarToolBarLayoutData);
          viewport.add(getLeftSideBar(), leftSidebarLayoutData);
          viewport.add(getMainContents(), mainContentsLayoutData);
          viewport.add(getRightSideBar(), rightSidebarLayoutData);
          viewport.add(getFooter(), footerLayoutData);
          RootPanel.get().add(viewport);
          
          

    }
    
    public static MainScreen getInstance()
	{	
            return INSTANCE;
	}
    
    public ContentPanel getMainContents(){
        MainPanel mainPanel=new MainPanel();
        return mainPanel;
    }
    
    public ContentPanel getRightSideBar(){
        RightNavigationPanel rightSidebarPanel = new RightNavigationPanel();
        return rightSidebarPanel;    
    }
    
    public ContentPanel getLeftSideBar(){
        
        LeftNavigationPanel leftSidebarPanel=new LeftNavigationPanel();
        return leftSidebarPanel;
    }
    
    public VerticalPanel getFooter(){        
       VerticalPanel footerPanel = new VerticalPanel();
       footerPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
       Label label = new Label("Design by JDEVELOPER.Copyright © JDEVELOPER.");
       footerPanel.add(label);
       return footerPanel;
    }
    
    public  static void addTab(String Text,ContentPanel contentPanel){
    
    TabItem item=new TabItem();
    item.setText(Text);
    item.setClosable(true);
    item.setScrollMode(Style.Scroll.AUTOY);
    item.add(contentPanel);
    
    String tabId=item.getId();
    TabItem existingTab=tabPanel.findItem(tabId,false);
    
    if(existingTab==null){    
    tabPanel.add(item);
    tabPanel.setSelection(item);
    }else{
    
    tabPanel.setSelection(existingTab);
    }
    }
    
    
    private ContentPanel getMenuAndToolBar() {
        CommercialNavigationPanel commercialNavigationPanel = new CommercialNavigationPanel();
        return commercialNavigationPanel;
    }
    
         public ContentPanel getBanner()
        
         {
            ContentPanel bannerPanel = new ContentPanel();
            bannerPanel.add(getMenuBar());     
            VerticalPanel imagePanel = new VerticalPanel();
            imagePanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
            imagePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
            Image imageSapressi=new Image("resources/images/banner5.png");
            imagePanel.add(imageSapressi);            
            bannerPanel.add(imagePanel);
            return bannerPanel;
        }
    
   
    
    private MenuBar getMenuBar(){
        MenuBar menuBar= new MenuBar();
        
        Menu fileMenu=new Menu();
        Menu reportsMenu=new Menu();
        Menu helpMenu=new Menu();
        
        //Items for File menu
        MenuItem productMenuItem=new MenuItem("Product");
        fileMenu.add(productMenuItem);
        MenuItem stockMenuItem=new MenuItem("Stock");
        fileMenu.add(stockMenuItem);
        MenuItem purchaseMenuItem=new MenuItem("Purchase");
        fileMenu.add(purchaseMenuItem);
        MenuItem salesMenuItem=new MenuItem("Sales");
        fileMenu.add(salesMenuItem);
        
        //Items for Reports menu
        MenuItem productListMenuItem=new MenuItem("Product List");
        reportsMenu.add(productListMenuItem);
        MenuItem stockStatusMenuItem=new MenuItem("Stock Status");
        reportsMenu.add(stockStatusMenuItem);
        MenuItem purchaseDetailMenuItem=new MenuItem(
        "Purchase Detail");
        reportsMenu.add(purchaseDetailMenuItem);
        MenuItem salesDetailMenuItem=new MenuItem("Sales Detail");
        reportsMenu.add(salesDetailMenuItem);
        //Items for Help menu
        MenuItem aboutMenuItem=new MenuItem("About");
        helpMenu.add(aboutMenuItem);
        
        MenuBarItem menuBarItemFile=new MenuBarItem("File",fileMenu);
        MenuBarItem menuBarItemReports=
        new MenuBarItem("Reports",reportsMenu);
        MenuBarItem menuBarItemHelp=
        new MenuBarItem("Help",helpMenu);
        
        menuBar.add(menuBarItemFile);
        menuBar.add(menuBarItemReports);
        menuBar.add(menuBarItemHelp);
        
        return menuBar;
    }

    
}
