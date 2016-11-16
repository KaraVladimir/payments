USE payments;

DELETE FROM Account;
INSERT INTO Account (numberAccount,balance,isBlocked)
	VALUES
	('1234123412341234',1500.50,b'0'),
	('565865265456855488',7000.00,b'0'),
	('545688323595325666',440.80,b'0'),
	('887896546896559887',789.60,b'1');

DELETE FROM Person;
INSERT INTO Person (familyNamePerson,namePerson,login,pass,rolePerson)
	VALUES
    ('Ivanova','Elena','ie','1',0),
    ('Petrenko','Ivan','pi','2',1),
    ('Doe','John','dj','3',0);



DELETE FROM CreditCard;
INSERT INTO CreditCard (numberCard,FK_idPerson,FK_idAccount)
	VALUES
    ('111111111111',1,1),
    ('222222222222',2,2),
    ('333333333333',2,2);