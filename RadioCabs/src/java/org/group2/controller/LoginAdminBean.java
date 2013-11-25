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
import org.group2.entity.Administrator;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@RequestScoped
public class LoginAdminBean implements Serializable{

    public LoginAdminBean() {
    }
    Administrator admin = new Administrator();

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public String checkLogin() {
        String email = "'" + admin.getEmail() + "'";
        String password = "'" + admin.getPassword() + "'";
        List<Administrator> l = new ControllerAdministrator().search("email = " + email + " and password = " + password);
        if (l.size() > 0) {            
            admin = (Administrator)l.get(0);            
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session =
                    (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("adminUser", admin);
            return "/admin_v2/Company/Company.xhtml?faces-redirect=true";
        } else {
            return "";
        }
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session =
                (HttpSession) context.getExternalContext().getSession(true);
        session.removeAttribute("adminUser");
        return "/admin_v2/Login/Login.xhtml?faces-redirect=true";
    }
}
