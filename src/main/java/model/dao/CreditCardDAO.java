package model.dao;

import model.entities.CreditCard;

import java.sql.SQLException;

/**
 * Created by Kara_Vladimir.
 */
public interface CreditCardDAO {
    boolean save(CreditCard creditCard) throws SQLException;

    CreditCard read(int PK) throws SQLException;

    boolean update(CreditCard creditCard) throws SQLException;

    boolean delete(CreditCard creditCard) throws SQLException;
}
