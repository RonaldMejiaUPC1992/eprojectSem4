/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.model;

import java.io.Serializable;
import org.group2.entity.RegisteredUnit;

/**
 *
 * @author DUONGHM
 */
public class ModelCompany extends AbstractModel<RegisteredUnit> implements Serializable{

    public ModelCompany(Class<RegisteredUnit> entityClass){
        super(entityClass);
    }
    
}
