/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.util.List;
import javax.faces.event.ActionEvent;
import org.group2.entity.RegisteredUnit;
import org.group2.model.CompanyModel;
import org.group2.util.JsfUtil;

/**
 *
 * @author chuandemon
 */
public class CompanyController {

    public CompanyController() {
        company = new RegisteredUnit();
    }
    /**
     * Creates a new instance of CompanyController
     */
    RegisteredUnit company;
    List<RegisteredUnit> listCompany;

    public RegisteredUnit getCompany() {
        return company;
    }

    public void setCompany(RegisteredUnit company) {
        this.company = company;
    }

    public List<RegisteredUnit> getListCompany() {
        CompanyModel model = new CompanyModel();
        listCompany = model.getAllCompany();
        return listCompany;
    }

    public void setListCompany(List<RegisteredUnit> listCompany) {
        this.listCompany = listCompany;
    }

    public void addCompany(ActionEvent evt) {
        CompanyModel model = new CompanyModel();
        model.addCompany(company);
        JsfUtil.addSuccessMessage("Create");
    }

    public void updateCompany(ActionEvent evt) {
        CompanyModel model = new CompanyModel();
        model.updateCompany(company);
        JsfUtil.addSuccessMessage("Update");
    }

    public void deleteCompany(ActionEvent evt) {
        CompanyModel model = new CompanyModel();
        model.deleteCompany(company);
        JsfUtil.addSuccessMessage("Delete");
    }
}
