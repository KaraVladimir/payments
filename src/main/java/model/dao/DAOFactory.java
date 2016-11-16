package model.dao;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by Kara_Vladimir.
 */
public interface DAOFactory {
    //Connection getConnection();

    AccountDAO getAccountDAO(DataSource dataSource);

    CreditCardDAO getCreditCardDAO(DataSource dataSource);

    PaymentDAO getPaymentDAO(DataSource dataSource);

    PersonDAO getPersonDAO(DataSource dataSource);
}
