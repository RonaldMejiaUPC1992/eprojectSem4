/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.group2.entity.Administrator;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@RequestScoped
public class LoginAdminBean {
    
    public LoginAdminBean() {
    }
    Administrator admin = new Administrator();

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }
        
    public String checkLogin(){
        String email = "'" + admin.getEmail() + "'";
        String password = "'" + admin.getPassword() + "'";
        List l = new ControllerAdministrator().search("email = "+email+" and password = "+password);
        if(l.size()>0){        
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map<String, Object> session = facesContext.getExternalContext().getSessionMap();
            session.put("user", admin);
            return "SUCCESS";
        }else{
            return "ERROR";
        }
    }
}
