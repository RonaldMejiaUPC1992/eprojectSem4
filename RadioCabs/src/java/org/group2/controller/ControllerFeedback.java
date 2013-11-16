/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.group2.entity.Feedback;
import org.group2.entity.RegisteredUnit;

/**
 *
 * @author DUONGHM
 */
@ManagedBean
@ViewScoped
public class ControllerFeedback extends AbstractController {
    
    public ControllerFeedback() {
        super(Feedback.class);
    }
    
}
