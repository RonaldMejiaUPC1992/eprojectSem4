/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;
import org.group2.model.AbstractModel;
import org.group2.util.HibernateUtil;
import org.group2.util.JsfUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author DUONGHM
 */
public abstract class AbstractController<T> {

    Class<T> entityClass;
    AbstractModel<T> model;
    T selected;
    List<T> list;

    public AbstractController() {
    }

    public AbstractController(Class<T> entityClass) {

        this.entityClass = entityClass;
        //selected = entityClass.newInstance();
        model = new AbstractModel<T>(entityClass) {
        };

    }

    public T getSelected() {
        return selected;
    }

    public void setSelected(T selected) {
        this.selected = selected;
    }

    public List<T> getList() {
        if (list == null) {
            list = model.getAll();
        }
        return list;
    }

    public List<T> getList(String condtion) {
        if (list == null) {
            list = model.getAll(condtion);
        }
        return list;
    }

    public List<T> search(String condtion) {
        List r = model.search(condtion);
        return r;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void prepareCreate(ActionEvent evt) {
        try {
            selected = entityClass.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(ActionEvent evt) {
        try {
            model.add(selected);
            JsfUtil.addSuccessMessage("Create");
            list = null;
        } catch (Exception ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void update(ActionEvent evt) {
        try {
            model.update(selected);
            JsfUtil.addSuccessMessage("Update");
        } catch (Exception ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void delete(ActionEvent evt) {
        try {
            model.delete(selected);
            JsfUtil.addSuccessMessage("Delete");
            list = null;
        } catch (Exception ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
}
