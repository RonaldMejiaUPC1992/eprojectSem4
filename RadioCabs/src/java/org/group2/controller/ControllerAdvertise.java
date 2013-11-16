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
public class ControllerAdvertise extends AbstractController {
    
    public ControllerAdvertise() {
        super(RegisteredUnit.class);
    }
    
    @Override
    public List getList() {        
        return super.getList("registeredTypeID = 3");
    }

    @Override
    public void create(ActionEvent evt) {
        ((RegisteredUnit)selected).setRegisteredType(new RegisteredType(3, null));
        super.create(evt);
    }
}