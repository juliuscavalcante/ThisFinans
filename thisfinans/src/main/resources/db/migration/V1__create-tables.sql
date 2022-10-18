CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT AUTO_INCREMENT,
    user_cod BINARY(36) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    deleted TINYINT NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS user_configs (
    config_id BIGINT AUTO_INCREMENT,
    budget_closing_day TINYINT NOT NULL,
    user_fk BIGINT NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    CONSTRAINT pk_config PRIMARY KEY (config_id),
    CONSTRAINT fk_config_user_id FOREIGN KEY (user_fk) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS accounts (
    account_id BIGINT AUTO_INCREMENT,
    account_cod BINARY(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    user_fk BIGINT NOT NULL,
    deleted TINYINT NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (account_id),
    CONSTRAINT fk_accounts_user_id FOREIGN KEY (user_fk) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS transactions (
    transaction_id BIGINT AUTO_INCREMENT,
    transaction_cod BINARY(36) NOT NULL,
    description VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    amount DECIMAL(10,4) NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    deleted TINYINT NOT NULL,
    account_fk BIGINT NOT NULL,
    CONSTRAINT pk_entry PRIMARY KEY (transaction_id),
    CONSTRAINT fk_transactions_account_id FOREIGN KEY (account_fk) REFERENCES accounts (account_id)
);

CREATE TABLE IF NOT EXISTS transaction_days (
    transaction_day_id BIGINT AUTO_INCREMENT,
    transaction_day TINYINT NOT NULL,
    transaction_fk BIGINT NOT NULL,
    CONSTRAINT pk_transaction_day PRIMARY KEY (transaction_day_id),
    CONSTRAINT fk_day_transaction_id FOREIGN KEY (transaction_fk) REFERENCES transactions(transaction_id)
);

CREATE TABLE IF NOT EXISTS transaction_entries (
    transaction_entry_id BIGINT AUTO_INCREMENT,
    transaction_entry_cod BINARY(36) NOT NULL,
    amount DECIMAL(10,4) NOT NULL,
    entry_date TIMESTAMP NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    transaction_fk BIGINT NOT NULL,
    account_fk BIGINT NOT NULL,
    CONSTRAINT pk_transaction_entry PRIMARY KEY (transaction_entry_id),
    CONSTRAINT fk_entry_transaction_id FOREIGN KEY (transaction_fk) REFERENCES transactions(transaction_id),
    CONSTRAINT fk_transaction_entries_account_id FOREIGN KEY (account_fk) REFERENCES accounts (account_id)
);
