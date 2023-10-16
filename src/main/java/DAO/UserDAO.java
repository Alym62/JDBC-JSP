package DAO;

import entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;

public class UserDAO {
    // CRUD CREATE
    public void inserirUser(User user) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

    // CRUD READ
    public ArrayList<User> listDeUsuarios() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            ArrayList<User> users = (ArrayList<User>)
                    session.createQuery("FROM registro", User.class)
                            .getResultList();

            transaction.commit();

            return users;

        } catch (HibernateException e) {
            System.out.println(e);

            return null;

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    // CRUD SELECT
    public User selectUser(User user){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            user = session.get(User.class, user.getCod_registro());
            transaction.commit();
        } catch (HibernateException e){
            if(transaction != null){
                transaction.rollback();
            }

            e.printStackTrace();
        }

        return user;
    }

    // CRUD UPDATE
    public void updateUser(User user){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(user);
            transaction.commit();
        } catch (HibernateException e){
            if(transaction != null){
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    // CRUD DELETE
    public void deletarUsuariosDB(User user) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            if (user != null) {
                session.delete(user);
            }

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
