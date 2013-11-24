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

    public AbstractModel() {
    }

    public AbstractModel(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        Query query = session.createQuery("FROM " + entityClass.getName());
        //System.out.println("================FROM " + entityClass.getName() + "=======================");
        List<T> lst = query.list();
        trans.commit();
        session.close();
        return lst;
    }

    public List<T> getAll(String condition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        Query query = session.createQuery("FROM " + entityClass.getName() + " WHERE " + condition);
        //System.out.println("======FROM " + entityClass.getName()+ " WHERE "+condition+"======");
        List<T> lst = query.list();
        trans.commit();
        session.close();
        return lst;
    }

    public List<T> createHQLQuery(String hqlQuery) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        Query query = session.createQuery(hqlQuery);
        //System.out.println("======FROM " + entityClass.getName()+ " WHERE "+condition+"======");
        List<T> lst = query.list();
        trans.commit();
        session.close();
        return lst;
    }

    public List<T> search(String condition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        Query query = session.createQuery("FROM " + entityClass.getName() + " WHERE " + condition);
        //System.out.println("======FROM " + entityClass.getName()+ " WHERE "+condition+"======");
        List<T> lst = query.list();
        trans.commit();
        session.close();
        return lst;
    }

    public void add(T entity) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        try {            
            trans.begin();
            session.save(entity);
            trans.commit();            
        } catch (Exception ex) {
            trans.rollback();            
            ex.printStackTrace();            
            throw new Exception(ex.getMessage());
        }        
        session.close();
    }

    public void update(T entity) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        try {
            trans.begin();
            session.update(entity);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            ex.printStackTrace();  
            throw new Exception(ex.getMessage());
        }        
        session.close();
    }

    public void delete(T entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        try {
            trans.begin();
            session.delete(entity);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            ex.printStackTrace();  
            throw new Exception(ex.getMessage());
        }        
        session.close();
    }
}
