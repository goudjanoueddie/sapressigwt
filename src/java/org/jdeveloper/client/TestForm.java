/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.client;

import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;


public class TestForm extends FormPanel{
    
    
TextField<Integer> branchIdField = new TextField<Integer>();
TextField<String> nameField = new TextField<String>();
TextField<String> locationField = new TextField<String>();
Button findButton=new Button("Find");
Button saveButton=new Button("Save");
Button deleteButton=new Button("Delete");
Button clearButton=new Button("Clear");

private void createForm()
{
branchIdField.setFieldLabel("Branch ID");
branchIdField.setEmptyText("Enter the branch ID");
branchIdField.setAllowBlank(false);
nameField.setFieldLabel("Name");
nameField.setEmptyText("Enter the branch name");
nameField.setAllowBlank(false);
locationField.setFieldLabel("Location");
locationField.setEmptyText("Enter the branch location");
locationField.setAllowBlank(true);
add(branchIdField);
add(nameField);
add(locationField);
addButton(findButton);
addButton(saveButton);
addButton(deleteButton);
addButton(clearButton);
}

public TestForm()
{
setHeading("Branch");
setFrame(true);
setSize(350,200);
createForm();
}

    
}
