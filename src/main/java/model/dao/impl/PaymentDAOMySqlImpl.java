package model.dao.impl;

import model.dao.PaymentDAO;
import model.entities.Payment;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kara_Vladimir.
 */
public class PaymentDAOMySqlImpl implements PaymentDAO {
    /*
      idPayment INT NOT NULL AUTO_INCREMENT ,
      timeStampPayment TIMESTAMP NOT NULL ,
      amount DECIMAL(14,2) ,
      typeOfPayment TINYINT NOT NULL,
      FK_idSenderPerson INT,
      FK_idSenderAccount INT,
      FK_idSenderCard INT ,
      FK_idRecipientAccount INT ,
      */
    //Columns in table CreditCard
    public static final String COL_ID_PAYMENT = "idPayment";
    public static final String COL_TIMESTAMP = "timeStampPayment";
    public static final String COL__AMOUNT = "amount";
    public static final String COL_TYPE = "typeOfPayment";
    public static final String COL_FK_ID_SENDER_PERSON = "FK_idSenderPerson";
    public static final String COL_FK_ID_SENDER_ACCOUNT = "FK_idSenderAccount";
    public static final String COL_FK_ID_SENDER_CARD = "FK_idSenderCard";
    public static final String COL_FK_ID_RECIPIENT_ACCOUNT = "FK_idRecipientAccount";

    //SQL queries
    public final static String SQL_NEW_PAYMENT = "";
    public final static String SQL_FIND_PAYMENT_BY_ID = "";
    public final static String SQL_UPDATE_PAYMENT_BY_NUMBER = "";
    public final static String SQL_DELETE_PAYMENT_BY_NUMBER = "";


    private DataSource dataSource = null;

    public PaymentDAOMySqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean save(Payment payment) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_NEW_PAYMENT);
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
    public Payment read(int PK) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Payment payment = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_PAYMENT_BY_ID);
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
    public boolean update(Payment payment) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_PAYMENT_BY_NUMBER);
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
    public boolean delete(Payment payment) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_PAYMENT_BY_NUMBER);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    private Payment extractPayment(ResultSet resultSet) throws SQLException {
        Payment payment = new Payment();
        return payment;
    }
}
