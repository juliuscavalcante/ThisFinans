CREATE TABLE IF NOT EXISTS USERS (
    user_id BIGINT AUTO_INCREMENT,
    user_cod BINARY(16) NOT NULL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS CONFIGS (
    config_id BIGINT AUTO_INCREMENT,
    budget_closing_day TINYINT NOT NULL,
    user_fk BIGINT NOT NULL,
    CONSTRAINT pk_config PRIMARY KEY (config_id),
    CONSTRAINT fk_config_user_id FOREIGN KEY (user_fk) REFERENCES USERS(user_id)
);

CREATE TABLE IF NOT EXISTS ACCOUNTS (
    account_id BIGINT AUTO_INCREMENT,
    account_cod BINARY(16) NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    user_fk BIGINT NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (account_id),
    CONSTRAINT fk_accounts_user_id FOREIGN KEY (user_fk) REFERENCES USERS(user_id)
);

CREATE TABLE IF NOT EXISTS TRANSACTIONS (
    transaction_id BIGINT AUTO_INCREMENT,
    transaction_cod BINARY(16) NOT NULL,
    description VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    amount DECIMAL(10,4) NOT NULL,
    status VARCHAR(50) NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    CONSTRAINT pk_entry PRIMARY KEY (transaction_id)
);

CREATE TABLE IF NOT EXISTS TRANSACTION_DAYS (
    transaction_day_id BIGINT AUTO_INCREMENT,
    day TINYINT NOT NULL,
    transaction_fk BIGINT NOT NULL,
    CONSTRAINT pk_transaction_day PRIMARY KEY (transaction_day_id),
    CONSTRAINT fk_day_transaction_id FOREIGN KEY (transaction_fk) REFERENCES TRANSACTIONS(transaction_id)
);

CREATE TABLE IF NOT EXISTS TRANSACTION_ENTRIES (
    transaction_entry_id BIGINT AUTO_INCREMENT,
    transaction_entry_cod BINARY(16) NOT NULL,
    amount DECIMAL(10,4) NOT NULL,
    transaction_entry_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    transaction_fk BIGINT NOT NULL,
    CONSTRAINT pk_transaction_entry PRIMARY KEY (transaction_entry_id),
    CONSTRAINT fk_entry_transaction_id FOREIGN KEY (transaction_fk) REFERENCES TRANSACTIONS(transaction_id)
);
