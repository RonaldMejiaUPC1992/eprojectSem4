/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.group2.entity.RegisteredType;
import org.group2.entity.RegisteredUnit;
import org.group2.util.JsfUtil;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@ViewScoped
public class ControllerAdvertise extends AbstractController implements Serializable {

    public ControllerAdvertise() {
        super(RegisteredUnit.class);
    }

    @Override
    public List getList() {
        return super.getList("registeredTypeID = 3");
    }

    @Override
    public void create(ActionEvent evt) {
        ((RegisteredUnit) selected).setRegisteredType(new RegisteredType(3, null));
        super.create(evt);
    }

    public void register(ActionEvent evt) {
        try {
            ((RegisteredUnit) selected).setRegisteredType(new RegisteredType(3, null));
            model.add(selected);
            JsfUtil.addSuccessMessage("contact-form:sucInsert", "Register Success");

            FacesContext context = FacesContext.getCurrentInstance();
            ControllerBilling controllerBilling = (ControllerBilling) context.getApplication().evaluateExpressionGet(context, "#{controllerBilling}", ControllerBilling.class);
            controllerBilling.paidForAdvertise((RegisteredUnit)selected);
            ControllerUploadFile controllerUploadFile = (ControllerUploadFile) context.getApplication().evaluateExpressionGet(context, "#{controllerUploadFile}", ControllerUploadFile.class);
            controllerUploadFile.updateImageForAdvertise((RegisteredUnit)selected);
            
        } catch (Exception ex) {
            JsfUtil.addErrorMessage("contact-form:errInsert", "Cannot register. Please check your information again.");

        }
    }

    public List getDisplayList() {
        String hqlQuery = "select r From RegisteredUnit r join r.billings b where r.registeredType.registeredTypeId = 3 and b.expriateDate > CURRENT_DATE() ";
        return super.createHQLQuery(hqlQuery);
    }
}
