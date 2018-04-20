/*
 * ProductDao
 *
 * Description: This source file is a part of the Knight web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/04/10
 *
 * Updated: 2018/04/20
 */
package ua.training.model.dao;

import ua.training.model.entity.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product> {
    List<Product> findByDesc(String description);
}
