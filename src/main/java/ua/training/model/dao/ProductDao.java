package ua.training.model.dao;

import ua.training.model.entity.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product> {
    List<Product> findByDesc(String description);
}
