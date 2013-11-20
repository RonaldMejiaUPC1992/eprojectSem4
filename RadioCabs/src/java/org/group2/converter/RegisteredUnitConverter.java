/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.group2.entity.RegisteredUnit;
import org.group2.model.AbstractModel;

/**
 *
 * @author DUONGHM
 */
@FacesConverter("registeredUnitConverter")
public class RegisteredUnitConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return new AbstractModel(RegisteredUnit.class){}.search("registrationId = '" + string + "'").get(0);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {        
        return ((RegisteredUnit)o).getRegistrationId();
    }
    
}
