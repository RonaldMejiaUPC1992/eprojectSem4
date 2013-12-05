/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.group2.entity.RegisteredUnit;
import org.group2.model.AbstractModel;
import org.group2.util.HibernateUtil;
import org.group2.util.JsfUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@ViewScoped
public class ControllerUploadFile {

    public ControllerUploadFile() {
    }
    UploadedFile uploadFile;

    public UploadedFile getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(UploadedFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    public void updateImage(ActionEvent evt) {
        if (uploadFile != null) {
            try {
                String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
                File targetFile = new File(path + "Images/" + uploadFile.getFileName());
                InputStream inputStream = uploadFile.getInputstream();
                OutputStream out = new FileOutputStream(targetFile);
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                inputStream.close();
                out.flush();
                out.close();

                RegisteredUnit selected = (RegisteredUnit) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("clientUser");
                selected.setPhoto(uploadFile.getFileName());
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction trans = session.beginTransaction();
                try {
                    trans.begin();
                    session.merge(selected);
                    trans.commit();
                } catch (Exception ex) {
                    trans.rollback();
                    ex.printStackTrace();
                    throw new Exception(ex.getMessage());
                }
                session.close();

                JsfUtil.addSuccessMessage("Update Success");

            } catch (Exception e) {
                e.printStackTrace();
                JsfUtil.addSuccessMessage("Update Error");
            }
        } else {
            JsfUtil.addSuccessMessage("Please select Image");
        }
    }
    @ManagedProperty(value = "#{controllerAdvertise}")
    private ControllerAdvertise controllerAdvertise;

    public ControllerAdvertise getControllerAdvertise() {
        return controllerAdvertise;
    }

    public void setControllerAdvertise(ControllerAdvertise controllerAdvertise) {
        this.controllerAdvertise = controllerAdvertise;
    }

    public void updateImageForAdvertise(ActionEvent evt) {        
        if (uploadFile != null) {            
            try {
                String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
                File targetFile = new File(path + "Images/" + uploadFile.getFileName());
                InputStream inputStream = uploadFile.getInputstream();
                OutputStream out = new FileOutputStream(targetFile);
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                inputStream.close();
                out.flush();
                out.close();

                RegisteredUnit selected = (RegisteredUnit)controllerAdvertise.selected;
                selected.setPhoto(uploadFile.getFileName());
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction trans = session.beginTransaction();
                try {
                    trans.begin();
                    session.merge(selected);
                    trans.commit();
                } catch (Exception ex) {
                    trans.rollback();
                    ex.printStackTrace();
                    throw new Exception(ex.getMessage());
                }
                session.close();

                JsfUtil.addSuccessMessage("contact-form:sucInsert", "Upload Image Successful");

            } catch (Exception e) {
                e.printStackTrace();
                JsfUtil.addErrorMessage("contact-form:errInsert", "Cannot Upload Image"); 
            }
        } else {
            JsfUtil.addSuccessMessage("contact-form:sucInsert", "Use default Image");
        }
    }
    
    public void updateImageForAdvertise(RegisteredUnit selected){
        if (uploadFile != null) {            
            try {
                String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
                File targetFile = new File(path + "Images/" + uploadFile.getFileName());
                InputStream inputStream = uploadFile.getInputstream();
                OutputStream out = new FileOutputStream(targetFile);
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                inputStream.close();
                out.flush();
                out.close();
                
                selected.setPhoto(uploadFile.getFileName());
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction trans = session.beginTransaction();
                try {
                    trans.begin();
                    session.merge(selected);
                    trans.commit();
                } catch (Exception ex) {
                    trans.rollback();
                    ex.printStackTrace();
                    throw new Exception(ex.getMessage());
                }
                session.close();

                JsfUtil.addSuccessMessage("contact-form:sucInsert", "Upload Image Successful");

            } catch (Exception e) {
                e.printStackTrace();
                JsfUtil.addErrorMessage("contact-form:errInsert", "Cannot Upload Image"); 
            }
        } else {
            JsfUtil.addSuccessMessage("contact-form:sucInsert", "Use default Image");
        }
    }
}
