package model.dao.impl;

import model.dao.CreditCardDAO;
import model.entities.CreditCard;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kara_Vladimir.
 */
public class CreditCardDAOMySqlImpl implements CreditCardDAO {
    /*  idCreditCard INT NOT NULL AUTO_INCREMENT ,
        numberCard VARCHAR(16) NOT NULL ,
        FK_idPerson INT,
        FK_idAccount INT,*/
    //Columns in table CreditCard
    public final static String COL_ID_CREDIT_CARD = "idCreditCard";
    public final static String COL_NUMBER_CARD = "numberCard";
    public final static String COL_FK_ID_PERSON = "FK_idPerson";
    public final static String COL_FK_ID_ACCOUNT = "FK_idAccount";
    //SQL queries
    public final static String SQL_NEW_CREDIT_CARD = "INSERT INTO CreditCard "+COL_ID_CREDIT_CARD;
    public final static String SQL_FIND_CREDIT_CARD_BY_ID = "";
    public final static String SQL_UPDATE_CREDIT_CARD_BY_NUMBER = "";
    public final static String SQL_DELETE_CREDIT_CARD_BY_NUMBER = "";

    private DataSource dataSource = null;

    CreditCardDAOMySqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean save(CreditCard creditCard) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_NEW_CREDIT_CARD );
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
    public CreditCard read(int PK) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CreditCard creditCard = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_CREDIT_CARD_BY_ID );
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
    public boolean update(CreditCard creditCard) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_CREDIT_CARD_BY_NUMBER );
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
    public boolean delete(CreditCard creditCard) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_CREDIT_CARD_BY_NUMBER);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    private CreditCard extractCreditCard(ResultSet resultSet) throws SQLException {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(resultSet.getString(COL_NUMBER_CARD));
        creditCard.setIdAccount(resultSet.getInt(COL_FK_ID_ACCOUNT));
        creditCard.setIdPerson(resultSet.getInt(COL_FK_ID_PERSON));
        return creditCard;
    }
}
