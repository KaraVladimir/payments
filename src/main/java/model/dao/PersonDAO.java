package model.dao;

import model.entities.Person;

import java.sql.SQLException;

/**
 * Created by Kara_Vladimir.
 */
public interface PersonDAO {
    boolean save(Person person) throws SQLException;

    Person read(int PK) throws SQLException;

    boolean update(Person person) throws SQLException;

    boolean delete(Person person) throws SQLException;
}
