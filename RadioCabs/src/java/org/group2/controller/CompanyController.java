/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.util.List;
import javax.faces.event.ActionEvent;
import org.group2.entity.RegisteredUnit;
import org.group2.model.ModelCompany;
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
        ModelCompany model = new ModelCompany(RegisteredUnit.class);
        listCompany = model.getAll();
        return listCompany;
    }

    public void setListCompany(List<RegisteredUnit> listCompany) {
        this.listCompany = listCompany;
    }

    public void addCompany(ActionEvent evt) {
        ModelCompany model = new ModelCompany(RegisteredUnit.class);
        model.add(company);
        JsfUtil.addSuccessMessage("Create");
    }

    public void updateCompany(ActionEvent evt) {
        ModelCompany model = new ModelCompany(RegisteredUnit.class);
        model.update(company);
        JsfUtil.addSuccessMessage("Update");
    }

    public void deleteCompany(ActionEvent evt) {
        ModelCompany model = new ModelCompany(RegisteredUnit.class);
        model.delete(company);
        JsfUtil.addSuccessMessage("Delete");
    }
}
