/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.group2.entity.Billing;
import org.group2.entity.RegisteredType;
import org.group2.entity.RegisteredUnit;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author DUONGHM
 */
@ManagedBean(name = "controllerDriver")
@ViewScoped
public class ControllerDriver extends AbstractController implements Serializable {

    public ControllerDriver() {
        super(RegisteredUnit.class);
    }

    @Override
    public List getList() {        
        return super.getList("registeredTypeID = 2");
    }

    @Override
    public void create(ActionEvent evt) {
        ((RegisteredUnit) selected).setRegisteredType(new RegisteredType(2, null));
        super.create(evt);
    }

    @Override
    public void update(ActionEvent evt) {          
        super.update(evt);
    }
    
    

    public List getDisplayList() {
        //return super.createHQLQuery("select r From RegisteredUnit r join r.billings b where r.registeredType.registeredTypeId = 2 and b.expriateDate > CURRENT_DATE() " + condition);
        String hqlQuery = "select r From RegisteredUnit r join r.billings b where r.registeredType.registeredTypeId = 2 and b.expriateDate > CURRENT_DATE() " + condition;                
        return super.createHQLQuery(hqlQuery);
    }
    RegisteredUnit searchedUnit = new RegisteredUnit();
    String condition = "";

    public RegisteredUnit getSearchedUnit() {
        return searchedUnit;
    }

    public void setSearchedUnit(RegisteredUnit searchedUnit) {
        this.searchedUnit = searchedUnit;
    }

    public void searchByName(ActionEvent evt) {
        selected = new RegisteredUnit();        
        condition = " and r.name like '%" + searchedUnit.getName() + "%'";
        condition += " and r.city like '%" + searchedUnit.getCity()+ "%'";
        condition += " and r.telephone like '%" + searchedUnit.getTelephone() + "%'";
        condition += " and r.experience >= " + searchedUnit.getExperience();
    }        
}
