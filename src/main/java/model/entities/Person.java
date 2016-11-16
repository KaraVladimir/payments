package model.entities;

import java.util.Collection;

/**
 * Created by Kara_Vladimir.
 */
public class Person {
    private int idPerson;
    private String familyName;
    private String name;
    private String login;
    //TODO test field pass
    private String pass;
    private Role role;
    private Collection<CreditCard> creditCards;

    public boolean addCreditCard(CreditCard creditCard) {
        return creditCards.add(creditCard);
    }

    public boolean removeCreditCard(CreditCard creditCard) {
        return creditCards.remove(creditCard);
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @Override
    public String toString() {
        return "User [login=" + getLogin() + ", password=" + pass
                + ", familyName=" + getFamilyName() + ", name=" + getName()
                + ", role=" + getRole() + "]";
    }
}
