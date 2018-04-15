package ua.training.model.dao;

import ua.training.model.dao.implement.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract KnightDao createKnightDao();
    public abstract ProductDao createProductDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory == null){
                    DaoFactory daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}