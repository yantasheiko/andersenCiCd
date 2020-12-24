package services;

import dao.impl.UserDaoImpl;
import entities.User;

import java.util.List;

public class UserService {

    private static UserService INSTANCE = UserService.getInstance();
    private UserDaoImpl dao;

    private UserService() {
        dao = new UserDaoImpl();
    }

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    public void delete(User entity) {
        dao.delete(entity);
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public void add(User entity) {
        dao.add(entity);
    }

    public User findById(int id) {
        return dao.findById(id);
    }
}
