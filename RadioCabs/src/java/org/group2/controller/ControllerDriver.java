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
@ManagedBean(name="controllerDriver")
@ViewScoped
public class ControllerDriver extends AbstractController {

    public ControllerDriver(){
        super(RegisteredUnit.class);
    }

    @Override
    public List getList() {        
        return super.getList("registeredTypeID = 2");
    }

    @Override
    public void create(ActionEvent evt) {
        ((RegisteredUnit)selected).setRegisteredType(new RegisteredType(2, null));
        super.create(evt);
    }
    
}
