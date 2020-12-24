package dao;

import entities.User;
import java.util.List;

public interface UserDao {

    /**
     * Delete object record from DB
     *
     * @param entity - selected entity
     */
    void delete(User entity);

    /**
     * Write new object record in DB
     *
     * @param entity - selected entity
     */
    void add(User entity);

    /**
     * Get all user records from DB
     *
     * @return list of all existing objects
     * in table
     */
    List<User> findAll();

    /**
     * Get object record from DB by id
     *
     * @param id - identifier of entity
     * @return object of appropriate this id
     */
    User findById(Integer id);
}