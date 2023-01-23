package services;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.IDao;
import entities.Garde;
import entities.Pharmacie;
import entities.Photo;
import util.HibernateUtil;

public class PhotoService implements IDao<Photo> {

	@Override
	public boolean create(Photo o) {
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
	public boolean update(Photo o) {
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
	public boolean delete(Photo o) {
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
	public Photo findById(int id) {
		Session session = null;
        Transaction tx = null;
       Photo photo = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            photo = (Photo) session.get(Photo.class, id);
            tx.commit();
            return photo;
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
	public List<Photo> findAll() {
		Session session = null;
        Transaction tx = null;
        List<Photo> photos = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            photos = session.createQuery("from Photo").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return photos;
	}
	public Photo findByPharma(Pharmacie ph) {
		Session session = null;
        Transaction tx = null;
        Photo photos = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            photos = (Photo) session.createQuery("from Photo where pharmacie_id= :id ").setParameter("id", ph).uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return photos;
	}

}