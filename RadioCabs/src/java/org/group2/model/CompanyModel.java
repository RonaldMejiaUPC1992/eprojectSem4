/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.group2.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.group2.entity.RegisteredUnit;
import org.group2.util.HibernateUtil;

/**
 *
 * @author Administrator
 */
public class CompanyModel {

    public List<RegisteredUnit> getAllCompany()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RegisteredUnit> list = session.createQuery("from RegisteredUnit").list();
        transaction.commit();
        session.close();
        return list;
    }
    
    public void addCompany(RegisteredUnit company) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(company);
        transaction.commit();
        session.close();
    }

    public void updateCompany(RegisteredUnit company) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(company);
        transaction.commit();
        session.close();
    }

    public void deleteCompany(RegisteredUnit company) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(company);
        transaction.commit();
        session.close();
    }
}
