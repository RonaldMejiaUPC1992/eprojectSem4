/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.group2.entity.Administrator;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@ViewScoped
public class ControllerAdministrator extends AbstractController {
    
    public ControllerAdministrator() {
        super(Administrator.class);
    }
    
    public String checkLogin(){
        String email = "'" + ((Administrator)selected).getEmail() + "'";
        String password = "'" + ((Administrator)selected).getPassword() + "'";
        List l = search("email = "+email+" and password = "+password);
        if(l.size()>0){            
            return "SUCCESS";
        }else{
            return "ERROR";
        }
    }
    
}
