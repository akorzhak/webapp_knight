/*
 * KnightDao
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

import ua.training.model.entity.Knight;

public interface KnightDao extends GenericDao<Knight> {
    boolean findByLogin(String login, String password);
}