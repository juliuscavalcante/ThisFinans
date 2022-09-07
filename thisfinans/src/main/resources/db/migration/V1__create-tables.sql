CREATE TABLE IF NOT EXISTS USERS (
    user_id INT AUTO_INCREMENT,
    user_cod BINARY(16) NOT NULL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS ACCOUNTS (
    account_id INT AUTO_INCREMENT,
    account_cod BINARY(16) NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    user_fk INT NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (account_id),
    CONSTRAINT fk_accounts_user_id FOREIGN KEY (user_fk) REFERENCES USERS(user_id)
);

CREATE TABLE IF NOT EXISTS TRANSACTIONS (
    transaction_id INT AUTO_INCREMENT,
    transaction_cod BINARY(16) NOT NULL,
    description VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    CONSTRAINT pk_entry PRIMARY KEY (transaction_id)
);

CREATE TABLE IF NOT EXISTS TRANSACTION_ENTRIES (
    transaction_entry_id INT AUTO_INCREMENT,
    transaction_entry_cod BINARY(16) NOT NULL,
    description VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    entry_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    transaction_fk INT NOT NULL,
    CONSTRAINT pk_transaction_entry PRIMARY KEY (transaction_entry_id),
    CONSTRAINT fk_entry_transaction_id FOREIGN KEY (transaction_fk) REFERENCES TRANSACTIONS(transaction_id)
);