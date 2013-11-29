/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.group2.entity.RegisteredType;
import org.group2.entity.RegisteredUnit;
import org.group2.util.JsfUtil;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author DUONGHM
 */
@ManagedBean(name = "controllerDriver")
@ViewScoped
public class ControllerDriver extends AbstractController implements Serializable {
    
    public ControllerDriver() {
        super(RegisteredUnit.class);
    }
    
    @Override
    public List getList() {
        return super.getList("registeredTypeID = 2");
    }
    
    @Override
    public void create(ActionEvent evt) {
        ((RegisteredUnit) selected).setRegisteredType(new RegisteredType(2, null));
        super.create(evt);
    }
    
    @Override
    public void update(ActionEvent evt) {
        super.update(evt);
    }
    
    public List getDisplayList() {
        //return super.createHQLQuery("select r From RegisteredUnit r join r.billings b where r.registeredType.registeredTypeId = 2 and b.expriateDate > CURRENT_DATE() " + condition);
        String hqlQuery = "select r From RegisteredUnit r join r.billings b where r.registeredType.registeredTypeId = 2 and b.expriateDate > CURRENT_DATE() " + condition;
        return super.createHQLQuery(hqlQuery);
    }
    RegisteredUnit searchedUnit = new RegisteredUnit();
    String condition = "";
    
    public RegisteredUnit getSearchedUnit() {
        return searchedUnit;
    }
    
    public void setSearchedUnit(RegisteredUnit searchedUnit) {
        this.searchedUnit = searchedUnit;
    }
    
    public void searchByName(ActionEvent evt) {
        selected = new RegisteredUnit();
        condition = " and r.name like '%" + searchedUnit.getName() + "%'";
        condition += " and r.city like '%" + searchedUnit.getCity() + "%'";
        condition += " and r.telephone like '%" + searchedUnit.getTelephone() + "%'";
        condition += " and r.experience >= " + searchedUnit.getExperience();
    }
    
    public void handleImageUpload(FileUploadEvent evt) {
        try {
            String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
            File targetFile = new File(path + "Images/Drivers/" + evt.getFile().getFileName());
            InputStream inputStream = evt.getFile().getInputstream();
            OutputStream out = new FileOutputStream(targetFile);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
            System.out.println(targetFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     public void upload(){
     if(uploadFile != null){
     System.out.println(uploadFile.getFileName());
     JsfUtil.addSuccessMessage(uploadFile.getFileName());
     }else{
     JsfUtil.addErrorMessage("Please select file");
     }
     }*/
}
