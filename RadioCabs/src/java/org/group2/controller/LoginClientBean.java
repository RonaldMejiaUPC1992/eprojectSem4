/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.group2.entity.RegisteredUnit;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@RequestScoped
public class LoginClientBean implements Serializable{
    
    RegisteredUnit user = new RegisteredUnit();
    
    public LoginClientBean() {
    }

    public RegisteredUnit getUser() {
        return user;
    }

    public void setUser(RegisteredUnit user) {
        this.user = user;
    }
    
    public String checkLogin(){        
        String registrationID = "'" + user.getRegistrationId() + "'";
        String password = "'" + user.getPassword() + "'";
        List<RegisteredUnit> l = new ControllerDriver().search("registrationId = " + registrationID + " and password = " + password);
        if (l.size() > 0) {
            user = l.get(0);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session =
                    (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("clientUser", user);
            return "";
        } else {            
            return "";
        }
    }
    
    public String logout(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session =
                (HttpSession) context.getExternalContext().getSession(true);
        session.removeAttribute("clientUser");
        return "/client/index.xhtml?faces-redirect=true";
    }
    
    public String gotoDetail(){
        return "/client/ViewInfor.xhtml?faces-redirect=true";
    }
    
    public String gotoBillingHistory(){
        return "/client/Billing/BillingDetail.xhtml?faces-redirect=true";
    }
    
    public String gotoHomepage(){
        return "/client/index.xhtml?faces-redirect=true";
    }
}
