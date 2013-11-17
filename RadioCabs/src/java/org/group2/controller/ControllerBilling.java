/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.group2.entity.Billing;
import org.group2.entity.RegisteredUnit;

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
    /*
    List<Billing> currentUserBillings;    
    
    public List<Billing> getCurrentUserBillings(){
        if(currentUserBillings==null){
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session =
                    (HttpSession) context.getExternalContext().getSession(true);        
            RegisteredUnit currentUser = (RegisteredUnit)session.getAttribute("clientUser");
            String registrationID = "'" + currentUser.getRegistrationId() + "'";        
            currentUserBillings = search("registrationId = "+registrationID + " order by expriateDate desc");
        }
        return currentUserBillings;        
    }
    
    public Billing getLastestBilling(){
        return currentUserBillings.get(0);
    }*/
}
