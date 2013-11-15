/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.model;

import java.util.List;
import org.group2.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DUONGHM
 */
public abstract class AbstractModel<T> {
    
    private Class<T> entityClass;
    
    public AbstractModel(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public List<T> getAll(){        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        Query query = session.createQuery("FROM " + entityClass.getName());        
        List<T> lst = query.list();
        trans.commit();
        session.close();
        return lst;
    }
    
    public void add(T entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        session.save(entity);
        trans.commit();
        session.close();
    }
    
    public void update(T entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        session.update(entity);
        trans.commit();
        session.close();
    }
    
    public void delete(T entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        session.delete(entity);
        trans.commit();
        session.close();
    }
    
}
