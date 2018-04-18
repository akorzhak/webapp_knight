package ua.training.model.dao;

import ua.training.model.entity.Knight;

public interface KnightDao extends GenericDao<Knight> {
    boolean findByLogin(String login, String password);
}