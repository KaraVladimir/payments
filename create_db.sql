/*CREATE SCHEMA paymentsDB DEFAULT CHARACTER SET utf8 ;*/
DROP DATABASE IF EXISTS payments;
CREATE DATABASE IF NOT EXISTS payments;
USE payments;

CREATE  TABLE IF NOT EXISTS Account (
  idAccount INT NOT NULL AUTO_INCREMENT ,
  numberAccount VARCHAR(34) NOT NULL ,
  balance DECIMAL(14,2) NULL ,
  isBlocked BIT NOT NULL,
  PRIMARY KEY (idAccount) );

CREATE  TABLE IF NOT EXISTS Person (
  idPerson INT NOT NULL AUTO_INCREMENT ,
  familyNamePerson VARCHAR(80) NOT NULL,
  namePerson VARCHAR(80) NOT NULL,
  login VARCHAR(20) NOT NULL,
  pass VARCHAR(20),
  rolePerson TINYINT NOT NULL,
  PRIMARY KEY (idPerson) );

CREATE  TABLE IF NOT EXISTS CreditCard (
  idCreditCard INT NOT NULL AUTO_INCREMENT ,
  numberCard VARCHAR(16) NOT NULL ,
  FK_idPerson INT,
  FK_idAccount INT,
  PRIMARY KEY (idCreditCard),
  CONSTRAINT FK_idPerson FOREIGN KEY (FK_idPerson) REFERENCES Person(idPerson),
  CONSTRAINT FK_idAccount FOREIGN KEY (FK_idAccount) REFERENCES ACCOUNT(idAccount));

CREATE  TABLE IF NOT EXISTS Payment (
  idPayment INT NOT NULL AUTO_INCREMENT ,
  timeStampPayment TIMESTAMP NOT NULL ,
  amount DECIMAL(14,2) ,
  typeOfPayment TINYINT NOT NULL,
  FK_idSenderPerson INT,
  FK_idSenderAccount INT,
  FK_idSenderCard INT ,
  FK_idRecipientAccount INT ,
  PRIMARY KEY (idPayment),
  CONSTRAINT FK_idSenderPerson FOREIGN KEY (FK_idSenderPerson) REFERENCES Person(idPerson),
  CONSTRAINT FK_idSenderAccount FOREIGN KEY (FK_idSenderAccount) REFERENCES ACCOUNT(idAccount),
  CONSTRAINT FK_idSenderCard FOREIGN KEY (FK_idSenderCard) REFERENCES CreditCard(idCreditCard),
  CONSTRAINT FK_idRecipientAccount FOREIGN KEY (FK_idRecipientAccount) REFERENCES ACCOUNT(idAccount));





