CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT AUTO_INCREMENT,
    user_cod BINARY(16) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS accounts (
    account_id BIGINT AUTO_INCREMENT,
    account_cod BINARY(16) NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    user_fk BIGINT NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (account_id),
    CONSTRAINT fk_accounts_user_id FOREIGN KEY (user_fk) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS transactions (
    transaction_id BIGINT AUTO_INCREMENT,
    transaction_cod BINARY(16) NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(10,4) NOT NULL,
    type VARCHAR(50) NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    CONSTRAINT pk_entry PRIMARY KEY (transaction_id)
);

CREATE TABLE IF NOT EXISTS transaction_entries (
    transaction_entry_id BIGINT AUTO_INCREMENT,
    transaction_entry_cod BINARY(16) NOT NULL,
    description VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    entry_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    transaction_fk BIGINT NOT NULL,
    CONSTRAINT pk_transaction_entry PRIMARY KEY (transaction_entry_id),
    CONSTRAINT fk_entry_transaction_id FOREIGN KEY (transaction_fk) REFERENCES transactions(transaction_id)
);