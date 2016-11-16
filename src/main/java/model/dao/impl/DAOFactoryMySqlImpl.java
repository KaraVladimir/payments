package model.dao.impl;

import model.dao.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by Kara_Vladimir.
 */
public class DAOFactoryMySqlImpl implements DAOFactory {
    private static DataSource dataSource = null;
    private static DAOFactory instance = new DAOFactoryMySqlImpl();
    static {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/payments");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private DAOFactoryMySqlImpl() {
    }

    @Override
    public AccountDAO getAccountDAO(DataSource dataSource) {
        return new AccountDAOMySqlImpl(dataSource);
    }

    @Override
    public CreditCardDAO getCreditCardDAO(DataSource dataSource) {
        return new CreditCardDAOMySqlImpl(dataSource);
    }

    @Override
    public PaymentDAO getPaymentDAO(DataSource dataSource) {
        return new PaymentDAOMySqlImpl(dataSource);
    }

    @Override
    public PersonDAO getPersonDAO(DataSource dataSource) {
        return new PersonDAOMySqlImpl(dataSource);
    }
}
