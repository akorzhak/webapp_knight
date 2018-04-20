/*
 * DaoFactory
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