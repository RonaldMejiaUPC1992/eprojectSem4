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
import javax.servlet.http.HttpSession;
import org.group2.entity.Billing;
import org.group2.entity.PaymentType;
import org.group2.entity.RegisteredUnit;
import org.group2.model.AbstractModel;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@ViewScoped
public class ControllerBilling extends AbstractController implements Serializable{
    
    List<PaymentType> listPaymentType;
    List<RegisteredUnit> listRegisteredUnit;
        
    public ControllerBilling() {
        super(Billing.class);
        listPaymentType = new AbstractModel<PaymentType>(PaymentType.class){}.getAll();
        listRegisteredUnit = new AbstractModel<RegisteredUnit>(RegisteredUnit.class){}.getAll(); 
    }

    public List<PaymentType> getListPaymentType() {
        return listPaymentType;
    }

    public void setListPaymentType(List<PaymentType> listPaymentType) {
        this.listPaymentType = listPaymentType;
    }

    public List<RegisteredUnit> getListRegisteredUnit() {
        return listRegisteredUnit;
    }

    public void setListRegisteredUnit(List<RegisteredUnit> listRegisteredUnit) {
        this.listRegisteredUnit = listRegisteredUnit;
    }
    
}
