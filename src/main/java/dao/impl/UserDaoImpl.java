package dao.impl;

import dao.UserDao;
import dao.utils.HibernateUtil;
import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private static Session currentSession;

    private void openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
    }

    private void closeCurrentSession() {
        currentSession.close();
    }

    private Session getCurrentSession() {
        return currentSession;
    }

    public List<User> findAll() {
        openCurrentSession();
        Transaction transaction = getCurrentSession().beginTransaction();
        List<User> list = getCurrentSession().createQuery("from User").list();
        transaction.commit();
        closeCurrentSession();
        return list;
    }

    public void delete(User entity) {
        openCurrentSession();
        Transaction transaction = getCurrentSession().beginTransaction();
        getCurrentSession().delete(entity);
        transaction.commit();
        closeCurrentSession();
    }

    public void add(User entity) {
        openCurrentSession();
        Transaction transaction = getCurrentSession().beginTransaction();
        getCurrentSession().saveOrUpdate(entity);
        transaction.commit();
        closeCurrentSession();
    }

    public User findById(Integer id) {
        openCurrentSession();
        Transaction transaction = getCurrentSession().beginTransaction();
        User user = (User) getCurrentSession().get(User.class, id);
        transaction.commit();
        closeCurrentSession();
        return user;
    }
}
