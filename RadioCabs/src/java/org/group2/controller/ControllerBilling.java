/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import org.group2.entity.Billing;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@ViewScoped
public class ControllerBilling extends AbstractController {

    /**
     * Creates a new instance of ControllerBilling
     */
    public ControllerBilling() {
        super(Billing.class);
    }
}
