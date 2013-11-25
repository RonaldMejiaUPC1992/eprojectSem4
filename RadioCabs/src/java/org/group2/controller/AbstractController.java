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
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author DUONGHM
 */
public abstract class AbstractController<T> {

    Class<T> entityClass;
    AbstractModel<T> model;
    T selected;
    List<T> list;
    List<T> selectedItems;

    public AbstractController() {
    }

    public AbstractController(Class<T> entityClass) {
        try {
            this.entityClass = entityClass;
            selected = entityClass.newInstance();
            model = new AbstractModel<T>(entityClass) {
            };
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public T getSelected() {
        return selected;
    }

    public void setSelected(T selected) {
        this.selected = selected;
    }

    public List<T> getList() {
        if (list == null) {
            model = new AbstractModel<T>(entityClass) {
            };
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

    public List<T> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<T> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<T> search(String condtion) {
        List r = model.search(condtion);
        return r;
    }

    public List<T> createHQLQuery(String hqlQuery) {
        list = model.createHQLQuery(hqlQuery);
        return list;
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
            ex.printStackTrace();
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void onEdit(RowEditEvent evt) {
        selected = (T) evt.getObject();
        try {
            model.update(selected);
            JsfUtil.addSuccessMessage("Update");
        } catch (Exception ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
            ex.printStackTrace();
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

    public void deleteObject(T obj) {
        try {
            model.delete(obj);
            JsfUtil.addSuccessMessage("Delete");
            list = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void deleteMany(ActionEvent evt) {
        try {
            for (int i = 0; i < selectedItems.size(); i++) {
                model.delete(selectedItems.get(i));
            }
            list = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void delete(ActionEvent evt) {
        try {
            model.delete(selected);
            JsfUtil.addSuccessMessage("Delete");
            list = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
}
