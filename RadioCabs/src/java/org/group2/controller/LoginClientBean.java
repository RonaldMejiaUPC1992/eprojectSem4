/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

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
public class LoginClientBean {
    
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
        List<RegisteredUnit> l = new ControllerDriver().search("registrationId = " + registrationID + " and password = " + password + " and registeredTypeID = 1 or registeredTypeID = 2");
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
}