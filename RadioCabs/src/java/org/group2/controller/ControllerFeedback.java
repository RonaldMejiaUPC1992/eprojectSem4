/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.group2.entity.Feedback;
import org.group2.entity.FeedbackType;
import org.group2.entity.RegisteredUnit;
import org.group2.model.AbstractModel;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@ViewScoped
public class ControllerFeedback extends AbstractController implements Serializable{
    
    private List<FeedbackType> listFeedbackType;
    
    public ControllerFeedback() {
        super(Feedback.class);         
        listFeedbackType = new AbstractModel<FeedbackType>(FeedbackType.class){}.getAll();               
    }

    public List<FeedbackType> getListFeedbackType() {        
        return listFeedbackType;
    }

    public void setListFeedbackType(List<FeedbackType> listFeedbackType) {
        this.listFeedbackType = listFeedbackType;
    }
    
}
