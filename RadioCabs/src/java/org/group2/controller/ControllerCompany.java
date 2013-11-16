/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.group2.entity.RegisteredType;
import org.group2.entity.RegisteredUnit;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@ViewScoped
public class ControllerCompany extends AbstractController {
    
    public ControllerCompany(){
        super(RegisteredUnit.class);
    }

    @Override
    public List getList() {        
        return super.getList("registeredTypeID = 1");
    }

    @Override
    public void create(ActionEvent evt) {
        ((RegisteredUnit)selected).setRegisteredType(new RegisteredType(1, null));
        super.create(evt);
    }
    
    
}
/*public class ControllerCompany {

    public ControllerCompany() {   
        selected = new RegisteredUnit();
    }
    
    RegisteredUnit selected;
    List<RegisteredUnit> list;

    public RegisteredUnit getSelected() {
        return selected;
    }

    public void setSelected(RegisteredUnit selected) {
        this.selected = selected;
    }

    public List<RegisteredUnit> getList() {
        if(list==null){
            list = new ModelCompany(RegisteredUnit.class).getAll();
        }
        return list;
    }

    public void setList(List<RegisteredUnit> list) {
        this.list = list;
    }
    
    public void prepareCreate(ActionEvent evt){
        selected = new RegisteredUnit();        
    }

    public void create(ActionEvent evt) {               
        ModelCompany model = new ModelCompany(RegisteredUnit.class);
        model.add(selected);
        list = null;
        JsfUtil.addSuccessMessage("Create");
    }

    public void update(ActionEvent evt) {
        ModelCompany model = new ModelCompany(RegisteredUnit.class);
        model.update(selected);
        JsfUtil.addSuccessMessage("Update");
    }

    public void delete(ActionEvent evt) {
        ModelCompany model = new ModelCompany(RegisteredUnit.class);
        model.delete(selected);
        list = null;
        JsfUtil.addSuccessMessage("Delete");        
    }
}*/