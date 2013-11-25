/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.group2.entity.Administrator;
import org.group2.util.JsfUtil;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@ViewScoped
public class ControllerAdministrator extends AbstractController implements Serializable {

    public ControllerAdministrator() {
        super(Administrator.class);
    }

    @Override
    public List getList() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session =
                (HttpSession) context.getExternalContext().getSession(true);
        Administrator admin = (Administrator) session.getAttribute("adminUser");
        if (admin != null) {
            return super.getList("role >= " + admin.getRole());
        } else {
            return null;
        }
    }

    @Override
    public void delete(ActionEvent evt) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session =
                (HttpSession) context.getExternalContext().getSession(true);
        Administrator admin = (Administrator) session.getAttribute("adminUser");
        if (admin.equals((Administrator) selected)) {
            JsfUtil.addErrorMessage("Cannot delete current User");
        } else {
            super.delete(evt);
        }
    }

    @Override
    public void deleteMany(ActionEvent evt) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session =
                (HttpSession) context.getExternalContext().getSession(true);
        Administrator admin = (Administrator) session.getAttribute("adminUser");
        if(selectedItems.contains(admin)){
            JsfUtil.addErrorMessage("Cannot delete current User");
        }else{
            super.deleteMany(evt);
        }
    }
}
