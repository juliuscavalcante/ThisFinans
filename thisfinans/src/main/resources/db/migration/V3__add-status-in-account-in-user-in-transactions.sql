ALTER TABLE accounts
    ADD status TINYINT NOT NULL;

ALTER TABLE users
    ADD status TINYINT NOT NULL;

ALTER TABLE transactions
    ADD status TINYINT NOT NULL;