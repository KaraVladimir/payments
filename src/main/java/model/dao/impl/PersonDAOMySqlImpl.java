package model.dao.impl;

import model.dao.PersonDAO;
import model.entities.Person;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kara_Vladimir.
 */
public class PersonDAOMySqlImpl implements PersonDAO {
    /*
    idPerson INT NOT NULL AUTO_INCREMENT ,
    familyNamePerson VARCHAR(80) NOT NULL,
    namePerson VARCHAR(80) NOT NULL,
    login VARCHAR(20) NOT NULL,
    pass VARCHAR(20),
    rolePerson TINYINT NOT NULL,*/
    //Columns in table CreditCard
    public final static String COL_ID_PERSON = "idPerson";
    public final static String COL_FAMILY_NAME = "familyNamePerson";
    public final static String COL_NAME = "namePerson";
    public final static String COL_LOGIN = "login";
    public final static String COL_PASS = "pass";
    public final static String COL_ROLE_PERSON = "rolePerson";

    //SQL queries
    public final static String SQL_NEW_PERSON = "";
    public final static String SQL_FIND_PERSON_BY_ID = "";
    public final static String SQL_UPDATE_PERSON_BY_NUMBER = "";
    public final static String SQL_DELETE_PERSON_BY_NUMBER = "";



    private DataSource dataSource = null;

    public PersonDAOMySqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean save(Person person) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_NEW_PERSON);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    public Person read(int PK) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Person person = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_PERSON_BY_ID);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Person person) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_PERSON_BY_NUMBER);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Person person) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_PERSON_BY_NUMBER);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    private Person extractPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        return person;
    }
}
