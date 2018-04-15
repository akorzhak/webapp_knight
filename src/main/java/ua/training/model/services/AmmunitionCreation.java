package ua.training.model.services;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ProductDao;
import ua.training.model.dao.implement.JDBCDaoFactory;
import ua.training.model.entity.Ammunition;
import ua.training.model.entity.Product;


public class AmmunitionCreation {

    private DaoFactory daoFactory = new JDBCDaoFactory();
    private ProductDao productDao = daoFactory.createProductDao();

    public Ammunition createAmmunition(String helmetName, String weaponName, String chainArmorName,
                                       String legArmorName, String vehicleName) {

        Product helmet = productDao.findByName(helmetName);
        Product weapon = productDao.findByName(weaponName);
        Product chainArmor = productDao.findByName(chainArmorName);
        Product legArmor = productDao.findByName(legArmorName);
        Product vehicle = productDao.findByName(vehicleName);

        long price = calculateAmmunitionPrice(helmet.getPrice(), weapon.getPrice(), chainArmor.getPrice(),
                legArmor.getPrice(), vehicle.getPrice());

        return new Ammunition(helmet, weapon, chainArmor, legArmor, vehicle, price);
    }

    private long calculateAmmunitionPrice(long helmetPrice, long weaponPrice, long chainArmorPrice,
                                          long legArmorPrice, long vehiclePrice) {
        return helmetPrice + weaponPrice + chainArmorPrice + legArmorPrice + vehiclePrice;
    }
}
