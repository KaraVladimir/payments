package model.dao;

import model.entities.Account;

import java.sql.SQLException;

/**
 * Created by Kara_Vladimir.
 */
public interface AccountDAO {
    boolean save(Account account) throws SQLException;

    Account read(int PK) throws SQLException;

    boolean update(Account account) throws SQLException;

    boolean delete(Account account) throws SQLException;
}
