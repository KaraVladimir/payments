package model.dao.impl;

import model.dao.AccountDAO;
import model.entities.Account;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kara_Vladimir.
 */
public class AccountDAOMySqlImpl implements AccountDAO {
    //Columns in table Account
    public static final String COL_ID = "idAccount";
    public static final String COL_NUMBER_ACCOUNT = "numberAccount";
    public static final String COL_BALANCE = "balance";
    public static final String COL_IS_BLOCKED = "isBlocked";
    //SQL queries
    public final static String SQL_NEW_ACCOUNT = "INSERT INTO Account("+ COL_NUMBER_ACCOUNT +","+ COL_BALANCE +
            ","+ COL_IS_BLOCKED +") VALUES (?,?,?)";
    public final static String SQL_FIND_ACCOUNT_BY_ID = "SELECT * FROM Account WHERE "+ COL_ID +"=?";
    public final static String SQL_UPDATE_ACCOUNT_BY_NUMBER = "UPDATE Account SET "+COL_BALANCE+"=?," +
            COL_IS_BLOCKED+"=? WHERE "+COL_NUMBER_ACCOUNT+" = ?";
    public final static String SQL_DELETE_BY_NUMBER_ACCOUNT = "DELETE FROM Account WHERE "+COL_NUMBER_ACCOUNT+"=?";

    private DataSource dataSource = null;

    AccountDAOMySqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean save(Account account) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_NEW_ACCOUNT);
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setBigDecimal(2, account.getAccountBalance());
            preparedStatement.setBoolean(3, account.isBlocked());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Account read(int PK) throws SQLException {
        Account account = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_ACCOUNT_BY_ID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                account = extractAccount(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return account;
    }

    @Override
    public boolean update(Account account) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ACCOUNT_BY_NUMBER);
            preparedStatement.setBigDecimal(1,account.getAccountBalance());
            preparedStatement.setBoolean(2,account.isBlocked());
            preparedStatement.setString(3,account.getAccountNumber());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public boolean delete(Account account) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_NUMBER_ACCOUNT);
            preparedStatement.setString(1, account.getAccountNumber());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private Account extractAccount(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setIdAccount(resultSet.getInt(COL_NUMBER_ACCOUNT));
        account.setAccountNumber(resultSet.getString(COL_NUMBER_ACCOUNT));
        account.setAccountBalance(resultSet.getBigDecimal(COL_BALANCE));
        account.setBlocked(resultSet.getBoolean(COL_IS_BLOCKED));
        return account;
    }
}
