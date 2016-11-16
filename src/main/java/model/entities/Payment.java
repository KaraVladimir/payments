package model.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Kara_Vladimir.
 */
public class Payment {
    private int idPayment;
    private Timestamp timestamp;
    private BigDecimal amount;
    private byte typeOfPayment;
    private Person senderPerson;
    private Account senderAccount;
    private CreditCard senderCard;
    private Account recipientAccount;

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public byte getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(byte typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    public Person getSenderPerson() {
        return senderPerson;
    }

    public void setSenderPerson(Person senderPerson) {
        this.senderPerson = senderPerson;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public CreditCard getSenderCard() {
        return senderCard;
    }

    public void setSenderCard(CreditCard senderCard) {
        this.senderCard = senderCard;
    }

    public Account getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(Account recipientAccount) {
        this.recipientAccount = recipientAccount;
    }
}
