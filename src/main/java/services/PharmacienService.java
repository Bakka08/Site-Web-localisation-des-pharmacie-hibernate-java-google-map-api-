package services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.IDao;
import entities.Pharmacien;
import util.HibernateUtil;

public class PharmacienService implements IDao<Pharmacien> {

    @Override
    public boolean create(Pharmacien o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean update(Pharmacien o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Pharmacien o
    ) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public Pharmacien findById(int id
    ) {
        Session session = null;
        Transaction tx = null;
        Pharmacien pharmacien = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            pharmacien = (Pharmacien) session.get(Pharmacien.class, id);
            tx.commit();
            return pharmacien;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return null;
    }

    @Override
    public List<Pharmacien> findAll() {
        Session session = null;
        Transaction tx = null;
        Pharmacien pharmacien = null;
        List<Pharmacien> pharmaciens = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            pharmaciens = session.createQuery("from Pharmacien").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return pharmaciens;
   
    }

}



