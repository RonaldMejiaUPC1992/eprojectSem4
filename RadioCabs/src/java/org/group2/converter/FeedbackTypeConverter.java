/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.group2.entity.FeedbackType;
import org.group2.model.AbstractModel;

/**
 *
 * @author acer
 */
@FacesConverter("feedbackTypeConverter")
public class FeedbackTypeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        //System.out.println("value receive = " + string);
        return new AbstractModel(FeedbackType.class){}.search("feedbackTypeId = " + string).get(0);
        //return new FeedbackType(Integer.parseInt(string), null);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        int v = ((FeedbackType)o).getFeedbackTypeId();
        return String.valueOf(v);
    }
    
    
}
