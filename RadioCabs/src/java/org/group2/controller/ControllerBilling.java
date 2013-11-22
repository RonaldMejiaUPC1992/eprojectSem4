/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.group2.entity.Billing;
import org.group2.entity.PaymentType;
import org.group2.entity.RegisteredUnit;
import org.group2.model.AbstractModel;
import org.group2.util.JsfUtil;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@ViewScoped
public class ControllerBilling extends AbstractController implements Serializable {

    List<PaymentType> listPaymentType;
    List<RegisteredUnit> listRegisteredUnit;

    public ControllerBilling() {
        super(Billing.class);
        listPaymentType = new AbstractModel<PaymentType>(PaymentType.class) {
        }.getAll();
        listRegisteredUnit = new AbstractModel<RegisteredUnit>(RegisteredUnit.class) {
        }.getAll();
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

    @Override
    public void update(ActionEvent evt) {
        System.out.println("Start Date: " + ((Billing) selected).getPurchaseDate());
        super.update(evt);
    }
    int displayMoney;

    public int getDisplayMoney() {
        return displayMoney;
    }

    public void updateMoney(ActionEvent evt) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session =
                (HttpSession) context.getExternalContext().getSession(true);
        RegisteredUnit user = (RegisteredUnit) session.getAttribute("clientUser");
        if (((Billing) selected).getPaymentType() != null) {            
            if (((Billing) selected).getPaymentType().getPaymentTypeId() == 1) {
                switch (user.getRegisteredType().getRegisteredTypeId()) {
                    case 1:
                        displayMoney = 15;
                        break;
                    case 2:
                        displayMoney = 10;
                        break;
                }
            } else if (((Billing) selected).getPaymentType().getPaymentTypeId() == 2) {
                switch (user.getRegisteredType().getRegisteredTypeId()) {
                    case 1:
                        displayMoney = 40;
                        break;
                    case 2:
                        displayMoney = 25;
                        break;
                }
            } else {
                displayMoney = 0;
            }
        }else{
            displayMoney = 0;
        }
    }

    public void paid(ActionEvent evt) {
        System.out.println("Call paid");
        if (((Billing) selected).getPaymentType() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session =
                    (HttpSession) context.getExternalContext().getSession(true);
            RegisteredUnit user = (RegisteredUnit) session.getAttribute("clientUser");
            ((Billing) selected).setRegisteredUnit(user);

            Date now = new Date();
            ((Billing) selected).setPurchaseDate(now);

            Calendar cal = Calendar.getInstance();
            cal.setTime(now);

            if (((Billing) selected).getPaymentType().getPaymentTypeId() == 1) {
                cal.add(Calendar.MONTH, 1);
                switch (user.getRegisteredType().getRegisteredTypeId()) {
                    case 1:
                        ((Billing) selected).setMoney(15);
                        break;
                    case 2:
                        ((Billing) selected).setMoney(10);
                        break;
                }
                ((Billing) selected).setExpriateDate(cal.getTime());
            } else if (((Billing) selected).getPaymentType().getPaymentTypeId() == 2) {
                cal.add(Calendar.MONTH, 3);
                switch (user.getRegisteredType().getRegisteredTypeId()) {
                    case 1:
                        ((Billing) selected).setMoney(40);
                        break;
                    case 2:
                        ((Billing) selected).setMoney(25);
                        break;
                }
                ((Billing) selected).setExpriateDate(cal.getTime());
            } else {
                ((Billing) selected).setExpriateDate(null);
            }
            super.create(evt);
            JsfUtil.addSuccessMessage("Purchase success");
        } else {
            JsfUtil.addErrorMessage("Cannot purchase");
        }
    }
}
