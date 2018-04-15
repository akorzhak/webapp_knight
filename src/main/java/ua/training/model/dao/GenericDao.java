package ua.training.model.dao;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable{
    boolean create (T entity);
    T findById(int id);
    T findByName(String name);
    List<T> findAll();
    boolean update(T entity);
    boolean delete(int id);
}