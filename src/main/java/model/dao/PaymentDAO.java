package model.dao;

import model.entities.Payment;

import java.sql.SQLException;

/**
 * Created by Kara_Vladimir.
 */
public interface PaymentDAO {
    boolean save(Payment payment) throws SQLException;

    Payment read(int PK) throws SQLException;

    boolean update(Payment payment) throws SQLException;

    boolean delete(Payment payment) throws SQLException;
}
